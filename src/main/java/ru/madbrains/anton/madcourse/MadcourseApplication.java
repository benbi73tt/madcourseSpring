package ru.madbrains.anton.madcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.madbrains.anton.madcourse.company.ITCompany;
import ru.madbrains.anton.madcourse.config.CompanyConfig;

@SpringBootApplication //запуск tomcat
public class MadcourseApplication {
	public static void main(String[] args) {
		SpringApplication.run(MadcourseApplication.class, args);

	}

}
