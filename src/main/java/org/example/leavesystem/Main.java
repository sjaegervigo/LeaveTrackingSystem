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
        } while (role != null);
    }

    public static LoginResult login(String role){
        return new LoginResult(false, null);
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

    }


}