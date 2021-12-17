package ru.madbrains.anton.madcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.madbrains.anton.madcourse.company.ITCompany;
import ru.madbrains.anton.madcourse.config.CompanyConfig;

//@SpringBootApplication
public class MadcourseApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(CompanyConfig.class);

		// ITCompany company = context.getBean("CompanyComponent",ITCompany.class);
		ITCompany company = context.getBean(ITCompany.class);
		System.out.println(company.getName());
		System.out.println(company.getDirector());

	}

}
