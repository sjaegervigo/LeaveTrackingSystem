package org.example.leavesystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee {

    // Properties
    private static final AtomicInteger count = new AtomicInteger(0); //maneja los incrementos de manera segura en contextos multihilo
    private final Integer id;
    private String name;
    private String email;
    private Integer leaveBalance;
    private List<LeaveRequest> leaveRequests = new ArrayList<>();

    // Attributes
    public Employee(){
        this.id = count.incrementAndGet();
        this.name = "change name";
        this.email = "change email";
        this.leaveBalance = 20;
    }

    // Constructors
    public Employee(String name, String email){
        this.id = count.incrementAndGet();
        this.name = name;
        this.email = email;
        this.leaveBalance = 20;
    }

    public Integer getId() {
        return id;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Integer getCount(){
        return count.get();
    }

    public Integer getLeaveBalance(){
        return this.leaveBalance;
    }

    public void setLeaveBalance(Integer newBalance){
        this.leaveBalance = newBalance;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
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
