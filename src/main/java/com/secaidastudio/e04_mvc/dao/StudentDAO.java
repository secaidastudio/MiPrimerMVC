package com.secaidastudio.e04_mvc.dao;

import com.secaidastudio.e04_mvc.model.Student;
import com.secaidastudio.e04_mvc.utils.CustomConnection;
import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class StudentDAO implements GeneralDAO<Student> {

    @Override
    public List<Student> queryAll() {
    //Primero, crear un objeto estudiante temporal
    List<Student> temp = new ArrayList<>();
    
    //Segundo, realizar la conexion con la base de datos
    try{
        Connection conn = CONN_WRAPPER.getConnection();
        Statement stm = conn.createStatement();
        ResultSet result = stm.executeQuery("SELECT code, firstName, lastName, email, contactPhone, guardian FROM student");
        while(result.next()){
            Student s = new Student();
            s.setCode((int) result.getLong("code"));
            s.setFirstName(result.getString("firstName"));
            s.setLastName(result.getString("lastName"));
            s.setEmail(result.getString("email"));
            s.setContactPhone(result.getString("contactPhone"));
            s.setGuardian(result.getString("guardian"));
            temp.add(s);
        }
                
        
    }   catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } 
    return temp;
    }

    @Override
    public Student findById(long id) {
        Student s = null;
        
        //Conexion a la base de datos
        try{
            Connection conn = CONN_WRAPPER.getConnection();
            //PREPARANDO UN STATEMENT
            PreparedStatement stmnt = conn.prepareStatement("SELECT code, firstName, LastName, gender, email, contactPhone, guardian, birthday FROM student WHERE code = ?");
            stmnt.setLong(1, id);
            
            ResultSet result = stmnt.executeQuery();
            if (result.next()) {
                s = new Student();
                s.setCode((int) result.getLong("code"));
                s.setFirstName(result.getString("firstName"));
                s.setLastName(result.getString("lastName"));
                s.setGender(result.getString("gender"));
                s.setEmail(result.getString("email"));
                s.setContactPhone( result.getString("contactPhone"));
                s.setGuardian(result.getString("guardian"));
                s.setBirthday(result.getDate("birthday"));
                
            }
        }catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return s;
    }

    @Override
    public void create(Student student) {
        try {
            Connection conn = CONN_WRAPPER.getConnection();           
            
            PreparedStatement stmnt = conn.prepareStatement(
                "INSERT INTO student (firstName, lastName, gender, email, contactPhone, guardian, birthday) VALUES (?,?,?,?,?,?,?)"
                        );
            stmnt.setString(1, student.getFirstName());
            stmnt.setString(2, student.getLastName());
            stmnt.setString(3, student.getGender());
            stmnt.setString(4, student.getEmail());
            stmnt.setString(5, student.getContactPhone());
            stmnt.setString(6, student.getGuardian());
            stmnt.setTimestamp(7, Timestamp.from(student.getBirthday().toInstant()));
            stmnt.execute();
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void edit(long id, Student edited) {
        try{
            Connection conn = CONN_WRAPPER.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(
               "UPDATE student SET "
              + " firstName = ?,"
              + " lastName = ?,"
              + " gender = ?,"
              + " email = ?,"
              + " contactPhone = ?,"
              + " guardian = ?,"
              + " birthday = ?"
              + " WHERE code = ?"
            
            );
            
            stmnt.setString(1, edited.getFirstName());
            stmnt.setString(2, edited.getLastName());
            stmnt.setString(3, edited.getGender());
            stmnt.setString(4, edited.getEmail());
            stmnt.setString(5, edited.getContactPhone());
            stmnt.setString(6, edited.getGuardian());
            stmnt.setTimestamp(7, Timestamp.from(edited.getBirthday().toInstant()));
            stmnt.setLong(8, id);
            stmnt.execute();
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        try{
            Connection conn = CONN_WRAPPER.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(
                    "DELETE FROM student WHERE code = ?"            
            );
            stmnt.setLong(1, id);
            stmnt.executeUpdate();
        } catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
