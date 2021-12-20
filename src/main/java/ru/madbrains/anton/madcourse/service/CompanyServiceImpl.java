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
import ru.madbrains.anton.madcourse.dao.CompanyDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyDAO companyDAO;


    @Override
    @Transactional
    public Integer createCompany(ITCompany company) {
        return companyDAO.create(company);
    }

    @Override
    public ITCompany getCompany(int id) {
        return companyDAO.find(id);
    }

    @Override
    @Transactional
    public void addDeveloper(Developer developer, int company_id) {
        developer.setCompany(getCompany(company_id));
        companyDAO.addDeveloper(developer);
    }

    @Override
    public List<Employer> getEmployersByRole(ITRole role, int company_id) {
        return companyDAO.getEmployerByRole(role, company_id);
    }

    @Override
    @Transactional
    public Employer<ITRole> getEmployerByIndex(int index) {
       return companyDAO.findEmployer(index);
    }


}
