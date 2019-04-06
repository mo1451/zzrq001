package com.zzrq.lom.alarm.service.impl;

import javax.annotation.Resource;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.iot.api.Profile;
import com.aliyun.openservices.iot.api.message.MessageClientFactory;
import com.aliyun.openservices.iot.api.message.api.MessageClient;
import com.aliyun.openservices.iot.api.message.callback.MessageCallback;
import com.aliyun.openservices.iot.api.message.entity.Message;
import com.zzrq.lom.alarm.dto.AlarmDetail;
import com.zzrq.lom.alarm.dto.AlarmHistory;
import com.zzrq.lom.alarm.dto.AlarmReceivedData;
import com.zzrq.lom.alarm.mapper.AlarmHistoryMapper;
import com.zzrq.lom.alarm.mapper.AlarmReceivedDataMapper;
import com.zzrq.lom.alarm.service.AlarmDetailService;
import com.zzrq.lom.alarm.service.AlarmReceivedDataService;
import com.zzrq.lom.sys.service.SysConfigService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: mo1451
 * @Date: 2019/04/06 18:10
 */
@Service
public class AlarmReceivedDataServiceImpl implements AlarmReceivedDataService {
    private Logger logger = LoggerFactory.getLogger(AlarmReceivedDataServiceImpl.class);
    @Resource
    private AlarmReceivedDataMapper receivedDataMapper;
    @Resource(name = "alarmDetailServiceImpl")
    private AlarmDetailService detailService;
    @Resource
    private AlarmHistoryMapper historyMapper;
    @Resource(name = "sysConfigServiceImpl")
    private SysConfigService configService;


    @Override
    public void AlarmReceiveData() {

        // 阿里云accessKey
        String accessKey = configService.getConfigVlaue("accessKey");
        // 阿里云accessSecret
        String accessSecret = configService.getConfigVlaue("accessSecret");
        // regionId
        String regionId = configService.getConfigVlaue("regionId");
        // 阿里云uid
        String uid = configService.getConfigVlaue("uid");
        // endPoint:  https://${uid}.iot-as-http2.${region}.aliyuncs.com
        String endPoint = "https://" + uid + ".iot-as-http2." + regionId + ".aliyuncs.com";

        // 连接配置
        Profile profile = Profile.getAccessKeyProfile(endPoint, regionId, accessKey, accessSecret);

        // 构造客户端
        MessageClient client = MessageClientFactory.messageClient(profile);

        // 数据接收
        client.connect(messageToken -> {
            Message m = messageToken.getMessage();
            String topic = m.getTopic();
            String[] split = topic.split("/");
            String productKey = split[1];
            logger.info("===========productKey:{}",productKey);
            String deviceName = split[2];
            logger.info("===========deviceName:{}",deviceName);
            String payload = new String(m.getPayload());
            logger.info("===========payload:{}",payload);
            JSONObject jsonObject = JSONObject.parseObject(payload);
            JSONObject items = (JSONObject) jsonObject.get("items");
            if(items != null) {
                String propBool = ((JSONObject)items.get("prop_bool")).getString("value");
                String propControl = ((JSONObject)items.get("prop_control")).getString("value");
                String propSensor = ((JSONObject)items.get("prop_sensor")).getString("value");

                if(StringUtils.isNotEmpty(propBool)
                        && StringUtils.isNotEmpty(propControl)
                        && StringUtils.isNotEmpty(propSensor)) {
                    AlarmReceivedData receivedData = new AlarmReceivedData();
                    receivedData.setDeviceName(deviceName);
                    receivedData.setCreationDate(new Date(m.getGenerateTime()));
                    receivedData.setLastupdateDate(new Date());
                    receivedData.setProductKey(productKey);
                    receivedData.setPropBool(propBool);
                    receivedData.setPropControl(propControl);
                    receivedData.setPropSensor(propSensor);
                    receivedDataMapper.insertSelective(receivedData);

                    if("0".equals(propBool)) {
                        AlarmDetail alarmDetail = detailService.queryAlarm(propSensor, propControl, deviceName);
                        if(alarmDetail != null) {
                            AlarmHistory history = new AlarmHistory();
                            history.setAlarmId(alarmDetail.getId());
                            history.setAlarmDate(new Date(m.getGenerateTime()));
                            history.setAlarmProcessingStatus(0);
                            historyMapper.insertSelective(history);
                        } else {
                            logger.warn("========propSensor:{},propControl:{},deviceName:{} is not exist",propSensor,propControl,deviceName);
                        }
                    }
                }
            }
            return MessageCallback.Action.CommitSuccess;
        });
    }
}
