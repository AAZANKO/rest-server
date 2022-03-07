package by.declarant.server.repository;

import by.declarant.server.model.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Интерфейс слоя DAO, для работы с методами базы данных объекта "Контакт".
 * @autor Alexandr Zanko
 * @version 1.1
 */
public interface ContactRepository extends JpaRepository<Contacts, Long> {

    /**
     * Метод - обновление объекта
     * @param id - уникальный идентификатор
     * @param telephone - номер телефона
     * @param idPerson - уникальный идентификатор личность
     * @param typePhone - тип номера телефона
     */
    @Modifying
    @Query(value = "UPDATE opday.contacts "  +
            " SET telephone = :telephone, " +
            " id_person = :idPerson, " +
            " type_phone = :typePhone " +
            " where id = :id ", nativeQuery = true)
    void update(@Param("id") Long id,
                        @Param("telephone") String telephone,
                        @Param("idPerson") Long idPerson,
                        @Param("typePhone") Long typePhone);

}
