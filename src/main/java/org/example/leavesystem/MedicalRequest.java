package org.example.leavesystem;

import java.time.LocalDate;

public class MedicalRequest extends LeaveRequest{

    private String doctorNote;

    public MedicalRequest() {
        super();
        this.doctorNote = "update this field please";
    }

    public MedicalRequest(Employee requestingEmployee, LocalDate startDate, LocalDate endDate, String reason, String doctorNote) {
        super(requestingEmployee, startDate, endDate, reason);
        this.doctorNote = doctorNote;
    }

    public String getDoctorNote() {
        return doctorNote;
    }

    public void setDoctorNote(String doctorNote) {
        this.doctorNote = doctorNote;
    }

    @Override
    public String toString() {
        return "MedicalRequest{" + super.toString()+ "\n "+
                "doctorNote='" + doctorNote + '\'' +
                '}';
    }
}
