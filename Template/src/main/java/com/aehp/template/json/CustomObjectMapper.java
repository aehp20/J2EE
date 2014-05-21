package com.aehp.template.json;

import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CustomObjectMapper extends ObjectMapper {

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 20000;

    /**
     * The date format to use.
     */
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");

    /**
     * The date-time format to use.
     */
    public static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    /**
     * The date-time with seconds format to use.
     */
    public static final SimpleDateFormat DATETIMESECONDS_FORMAT = new SimpleDateFormat(
        "yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    /**
     * Post-initialization of the bean.
     */
    @PostConstruct
    public void init() {
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        getSerializerProvider().setNullValueSerializer(new NullSerializerProvider());
        setDateFormat(DATE_FORMAT);
    }
}