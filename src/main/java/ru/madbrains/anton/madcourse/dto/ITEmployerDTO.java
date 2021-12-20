package ru.madbrains.anton.madcourse.dto;

import lombok.Data;
import ru.madbrains.anton.madcourse.company.employer.Employer;
import ru.madbrains.anton.madcourse.company.employer.ITRole;

@Data
public class ITEmployerDTO {
    private int id;
    private String name;
    private int age;
    private ITRole role;

    public static ITEmployerDTO from(Employer<ITRole> employer){
        ITEmployerDTO dto = new ITEmployerDTO();
        dto.setAge(employer.getAge());
        dto.setId(employer.getId());
        dto.setName(employer.getName());
        dto.setRole(employer.getRole());
        return dto;
    }
    public Employer<ITRole> toEmployer(){
        Employer<ITRole> employer = new Employer<>();
        employer.setId(this.id);
        employer.setAge(this.age);
        employer.setName(this.name);
        employer.setRole(this.role);
        return employer;
    }
}
