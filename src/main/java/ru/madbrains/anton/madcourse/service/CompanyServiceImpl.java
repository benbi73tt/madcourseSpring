package ru.madbrains.anton.madcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.madbrains.anton.madcourse.company.ITCompany;
import ru.madbrains.anton.madcourse.company.employer.Developer;
import ru.madbrains.anton.madcourse.company.employer.Employer;
import ru.madbrains.anton.madcourse.company.employer.ITRole;
import ru.madbrains.anton.madcourse.company.employer.PM;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private ITCompany company;


    @Override
    public ITCompany getCompany() {
        return company;
    }

    @Override
    public void addDeveloper(Developer developer) {
        company.getEntities().add(developer);
    }

    @Override
    public void addPM(PM pm) {
        company.getEntities().add(pm);
    }

    @Override
    public List<Employer<ITRole>> getEmployersByRole(ITRole role) {
        List<Employer<ITRole>> employers = company.getEntities().stream()
                .filter(employer -> employer.getRole().equals(role))
                .collect(Collectors.toList());
        return employers;
    }

    @Override
    public Employer<ITRole> getEmployerByIndex(int index) {
        Employer<ITRole> employer = company.getEntities().get(index);
        return employer;
    }
}
