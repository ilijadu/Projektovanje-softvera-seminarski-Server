/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import communication.Receiver;
import communication.Sender;
import controller.Controller;
import domain.Antikvitet;
import domain.Aukcija;
import domain.Korisnik;
import domain.Mesto;
import domain.ProdajaAntikviteta;
import domain.TipAntikviteta;
import domain.Vlasnik;
import java.net.Socket;
import java.util.List;
import javafx.util.Pair;
import operation.Operation;
import server.Server;
import transfer.Request;
import transfer.Response;

/**
 *
 * @author Ilija Dumanović
 */
public class ProcessClientRequests extends Thread {

    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    private boolean signal = true;
    private Server server;
    private Korisnik korisnik;

    public ProcessClientRequests(Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
        this.sender = new Sender(socket);
        this.receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        while (signal) {
            try {
                Request request = (Request) receiver.receive();
                Response response = null;
                try {
                    switch (request.getOperation()) {

                        case login:
                            Korisnik k = (Korisnik) request.getObj();
                            System.out.println("primljen korisnik");
                            korisnik = Controller.getInstance().login(k.getUsername(), k.getPassword());
                            int broj = server.dodajNovogKorisnika(korisnik);
                            if (broj == 0) {
                                response = new Response(korisnik, null);
                                server.dodajKorisnika(this);
                            } else if (broj == -1) {
                                response = new Response(null, new Exception("Vec je ulogovan ovaj korisnik"));
                            }
                            break;
                        case logout:
                            server.obrisiKorisnika(this);
                            response = new Response("Uspešno ste se odjavili!", null);
                            signal = false;
                            break;

                        case KreirajAntikvitet:
                            Antikvitet a = (Antikvitet) request.getObj();
                            response = new Response(Controller.getInstance().dodajAntikvitet(a), null);
                            break;
                        case ObrisiAntikvitet:
                            Antikvitet an = (Antikvitet) request.getObj();
                            response = new Response(Controller.getInstance().obrisiAntikvitet(an), null);
                            break;
                        case ZapamtiAntikvitet:
                            Antikvitet ant = (Antikvitet) request.getObj();
                            response = new Response(Controller.getInstance().zapamtiAnrikvitet(ant), null);
                            break;
                        case UcitajAntikvitet:
                            int aid = (int) request.getObj();
                            Antikvitet anti = Controller.getInstance().ucitajAntikvitet(aid);
                            response = new Response(anti, null);
                            break;
                        case UcitajAntikvitete:
                            List<Antikvitet> antik = Controller.getInstance().sviAntikviteti();
                            response = new Response(antik, null);
                            break;
                        case UcitajAntikviteteSaParametrom:
                            System.out.println("thread.ProcessClientRequests.run(), pocetak ucitavanja antikvi sa parametrom");
                            List<Antikvitet> antikv = Controller.getInstance().sviAntikvitetiSaParametrom((Pair) request.getObj());
                            System.out.println("thread.ProcessClientRequests.run(), antikviteti:" + antikv);
                            response = new Response(antikv, null);
                            System.out.println("thread.ProcessClientRequests.run(), napravio response");
                            break;

                        case KreirajAuckiju:
                            Aukcija au = (Aukcija) request.getObj();
                            response = new Response(Controller.getInstance().kreirajAukciju(au), null);
                            break;
                        case ObrisiAukciju:
                            Aukcija auk = (Aukcija) request.getObj();
                            response = new Response(Controller.getInstance().obrisiAukciju(auk), null);
                            break;
                        case ZapamtiAukciju:
                            Aukcija aukc = (Aukcija) request.getObj();
                            response = new Response(Controller.getInstance().zapamtiAukciju(aukc), null);
                            break;
                        case UcitajAukciju:
                            int auid = (int) request.getObj();
                            Aukcija aukci = Controller.getInstance().ucitajAukciju(auid);
                            response = new Response(aukci, null);
                            break;
                        case UcitajAukcije:
                            List<Aukcija> aukcije = Controller.getInstance().sveAukcije();
                            response = new Response(aukcije, null);
                            break;
                        case UcitajAukcijeSaParametrom:
                            List<Aukcija> aukcijee = Controller.getInstance().sveAukcijeSaParametrom((Pair) request.getObj());
                            response = new Response(aukcijee, null);
                            break;

                        case KreirajVlasnika:
                            Vlasnik v = (Vlasnik) request.getObj();
                            response = new Response(Controller.getInstance().dodajVlasnika(v), null);
                            break;
                        case ObrisiVlasnika:
                            Vlasnik vl = (Vlasnik) request.getObj();
                            response = new Response(Controller.getInstance().obrisiVlasnika(vl), null);
                            break;
                        case ZapamtiVlasnika:
                            Vlasnik vla = (Vlasnik) request.getObj();
                            response = new Response(Controller.getInstance().promeniVlasnika(vla), null);
                            break;
                        case UcitajVlasnika:
                            int vid = (int) request.getObj();
                            Vlasnik vlas = Controller.getInstance().ucitajVlasnika(vid);
                            response = new Response(vlas, null);
                            break;
                        case UcitajVlasnike:
                            List<Vlasnik> vlasnici = Controller.getInstance().sviVlasnici();
                            response = new Response(vlasnici, null);
                            break;
                        case UcitajVlasnikeSaParametrom:
                            List<Vlasnik> vlasnicii = Controller.getInstance().sviVlasniciSaParametrom((Pair) request.getObj());
                            response = new Response(vlasnicii, null);
                            break;

                        case KreirajProdajaAntikviteta:
                            ProdajaAntikviteta p = (ProdajaAntikviteta) request.getObj();
                            response = new Response(Controller.getInstance().dodajProdajaAntikviteta(p), null);
                            break;
                        case ObrisiProdajaAntikviteta:
                            ProdajaAntikviteta pr = (ProdajaAntikviteta) request.getObj();
                            response = new Response(Controller.getInstance().obrisiProdajaAntikviteta(pr), null);
                            break;
                        case ZapamtiProdajaAntikviteta:
                            ProdajaAntikviteta pra = (ProdajaAntikviteta) request.getObj();
                            response = new Response(Controller.getInstance().promeniProdajaAntikviteta(pra), null);
                            break;
                        case UcitajProdajaAntikviteta:
                            int proda = (int) request.getObj();
                            ProdajaAntikviteta prod = Controller.getInstance().ucitajProdajaAntikviteta(proda);
                            response = new Response(prod, null);
                            break;
                        case UcitajSveProdajaAntikviteta:
                            List<ProdajaAntikviteta> pro = Controller.getInstance().sviProdajaAntikviteta();
                            response = new Response(pro, null);
                            break;

                        case UcitajSveProdajaAntikvitetaSaParametrom:
                            System.out.println("thread.ProcessClientRequests.run(), pocetak ucitavanja antikvi sa parametrom");
                            List<ProdajaAntikviteta> prodsapar = Controller.getInstance().sviProdajaAntikvitetaSaParametrom((Pair) request.getObj());
                            System.out.println("thread.ProcessClientRequests.run(), antikviteti:" + prodsapar);
                            response = new Response(prodsapar, null);
                            System.out.println("thread.ProcessClientRequests.run(), napravio response");
                            break;

                        case UcitajListuMesta:
                            List<Mesto> mesta = Controller.getInstance().svaMesta();
                            response = new Response(mesta, null);
                            break;
                        case UcitajListuTipova:
                            List<TipAntikviteta> tip = Controller.getInstance().sviTipovi();
                            response = new Response(tip, null);
                            break;

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    response = new Response(null, ex);
                }
                sender.send(response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

}
