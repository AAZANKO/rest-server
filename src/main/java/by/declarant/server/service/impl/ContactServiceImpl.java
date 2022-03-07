package by.declarant.server.service.impl;

import by.declarant.server.model.Contacts;
import by.declarant.server.repository.ContactRepository;
import by.declarant.server.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Класс слоя сервис для объекта "Контакт", со свойствами <b>contactRepository</b>.
 * @autor Alexandr Zanko
 * @version 1.1
 */
@Transactional
@Slf4j
@Service
public class ContactServiceImpl implements ContactService {

    /** Поле для доступа к медодам слоя DAO */
    private ContactRepository contactRepository;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param contactRepository - получение методов из слоя DAO
     */
    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    /**
     * Метод - поиск объекта
     * @param id - уникальный идентификатор
     * @return - объект типа контакт
     */
    @Override
    public Contacts getByID(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    /**
     * Метод - сохранение нового объекта
     * @param contacts - новый объект
     */
    @Override
    public void save(Contacts contacts) {
        contactRepository.save(contacts);
    }

    /**
     * Метод - удаление объекта
     * @param id - уникальный идентификатор
     */
    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

    /**
     * Метод - возвращает коллекцию всех объектов
     * @return - коллекция объектов типа контакт
     */
    @Override
    public List<Contacts> getAll() {
        return contactRepository.findAll();
    }

    /**
     * Метод - обновление объекта
     * @param contacts - обновленнный объект
     */
    @Override
    public void update(Contacts contacts) {
        contactRepository.update(contacts.getId(), contacts.getTelephone(), contacts.getPerson().getId(), contacts.getTypePhone());
    }
}
