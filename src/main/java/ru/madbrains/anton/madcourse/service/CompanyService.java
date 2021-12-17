package ru.madbrains.anton.madcourse.service;

import ru.madbrains.anton.madcourse.company.ITCompany;
import ru.madbrains.anton.madcourse.company.employer.Developer;
import ru.madbrains.anton.madcourse.company.employer.Employer;
import ru.madbrains.anton.madcourse.company.employer.ITRole;
import ru.madbrains.anton.madcourse.company.employer.PM;

import java.util.List;

public interface CompanyService {
    ITCompany getCompany();
    void addDeveloper(Developer developer);
    void addPM(PM pm);
    List<Employer<ITRole>> getEmployersByRole(ITRole role);
    Employer<ITRole> getEmployerByIndex(int index);
}
