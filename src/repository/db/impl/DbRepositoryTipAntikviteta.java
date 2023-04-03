///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package repository.db.impl;
//
//import repository.db.*;
//import domain.TipAntikviteta;
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
//public class DbRepositoryTipAntikviteta implements DbRepository<TipAntikviteta, Integer> {
//
//    @Override
//    public void add(TipAntikviteta param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public int edit(TipAntikviteta param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public int delete(TipAntikviteta param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public List<TipAntikviteta> getAll() throws Exception {
//        List<TipAntikviteta> tipovi = new ArrayList<>();
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "SELECT id, naziv FROM tipantikviteta ";
//        PreparedStatement ps = connection.prepareStatement(query);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            TipAntikviteta tip = new TipAntikviteta(rs.getInt("id"), rs.getString("naziv"));
//            tipovi.add(tip);
//        }
//        connection.close();
//        return tipovi;
//    }
//
//    @Override
//    public List<TipAntikviteta> getAll(TipAntikviteta param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public TipAntikviteta getOne(Integer id) throws Exception {
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "SELECT naziv FROM tipantikviteta WHERE id=? ";
//        PreparedStatement ps = connection.prepareStatement(query);
//        ps.setInt(1, id);
//        ResultSet rs = ps.executeQuery();
//        TipAntikviteta tip = null;
//        while (rs.next()) {
//            tip = new TipAntikviteta(id, rs.getString("naziv"));
//        }
//
//        connection.close();
//        return tip;
//    }
//
//}
