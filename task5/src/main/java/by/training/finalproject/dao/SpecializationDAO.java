package by.training.finalproject.dao;

import by.training.finalproject.entity.Specialization;

import java.util.List;

public abstract class SpecializationDAO {
    public abstract long addSpecialization(Specialization specialization);
    public abstract void deleteSpecialization(Specialization specialization);
    public abstract void deleteSpecialization(long idSpecialization);
    public abstract List<Specialization> getAllSpecializations();
}
