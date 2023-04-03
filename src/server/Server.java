/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import constant.ServerKonstante;
import domain.Korisnik;
import form.UserTabelModel;
import form.serverForm;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import thread.ProcessClientRequests;

/**
 *
 * @author Ilija Dumanović
 */
public class Server extends Thread {

    private ServerSocket ss;
    private List<ProcessClientRequests> klijenti = new ArrayList<>();
    private List<Korisnik> korsnici = new ArrayList<>();
    private serverForm forma;
    private boolean signal = true;

    public Server(serverForm forma) {
        try {
            int port = pokupiPort();
            this.ss = new ServerSocket(port);
            this.forma = forma;

            start();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (signal) {
            System.out.println("Server je pokrenut!");
            while (true) {
                try {
                    Socket socket = ss.accept();
                    System.out.println("New client detected!");
                    handleClientRequests(socket);
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ServerSocket getSS() {
        return ss;
    }

    private void handleClientRequests(Socket socket) {
        ProcessClientRequests pcr = new ProcessClientRequests(this, socket);
        klijenti.add(pcr);
        pcr.start();
    }

    public void dodajKorisnika(ProcessClientRequests pcr) {
        ((UserTabelModel) forma.getTblKorisnici().getModel()).add(pcr.getKorisnik());
    }

    public void obrisiKorisnika(ProcessClientRequests pcr) {
        klijenti.remove(pcr);
        korsnici.remove(pcr.getKorisnik());
        ((UserTabelModel) forma.getTblKorisnici().getModel()).delete(pcr.getKorisnik());
    }

    public int dodajNovogKorisnika(Korisnik korisnik) throws Exception {
        if (korsnici.contains(korisnik)) {
            return -1;
        }
        korsnici.add(korisnik);
        return 0;
    }

    private int pokupiPort() throws FileNotFoundException, IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream(ServerKonstante.FILE_PATH_SERVER));
        return Integer.valueOf(properties.getProperty(ServerKonstante.PORT));

    }
    
    public List<Korisnik> vratiListuKorisnika(){
        return korsnici;
    }
    public List<ProcessClientRequests> vratiListuProcesa(){
        return klijenti;
    }
}
