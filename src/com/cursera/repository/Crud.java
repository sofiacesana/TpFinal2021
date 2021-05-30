package com.cursera.repository;

import java.util.List;

public interface Crud <T>{
    List<T> list();
    T searchById(Integer id);
    void create (T t);
    void edit (T t);
    void delete (Integer id);
}
