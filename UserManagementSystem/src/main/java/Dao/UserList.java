/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nigelantwi-boasiako
 */
public class UserList {
    
    private List userList = new ArrayList<>();
    
    public UserList(){
        
    } 

    public List getUserList() {
        return userList;
    }

    public void setUserList(List userList) {
        this.userList = userList;
    }
}
