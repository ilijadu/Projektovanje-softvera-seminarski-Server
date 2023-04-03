///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package repository.db.impl;
//
//import repository.db.*;
//import domain.Aukcija;
//import domain.Mesto;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author Ilija Dumanović
// */
//public class DbRepositoryAukcija implements DbRepository<Aukcija, Integer> {
//
//    @Override
//    public void add(Aukcija param) throws Exception {
//
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "INSERT INTO aukcija(naziv,datum,mesto_id) VALUES (?,?,?);";
//        PreparedStatement ps = connection.prepareStatement(query);
//
//        ps.setString(1, param.getNaziv());
//        ps.setDate(2, Date.valueOf(param.getDatumOdrzavanja()));
//        ps.setInt(3, param.getMesto().getId());
//
//        int br=ps.executeUpdate();
//        ps.close();
//        connection.close();
//    }
//
//    @Override
//    public int edit(Aukcija param) throws Exception {
//
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "UPDATE aukcija SET naziv = ?, datum=?,mesto_id=? WHERE id=?;";
//        PreparedStatement ps = connection.prepareStatement(query);
//
//        ps.setString(1, param.getNaziv());
//        ps.setDate(2, Date.valueOf(param.getDatumOdrzavanja()));
//        ps.setInt(3, param.getMesto().getId());
//        ps.setInt(4, param.getId());
//
//        int br=ps.executeUpdate();
//        ps.close();
//        connection.close();
//        return br;
//
//    }
//
//    @Override
//    public int delete(Aukcija param) throws Exception {
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//
//        String query = "delete from aukcija where id = ?";
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
//    public List<Aukcija> getAll() throws Exception {
//        List<Aukcija> aukcije = new ArrayList<>();
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "SELECT a.id, a.naziv, a.datum, m.id FROM aukcja a JOIN mesto m ON m.id=a.mesto_id";
//        PreparedStatement ps = connection.prepareStatement(query);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            Mesto mesto = new DbRepositoryMesto().getOne(rs.getInt("m.id"));
//            Aukcija aukcija = new Aukcija(rs.getInt("a.id"), rs.getString("a.naziv"),
//                    rs.getDate("a.datum").toLocalDate(), mesto);
//            aukcije.add(aukcija);
//        }
//        connection.close();
//        return aukcije;
//    }
//
//    @Override
//    public List<Aukcija> getAll(Aukcija param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Aukcija getOne(Integer id) throws Exception {
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "SELECT a.naziv, a.datum, m.id FROM aukcja a JOIN mesto m ON m.id=a.mesto_id WHERE id=?";
//        PreparedStatement ps = connection.prepareStatement(query);
//        
//        ps.setInt(1,id);
//        ResultSet rs = ps.executeQuery();
//        
//        Mesto mesto = new DbRepositoryMesto().getOne(rs.getInt("m.id"));
//        Aukcija aukcija = new Aukcija(rs.getInt("a.id"), rs.getString("a.naziv"),
//                rs.getDate("a.datum").toLocalDate(), mesto);
//        
//        return aukcija;
//    }
//
//}
