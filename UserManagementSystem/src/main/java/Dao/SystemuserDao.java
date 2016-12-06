/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Systemuser;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nigelantwi-boasiako
 */
public class SystemuserDao {

    private List<Systemuser> userList = new ArrayList<>();

    private UserList list = new UserList();

    public void addUser(Systemuser u) {
        userList.add(u);
    }

    public void removeUser(Systemuser u) {
        userList.remove(u);
    }
    
    public void edit(Systemuser u){
        for(Systemuser us:userList){
            if(us.getId()==u.getId()){
                userList.remove(u);
                userList.add(u);
            }
        }
    }

    /**
     * User is information is serialized to a file called user.xml.
     */
    public void saveUser() {
        list.setUserList(userList);
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("user.xml")));
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("error: Creating or opening user.xml");
        }
        encoder.writeObject(list);
        encoder.close();
    }

    /**
     * 
     * @return a list of users from the user.xml file.
     */
    public List<Systemuser> findUsers() {
        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("user.xml")));
        } catch (FileNotFoundException e) {
            System.out.println("error:user.xml not found");
        }
        UserList users = (UserList) decoder.readObject();
        return users.getUserList();
    }
    
    

}
