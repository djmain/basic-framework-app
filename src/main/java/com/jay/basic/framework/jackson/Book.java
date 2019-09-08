package com.jay.basic.framework.jackson;

/**
 * created by Jay on 2019/9/8
 */
public interface Book<T1, T2, T3>
{
    <T1> T1 read(String name);

    <T2> T2 read(Object object);

    <T3> T3 read(Integer num);
}
