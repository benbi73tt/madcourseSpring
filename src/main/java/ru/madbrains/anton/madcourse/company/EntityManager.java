package ru.madbrains.anton.madcourse.company;

import ru.madbrains.anton.madcourse.company.employer.Employer;

import java.lang.reflect.Array;

public class EntityManager<T extends Employer> {
    private T[] entities;
    int size;

    @SuppressWarnings("unchecked")
    public EntityManager(int maxSize, Class<T> clazz){
        this.entities = (T[]) Array.newInstance(clazz, maxSize);
    }

    @SuppressWarnings("unchecked")
    public void addEntities(T entity){
        System.out.println(entity.getName() + " is added");
        entities[size] = entity;
        size++;
    }
    public int getSize() { return size; }
    public T[] getEntities(){ return entities; }
}

