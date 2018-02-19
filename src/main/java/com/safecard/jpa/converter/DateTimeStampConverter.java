package com.safecard.jpa.converter;

import javax.persistence.AttributeConverter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class DateTimeStampConverter implements AttributeConverter <Date, Timestamp > {
    @Override
    public Timestamp convertToDatabaseColumn(Date attribute) {
        return attribute != null ? new Timestamp(attribute.getTime()) : null;
    }
    @Override
    public Date convertToEntityAttribute(Timestamp dbData) {
        return dbData != null ? new Date(dbData.getTime()) : null;
    }

}