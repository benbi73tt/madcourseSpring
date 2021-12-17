package ru.madbrains.anton.madcourse.company.employer;

public class QA extends Employer<ITRole> {

    public QA(String name, int age){
        super(name, age, ITRole.QA);
    }
    public void work(){
        System.out.println(this.getName() + " is testing");
    }
}
