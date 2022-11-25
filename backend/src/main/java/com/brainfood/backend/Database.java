package SWE Project;


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
    private Database getInstance() {
        return this.instance;
    }
    
    /**
    * @generated
    */
    private Database setInstance(Database instance) {
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
    public Set<DAO> setDAO(DAO DAO) {
        this.DAO = DAO;
    }
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public Database getInstance() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public void query() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    private Database() {
        //TODO
    }
    
}
