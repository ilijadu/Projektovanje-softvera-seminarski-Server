/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.db;

/**
 *
 * @author Ilija Dumanović
 */
public interface DbRepository<T, K> extends repository.Repository<T, K> {
    
    default void connect() throws Exception {
        DBConnectionFactory.getInstance().getConnection();
    }

    default void disconnect() throws Exception {
        DBConnectionFactory.getInstance().getConnection().close();
    }

    default void commit() throws Exception {
        DBConnectionFactory.getInstance().getConnection().commit();
    }

    default void rollback() throws Exception {
        DBConnectionFactory.getInstance().getConnection().rollback();
    }
}
