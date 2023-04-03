/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.prodaja;

import domain.ProdajaAntikviteta;
import java.util.List;
import javafx.util.Pair;
import operation.AbstractGenericOperation;

/**
 *
 * @author Ilija Dumanović
 */
public class UcitajSveProdajaAntikvitetaSaPrametrom extends AbstractGenericOperation {
    List<ProdajaAntikviteta> prodaja;
    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Pair)) {
            throw new Exception("Nepravilni podaci za antikvitet");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        prodaja=repository.getAllByCriteria(new ProdajaAntikviteta(), param);
    }

    public List<ProdajaAntikviteta> getProdaja() {
        return prodaja;
    }

}
