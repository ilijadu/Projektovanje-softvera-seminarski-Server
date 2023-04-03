/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.vlasnik;

import domain.Vlasnik;
import java.util.List;
import javafx.util.Pair;
import operation.AbstractGenericOperation;

/**
 *
 * @author Ilija Dumanović
 */
public class UcitajVlasnikeSaParametrom extends AbstractGenericOperation {
    List<Vlasnik>vlasnici;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Pair)) {
            throw new Exception("Nepravilni podaci za antikvitet");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        vlasnici=repository.getAllByCriteria(new Vlasnik(), param);
    }

    public List<Vlasnik> getVlasnici() {
        return vlasnici;
    }

}
