package by.declarant.server.service;

import by.declarant.server.model.Contacts;

import java.util.List;

/**
 * Интерфейс слоя сервис для объекта "Контакт".
 * @autor Alexandr Zanko
 * @version 1.1
 */
public interface ContactService {

    /**
     * Метод - поиск объекта
     * @param id - уникальный идентификатор
     * @return - объект типа контакт
     */
    Contacts getByID(Long id);

    /**
     * Метод - сохранение нового объекта
     * @param contacts - новый объект
     */
    void save(Contacts contacts);

    /**
     * Метод - удаление объекта
     * @param id - уникальный идентификатор
     */
    void delete(Long id);

    /**
     * Метод - возвращает коллекцию всех объектов
     * @return - коллекция объектов типа контакт
     */
    List<Contacts> getAll();

    /**
     * Метод - обновление объекта
     * @param contacts - обновленнный объект
     */
    void update(Contacts contacts);
}
