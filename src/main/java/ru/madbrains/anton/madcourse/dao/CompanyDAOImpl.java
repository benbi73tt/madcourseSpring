package ru.madbrains.anton.madcourse.dao;

import org.springframework.stereotype.Repository;
import ru.madbrains.anton.madcourse.company.ITCompany;
import ru.madbrains.anton.madcourse.company.employer.Developer;
import ru.madbrains.anton.madcourse.company.employer.Employer;
import ru.madbrains.anton.madcourse.company.employer.ITRole;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Integer create(ITCompany company) {
        entityManager.persist(company);
        entityManager.flush();
        return company.getId();
    }

    @Override
    public ITCompany find(int id) {
        return entityManager.find(ITCompany.class, id);
    }

    @Override
    public void addDeveloper(Developer developer) {
        entityManager.persist(developer);

    }

    @Override
    public List<Employer> getEmployerByRole(ITRole role, int company_id) {

        List<Employer> employers = entityManager.createQuery("select e from Employer e where e.role = :role and e.company = :company", Employer.class)
                //HQL
                .setParameter("role", role)
                .setParameter("company", find(company_id))
                .getResultList();
        return employers;
    }

    @Override
    public Employer<ITRole> findEmployer(int employer_id) {
        Developer developer = entityManager.find(Developer.class, employer_id);
        return developer;
    }
}
