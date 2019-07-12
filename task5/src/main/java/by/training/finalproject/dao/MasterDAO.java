package by.training.finalproject.dao;

import by.training.finalproject.entity.Master;
import by.training.finalproject.entity.Service;

import java.util.List;

public abstract class MasterDAO {
    //колл PersonDAO.addPerson();
    public abstract long addMaster(Master master);
    //колл PersonDAO.deletePerson();
    public abstract void deleteMaster(Master master);
    public abstract void deleteMaster(long idMaster);
    public abstract List<Master> getAllMasters();
    //можно сделать хранимой процедурой, где сначала получаешь айдишник услуги, а по нему потом список мастеров
    public abstract List<Master> getMastersByService(Service service);
}
