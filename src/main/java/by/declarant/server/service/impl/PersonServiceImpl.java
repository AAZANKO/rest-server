package by.declarant.server.service.impl;

import by.declarant.server.model.Person;
import by.declarant.server.repository.PersonRepository;
import by.declarant.server.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.util.List;

/**
 * Класс слоя сервис для объекта "Личность", со свойствами <b>personRepository</b>.
 * @autor Alexandr Zanko
 * @version 1.1
 */
@Transactional
@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    /** Поле для доступа к медодам слоя DAO */
    private PersonRepository personRepository;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param personRepository - получение методов из слоя DAO
     */
    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Метод - поиск объекта
     * @param id - уникальный идентификатор
     * @return - объект типа личность
     */
    @Override
    public Person getByID(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    /**
     * Метод - сохранение нового объекта
     * @param person - новый объект
     */
    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    /**
     * Метод - удаление объекта
     * @param id - уникальный идентификатор
     */
    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    /**
     * Метод - обновление объекта
     * @param person - обновленнный объект
     */
    @Override
    public void update(Person person) {
        personRepository.update(person.getId(), person.getName());
    }

    /**
     * Метод - возвращает коллекцию объектов
     * @param id - уникальный идентификатор
     * @return - коллекция объектов типа Tuple
     */
    @Override
    public List<Tuple> findAllById(Long id) {
        return personRepository.findAllById(id);
    }

    /**
     * Метод - возвращает коллекцию объектов
     * @param name - наименование личности
     * @return - коллекция объектов типа Tuple
     */
    @Override
    public List<Tuple> findAllByName(String name) {
        return personRepository.findAllByName(name);
    }

    /**
     * Метод - возвращает коллекцию всех объектов
     * @return - коллекция объектов типа Tuple
     */
    @Override
    public List<Tuple> findAllFull(){
        return personRepository.findAllFull();
    }
}
