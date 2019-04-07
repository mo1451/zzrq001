package com.zzrq.lom.sys.service.impl;

import javax.annotation.Resource;

import com.zzrq.lom.sys.dto.SysConfig;
import com.zzrq.lom.sys.mapper.SysConfigMapper;
import com.zzrq.lom.sys.service.SysConfigService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Author: mo1451
 * @Date: 2019/04/06 18:57
 */
@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Resource(name="sysConfigMapper")
    private SysConfigMapper sysConfigMapper;

    @Override
    public String getConfigVlaue(String configName) {
        Example example = new Example(SysConfig.class);
        example.createCriteria().andEqualTo("name",configName);
        SysConfig config = sysConfigMapper.selectOneByExample(example);
        return config == null?"":config.getValue();
    }
}
