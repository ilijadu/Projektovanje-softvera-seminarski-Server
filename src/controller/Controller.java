/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Antikvitet;
import domain.Aukcija;
import domain.Korisnik;
import domain.Mesto;
import domain.ProdajaAntikviteta;
import domain.TipAntikviteta;
import domain.Vlasnik;
import java.util.List;
import javafx.util.Pair;
import operation.AbstractGenericOperation;
import operation.aukcija.KreirajAukciju;
import operation.antikvitet.KreirajAntikvitet;
import operation.antikvitet.ObrisiAntikvitet;
import operation.antikvitet.UcitajAntikvitet;
import operation.antikvitet.UcitajAntikvitete;
import operation.antikvitet.UcitajAntikviteteSaParametrom;
import operation.antikvitet.ZapamtiAntikvitet;
import operation.aukcija.ObrisiAukciju;
import operation.aukcija.UcitajAukcije;
import operation.aukcija.UcitajAukciju;
import operation.aukcija.UcitajSveAukcijeSaParametrom;
import operation.aukcija.ZapamtiAukciju;
import operation.korisnik.DodajKorisnika;
import operation.korisnik.Login;
import operation.mesto.UcitajListuMesta;
import operation.prodaja.KreirajProdajaAntivkiteta;
import operation.prodaja.ObrisiProdajaAntikviteta;
import operation.prodaja.UcitajProdajaAntikviteta;
import operation.prodaja.UcitajSveProdajaAntikviteta;
import operation.prodaja.UcitajSveProdajaAntikvitetaSaPrametrom;
import operation.prodaja.ZapamtiProdajaAntikviteta;
import operation.tip.UcitajListuTipova;
import operation.vlasnik.KreirajVlasnika;
import operation.vlasnik.ObrisiVlasnika;
import operation.vlasnik.UcitajVlasnika;
import operation.vlasnik.UcitajVlasnike;
import operation.vlasnik.UcitajVlasnikeSaParametrom;
import operation.vlasnik.ZapamtiVlasnika;

/**
 *
 * @author Ilija Dumanović
 */
public class Controller {

    private static Controller controller;

