package ru.madbrains.anton.madcourse.company;

import ru.madbrains.anton.madcourse.company.employer.Employer;
import ru.madbrains.anton.madcourse.company.employer.ITRole;

import java.util.ArrayList;
import java.util.List;

public class EmployerManager<T extends Employer> {
    //@JsonIgnore // скрыть поле
    private List<Employer<ITRole>> entities;

    @SuppressWarnings("unchecked")
    public EmployerManager(int maxExampleCount, Class<Employer> employerClass) {
        this.entities = new ArrayList<>();
    }


    public int getSize() {
        return entities.size();
    }

    public List<Employer<ITRole>> getEmployers() {
        return entities;
    }
}

