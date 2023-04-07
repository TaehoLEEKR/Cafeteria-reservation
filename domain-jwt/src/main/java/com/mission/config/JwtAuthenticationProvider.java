package com.mission.config;


import com.mission.common.UserVo;
import com.mission.common.userType;
import com.mission.util.Aes256Util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Objects;

public class JwtAuthenticationProvider {
    private String secreKey = "secretKey";
    private long tokenVaildTime = 1000L * 60 * 60 * 24;

    public String createToken(String userPk , Long id, userType userType){
        Claims claims = Jwts.claims().setSubject(Aes256Util.encrypt(userPk)).setId(Aes256Util.encrypt(id.toString()));
        claims.put("roles",userType);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime()+tokenVaildTime))
                .signWith(SignatureAlgorithm.HS256,secreKey)
                .compact();
    }
    public boolean validateToken(String jwtToken){
        try{
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secreKey).parseClaimsJws(jwtToken);
            return !claimsJws.getBody().getExpiration().before(new Date());
        }catch (Exception e){
            return false;
        }
    }
    public UserVo getUserVo(String token){
        Claims c = Jwts.parser().setSigningKey(secreKey).parseClaimsJws(token).getBody();
        return new UserVo(Long.valueOf(Objects.requireNonNull(Aes256Util.encrypt(c.getId()))),Aes256Util.encrypt(c.getSubject()));
    }
}
