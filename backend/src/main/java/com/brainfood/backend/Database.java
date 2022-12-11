
package com.brainfood.backend;

import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
public class Database {

    private Database instance;

    private Set<DAO> DAO;



    //                          Operations                                  

    public Set<DAO> getDAO() {
        if (this.DAO == null) {
            this.DAO = new HashSet<DAO>();
        }
        return this.DAO;
    }

    public Database getInstance() {
        //
        if(this.instance==null)
            return new Database();
        else
            return this.instance;
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
