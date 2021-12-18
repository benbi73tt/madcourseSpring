package ru.madbrains.anton.madcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.madbrains.anton.madcourse.company.ITCompany;
import ru.madbrains.anton.madcourse.company.employer.Developer;
import ru.madbrains.anton.madcourse.company.employer.Employer;
import ru.madbrains.anton.madcourse.company.employer.ITRole;
import ru.madbrains.anton.madcourse.company.employer.PM;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private ITCompany company;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public ITCompany getCompany() {
        return company;
    }

    @Override
    @Transactional
    public void addDeveloper(Developer developer) {

//        company.getEmployers().add(developer);
        entityManager.persist(developer);
    }

    @Override
    public void addPM(PM pm) {
        company.getEmployers().add(pm);
    }

    @Override
    public List<Employer<ITRole>> getEmployersByRole(ITRole role) {
        List<Employer<ITRole>> employers = company.getEmployers().stream()
                .filter(employer -> employer.getRole().equals(role))
                .collect(Collectors.toList());
        return employers;
    }

    @Override
    @Transactional
    public Employer<ITRole> getEmployerByIndex(int index) {
        Developer developer = entityManager.find(Developer.class,index);
//        Employer<ITRole> employer = company.getEntities().get(index);
//        return employer;
        entityManager.detach(developer);//отделить от контекста, чтобы обезопасить

        return developer;
    }
}
