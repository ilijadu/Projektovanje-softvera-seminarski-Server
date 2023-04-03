///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package repository.db.impl;
//
//import repository.db.*;
//import domain.Antikvitet;
//import domain.Aukcija;
//import domain.ProdajaAntikviteta;
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
//public class DbRepositoryProdajaAntikviteta implements DbRepository<ProdajaAntikviteta, Integer> {
//
//    @Override
//    public void add(ProdajaAntikviteta param) throws Exception {
//
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "INSERT INTO prodaja_antikviteta(antikvitet_id,aukcija_id,cena,valuta) VALUES (?,?,?,?);";
//        PreparedStatement ps = connection.prepareStatement(query);
//
//        ps.setInt(1, param.getAntikvitet().getId());
//        ps.setInt(2, param.getAukcija().getId());
//        ps.setDouble(3, param.getCena());
//        ps.setString(4, param.getValuta().toString());
//
//       int br=ps.executeUpdate();
//        ps.close();
//        connection.close();
//
//    }
//
//    @Override
//    public int edit(ProdajaAntikviteta param) throws Exception {
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "UPDATE prodaja_antikviteta SET cena=?,valuta=? WHERE antikvitet_id=? and aukcija_id=?;";
//        PreparedStatement ps = connection.prepareStatement(query);
//
//        ps.setInt(3, param.getAntikvitet().getId());
//        ps.setInt(4, param.getAukcija().getId());
//        ps.setDouble(1, param.getCena());
//        ps.setString(2, param.getValuta().toString());
//
//        int br=ps.executeUpdate();
//        ps.close();
//        connection.close();
//        return br;
//    }
//
//    @Override
//    public int delete(ProdajaAntikviteta param) throws Exception {
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//
//        String query = "delete from aukcija where antikvitet_id=? and aukcija_id=?;";
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setInt(1, param.getAntikvitet().getId());
//        preparedStatement.setInt(2, param.getAukcija().getId());
//
//        int br=preparedStatement.executeUpdate();
//        preparedStatement.close();
//        connection.close();
//        return br;
//    }
//
//    @Override
//    public List<ProdajaAntikviteta> getAll() throws Exception {
//        List<ProdajaAntikviteta> antikviteti = new ArrayList<>();
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "SELECT an.id, au.id, p.cena, p.valuta FROM prodaja_antikviteta p "
//                + "JOIN antikvitet an ON p.antikvitet_id=an.id JOIN aukcija au ON au.id=p.aukcija_id";
//        PreparedStatement ps = connection.prepareStatement(query);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            Antikvitet antikvitet = new DbRepositoryAntikvitet().getOne(rs.getInt("an.id"));
//            Aukcija aukcija = new DbRepositoryAukcija().getOne(rs.getInt("au.id"));
//            ProdajaAntikviteta prod_ant = new ProdajaAntikviteta(antikvitet, aukcija, rs.getDouble("p.cena"));
//            antikviteti.add(prod_ant);
//        }
//        connection.close();
//        return antikviteti;
//    }
//
//    @Override
//    public List<ProdajaAntikviteta> getAll(ProdajaAntikviteta param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public ProdajaAntikviteta getOne(Integer id) throws Exception {
//        
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "SELECT an.id, au.id, p.cena, p.valuta FROM prodaja_antikviteta p "
//                + "JOIN antikvitet an ON p.antikvitet_id=an.id JOIN aukcija au ON au.id=p.aukcija_id";
//        
//        PreparedStatement ps = connection.prepareStatement(query);
//        ResultSet rs = ps.executeQuery();
//        
//        Antikvitet antikvitet = new DbRepositoryAntikvitet().getOne(rs.getInt("an.id"));
//        Aukcija aukcija = new DbRepositoryAukcija().getOne(rs.getInt("au.id"));
//        ProdajaAntikviteta prod_ant = new ProdajaAntikviteta(antikvitet, aukcija, rs.getDouble("p.cena"));
//        
//        return prod_ant;
//    }
//
//}
