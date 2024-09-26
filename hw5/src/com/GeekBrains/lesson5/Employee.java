package com.GeekBrains.lesson5;

//Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
public class Employee {
    int ID;
    String name;
    String position;
    String email;
    String phone;
    int salary;
    int age;
  //  Конструктор класса должен заполнять эти поля при создании объекта;
    Employee() {
        System.out.println("Объект создан");
        name="Jhon Doe";
        position="Anykeyman";

    }
    Employee (int ID,String name, String position, String email, String phone, int salary, int age)
    {
        this.name=name;
        this.position=position;
        this.email=email;
        this.phone=phone;
        this.salary=salary;
        this.age=age;
        this.ID=ID;
    }
    //Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    void getInfo()
    {
        System.out.println("ФИО:"+name+", должность:"+position+", почта:"+email+", телефон:"+phone+", зарплата:"+salary+" руб"+", возраст:"+age);
    }
    int getAge(){
        return age;
    }
}
