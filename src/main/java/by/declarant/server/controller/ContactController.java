package by.declarant.server.controller;

import by.declarant.server.model.Contacts;
import by.declarant.server.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс Rest контроллер для объекта "Контакт", со свойствами <b>contactService</b>.
 * @autor Alexandr Zanko
 * @version 1.1
 */
@RestController
@RequestMapping("/contacts")
public class ContactController {

    /** доступ к методам слоя Service */
    private ContactService contactService;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param contactService - получение методов из слоя Service
     */
    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    /**
     * Метод - поиск объекта
     * @param id - уникальный идентификатор
     * @return - объект в обертке ответа
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Contacts> getContactById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Contacts contacts = contactService.getByID(id);
        if (contacts == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    /**
     * Метод - сохранение нового объекта
     * @param contacts - новый объект
     * @return - сохраненный объект в обертке ответа
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Contacts> saveContacts(@RequestBody Contacts contacts) {
        if (contacts == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        contactService.save(contacts);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    /**
     * Метод - обновление объекта
     * @param contacts - обновленнный объект
     * @return - обновленный объект в обертке ответа
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<Contacts> updateContacts(@RequestBody Contacts contacts) {
        if (contacts == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        contactService.update(contacts);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    /**
     * Метод - удаление объекта
     * @param id - уникальный идентификатор
     * @return - удаляемыей объект в обертке ответа
     */
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity<Contacts> deleteContacts(@RequestBody Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Contacts contacts = contactService.getByID(id);
        contactService.delete(id);
        return new ResponseEntity<>(contacts, HttpStatus.NO_CONTENT);
    }

    /**
     * Метод - возвращает коллекцию объектов
     *
     * @return - коллекция объектов в обертке ответа
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Contacts>> getAllContact() {
        List<Contacts> contacts = contactService.getAll();
        if (contacts == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

}
