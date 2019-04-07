package com.zzrq.lom.alarm.mapper;

import java.util.List;

import com.zzrq.lom.alarm.dto.AlarmHistory;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author mo1451
 */
@Component
public interface AlarmHistoryMapper extends Mapper<AlarmHistory> {

    List<AlarmHistory> selectAlarmDetailByMonthByControl();

    List<AlarmHistory> selectAlarmDetailByYearByControl();

    List<AlarmHistory> selectAlarmDetailByYearByGateway();
}
