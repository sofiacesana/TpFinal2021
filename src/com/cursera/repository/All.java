package com.cursera.repository;

public interface All<T> extends Crud<T>, Accountant, Pageable<T>, Sorteable<T> {
}
