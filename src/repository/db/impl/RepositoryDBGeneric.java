/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import java.sql.CallableStatement;
import entity.GenericEntity;
import java.util.ArrayList;
import java.util.List;
import repository.DBRepository;
import java.sql.Connection;
import repository.DBConnectionFactory;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import oracle.jdbc.OraclePreparedStatement;

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
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(t.getTableName())
                    .append(t.getColumnNamesForInsert())
                    .append(" VALUES ")
                    .append(t.getInsertValues());

            String query = sb.toString();
            PreparedStatement statement = connection.prepareStatement(query);
            System.out.println("Query: " + query);

            ((OraclePreparedStatement) statement).registerReturnParameter(1, java.sql.Types.BIGINT);
            statement.executeUpdate();
            ResultSet rs = ((OraclePreparedStatement) statement).getReturnResultSet();
            Long id = null;
            if (rs.next()) {
                id = rs.getLong(1);
            }
            rs.close();
            t.setId(id);
            statement.close();
            return t;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericEntity update(GenericEntity t) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ")
                    .append(t.getTableName())
                    .append(" SET ")
                    .append(t.getUpdateSetValues(t))
                    .append(" WHERE ")
                    .append(t.getDeleteAndUpdateCondition(t));
            String query = sb.toString();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            return t;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(GenericEntity t) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ")
                    .append(t.getTableName())
                    .append(" WHERE ")
                    .append(t.getDeleteAndUpdateCondition(t));

            Statement statement = connection.createStatement();
            String query = sb.toString();
            statement.executeUpdate(query);
            statement.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public GenericEntity getById(GenericEntity t) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append(t.getSelectedValues())
                    .append(" WHERE ")
                    .append(t.getDeleteAndUpdateCondition(t));
            String query = sb.toString();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                GenericEntity e = t.getNewObject(rs);
                return e;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<GenericEntity> getWithCondition(GenericEntity t, String whereClause) throws Exception {
        List<GenericEntity> entities = new ArrayList<>();
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append(t.getSelectedValues())
                    .append(" WHERE ")
                    .append(whereClause);
            String query = sb.toString();

            Statement statement = connection.createStatement();
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

}
