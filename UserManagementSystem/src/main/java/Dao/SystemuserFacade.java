/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Systemuser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nigelantwi-boasiako
 */
@Stateless
public class SystemuserFacade extends AbstractFacade<Systemuser> {
    @PersistenceContext(unitName = "com.FYP_UserManagementSystem_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SystemuserFacade() {
        super(Systemuser.class);
    }
    
    public void removeUser(int id){
        getEntityManager().remove(getEntityManager().find(Systemuser.class, id));
    }
    
    public void editUser(int id){
        getEntityManager().merge(getEntityManager().find(Systemuser.class, id));
    }
    
}
