package com.cursera.repository;

import java.util.List;

public interface Crud <T>{
    List<T> list();
    T searchById(int id);
    void create (T t);
    T edit (T t);
    void delete (int id);
}
