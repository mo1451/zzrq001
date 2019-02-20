package com.zzrq.lom.service.impl;

import com.zzrq.lom.dto.User;
import com.zzrq.lom.mapper.UserMapper;
import com.zzrq.lom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
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
