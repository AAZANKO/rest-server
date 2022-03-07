package by.declarant.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO контакт, со свойствами <b>id</b>, <b>telephone</b>, <b>idPerson</b>, <b>typePhone</b>.
 * @autor Alexandr Zanko
 * @version 1.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactsDto {

    /** Поле уникальный идентификатор */
    private Long id;
    /** Поле номер телефона */
    private String telephone;
    /** Поле уникальный идентификатор, связь с объектом Person */
    private Long idPerson;
    /** Поле тип телефона */
    private Long typePhone;
}
