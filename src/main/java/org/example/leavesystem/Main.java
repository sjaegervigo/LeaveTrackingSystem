package org.example.leavesystem;

import java.time.LocalDate;

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

        LocalDate newStartDate = LocalDate.of(2025, 10 ,8);
        LocalDate newEndDate = LocalDate.of(2025, 10 ,20);

        e1.createLeaveRequest(newStartDate, newEndDate, "I need vacations to visit my mom, because she is sick");

        System.out.println(e1.consultLastLeaveRequest());
    }
}