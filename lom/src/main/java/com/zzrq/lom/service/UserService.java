package com.zzrq.lom.service;

import com.zzrq.lom.dto.User;

public interface UserService {
    User checkPassword(String inputUser, String inputPassword);
}
