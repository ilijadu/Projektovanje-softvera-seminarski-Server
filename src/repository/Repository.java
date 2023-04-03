/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author Ilija Dumanović
 */
public interface Repository<T, K> {

    int add(T param) throws Exception;

    int edit(T param) throws Exception;

    int delete(T param) throws Exception;

    List<T> getAllByCriteria(T param,K criteria) throws Exception;

    List<T> getAll(T param) throws Exception;

    T getOne(T param) throws Exception;
}
