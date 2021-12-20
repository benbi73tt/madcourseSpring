package ru.madbrains.anton.madcourse.dao;

import ru.madbrains.anton.madcourse.company.ITCompany;
import ru.madbrains.anton.madcourse.company.employer.Developer;
import ru.madbrains.anton.madcourse.company.employer.Employer;
import ru.madbrains.anton.madcourse.company.employer.ITRole;

import java.util.List;

public interface CompanyDAO {
    Integer create(ITCompany company);
    ITCompany find(int id);
    void addDeveloper(Developer developer);
    List<Employer> getEmployerByRole(ITRole role,int company_id);
    Employer<ITRole> findEmployer(int employer_id);

}
