/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/***
 * Common methods used to perform business actions for Data Access Objects
 * @author Lenovo
 * @param <T>: Generic Type for DAO classes
 */
public interface Accessible <T>{
    
    /**
     * An method for insert a record into table
     * @param obj: new object to be added
     * @return 
     */
    int insertRec(T obj);
    
    /**
     * An method for update a record in table
     * @param obj: new object to be update, this object will replace the old object
     * @return 
     */
    int updateRec(T obj);
    
    /**
     * An method for delete a record in table
     * @param obj: object that needed to be deleted
     * @return 
     */
    int deleteRec(T obj);
    
    /**
     * Search for an object in table with given String id and return
     * @param id: id of the object
     * @return 
     */
    T getObjectById(String id);
    
    /**
     * Get all records in the table, add to a List and return it
     * @return 
     */
    List<T> listAll();
    
    
}
