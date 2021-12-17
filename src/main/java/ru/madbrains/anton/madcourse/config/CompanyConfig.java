package ru.madbrains.anton.madcourse.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.madbrains.anton.madcourse.company.ITCompany;
import ru.madbrains.anton.madcourse.company.employer.Employer;
import ru.madbrains.anton.madcourse.company.employer.ITRole;

@Configuration
@ComponentScan("ru.madbrains.anton.madcourse.company")
public class CompanyConfig {

//    @Bean
//    @Primary //bean по умолчанию
//    public ITCompany getITCompany(Employer<ITRole> director){
//        ITCompany company = new ITCompany("MadBrains222222222", 100);
//        company.setDirector(director);
//        return company;
//    }
//
//    @Bean
//    public ITCompany getAnotherItCompany(){
//        return new ITCompany("SomeCompany",200);
//    }



    @Bean
    public Employer<ITRole> getDirector(){
        return new Employer<>("Oleg",30,ITRole.Director) {
            @Override
            public void work() {
                System.out.println(this.getName() + " is director");
            }
        };
    }

    @Bean("CompanyName")
    public String getCompanyName(){
        return "MadBrains";
    }

    @Bean("MaxEmployerCount")
    public int getCount(){
        return 100;
    }

}
