package org.example.leavesystem;

import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final LeaveSystem leaveSystem = LeaveSystem.getInstance();
    private static final Scanner sc = new Scanner(System.in);
    private static final AuthService authService = new AuthService(leaveSystem);

    public static void main(String[] args){
        loadData();

        do{
            String role = askForRol();
            if(role == null){
                System.out.println("Goodbye");
                break;
            }

            LoginResult result = login(role);
            if(result.isGranted()){
                System.out.println("Loged as " +role);
                System.out.println("Welcome " + result.getUser().getName() + "!");
                if(role.equals("Employee")){
                    showEmployeeMenu((Employee) result.getUser());
                } else if(role.equals("Manager")){
                    //showManagerMenu();
                }
            } else {
                System.out.println("Email or password incorrect for rol " + role);
            }
        } while (true);
    }

    public static void showEmployeeMenu(Employee logedEmployee){
        System.out.println("What do you want to do now?\n");
        System.out.println("1. View my leave requests");
        System.out.println("2. Create new leave request");
        try{
            int userOption = Integer.parseInt(sc.nextLine());
            switch (userOption){
                case 1 -> System.out.println(logedEmployee.getLeaveRequests());
                case 2 -> {
                    System.out.println("What kind of leave request do you want to create?");
                    System.out.println("1. Vacation request");
                    System.out.println("2. Medical request");
                    System.out.println("3. Emergency request");
                    userOption = Integer.parseInt(sc.nextLine());
                    switch (userOption){
                        case 1 -> {
                            System.out.println("Enter the start date: ");
                            String startDate = sc.nextLine();
                            System.out.println("Enter the end date: ");
                            String endDate = sc.nextLine();
                            VacationsRequest vr = new VacationsRequest(logedEmployee, LocalDate.parse(startDate), LocalDate.parse(endDate));
                            logedEmployee.getLeaveRequests().add(vr);
                            leaveSystem.addLeaveRequest(vr);
                        }
                    }
                }
            }

        } catch (NumberFormatException e){
            System.out.println( "\n++++++++++++++++++++++++++++++++++++++\n"+
                                "++ Exception catched!!              ++\n"+
                                "++ Cause:                           ++\n"+
                                "++ "+e.getMessage()+   "            ++\n"+
                                "++++++++++++++++++++++++++++++++++++++\n");

        }


    }

    public static LoginResult login(String role){
        System.out.println("Enter your email");
        String email = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();
        return authService.login(email, password, role);
    }

    public static void loadData(){
        authService.leaveSystem.addEmployee(new Employee("Sebastian", "sjaegervigo@gmail.com", "admin"));
        authService.leaveSystem.addManager(new Manager("Alejandro", "ajaegervigo@gmail.com", "admin"));
    }

    public static String askForRol(){
        System.out.println("Who are you?");
        System.out.println("1. Employee");
        System.out.println("2. Manager");
        System.out.println("-------------");
        System.out.println("0. Exit");
        try{
            int option = Integer.parseInt(sc.nextLine());
            return switch (option){
                case 1 -> "Employee";
                case 2 -> "Manager";
                case 0 -> null;
                default -> {
                    System.out.println("Invalid option");
                    yield askForRol();
                }
            };

        } catch (NumberFormatException e){
            System.out.println( "\n++++++++++++++++++++++++++++++++++++++\n"+
                                "++ Exception catched!!              ++\n"+
                                "++ Cause:                           ++\n"+
                                "++ "+e.getMessage()+   "            ++\n"+
                                "++++++++++++++++++++++++++++++++++++++\n");
            askForRol();
        }
        return null;
    }
}