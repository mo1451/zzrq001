package com.zzrq.lom.login.service.impl;

import javax.annotation.Resource;
import java.util.List;

import com.zzrq.lom.login.dto.User;
import com.zzrq.lom.login.mapper.UserMapper;
import com.zzrq.lom.login.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author mo1451
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User checkPassword(String inputUser, String inputPassword) {
        Example userExample = new Example(User.class);
        userExample.createCriteria().andEqualTo("name",inputUser);
        List<User> users = userMapper.selectByExample(userExample);

        if(users == null || users.size() == 0) {
            return null;
        } else {
            if(users.get(0).getPassword().equals(inputPassword)) {
                return users.get(0);
            } else {
                return null;
            }
        }
    }
}
