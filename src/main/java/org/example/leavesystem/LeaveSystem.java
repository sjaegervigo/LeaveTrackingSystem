package org.example.leavesystem;

import java.util.ArrayList;
import java.util.List;

public class LeaveSystem {

    // Instance to use singleton
    private static LeaveSystem instance;

    private List<Employee> employeesGeneralList = new ArrayList<>();
    private List<Manager> managersGeneralList = new ArrayList<>();
    private List<LeaveRequest> allRequestsGeneralList = new ArrayList<>();

    private LeaveSystem(){
        System.out.println("Leave System correctly loaded!");
    }

    // Singleton implementation

    public static LeaveSystem getInstance(){
        if(instance == null){
            instance = new LeaveSystem();
        }
        return instance;
    }

    // Other methods

    public void addEmployee(Employee e){
        this.employeesGeneralList.add(e);
    }

    public List<Employee> getEmployeesGeneralList(){
        return this.employeesGeneralList;
    }

    public void addManager(Manager m){
        this.managersGeneralList.add(m);
    }

    public List<Manager> getManagersGeneralList(){
        return this.managersGeneralList;
    }

    public void addLeaveRequest(LeaveRequest lr){
        this.allRequestsGeneralList.add(lr);
    }

    public List<LeaveRequest> getAllRequestsGeneralList(){
        return this.allRequestsGeneralList;
    }




}
