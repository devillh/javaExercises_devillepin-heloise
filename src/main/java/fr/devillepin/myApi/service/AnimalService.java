package fr.devillepin.myApi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.devillepin.myApi.model.Animal;

@Service
public class AnimalService {
    private ArrayList<Animal> animals;

    public AnimalService() {
        this.animals = new ArrayList<Animal>();

        this.animals.add(new Animal(0, "Chouchou", "chat", 16));
        this.animals.add(new Animal(1, "Médor", "chien", 35));
        this.animals.add(new Animal(2, "Magicarpe", "poisson", 1));
    }

    public Animal getAnimal(int id) {
        for (Animal animal : this.animals) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    public Animal createAnimal(String name, String type, int weight) {
        Animal animal = new Animal(this.animals.size(), name, type, weight);
        this.animals.add(animal);

        return animal;
    }

    public Animal updateAnimal(int id, String name, String type, int weight) {
        for (Animal animal : this.animals) {
            if (animal.getId() == id) {
                animal.setName(name);
                animal.setType(type);
                animal.setWeight(weight);
                return animal;
            }
        }

        return null;
    }

    public Animal deleteAnimal(int id) {
        for (Animal animal : this.animals) {
            if (animal.getId() == id) {
                int index = this.animals.indexOf(animal);
                return this.animals.remove(index);
            }
        }

        return null;
    }

    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }
}