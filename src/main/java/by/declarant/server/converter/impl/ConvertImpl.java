package by.declarant.server.converter.impl;

import by.declarant.server.converter.Converter;
import by.declarant.server.dto.PersonDto;

import javax.persistence.Tuple;

/**
 * Класс конвертирует объекта Tuple в объект Dto.
 * @autor Alexandr Zanko
 * @version 1.1
 */
public class ConvertImpl implements Converter<Tuple, PersonDto> {

    /**
     * Метод - поиск объекта
     * @param object - объект типа Tuple
     * @return - объект типа PersonDto
     */
    @Override
    public PersonDto converter(Tuple object) {
        return PersonDto.builder()
                .id(object.get(0, Long.class))
                .name(object.get(1, String.class))
                .telephone(object.get(2, String.class))
                .typePhone(object.get(3, Long.class))
                .build();
    }
}
