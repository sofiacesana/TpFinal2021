package com.cursera.repository;

import java.util.List;

public interface Pageable <T>{
    List<T> list (int since, int until);
}
