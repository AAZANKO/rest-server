package by.declarant.server.service;

import by.declarant.server.model.Person;

import javax.persistence.Tuple;
import java.util.List;

public interface PersonService {

    /**
     * Метод - поиск объекта
     * @param id - уникальный идентификатор
     * @return - объект типа личность
     */
    Person getByID(Long id);

    /**
     * Метод - сохранение нового объекта
     * @param person - новый объект
     */
    void save(Person person);

    /**
     * Метод - удаление объекта
     * @param id - уникальный идентификатор
     */
    void delete(Long id);

    /**
     * Метод - обновление объекта
     * @param person - обновленнный объект
     */
    void update(Person person);

    /**
     * Метод - возвращает коллекцию объектов
     * @param id - уникальный идентификатор
     * @return - коллекция объектов типа Tuple
     */
    List<Tuple> findAllById(Long id);

    /**
     * Метод - возвращает коллекцию объектов
     * @param name - наименование личности
     * @return - коллекция объектов типа Tuple
     */
    List<Tuple> findAllByName(String name);

    /**
     * Метод - возвращает коллекцию всех объектов
     * @return - коллекция объектов типа Tuple
     */
    List<Tuple> findAllFull();
}
