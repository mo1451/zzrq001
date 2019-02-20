package com.zzrq.lom.mapper;

import com.zzrq.lom.dto.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface UserMapper extends Mapper<User> {
}
