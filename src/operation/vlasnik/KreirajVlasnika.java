/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.vlasnik;

import domain.Vlasnik;
import operation.AbstractGenericOperation;

/**
 *
 * @author Ilija Dumanović
 */
public class KreirajVlasnika extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
         if (param == null || !(param instanceof Vlasnik)) {
            throw new Exception("Nepravilni podaci za vlasnika");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Vlasnik)param);
    }
    
}
