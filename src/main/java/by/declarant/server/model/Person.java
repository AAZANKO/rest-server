package by.declarant.server.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity личность, со свойствами <b>id</b> и <b>name</b>.
 * @autor Alexandr Zanko
 * @version 1.1
 */
@ToString(exclude = "contactsList")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "opday", name = "person")
public class Person extends BaseEntity{

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "person")
    private List<Contacts> contactsList = new ArrayList<>();

}
