package com.esprit.b8ks_web.services;

import java.util.List;

public interface IService <T> {
    public void add(T p);
    public List<T> getList();
    public void delete(int p);
    public T modify(T p);
    public T findById(int id);
    public T findByEmail(String E);
}
