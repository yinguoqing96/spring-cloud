package cn.yinguoqing.springcloud.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @author yinguoqing
 * @date 2022/9/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Payment implements Serializable {

    private static final long serialVersionUID = 6051966318127731179L;

    private Long id;

    private String serial;
}