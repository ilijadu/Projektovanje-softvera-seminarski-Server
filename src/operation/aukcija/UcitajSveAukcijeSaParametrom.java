/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.aukcija;

import domain.Aukcija;
import java.util.List;
import javafx.util.Pair;
import operation.AbstractGenericOperation;

/**
 *
 * @author Ilija Dumanović
 */
public class UcitajSveAukcijeSaParametrom extends AbstractGenericOperation{
    List<Aukcija> aukcije;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Pair)) {
            throw new Exception("Nepravilni podaci za antikvitet");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        aukcije=repository.getAllByCriteria(new Aukcija(), param);
    }
    

    public List<Aukcija> getAukcije() {
        return aukcije;
    }
    
}
