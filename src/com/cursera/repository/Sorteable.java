package com.cursera.repository;

import com.cursera.util.Direction;

import java.util.List;

public interface Sorteable <T>{
    List<T> list(String field, Direction dir);
}
