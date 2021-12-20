package ru.madbrains.anton.madcourse.service;

import ru.madbrains.anton.madcourse.company.ITCompany;
import ru.madbrains.anton.madcourse.company.employer.Developer;
import ru.madbrains.anton.madcourse.company.employer.Employer;
import ru.madbrains.anton.madcourse.company.employer.ITRole;
import ru.madbrains.anton.madcourse.company.employer.PM;

import java.util.List;

public interface CompanyService {
    Integer createCompany(ITCompany company);

    ITCompany getCompany(int id);

    void addDeveloper(Developer developer, int company_id);

    List<Employer> getEmployersByRole(ITRole role, int company_id);

    Employer<ITRole> getEmployerByIndex(int index);

}
