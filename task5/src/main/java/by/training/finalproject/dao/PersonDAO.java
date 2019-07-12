package by.training.finalproject.dao;

import by.training.finalproject.entity.Person;

public abstract class PersonDAO {
    public abstract long addPerson(Person person);
    public abstract void deletePerson(Person person);
    public abstract void deletePerson(long idPerson);
}
