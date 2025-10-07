package org.example.leavesystem;

import java.time.LocalDate;

public class EmergencyRequest  extends LeaveRequest{

    private String emergencyNote;

    public EmergencyRequest(){
        super();
        this.emergencyNote = "update this field please";
    }

    public EmergencyRequest(Employee employee, LocalDate newStartDate, LocalDate newEndDate, String reason, String emergencyNote){
        super(employee, newStartDate, newEndDate, reason);
        this.emergencyNote = emergencyNote;
    }

    public String getEmergencyNote() {
        return emergencyNote;
    }

    public void setEmergencyNote(String emergencyNote) {
        this.emergencyNote = emergencyNote;
    }

    @Override
    public String toString() {
        return "EmergencyRequest{" + super.toString()+ "\n "+
                "emergencyNote='" + emergencyNote + '\'' +
                '}';
    }
}
