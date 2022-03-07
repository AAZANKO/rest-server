package by.declarant.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO личность, со свойствами <b>id</b>, <b>name</b>, <b>telephone</b>, <b>typePhone</b>.
 * @autor Alexandr Zanko
 * @version 1.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDto {

    /** Поле уникальный идентификатор */
    private Long id;
    /** Поле наименование */
    private String name;
    /** Поле номер телефона */
    private String telephone;
    /** Поле тип телефона */
    private Long typePhone;
}
