package by.declarant.server.repository;

import by.declarant.server.dto.PersonDto;
import by.declarant.server.model.Person;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Интерфейс конверотация объекта Tuple в объект Dto.
 * @autor Alexandr Zanko
 * @version 1.1
 */
public interface PersonDtoToPerson {

    /**
     * Метод - конвертирует объект Entity в объект Dto.
     * @param personDto - объект типа Tuple
     * @return - объект типа Dto
     */
    @Mappings({
            @Mapping(target="id", source="personDto.id"),
            @Mapping(target="name", source="personDto.name")
    })
    Person personEntityToPersonDto(PersonDto personDto);
}
