package org.example.leavesystem;

import java.util.List;

public class AuthService {
    public LeaveSystem leaveSystem;

    public AuthService(LeaveSystem leaveSystem){
        this.leaveSystem = leaveSystem;
    }

    public LoginResult login(String email, String password, String role){
        List<? extends User> users = role.equals("Manager")
                ? leaveSystem.getManagersGeneralList()
                : leaveSystem.getEmployeesGeneralList();

        for (User u : users){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                return new LoginResult(true, u);
            }
        }
        return new LoginResult(false, null);
    }
}
