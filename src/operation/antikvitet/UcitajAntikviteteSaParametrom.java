/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.antikvitet;

import domain.Antikvitet;
import java.util.List;
import javafx.util.Pair;
import operation.AbstractGenericOperation;

/**
 *
 * @author Ilija Dumanović
 */
public class UcitajAntikviteteSaParametrom extends AbstractGenericOperation{

    List<Antikvitet>antikviteti;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Pair)) {
            throw new Exception("Nepravilni podaci za antikvitet");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        antikviteti=repository.getAllByCriteria(new Antikvitet(), param);
        System.out.println("operation.antikvitet.UcitajAntikviteteSaParametrom.executeOperation(), ucitao antikvitete sa parametrom");
    }

    public List<Antikvitet> getAntiques() {
        return antikviteti;
    }
    
}
