package ru.madbrains.anton.madcourse.company.employer;

public interface Worker {
    default void work(){
        throw new RuntimeException("Not implemented");
    };
}
