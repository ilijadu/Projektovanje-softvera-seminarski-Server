/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.antikvitet;

import domain.Antikvitet;
import operation.AbstractGenericOperation;

/**
 *
 * @author Ilija Dumanović
 */
public class ObrisiAntikvitet extends AbstractGenericOperation{
    int broj=-1;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Antikvitet)) {
            throw new Exception("Nepravilni podaci za antikvitet");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        broj=repository.delete((Antikvitet)param);
    }
    public int getBroj(){
        return broj;
    }
}
