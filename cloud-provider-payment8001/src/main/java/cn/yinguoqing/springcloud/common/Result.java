package cn.yinguoqing.springcloud.common;

import lombok.*;
import org.apache.logging.log4j.message.Message;

/**
 * @author yinguoqing
 * @date 2022/9/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public Result(Integer code, String message) {
        this(code, message, null);
    }

}