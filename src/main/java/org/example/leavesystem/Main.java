package org.example.leavesystem;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Employee e1 = new Employee();
        e1.setName("Pedro");
        e1.setEmail("pedrosky@gmail.com");

        System.out.println(e1);

        Employee e2 = new Employee("Raul", "raulito@gmail.com");

        System.out.println(e2);
        System.out.println(e1);

        System.out.println(Employee.getCount());
    }
}