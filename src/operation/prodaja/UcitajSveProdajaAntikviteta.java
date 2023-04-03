/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.prodaja;

import domain.ProdajaAntikviteta;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Ilija Dumanović
 */
public class UcitajSveProdajaAntikviteta extends AbstractGenericOperation{
    List<ProdajaAntikviteta> prodaja;
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        prodaja=repository.getAll(new ProdajaAntikviteta());
    }
    public List<ProdajaAntikviteta> getProdaja(){
        return prodaja;
    }
}
