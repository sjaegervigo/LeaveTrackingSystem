package org.example.leavesystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LeaveRequest {

    private static final AtomicInteger count = new AtomicInteger(0);
    private final Integer id;
    private Employee requestingEmployee;
    private Integer daysRequested;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private State state;

    public enum State{
        SENT, // request sent to its revision
        APPROVED, // request approved but not started
        REJECTED, // request not approved
        POSTPONED, // request postponed to another date
        IN_PROGRESS, // employee is in leave
        ENDED // leave terminated
    };

    public LeaveRequest(){
        this.id = count.incrementAndGet();
        this.requestingEmployee = null;
        this.daysRequested = null;
        this.startDate = null;
        this.endDate = null;
        this.reason = null;
        this.state = State.SENT;
    }

    public LeaveRequest(Employee requestingEmployee, LocalDate startDate, LocalDate endDate, String reason){
        this.id = count.incrementAndGet();
        this.requestingEmployee = requestingEmployee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.daysRequested =(int) ChronoUnit.DAYS.between(startDate, endDate);
        this.reason = reason;
        this.state = State.SENT;
    }

    public Integer getId(){
        return this.id;
    }

    // This function returns the number of existing objects of the class
    public static Integer getCount(){
        return count.get();
    }

    public Employee getRequestingEmployee(){
        return this.requestingEmployee;
    }

    public void setRequestingEmployee(Employee requestingEmployee){
        this.requestingEmployee=requestingEmployee;
    }

    public Integer getDaysRequested(){
        return this.daysRequested;
    }

    private void setDaysRequested(LocalDate newStartDay, LocalDate newEndDay){
        this.daysRequested = (int) ChronoUnit.DAYS.between(newStartDay,newEndDay);
    }

    public LocalDate getStartDate(){
        return this.startDate;
    }

    public void setStartDate(LocalDate newStartDate){
        this.startDate = newStartDate;
        if(this.endDate != null){
            setDaysRequested(this.startDate, this.endDate);
            System.out.println("Number of days requested updated!");
        } else {
            System.out.println("Don't forget to set the end date too!");
        }
    }

    public LocalDate getEndDate(){
        return this.endDate;
    }

    public void setEndDate(LocalDate newEndDate){
        this.endDate = newEndDate;
        if(this.startDate != null){
            setDaysRequested(this.startDate, this.endDate);
            System.out.println("Number of days requested updated!");
        } else {
            System.out.println("Don't forget to set the start date too!");
        }
    }

    public String getReason(){
        return this.reason;
    }

    public void setReason(String newReason){
        this.reason = newReason;
    }

    public State getState(){
        return this.state;
    }

    public void setState(State newState){
        this.state = newState;
    }

    @Override
    public String toString() {
        return "LeaveRequest{" +
                "id=" + id +
                ", requestingEmployee=" + requestingEmployee +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", daysRequested=" + daysRequested +
                ", reason='" + reason + '\'' +
                ", state=" + state +
                '}';
    }
}
