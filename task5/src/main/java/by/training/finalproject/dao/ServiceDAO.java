package by.training.finalproject.dao;

import by.training.finalproject.entity.Master;
import by.training.finalproject.entity.Service;
import by.training.finalproject.entity.Specialization;

import java.util.List;

public abstract class ServiceDAO {
    //return id
    public abstract long addService(Service service);
    public abstract void deleteService(Service service);
    public abstract void deleteService(long idService);
    public abstract List<Service> getAllServices();
    public abstract List<Service> getServicesBySpec(Specialization specialization);
    public abstract List<Service> getMasterServices(Master master);
}
