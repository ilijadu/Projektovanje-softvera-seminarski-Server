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
public class KreirajAntikvitet extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Antikvitet)) {
            throw new Exception("Nepravilni podaci za antikvitet");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Antikvitet) param);
    }

}
