package com.jay.basic.framework.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

/**
 * created by Jay on 2019/9/8
 */
@Data
/**
 * 解决首字母、第二个字母大写转换异常的问题
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Father
{
    private String name;
}