    private Controller() {
    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public void DodajKorisnika(Korisnik k) throws Exception {
        AbstractGenericOperation operation = new DodajKorisnika();
        operation.execute(k);
    }
    
    public Korisnik login(String username, String password) throws Exception {
        AbstractGenericOperation operation = new Login();
        operation.execute(new Korisnik());
        List<Korisnik> korisnici = ((Login) operation).getKorisnici();
        for (Korisnik korisnik : korisnici) {
            if ((korisnik.getUsername().equals(username))) {
                System.out.println("nadjen korisnik");
                return korisnik;
            }
        }
        throw new Exception("Nepoznat korisnik!");
    }

    public List<Antikvitet> sviAntikviteti() throws Exception {
        AbstractGenericOperation operation = new UcitajAntikvitete();
        operation.execute(new Antikvitet());
        return ((UcitajAntikvitete) operation).getAntiques();
    }
    public List<Antikvitet> sviAntikvitetiSaParametrom(Pair p) throws Exception {
        AbstractGenericOperation operation = new UcitajAntikviteteSaParametrom();
        operation.execute(p);
        System.out.println("controller.Controller.sviAntikvitetiSaParametrom(), izvrsio sa parametrom");
        return ((UcitajAntikviteteSaParametrom) operation).getAntiques();
    }

    public Object dodajAntikvitet(Antikvitet antikvitet) throws Exception {
        AbstractGenericOperation operation = new KreirajAntikvitet();
        operation.execute(antikvitet);
        return "Uspesno dodat antikvitet.";
    }

    public Object zapamtiAnrikvitet(Antikvitet antikvitet) throws Exception {
        AbstractGenericOperation operation = new ZapamtiAntikvitet();
        operation.execute(antikvitet);
        return ((ZapamtiAntikvitet)operation).getBroj();
    }

    public Object obrisiAntikvitet(Antikvitet antikvitet) throws Exception {
        AbstractGenericOperation operation = new ObrisiAntikvitet();
        operation.execute(antikvitet);
        return ((ObrisiAntikvitet)operation).getBroj();
    }

    public Antikvitet ucitajAntikvitet(int id) throws Exception {
        AbstractGenericOperation operation = new UcitajAntikvitet();
        operation.execute(id);
        return ((UcitajAntikvitet) operation).getAntikvitet();
    }

    public Object kreirajAukciju(Aukcija aukcija) throws Exception {
        AbstractGenericOperation operation = new KreirajAukciju();
        operation.execute(aukcija);
        return  ((KreirajAukciju) operation).getId();
    }

    public Object zapamtiAukciju(Aukcija aukcija) throws Exception {
        AbstractGenericOperation operation = new ZapamtiAukciju();
        operation.execute(aukcija);
        return ((ZapamtiAukciju)operation).getBroj();
    }

    public Object obrisiAukciju(Aukcija aukcija) throws Exception {
        AbstractGenericOperation operation = new ObrisiAukciju();
        operation.execute(aukcija);
        return ((ObrisiAukciju)operation).getBroj();
    }

    public Aukcija ucitajAukciju(int id) throws Exception {
        AbstractGenericOperation operation = new UcitajAukciju();
        operation.execute(id);
        return ((UcitajAukciju) operation).getAukcija();
    }

    public List<Aukcija> sveAukcije() throws Exception {
        AbstractGenericOperation operation = new UcitajAukcije();
        operation.execute(new Aukcija());
        return ((UcitajAukcije) operation).getAukcije();
    }
    public List<Aukcija> sveAukcijeSaParametrom(Pair p) throws Exception {
        AbstractGenericOperation operation = new UcitajSveAukcijeSaParametrom();
        operation.execute(p);
        return ((UcitajSveAukcijeSaParametrom) operation).getAukcije();
    }

    public Object dodajVlasnika(Vlasnik vlasnik) throws Exception {
        AbstractGenericOperation operation = new KreirajVlasnika();
        operation.execute(vlasnik);
        return "Uspesno dodat vlasnik.";
    }

    public Object promeniVlasnika(Vlasnik vlasnik) throws Exception {
        AbstractGenericOperation operation = new ZapamtiVlasnika();
        operation.execute(vlasnik);
        return ((ZapamtiVlasnika)operation).getBroj();
    }

    public Object obrisiVlasnika(Vlasnik vlasnik) throws Exception {
        AbstractGenericOperation operation = new ObrisiVlasnika();
        operation.execute(vlasnik);
        return ((ObrisiVlasnika)operation).getBroj();
    }

    public Vlasnik ucitajVlasnika(int id) throws Exception {
        AbstractGenericOperation operation = new UcitajVlasnika();
        operation.execute(id);
        return ((UcitajVlasnika) operation).getVlasnik();
    }

    public List<Vlasnik> sviVlasnici() throws Exception {
        AbstractGenericOperation operation = new UcitajVlasnike();
        operation.execute(new Vlasnik());
        return ((UcitajVlasnike) operation).getVlasnici();
    }
    public List<Vlasnik> sviVlasniciSaParametrom(Pair p) throws Exception {
        AbstractGenericOperation operation = new UcitajVlasnikeSaParametrom();
        operation.execute(p);
        return ((UcitajVlasnikeSaParametrom) operation).getVlasnici();
    }

    public List<TipAntikviteta> sviTipovi() throws Exception {
        AbstractGenericOperation operation = new UcitajListuTipova();
        operation.execute(new TipAntikviteta());
        return ((UcitajListuTipova) operation).getTip();
    }

    public List<Mesto> svaMesta() throws Exception {
        AbstractGenericOperation operation = new UcitajListuMesta();
        operation.execute(new Mesto());
        return ((UcitajListuMesta) operation).getMesta();
    }

    public Object dodajProdajaAntikviteta(ProdajaAntikviteta pa) throws Exception {
        AbstractGenericOperation operation = new KreirajProdajaAntivkiteta();
        operation.execute(pa);
        return "Uspesno dodata prodaja antivkiteta.";
    }

    public Object promeniProdajaAntikviteta(ProdajaAntikviteta pa) throws Exception {
        AbstractGenericOperation operation = new ZapamtiProdajaAntikviteta();
        operation.execute(pa);
        return ((ZapamtiProdajaAntikviteta)operation).getBroj();
    }

    public Object obrisiProdajaAntikviteta(ProdajaAntikviteta pa) throws Exception {
        AbstractGenericOperation operation = new ObrisiProdajaAntikviteta();
        operation.execute(pa);
        return ((ObrisiProdajaAntikviteta)operation).getBroj();
    }

    public ProdajaAntikviteta ucitajProdajaAntikviteta(int id) throws Exception {
        AbstractGenericOperation operation = new UcitajProdajaAntikviteta();
        operation.execute(id);
        return ((UcitajProdajaAntikviteta) operation).getProdaja();
    }

    public List<ProdajaAntikviteta> sviProdajaAntikviteta() throws Exception {
        AbstractGenericOperation operation = new UcitajSveProdajaAntikviteta();
        operation.execute(new ProdajaAntikviteta());
        return ((UcitajSveProdajaAntikviteta) operation).getProdaja();
    }
    public List<ProdajaAntikviteta> sviProdajaAntikvitetaSaParametrom(Pair p) throws Exception {
        AbstractGenericOperation operation = new UcitajSveProdajaAntikvitetaSaPrametrom();
        operation.execute(p);
        return ((UcitajSveProdajaAntikvitetaSaPrametrom) operation).getProdaja();
    }

}
