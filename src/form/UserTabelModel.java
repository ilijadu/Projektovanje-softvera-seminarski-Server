/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import domain.Korisnik;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ilija Dumanović
 */
public class UserTabelModel extends AbstractTableModel {

    List<Korisnik> korisnici = new ArrayList<>();
    String[] kolone = {"Ime i Prezime", "Username", "Password", "Datum prijave"};

    public UserTabelModel(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public UserTabelModel() {
    }

    @Override
    public int getRowCount() {
        return korisnici.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return korisnici.get(rowIndex).getIme() + " " + korisnici.get(rowIndex).getPrezime();
            case 1:
                return korisnici.get(rowIndex).getUsername();
            case 2:
                return korisnici.get(rowIndex).getPassword();
            case 3:
                return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void clear() {
        this.korisnici = new ArrayList<>();
        fireTableDataChanged();
    }

    public void add(Korisnik k) {
        korisnici.add(k);
        fireTableDataChanged();
    }

    public void delete(Korisnik k) {
        korisnici.remove(k);
        fireTableDataChanged();
    }

}
