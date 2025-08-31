/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import entity.GenericEntity;
import java.util.ArrayList;
import java.util.List;
import repository.DBRepository;
import java.sql.Connection;
import repository.DBConnectionFactory;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class RepositoryDBGeneric implements DBRepository<GenericEntity> {

    @Override
    public List<GenericEntity> get(GenericEntity t) throws Exception {
        List<GenericEntity> entities = new ArrayList<>();
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append(t.getSelectedValues());
            String query = sb.toString();

            Statement statement = connection.createStatement();
            System.out.println("Query: " + query);
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                entities.add(t.getNewObject(rs));
            }
            return entities;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericEntity create(GenericEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity update(GenericEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(GenericEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity getById(GenericEntity t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
