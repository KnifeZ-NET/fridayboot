package org.knifez.fridaybootcore.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;


/**
 * 结果状态
 *
 * @author KnifeZ
 */
@Getter
public enum ResultStatus {
    //Http状态码
    SUCCESS(HttpStatus.OK),
    BAD_REQUEST(HttpStatus.BAD_REQUEST),

    // 授权/登录验证失败
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), "不存在的用户或已超期，请登录后再进行操作！"),
    UNAUTHORIZED_001(401001, "用户名或密码不正确。"),
    UNAUTHORIZED_002(401002, "原密码校验失败"),

    FORBIDDEN(HttpStatus.FORBIDDEN.value(), "禁止访问! 请联系管理员确认账户权限"),
    FORBIDDEN_001(403001, "账户已锁定，请联系管理员解锁"),
    FORBIDDEN_002(403002, "登录失败次数过多，请稍后再试"),
    FORBIDDEN_003(403003, "该帐号已存在"),
    FORBIDDEN_004(403004, "授权校验失败"),
    FORBIDDEN_005(403005, "授权站点数量已达上限"),
    FORBIDDEN_006(403006, "授权已过期"),


    CHECK_PARAMS_FAILED(400001, "参数校验失败"),

    UPLOAD_NO_DIR(400101, "不存在上传目录"),
    UPLOAD_OVER_LIMIT(400102, "文件大小超出上传最大限制"),
    UPLOAD_TYPE_FORBIDDEN(400103, "未声明的附件类型"),

    ENTITY_NOT_FOUND(404001, "操作对象不存在");

    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 消息
     */
    private final String message;

    ResultStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    ResultStatus(HttpStatus status) {
        this.code = status.value();
        this.message = status.getReasonPhrase();
    }
}
