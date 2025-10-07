package org.example.leavesystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee extends User{

    // Properties
    private Integer leaveBalance;
    private List<LeaveRequest> leaveRequests = new ArrayList<>();

    // Attributes
    public Employee(){
        super();
        this.leaveBalance = 20;
    }

    // Constructors
    public Employee(String name, String email, String password){
        super(name, email, password);
        this.leaveBalance = 20;
    }

    //Getters and setters

    public Integer getLeaveBalance(){
        return this.leaveBalance;
    }

    public void setLeaveBalance(Integer newBalance){
        this.leaveBalance = newBalance;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString()+"\n"+
                ", leaveBalance=" + leaveBalance +
                '}';
    }

    // Other methods

    public void createLeaveRequest(LocalDate startDate, LocalDate endDate, String reason){
        LeaveRequest lr = new LeaveRequest();
        lr.setStartDate(startDate);
        lr.setEndDate(endDate);
        lr.setReason(reason);
        lr.setRequestingEmployee(this);
        this.leaveRequests.add(lr);
    }

    public List<LeaveRequest> getLeaveRequests(){
        return this.leaveRequests;
    }

    public LeaveRequest getLeaveRequestsById(Integer leaveRequestId){
        return this.leaveRequests.stream()
                .filter(r -> r.getId().equals(leaveRequestId))
                .findFirst()
                .orElse(null);
    }

    public LeaveRequest consultLastLeaveRequest(){
        return this.leaveRequests.getLast();
    }

    public boolean cancelLeaveRequestById(Integer leaveRequestIndex){
        LeaveRequest lrToDelete = this.leaveRequests.stream().filter(r -> r.getId().equals(leaveRequestIndex))
                .findFirst().orElse(null);
        if(lrToDelete != null){
            leaveRequests.remove(lrToDelete);
            return true;
        } else {
            System.out.println("There is no a leave request with index "+ leaveRequestIndex);
            return false;
        }
    }
}
