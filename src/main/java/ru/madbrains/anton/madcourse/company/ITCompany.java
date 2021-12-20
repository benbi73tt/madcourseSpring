package ru.madbrains.anton.madcourse.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.madbrains.anton.madcourse.company.employer.ITRole;
import ru.madbrains.anton.madcourse.company.employer.Employer;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="companies")
public class ITCompany extends EmployerManager<Employer<ITRole>> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //@Value("MadBrains")
    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    private Employer<ITRole> director;

    public ITCompany(String companyName) {
        super();
        this.name = companyName;
    }

    public ITCompany() {}


    public void setName(String name) {
        this.name = name;
    }

    public void setDirector(Employer<ITRole> director) {
        this.director = director;
    }

    public Employer<ITRole> getDirector() {
        return director;
    }

//    public ITCompany() {
//        super(100, Employer.class);
//    }

    public ITCompany(@Qualifier("CompanyName") String companyName,
                     @Qualifier("MaxEmployerCount") int maxExampleCount) {
        this.name = companyName;
    }

//    public void startWork() {
//        for (int i = 0; i < this.getSize(); i++) {
//            List<Employer<ITRole>> workers = this.getEmployers();
//            Employer worker = workers.get(i);
//            worker.work();
//            System.out.println(worker.getName() + " is " + worker.getRole());
//        }
//    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ITCompany {" +
                "name = '" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ITCompany company = (ITCompany) o;
        return Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
