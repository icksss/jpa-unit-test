package jpastart.jpa;

import jakarta.persistence.AttributeConverter;

public class BooleanYesNoConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return attribute ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "Y".equals(dbData) ? true : false;
    }
}
