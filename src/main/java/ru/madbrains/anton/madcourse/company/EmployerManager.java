package ru.madbrains.anton.madcourse.company;

import ru.madbrains.anton.madcourse.company.employer.Employer;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@MappedSuperclass
public class EmployerManager<T extends Employer> {
    //@JsonIgnore // скрыть поле
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private List<T> employers;

    @SuppressWarnings("unchecked")
    public EmployerManager() {
        this.employers = new ArrayList<>();
    }



    public int getSize() {
        return employers.size();
    }

    public List<T> getEmployers() {
        return employers;
    }
}

