package com.seesea.seeseacommon.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/10/29 下午 11:57
 * @Author xiechongyang
 */
public class TokenGenerate {

    /**
     * playload
     * 载荷就是存放有效信息的地方。基本上填2种类型数据
     *
     * -标准中注册的声明的数据
     * -自定义数据
     * 由这2部分内部做base64加密。最张数据进入JWT的chaims里存放。
     *
     * 标准中注册的声明 (建议但不强制使用)
     * iss: jwt签发者
     *
     * sub: jwt所面向的用户
     *
     * aud: 接收jwt的一方
     *
     * exp: jwt的过期时间，这个过期时间必须要大于签发时间
     *
     * nbf: 定义在什么时间之前，该jwt都是不可用的.
     *
     * iat: jwt的签发时间
     *
     * jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
     */
    /**
     * token秘钥，请勿泄露，请勿随便修改 backups:JKKLJOoasdlfj
     */
    @Value("${jwt.secret}")
    private String SECRET;
    /**
     * token 过期时间: 10天
     */
    @Value("${jwt.live.day}")
    private int calendarInterval;
    private int calendarField = Calendar.DATE;

    public String createToken(TokenInfo tokenInfo) {
        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(calendarField, calendarInterval);
        Date expiresDate = nowTime.getTime();

        // header Map
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        // build token
        // param backups {iss:Service, aud:APP}
        String token = JWT.create().withHeader(map) // header
                .withClaim("iss", "seesea") // payload
//                .withClaim("aud", "APP")
                .withClaim("userId", tokenInfo.getUserId())
//                .withClaim("loginType", tokenInfo.getLoginType())
                .withIssuedAt(iatDate) // sign time
                .withExpiresAt(expiresDate) // expire time
                .sign(Algorithm.HMAC256(SECRET)); // signature

        return token;
    }

    /**
     * 根据Token获取user_id
     *
     * @param token
     * @return user_id
     */
    public TokenInfo getTokenInfo(String token) {
        Map<String, Claim> claims = verifyToken(token);
        Claim userId = claims.get("userId");
//        Claim loginType = claims.get("loginType");

        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setUserId(userId.asString());
//        tokenInfo.setLoginType(loginType.asString());
        return tokenInfo;
    }


    /**
     * 解密Token
     *
     * @param token
     * @return
     * @throws Exception
     */
    private Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            // e.printStackTrace();
            // token 校验失败, 抛出Token验证非法异常
            throw e;
        }
        return jwt.getClaims();
    }

}
