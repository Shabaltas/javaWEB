package by.training.finalproject.dao;

import by.training.finalproject.entity.Session;

import java.util.List;

public abstract class SessionDAO {
    public abstract long addSession(Session session);
    public abstract void deleteSession(Session session);
    public abstract void deleteSession(long idSession);
    public abstract List<Session> getAllSessions();
}
