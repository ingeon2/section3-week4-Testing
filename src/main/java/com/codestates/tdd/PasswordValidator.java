package com.codestates.tdd;

import java.util.regex.Pattern;

public class PasswordValidator {
    public void validate(String password) {
        // 정규 표현식으로 패스워드가 유효한지 체크하도록 수정
        if (!Pattern.matches("(?=.*\\W)(?=\\S+$).+", password)) {
            throw new RuntimeException("Invalid password");
        }
    }
}
