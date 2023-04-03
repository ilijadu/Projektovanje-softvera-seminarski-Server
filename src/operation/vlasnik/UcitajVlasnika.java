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
public class UcitajVlasnika  extends AbstractGenericOperation{
    Vlasnik vlasnik;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Integer)) {
            throw new Exception("Nepravilni podaci za id.");
        }
        else if(((int)param)<0){
            throw new Exception("Nepravilan id za element.");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        vlasnik=(Vlasnik) repository.getOne((int)param);
    }
    public Vlasnik getVlasnik(){
        return vlasnik;
    }
}
