package com.cursera.repository;

import java.util.List;

public interface Crud <T>{
    List<T> list();
    T searchById(Integer id);
    void create (T t);
    T edit (Integer id);
    void delete (Integer id);
}
