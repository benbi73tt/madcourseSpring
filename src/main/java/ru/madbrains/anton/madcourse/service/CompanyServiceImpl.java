package ru.madbrains.anton.madcourse.service;

import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private ITCompany company;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Integer createCompany(ITCompany company) {
        entityManager.persist(company);
        entityManager.flush();
        return company.getId();
    }

    @Override
    public ITCompany getCompany(int id) {
        return entityManager.find(ITCompany.class, id);
    }

    @Override
    @Transactional
    public void addDeveloper(Developer developer, int company_id) {
        developer.setCompany(getCompany(company_id));
        entityManager.persist(developer);
    }


    public void setCompany(ITCompany company) {
        this.company = company;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employer> getEmployersByRole(ITRole role, int company_id) {
//        List<Employer<ITRole>> employers = company.getEmployers().stream()
//                .filter(employer -> employer.getRole().equals(role))
//                .collect(Collectors.toList());

        List<Employer> employers = entityManager.createQuery("select e from Employer e where e.role = :role and e.company = :company", Employer.class)
              //HQL
                .setParameter("role", role)
                .setParameter("company", getCompany(company_id))
                .getResultList();
        return employers;
    }

    @Override
    @Transactional
    public Employer<ITRole> getEmployerByIndex(int index) {
        Developer developer = entityManager.find(Developer.class, index);
//        Employer<ITRole> employer = company.getEntities().get(index);
//        return employer;
        entityManager.detach(developer);//отделить от контекста, чтобы обезопасить

        return developer;
    }


}
