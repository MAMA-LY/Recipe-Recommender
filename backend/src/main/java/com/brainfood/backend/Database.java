
package com.brainfood.backend;

import java.util.HashSet;
import java.util.Set;

/**
* @generated
*/
public class Database {
    
    /**
    * @generated
    */
    private Database instance;
    
    
    /**
    * @generated
    */
    private Set<DAO> DAO;
    
    

    /**
    * @generated
    */
    // private Database getInstance() {
    //     return this.instance;
    // }
    
    /**
    * @generated
    */
    private void setInstance(Database instance) {
        this.instance = instance;
    }
    
    
    
    /**
    * @generated
    */
    public Set<DAO> getDAO() {
        if (this.DAO == null) {
            this.DAO = new HashSet<DAO>();
        }
        return this.DAO;
    }
    
    /**
    * @generated
    */
    public void setDAO(Set<DAO> DAO) {
        this.DAO = DAO;
    }

    //                          Operations                                  
    
    /**
    * @generated
    */
    public Database getInstance() {
        //
        return null;
    }
    
    /**
    * @generated
    */
    public void query() {
        //
    }
    
    /**
    * @generated
    */
    private Database() {
        //
    }
    
}
