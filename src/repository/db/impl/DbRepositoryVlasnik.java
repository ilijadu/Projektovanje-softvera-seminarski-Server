///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package repository.db.impl;
//
//import repository.db.*;
//import domain.Mesto;
//import domain.Vlasnik;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author Ilija Dumanović
// */
//public class DbRepositoryVlasnik implements DbRepository<Vlasnik, Integer> {
//
//    @Override
//    public void add(Vlasnik param) throws Exception {
//
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "INSERT INTO vlasnik(ime,prezime,datum,mesto_id) VALUES (?,?,?,?);";
//        PreparedStatement ps = connection.prepareStatement(query);
//
//        ps.setString(1, param.getIme());
//        ps.setString(2, param.getPrezime());
//        ps.setDate(3, Date.valueOf(param.getDatumRodjenja()));
//        ps.setInt(4, param.getMesto().getId());
//
//        int br = ps.executeUpdate();
//        ps.close();
//        connection.close();
//    }
//
//    @Override
//    public int edit(Vlasnik param) throws Exception {
//
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "UPDATE vlasnik SET ime = ?, prezime=?, datum=?,mesto_id=? WHERE id=?;";
//        PreparedStatement ps = connection.prepareStatement(query);
//
//        ps.setString(1, param.getIme());
//        ps.setString(2, param.getPrezime());
//        ps.setDate(3, Date.valueOf(param.getDatumRodjenja()));
//        ps.setInt(4, param.getMesto().getId());
//        ps.setInt(5, param.getId());
//
//        int br = ps.executeUpdate();
//        ps.close();
//        connection.close();
//        return br;
//    }
//
//    @Override
//    public int delete(Vlasnik param) throws Exception {
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//
//        String query = "delete from vlasnik where id = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setInt(1, param.getId());
//
//        int br = preparedStatement.executeUpdate();
//        preparedStatement.close();
//        connection.close();
//        return br;
//    }
//
//    @Override
//    public List<Vlasnik> getAll() throws Exception {
//        List<Vlasnik> vlasnici = new ArrayList<>();
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "SELECT v.id, v.ime, v.prezime, v.datum,m.id FROM vlasnik v JOIN mesto m ON m.id=v.mesto_id";
//        PreparedStatement ps = connection.prepareStatement(query);
//
//        ResultSet rs = ps.executeQuery();
//        int i = 0;
//        while (rs.next()) {
//
//            System.out.println(++i);
//
//            System.out.println();
//
//            Vlasnik vlasnik = new Vlasnik(
//                    rs.getInt("v.id"),
//                    rs.getString("v.ime"),
//                    rs.getString("v.prezime"),
//                    rs.getDate("v.datum").toLocalDate(),
//                    null);
//            vlasnici.add(vlasnik);
//            System.out.println(vlasnik);
//        }
//
//        rs.close();
//        ps.close();
//        connection.close();
//        return vlasnici;
//    }
//
//    @Override
//    public List<Vlasnik> getAll(Vlasnik param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Vlasnik getOne(Integer id) throws Exception {
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "SELECT v.id, v.ime, v.prezime, v.datum, m.id, m.naziv, m.ptt FROM vlasnik v JOIN mesto m ON m.id=v.mesto_id WHERE v.id=?";
//
//        PreparedStatement ps = connection.prepareStatement(query);
//        ps.setInt(1, id);
//        ResultSet rs = ps.executeQuery();
//        Mesto mesto = null;
//        Vlasnik vlasnik = null;
//        while (rs.next()) {
//            mesto = new Mesto(rs.getInt("m.id"), rs.getString("m.naziv"),
//                    rs.getInt("m.ptt"));
//
//            vlasnik = new Vlasnik(id, rs.getString("ime"),
//                    rs.getString("prezime"), rs.getDate("datum").toLocalDate(), mesto);
//        }
//        return vlasnik;
//    }
//
//}
