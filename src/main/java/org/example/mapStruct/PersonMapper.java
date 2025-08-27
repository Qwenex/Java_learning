package org.example.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.Period;

@Mapper(componentModel = "default")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "name", source = ".", qualifiedByName = "fullName")
    @Mapping(target = "age", source = "birthday", qualifiedByName = "calculateAge")
    PersonIn toPersonIn(PersonOut personOut);

    @Named("fullName")
    default String mapToFullName(PersonOut personOut) {
        if (personOut == null) {
            return null;
        }
        return String.format("%s %s %s", personOut.getFirstName(), personOut.getSecondName(), personOut.getLastName());
    }

    @Named("calculateAge")
    default Integer calculateAge(LocalDate birthday) {
        if (birthday == null) {
            return null;
        }
        return Period.between(birthday, LocalDate.now()).getYears();
    }

}
