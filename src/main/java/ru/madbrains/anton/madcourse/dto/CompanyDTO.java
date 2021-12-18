package ru.madbrains.anton.madcourse.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import ru.madbrains.anton.madcourse.company.ITCompany;
import ru.madbrains.anton.madcourse.company.employer.Employer;
import ru.madbrains.anton.madcourse.company.employer.ITRole;

import java.util.List;

@Data //автоматически сгенерировались set'еры
public class CompanyDTO {
    private String name;
    private Employer<ITRole> director;
    private List<Employer<ITRole>> employers;

    public static CompanyDTO from(ITCompany company) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setDirector(company.getDirector());
        companyDTO.setName(company.getName());
        companyDTO.setEmployers(company.getEmployers());
        return companyDTO;
    }


}
