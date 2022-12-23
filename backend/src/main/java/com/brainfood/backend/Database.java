
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
            this.instance= new Database();
        return this.instance;
    }

    public void query() {
        //
    }

    private Database() {
        //
    }
    
}
