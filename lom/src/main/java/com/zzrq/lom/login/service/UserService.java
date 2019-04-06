package com.zzrq.lom.login.service;

import com.zzrq.lom.login.dto.User;

/**
 * @author mo1451
 */
public interface UserService {
    /**
     * 检查password
     * @param inputUser 用户名
     * @param inputPassword 密码
     * @return 正确则返回user，错误返回null
     */
    User checkPassword(String inputUser, String inputPassword);
}
