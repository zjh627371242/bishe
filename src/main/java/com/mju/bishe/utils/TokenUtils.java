package com.mju.bishe.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;

public class TokenUtils {
    //过期时间
//    private static final Integer TIME_OUT_DAY = 1;
//
//    public static String getToken(User user) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE,TIME_OUT_DAY);
//        String token="";
//        token= JWT.create().withAudience(user.getId() + "")
//                .withExpiresAt(calendar.getTime())
//                .sign(Algorithm.HMAC256(user.getPassword()));
//        return token;
//    }
}
