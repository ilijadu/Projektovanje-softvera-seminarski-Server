/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.antikvitet;

import domain.Antikvitet;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Ilija Dumanović
 */
public class UcitajAntikvitete extends AbstractGenericOperation {

    private List<Antikvitet> antiques;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        antiques=repository.getAll(new Antikvitet());
    }
    
    public List<Antikvitet> getAntiques(){
        return antiques;
    }
}
