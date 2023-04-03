/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.prodaja;

import domain.ProdajaAntikviteta;
import operation.AbstractGenericOperation;

/**
 *
 * @author Ilija Dumanović
 */
public class ZapamtiProdajaAntikviteta extends AbstractGenericOperation {

    int broj = -1;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof ProdajaAntikviteta)) {
            throw new Exception("Nepravilni podaci za prodaja antikviteta");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        broj = repository.edit((ProdajaAntikviteta) param);
    }

    public int getBroj() {
        return broj;
    }
}
