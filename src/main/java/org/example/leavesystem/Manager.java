package org.example.leavesystem;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Manager extends User{

    // Constructors

    public Manager(){
        super();
    }

    public Manager(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public String toString() {
        return "Manager{" + super.toString()+"\n"+
                '}';
    }

    // Other methods

    public void listPendingRequestsForEmployee(Employee employee){
        System.out.println("Consult pending requests for employee: "+ employee.getId() +" - "+ employee.getName());
        System.out.println(employee.getLeaveRequests().stream()
                .filter( r -> r.getState().equals(LeaveRequest.State.SENT))
                .toList());

    }

    public boolean changeStateOfLeaveRequest(Employee employee){

        System.out.println("Consulting leave requests of the employee: " + employee.getId() + " - "+ employee.getName());
        if(employee.getLeaveRequests().isEmpty()){
            System.out.println("There is no leave requests for this employee.");
            return false;
        } else {
            System.out.println("Please choose a leave request:");
            System.out.println(employee.getLeaveRequests());
            Scanner sc = new Scanner(System.in);
            String userOption = sc.nextLine();
            Integer leaveRequestIndex = Integer.parseInt(userOption);
            System.out.println("Choose a new state for this leave request: ");
            for(LeaveRequest.State c : LeaveRequest.State.values()){
                System.out.println(c.ordinal() + " - " + c.name());
            }
            int newStateIndex = Integer.parseInt(sc.nextLine());
            LeaveRequest chosenRequest = employee.getLeaveRequestsById(leaveRequestIndex);
            if(chosenRequest != null){
                try {
                    chosenRequest.setState(LeaveRequest.State.values()[newStateIndex]);
                    return true;
                } catch (IndexOutOfBoundsException e){
                    System.out.println(e.getMessage());
                    return false;
                }
            } else {
                System.out.println("The chosen request is null");
                return false;
            }
        }

    }
}
