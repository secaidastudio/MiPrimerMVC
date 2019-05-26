package com.secaidastudio.e04_mvc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author oscar
 */
public class CustomConnection {
    
    //creacion del singleton
    public static synchronized CustomConnection getInstance(){
        if (instance == null) {
            instance = new CustomConnection();
        }
        return instance;
    }
    
    private static CustomConnection instance;
    
    public CustomConnection(){};
    
    //aca acaba la creacion del singleton
    
    /**
     * creacion de las variables constantes
     */
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String HOST = "localhost";
    private static final String DATA_BASE = "proyectoMVC";
    private static final int PORT = 3306;
    private static final String URL = "jdbc:mysql://"+HOST+':'+PORT+'/'+DATA_BASE;
    private static final String USER = "root";
    private static final String PASS = "password";
    
    public Connection getConnection()
    throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        System.out.println("Driver encontrado"+DRIVER);
        
        Connection conn = DriverManager.getConnection(URL, USER, PASS);
        System.out.println("Conexion exitosa "+ URL);
        return conn;
                
    }
    
    
}
