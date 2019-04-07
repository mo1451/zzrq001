package com.zzrq.lom.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import com.zzrq.lom.login.dto.User;
import com.zzrq.lom.login.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author mo1451
 */
@Controller
public class IndexController {

    @Resource(name="userMapper")
    private UserMapper userMapper;

    @GetMapping(value = "index")
    public String login() {
        return "index";
    }

    @GetMapping(value = "user/change")
    public String userChange(Map<String,Object> map, HttpServletRequest httpServletRequest) {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        user = userMapper.selectByPrimaryKey(user);
        map.put("user",user);
        return "userChange";
    }

    @PostMapping(value = "user/change")
    public String userChange(Map<String,Object> map,String phone,String email,Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setPhone(phone);
        user.setEmail(email);
        userMapper.updateByPrimaryKeySelective(user);
        map.put("user",user);
        return "userChange";
    }
}
