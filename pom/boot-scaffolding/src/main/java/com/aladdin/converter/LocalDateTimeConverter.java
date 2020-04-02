package com.aladdin.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class LocalDateTimeConverter extends JsonSerializer {

    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        LocalDateTime localDateTime= (LocalDateTime) o;
        jsonGenerator.writeNumber(localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
    }
    /**
     * 时间戳返回
     * @JsonSerialize(using = LocalDateTimeConverter.class)
     * protected LocalDateTime gmtModified;
     * 格式化返回
     * @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
     * protected LocalDateTime gmtModified;
     * 格式化接受
     * @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     * protected LocalDateTime gmtModified;
     */
}