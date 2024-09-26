package com.GeekBrains.lesson5;


public class Main {

    public static void main(String[] args) {

        int alarm_age=40;

        //просто создаю сотрудников потренить
       // Employee emp1=new Employee(1,"Sailor Siu","engineer","jdoe@gmail.zb","+79991234567",750,36);
       // Employee emp2=new Employee(2,"Adam Bart","CEO","adam@gmail.zb","+79991234568",700,18);
      //  Employee emp3=new Employee();
        //просто вывожу инфу по ним
       // emp1.getInfo();
      //   emp2.getInfo();
      //  emp3.getInfo();
      //  System.out.println("Возраст:"+emp3.getAge());

        //Создать массив из 5 сотрудников
        Employee[] persArray = new Employee[5];
        persArray[0]=new Employee(1,"Sailor Siu","engineer","jdoe@gmail.zb","+79991234567",750,36);
        persArray[1]=new Employee(2,"Adam Bart","CEO","adam@gmail.zb","+79991234568",700,18);
        persArray[2]=new Employee(3,"Vagner Love","Football","vagner@gmail.zb","+79991234368",700000,28);
        persArray[3]=new Employee(4,"Luk Saint","Comic","luk@mail.ru","+76991234568",1200,64);
        persArray[4]=new Employee(5,"Mazer Lion","Policeman","fucker@gmail.zb","+78981234568",2800,54);

        // С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        for (int i=0; i<5;i++)
        {
          //Последовательно создаём объект
            Employee emp=persArray[i];
            //получаем возраст через метод, если true, то выполняет метод получения информаци
            if (emp.getAge()>alarm_age) {
                emp.getInfo();
            }
        }
    }
}
