/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import com.mysql.cj.conf.ConnectionUrlParser;
import domain.GenericEntity;
import domain.Vlasnik;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;
import repository.db.DBConnectionFactory;
import repository.db.DbRepository;

/**
 *
 * @author Ilija Dumanović
 */
public class DbRepositoryGeneric implements DbRepository<GenericEntity, Object> {

    @Override
    public int add(GenericEntity param) throws Exception {
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(param.getTableName())
                    .append(" (").append(param.getColumnNamesForInsert()).append(")")
                    .append(" VALUES (")
                    .append(param.getInsertValues())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = statement.getGeneratedKeys();
            int id = -1;
            if (rsKey.next()) {
                id = rsKey.getInt(1);
                param.setId(id);
            }
            statement.close();
            rsKey.close();
            return id;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public int edit(GenericEntity param) throws Exception {
        try {

            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            //String sql = "INSERT INTO " + param.getTableName() + "(" + param.getInsertColumns() + ") VALUES (" + param.getInsertValues() + ")";
            sb.append("UPDATE ").append(param.getTableName()).append(" SET ").append(param.getUpdateValues()).append(" WHERE ").append(param.getID());
            String sql = sb.toString();
            System.out.println(sql);
            int broj = statement.executeUpdate(sql);

            statement.close();
            return broj;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Update item DB error: \n" + ex.getMessage());
        }
    }

    @Override
    public int delete(GenericEntity param) throws Exception {
        try {

            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            //String sql = "INSERT INTO " + param.getTableName() + "(" + param.getInsertColumns() + ") VALUES (" + param.getInsertValues() + ")";
            sb.append("DELETE FROM ").append(param.getTableName()).append(" WHERE ").append(param.getID());
            String sql = sb.toString();
            System.out.println(sql);
            int broj = statement.executeUpdate(sql);

            statement.close();
            return broj;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Delete item DB error: \n" + ex.getMessage());
        }
    }

    @Override
    public List<GenericEntity> getAll(GenericEntity param) throws Exception {
        List<GenericEntity> generics = new ArrayList<>();
        Connection connection = DBConnectionFactory.getInstance().getConnection();
        Statement statement = connection.createStatement();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append(param.getTableName()).append(param.getJoinText());
        String sql = sb.toString();
        System.out.println("repository.db.impl.DbRepositoryGeneric.getAll(), sql je:" + sql);
        ResultSet rs = statement.executeQuery(sql);
        int i = 0;
        while (rs.next()) {
            System.out.println("int i:" + ++i);
            generics.add(param.getEntity(rs));
        }
        System.out.println("repository.db.impl.DbRepositoryGeneric.getAll(), lista je:" + generics);
        statement.close();
        return generics;
    }

    @Override
    public GenericEntity getOne(GenericEntity param) throws Exception {
        GenericEntity genericEntity = null;

        Connection connection = DBConnectionFactory.getInstance().getConnection();
        Statement statement = connection.createStatement();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append(param.getTableName()).append(param.getJoinText()).append(" WHERE ").append(param.getID());
        String sql = sb.toString();
        System.out.println(sql);
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            genericEntity = param.getEntity(rs);
        }
        statement.close();

        return genericEntity;
    }

    @Override
    public List<GenericEntity> getAllByCriteria(GenericEntity param, Object criteria) throws Exception {
        List<GenericEntity> generics = new ArrayList<>();
        Pair<String, String> p = criteria instanceof Pair ? (Pair) criteria : new Pair<String,String>("id","-1");
        Connection connection = DBConnectionFactory.getInstance().getConnection();
        Statement statement = connection.createStatement();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append(param.getTableName())
                .append(param.getJoinText()).append(" WHERE ")
                .append(p.getKey()).append("=").append(p.getValue());
        String sql = sb.toString();
        System.out.println("repository.db.impl.DbRepositoryGeneric.getAll(), sql je:" + sql);
        ResultSet rs = statement.executeQuery(sql);
        int i = 0;
        while (rs.next()) {
            System.out.println("int i:" + ++i);
            generics.add(param.getEntity(rs));
        }
        System.out.println("repository.db.impl.DbRepositoryGeneric.getAll(), lista je:" + generics);
        statement.close();
        return generics;
    }

}
