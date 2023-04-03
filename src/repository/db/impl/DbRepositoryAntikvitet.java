///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package repository.db.impl;
//
//import repository.db.*;
//import domain.Antikvitet;
//import domain.GenericEntity;
//import domain.Mesto;
//import domain.TipAntikviteta;
//import domain.Valuta;
//import domain.Vlasnik;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author Ilija Dumanović
// */
//public class DbRepositoryAntikvitet implements DbRepository<Antikvitet, Integer> {
//
//    @Override
//    public void add(Antikvitet param) throws Exception {
//        System.out.println("IZ DB-a: " + param);
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "INSERT INTO antikvitet(naziv,vrednost,valuta,vlasnik_id,tip_id) VALUES (?,?,?,?,?);";
//        PreparedStatement ps = connection.prepareStatement(query);
//        ps.setString(1, param.getNaziv());
//        ps.setDouble(2, param.getVrednost());
//        ps.setString(3, param.getValuta().toString());
//        ps.setInt(4, param.getVlasnik().getId());
//        ps.setInt(5, param.getTipAntikviteta().getId());
//
//        int br = ps.executeUpdate();
//        System.out.println("DA LI JE DODAT: " + br);
//
//        connection.commit();
//        ps.close();
//        connection.close();
//    }
//
//    @Override
//    public void edit(Antikvitet param) throws Exception {
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "UPDATE antikvitet SET naziv = ?, vrednost=?, valuta=?,vlasnik_id=?,tip_id=? WHERE id=?";
//        PreparedStatement ps = connection.prepareStatement(query);
//
//        ps.setString(1, param.getNaziv());
//        ps.setDouble(2, param.getVrednost());
//        ps.setString(3, param.getValuta().toString());
//        ps.setInt(4, param.getVlasnik().getId());
//        ps.setInt(5, param.getTipAntikviteta().getId());
//        ps.setInt(6, param.getId());
//        int br = ps.executeUpdate();
//
//        connection.commit();
//        ps.close();
//        connection.close();
//    }
//
//    @Override
//    public void delete(Antikvitet param) throws Exception {
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//
//        String query = "delete from antikvitet where id = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setInt(1, param.getId());
//
//        int br = preparedStatement.executeUpdate();
//        preparedStatement.close();
//
//        connection.commit();
//        connection.close();
//    }
//
//    public List<Antikvitet> getAll(GenericEntity param) throws Exception {
//
//        List<Antikvitet> antikviteti = new ArrayList<>();
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "SELECT a.id,a.naziv, a.vrednost, a.valuta, v.id, v.ime,v.prezime,v.datum,m.id,m.naziv,m.ptt, t.id, t.naziv FROM antikvitet a JOIN vlasnik v ON a.vlasnik_id=v.id JOIN mesto m ON v.mesto_id=m.id JOIN tipantikviteta t ON t.id=a.tip_id";
//        PreparedStatement ps = connection.prepareStatement(query);
//        ResultSet rs = ps.executeQuery();
//
//        int i = 0;
//        while (rs.next()) {
//            System.out.println(++i);
//            Mesto mesto = new Mesto(rs.getInt("m.id"), rs.getString("m.naziv"), rs.getInt("m.ptt"));
//            Vlasnik vlasnik = new Vlasnik(rs.getInt("v.id"), rs.getString("v.ime"),
//                    rs.getString("v.prezime"), rs.getDate("v.datum").toLocalDate(),
//                    mesto);
//            System.out.println(vlasnik);
//            System.out.println("MESTO PRETRAGE: " + mesto);
//            TipAntikviteta tip = new TipAntikviteta(rs.getInt("t.id"), rs.getString("t.naziv"));
//            Antikvitet ant = new Antikvitet(rs.getInt("a.id"), rs.getString("naziv"), rs.getDouble("vrednost"),
//                    Valuta.valueOf(rs.getString("valuta")), vlasnik, tip);
//            System.out.println(ant);
//            antikviteti.add(ant);
//        }
//        connection.close();
//        return antikviteti;
//    }
//
//    @Override
//    public List<Antikvitet> getAll(Antikvitet param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public Antikvitet getOne(GenericEntity param) throws Exception {
//
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        String query = "SELECT a.naziv, a.vrednost, a.valuta, v.id, v.ime,v.prezime,v.datum,m.id,"
//                + "m.naziv,m.ptt, t.id, t.naziv FROM antikvitet a JOIN"
//                + "vlasnik v ON a.vlasnik_id=v.id JOIN mesto m ON v.mesto_id=m.id JOIN tipantikviteta t ON"
//                + "t.id=a.tip_id WHERE id=? ";
//        PreparedStatement ps = connection.prepareStatement(query);
//        ps.setInt(1, 1);
//        ResultSet rs = ps.executeQuery();
//        Mesto mesto = new Mesto(rs.getInt("m.id"), rs.getString("m.naziv"), rs.getInt("m.ptt"));
//        Vlasnik vlasnik = new Vlasnik(rs.getInt("v.id"), rs.getString("v.ime"),
//                rs.getString("v.prezime"), rs.getDate("v.datum").toLocalDate(),
//                mesto);
//        TipAntikviteta tip = new TipAntikviteta(rs.getInt("t.id"), rs.getString("t.naziv"));
//        Antikvitet antikvitet = new Antikvitet(1, rs.getString("naziv"), rs.getDouble("vrednost"),
//                Valuta.valueOf(rs.getString("valuta")), vlasnik, tip);
//
//        connection.close();
//        return antikvitet;
//    }
//
//}
