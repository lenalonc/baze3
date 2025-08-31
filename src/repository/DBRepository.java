/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.SQLException;
import java.io.IOException;

/**
 *
 * @author user
 */
public interface DBRepository<T> extends Repository<T>{
    public default void connect() throws SQLException, IOException{
        DBConnectionFactory.getInstance().getConnection();
    }
    
    public default void disconnect() throws SQLException, IOException{
        DBConnectionFactory.getInstance().getConnection().close();
    }
    
    public default void commit() throws SQLException, IOException{
        DBConnectionFactory.getInstance().getConnection().commit();
    }
    
    public default void rollback() throws SQLException, IOException{
        DBConnectionFactory.getInstance().getConnection().rollback();
    }
}
