package by.declarant.server.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Entity контакт, со свойствами <b>id</b>, <b>telephone</b>, <b>person</b>, <b>typePhone</b>.
 * @autor Alexandr Zanko
 * @version 1.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "opday", name = "contacts")
public class Contacts extends BaseEntity{

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "type_phone")
    private Long typePhone;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
