package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
  @Autowired
    PeopleRepository peopleRepository;
  @Autowired
  PetRepository petRepository;


    @RequestMapping("/")
    public String index(Model model){
        //creates the person
        People people = new People();
        people.setName("Kevin Cheung");

        //create the pet
        Pet pet = new Pet();
        pet.setName("Mochi");
        pet.setBreed("Border Callie");
        pet.setDescription("Puppy");

        pet.setPeople(people);

        //add pet to empty list
        Set<Pet> pets = new HashSet<Pet>();
        pets.add(pet);

        pet = new Pet();
        pet.setName("Pablo");
        pet.setBreed("Corgi");
        pet.setDescription("Always happy and ready to play");
        pets.add(pet);

        people.setPets(pets);
        pet.setPeople(people);

        peopleRepository.save(people);
        petRepository.save(pet);

        model.addAttribute("peoples", peopleRepository.findAll());
        return "index";

    }
}
