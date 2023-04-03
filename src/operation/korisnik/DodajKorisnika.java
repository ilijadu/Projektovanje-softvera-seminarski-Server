/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.korisnik;

import domain.Korisnik;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Ilija Dumanović
 */
public class DodajKorisnika extends AbstractGenericOperation {

    List<Korisnik> korisnici;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        korisnici = repository.getAll(new Korisnik());
        Korisnik k = (Korisnik) param;
        if (param == null || !(param instanceof Korisnik)) {
            throw new Exception("Greska!");
        }
        if (korisnici.contains(k)) {
            throw new Exception("Vec postoji takav korisnik");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Korisnik)param);
    }
    
}
