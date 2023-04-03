///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package repository.db.impl;
//
//import repository.db.*;
//import controller.Controller;
//import domain.Korisnik;
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
//public class DbRepositoryKorisnik implements DbRepository<Korisnik, Integer>{
//
//    @Override
//    public void add(Korisnik param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public int edit(Korisnik param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public int delete(Korisnik param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public List<Korisnik> getAll() throws Exception {
//        Connection connection = DBConnectionFactory.getInstance().getConnection();
//        List<Korisnik>korisnici = new ArrayList<>();
//        String query = "Select * from korisnik";
//        PreparedStatement ps = connection.prepareStatement(query);
//        ResultSet rs = ps.executeQuery();
//        while(rs.next()){
//            korisnici.add(new Korisnik(rs.getString("username"), 
//                    rs.getString("password"), rs.getString("ime"), 
//                    rs.getString("prezime")));
//        }
//        ps.close();
//        return korisnici; 
//    }
//
//    @Override
//    public List<Korisnik> getAll(Korisnik param) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Korisnik getOne(Integer id) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//    
//}
