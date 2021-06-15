package com.cursera.repository;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractList<T> implements All<T> {

    public List<T> dataSource;

    public AbstractList(){
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> list (){
        return dataSource;
    }

    @Override
    public void create(T t){
        this.dataSource.add(t);
    }

    @Override
    public void delete(Integer id){
        this.dataSource.remove(this.searchById(id));
    }

    @Override
    public List<T> list(int since, int until){ return dataSource.subList(since, until); }

    @Override
    public int total(){
        return this.dataSource.size();
    }


}
