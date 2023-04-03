///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package repository.db.impl;
//
//import repository.db.*;
//import domain.Mesto;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author Ilija Dumanović
// */
//public class DbRepositoryMesto implements DbRepository<Mesto, Integer> {
//
//    @Override
//    public void add(Mesto param) throws Exception {
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "INSERT INTO mesto(naziv,ptt) VALUES (?,?);";
//        PreparedStatement ps = connection.prepareStatement(query);
//
//        ps.setString(1, param.getNaziv());
//        ps.setInt(2, param.getPtt());
//
//        int br=ps.executeUpdate();
//        ps.close();
//        connection.close();
//    }
//
//    @Override
//    public int edit(Mesto param) throws Exception {
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "UPDATE mesto SET naziv = ?, ptt=? WHERE id=?";
//        PreparedStatement ps = connection.prepareStatement(query);
//
//        ps.setString(1, param.getNaziv());
//        ps.setInt(2, param.getPtt());
//        ps.setInt(3, param.getId());
//        int br=ps.executeUpdate();
//
//        connection.commit();
//        ps.close();
//        connection.close();
//        return br;
//    }
//
//    @Override
//    public int delete(Mesto param) throws Exception {
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//
//        String query = "delete from mesto where id = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setInt(1, param.getId());
//
//        int br=preparedStatement.executeUpdate();
//        preparedStatement.close();
//        connection.close();
//        return br;
//    }
//
//    @Override
//    public List<Mesto> getAll() throws Exception {
//        List<Mesto> mesta = new ArrayList<>();
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "SELECT id, naziv, ptt FROM mesto ";
//        PreparedStatement ps = connection.prepareStatement(query);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            Mesto mesto = new Mesto(rs.getInt("id"), rs.getString("naziv"), rs.getInt("ptt"));
//            mesta.add(mesto);
//        }
//        connection.close();
//        return mesta;
//    }
//
//    @Override
//    public List<Mesto> getAll(Mesto param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Mesto getOne(Integer id) throws Exception {
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "SELECT naziv, ptt FROM mesto WHERE id=? ";
//        PreparedStatement ps = connection.prepareStatement(query);
//        ps.setInt(1, (int)id);
//        ResultSet rs = ps.executeQuery();
//        
//        Mesto mesto = null;
//        while (rs.next()) {
//            mesto = new Mesto(id, rs.getString("naziv"), rs.getInt("ptt"));
//        }
//        
//        
//        ps.close();
//        connection.close();
//        return mesto;
//    }
//
//}
