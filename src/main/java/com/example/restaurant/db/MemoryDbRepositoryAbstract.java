package com.example.restaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {
    private final List<T> db = new ArrayList<>();
    private int index = 0;

    @Override
    public Optional findById(int index) {
        return db.stream().filter(it -> it.getIndex() == index).findFirst();
    }

    @Override
    public T save(T entity) {

        var optionalEntity = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();

        if(optionalEntity.isPresent()) {
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;
        } else {

        }

        // db에 이미 데이터가 있는 경우

        // db에 데이터가 없는 경우
        return null;
    }

    @Override
    public void deleteById(int index) {

    }

    @Override
    public List listAll() {
        return null;
    }
}

