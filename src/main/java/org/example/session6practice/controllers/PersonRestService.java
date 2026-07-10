package org.example.session6practice.controllers;

import org.example.session6practice.Finals;
import org.example.session6practice.data.entities.Person;
import org.example.session6practice.data.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Person")
public class PersonRestService {

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.POST)
    @GetMapping("/json")
    public Map<String,String> addOrUpdate(Person person) {
        personService.addOrUpdate(person);

        Map<String,String> map = new HashMap<>();
        map.put("response","Person added Successfully done");
        return map;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @GetMapping("/json")
    public Map<String,String> deleteById(long id) {
        personService.deletePersonById(id);

        Map<String,String> map = new HashMap<>();
        map.put("response","Person has been deleted successfully done");
        return map;
    }

    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    @GetMapping("/json")
    public Map<String,String> deletePerson(Person person) {
        personService.deletePerson(person);

        Map<String,String> map = new HashMap<>();
        map.put("response","Person deleted successfully done");
        return map;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Person getPersonById(long id) {
        return personService.findPersonById(id);
    }

    @RequestMapping(value = "GetByNameAndFamily",method = RequestMethod.GET)
    public List<Person> getByNameAndFamily(String name, String family,int pageNo) {
        return personService.findByNameAndFamily(name,family, Finals.PER_PAGE_PAGINATION,pageNo);
    }



}
