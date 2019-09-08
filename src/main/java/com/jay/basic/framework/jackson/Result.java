package com.jay.basic.framework.jackson;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * created by Jay on 2019/9/8
 */
@Data
public class Result<T>
{
    private boolean success;
    List<T> data = new ArrayList<T>();
}
