/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.vlasnik;

import domain.Vlasnik;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Ilija Dumanović
 */
public class UcitajVlasnike extends AbstractGenericOperation{
    List<Vlasnik> vlasnici;
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        vlasnici=repository.getAll(new Vlasnik());
    }
    public List<Vlasnik> getVlasnici(){
        return vlasnici;
    }
}
