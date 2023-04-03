/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.aukcija;

import domain.Aukcija;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Ilija Dumanović
 */
public class UcitajAukcije extends AbstractGenericOperation {

    List<Aukcija> aukcije;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        aukcije = repository.getAll(new Aukcija());
    }

    public List<Aukcija> getAukcije() {
        return aukcije;
    }
}
