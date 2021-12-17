package ru.madbrains.anton.madcourse.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.madbrains.anton.madcourse.company.employer.ITRole;
import ru.madbrains.anton.madcourse.company.employer.Employer;

import java.util.List;
import java.util.Objects;

@Component("CompanyComponent")
public class ITCompany extends EntityManager<Employer> {
    //@Value("MadBrains")
    private String name;

    @Autowired
    private Employer<ITRole> director;


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
        super(maxExampleCount, Employer.class);
        this.name = companyName;
    }

    public void startWork() {
        for (int i = 0; i < this.getSize(); i++) {
            List<Employer<ITRole>> workers = this.getEntities();
            Employer worker = workers.get(i);
            worker.work();
            System.out.println(worker.getName() + " is " + worker.getRole());
        }
    }

    public String getName() {
        return name;
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
