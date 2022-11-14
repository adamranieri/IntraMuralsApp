package com.uni.daos;

import com.uni.entities.Season;

import java.util.List;

public interface CrudDAO<Entity, IDType> {

    //Create
    Entity save(Entity entity);

    //Read
    List<Entity> findAll();
    Entity findById(IDType id);

    //Update
    void update(Entity entity);

    //Delete



}
