package org.knifez.fridaybootadmin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @author KnifeZ
 */
@Getter
@Setter
@Schema(title = "Token令牌", description = "用户登录成功返回token结果")
public class Token {
    /**
     * 访问令牌
     */
    @Schema(title = "访问令牌")
    private String accessToken;
    /**
     * 令牌过期时间
     */
    @Schema(title = "令牌过期时间")
    private Long expires;
    /**
     * 刷新令牌
     */
    @Schema(title = "刷新令牌")
    private String refreshToken;
    /**
     * 刷新令牌时效
     */
    @Schema(title = "刷新令牌时效")
    private Long refreshTokenExpires;

    /**
     * 作用域
     */
    @Schema(title = "作用域")
    private String scope;

    public Token(String accessToken, Long expires, String refreshToken, Long refreshTokenExpires) {
        this.accessToken = accessToken;
        this.expires = expires;
        this.refreshToken = refreshToken;
        this.refreshTokenExpires = refreshTokenExpires;
    }
}
