package com.secaidastudio.e04_mvc.dao;

import com.secaidastudio.e04_mvc.utils.CustomConnection;
import java.util.List;

/**
 *
 * @author oscar
 */
public interface GeneralDAO<T> {
    /**
     * Propiedades que pueden utilizar todas las clases
     * que implementen GeneralDAO
     */
    
    CustomConnection CONN_WRAPPER = CustomConnection.getInstance();
    
    // Metodos pendientes a implementar
    
    List<T> queryAll();
    
    T findById (long id);
    void create (T element);
    void edit (long id, T element);
    void delete (long id);
            
}
