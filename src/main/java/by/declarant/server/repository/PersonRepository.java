package by.declarant.server.repository;

import by.declarant.server.dto.PersonDto;
import by.declarant.server.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.util.List;

/**
 * Интерфейс слоя DAO, для работы с методами базы данных объекта "Личность".
 * @autor Alexandr Zanko
 * @version 1.1
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    /**
     * Метод - обновление объекта
     * @param id - уникальный идентификатор
     * @param name - номер телефона
     */
    @Modifying
    @Query(value = "UPDATE opday.person "  +
            " SET name = :name, " +
            " where id = :id ", nativeQuery = true)
    void update(@Param("id") Long id,
                @Param("name") String name);

    /**
     * Метод - поиск объекта
     * @param id - уникальный идентификатор
     * @return - коллекцию объектов типа Tuple
     */
    @Modifying
    @Query(value = "SELECT p.id, p.name, c.telephone, c.type_phone FROM opday.person p"  +
            " INNER JOIN opday.contacts c ON c.id_person = p.id" +
            " WHERE p.id = :id ", nativeQuery = true)
    List<Tuple> findAllById(@Param("id") Long id);

    /**
     * Метод - поиск объекта
     * @param name - наименование объекта
     * @return - коллекцию объектов типа Tuple
     */
    @Modifying
    @Query(value = "SELECT p.id, p.name, c.telephone, c.type_phone FROM opday.person p"  +
            " INNER JOIN opday.contacts c ON c.id_person = p.id"+
            " WHERE p.name = :name ", nativeQuery = true)
    List<Tuple> findAllByName(@Param("name") String name);

    /**
     * Метод - поиск объекта
     * @return - коллекцию объектов типа Tuple
     */
    @Modifying
    @Query(value = "SELECT p.id, p.name, c.telephone, c.type_phone FROM opday.person p"  +
            " INNER JOIN opday.contacts c ON c.id_person = p.id", nativeQuery = true)
    List<Tuple> findAllFull();

}
