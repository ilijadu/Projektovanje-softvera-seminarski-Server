/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.tip;

import domain.TipAntikviteta;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Ilija Dumanović
 */
public class UcitajListuTipova extends AbstractGenericOperation{
    List<TipAntikviteta> tipovi;
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        tipovi=repository.getAll(new TipAntikviteta());
    }
    public List<TipAntikviteta> getTip(){
        return tipovi;
    }
}
