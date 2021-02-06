package com.esprit.b8ks_web.services;

import java.util.List;

public interface IService <T> {
    public void add(T p);
    public List<T> getList();
    public void delete(long p);
    public T modify(T p);
    public T findById(long id);
    public T findByEmail(String E);
    public List<T> findUsersByRole (String E);
}
