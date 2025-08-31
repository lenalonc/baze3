/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public interface GenericEntity {
    String getTableName();
    
    String getColumnNamesForInsert();
    
    String getInsertValues();
    
    void setId(Long id);
    
    String getSelectedValues();
    
    GenericEntity getNewObject(ResultSet rs) throws SQLException;
    
    String getDeleteAndUpdateCondition(Object object);
    
    String getUpdateSetValues(Object object);
}
