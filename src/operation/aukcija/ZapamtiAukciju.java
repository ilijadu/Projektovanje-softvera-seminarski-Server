/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.aukcija;

import domain.Aukcija;
import operation.AbstractGenericOperation;

/**
 *
 * @author Ilija Dumanović
 */
public class ZapamtiAukciju extends AbstractGenericOperation {

    int broj = -1;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Aukcija)) {
            throw new Exception("Nepravilni podaci za aukciju");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        broj = repository.edit((Aukcija) param);
    }

    public int getBroj() {
        return broj;
    }
}
