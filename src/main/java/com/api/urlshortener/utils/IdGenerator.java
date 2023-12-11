package com.api.urlshortener.utils;

import cn.hutool.core.lang.Snowflake;

import java.util.UUID;

public class IdGenerator {

    public static String generateSnowflakeId() {
        Snowflake snowflake = new Snowflake(1L, 1L);
        return snowflake.nextIdStr();
    };

    public static UUID generateUUID() {
        return UUID.randomUUID();
    };

}
