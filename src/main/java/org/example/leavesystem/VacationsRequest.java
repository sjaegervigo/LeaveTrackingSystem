package org.example.leavesystem;

import java.time.LocalDate;

public class VacationsRequest extends LeaveRequest{

    public VacationsRequest(){
        super();
        this.setReason("Vacations");
    }

    public VacationsRequest(Employee requestingEmployee, LocalDate startDate, LocalDate endDate){
        super(requestingEmployee, startDate, endDate, "Vacations");
    }

    @Override
    public String toString() {
        return "VacationsRequest{}" + super.toString();
    }
}
