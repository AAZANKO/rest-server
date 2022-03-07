package by.declarant.server.controller;

import by.declarant.server.converter.Converter;
import by.declarant.server.converter.impl.ConvertImpl;
import by.declarant.server.dto.PersonDto;
import by.declarant.server.model.Person;
import by.declarant.server.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Convert;
import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс Rest контроллер для объекта "Личность", со свойствами <b>personService</b>.
 * @autor Alexandr Zanko
 * @version 1.1
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    /** доступ к методам слоя Service */
    private PersonService personService;
    /** доступ к методу конвератара */
    private Converter converter;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param personService - получение методов из слоя Service
     */
    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    /**
     * Метод - поиск объекта
     * @param id - уникальный идентификатор
     * @return - найденный объект в обертке ответа
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<List<PersonDto>> getPersonById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Tuple> persons = personService.findAllById(id);
        if (persons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<PersonDto> personList = new ArrayList<>();
        convertationTupleToPersonDto(persons, personList);
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    /**
     * Метод - поиск объекта
     * @param name - наименование объекта
     * @return - найденный объект в обертке ответа
     */
    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public ResponseEntity<List<PersonDto>> getPersonByName(@PathVariable("name") String name) {
        if (name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Tuple> persons = personService.findAllByName(name);
        if (persons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<PersonDto> personList = new ArrayList<>();
        convertationTupleToPersonDto(persons, personList);
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    /**
     * Метод - возвращает коллекцию объектов
     * @return - коллекцию объектов в обертке ответа
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<PersonDto>> getAllPersons() {
        List<Tuple> persons = personService.findAllFull();
        if (persons == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<PersonDto> personList = new ArrayList<>();
        convertationTupleToPersonDto(persons, personList);
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    /**
     * Метод - сохранение нового объекта
     * @param person - новый объект
     * @return - сохраненный объект в обертке ответа
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        personService.save(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    /**
     * Метод - обновление объекта
     * @param person - обновляемый объект
     * @return - обновленный объект в обертке ответа
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        personService.update(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    /**
     * Метод - обновление объекта
     * @param id - уникальный идентификатор
     * @return - удаленный объект в обертке ответа
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Person> deletePerson(@PathVariable("id") Long id) {
        Person Person = personService.getByID(id);
        if (Person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        personService.delete(id);
        return new ResponseEntity<>(Person, HttpStatus.NO_CONTENT);
    }

    /**
     * Метод - преобразует коллекцию объектов Tuple в коллекцию объектов Dto
     * @param personsTuple - коллекция объектов Tuple
     * @param personList - коллекция объектов Dto
     */
    private void convertationTupleToPersonDto(List<Tuple> personsTuple, List<PersonDto> personList) {
        for (int i = 0; i < personsTuple.size(); i++) {
            PersonDto personDto = new PersonDto();
            personDto = (PersonDto) converter.converter(personsTuple.get(i));
            personList.add(personDto);
        }
    }
    
}
