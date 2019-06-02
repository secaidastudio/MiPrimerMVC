package com.secaidastudio.e04_mvc.dao;

import com.secaidastudio.e04_mvc.model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oscar
 */
public class CourseDAO implements GeneralDAO<Course> {

    @Override
    public List<Course> queryAll() {
        List<Course> temp = new ArrayList<>();

        //Conexion a la base de datos
        try {
            Connection conn = CONN_WRAPPER.getConnection();
            Statement stmnt = conn.createStatement();
            ResultSet result = stmnt.executeQuery("SELECT code, name, description, credits FROM course");

            while (result.next()) {
                Course c = new Course();
                c.setCode((int) result.getLong("code"));
                c.setName(result.getString("name"));
                c.setDescription(result.getString("description"));
                c.setCredits(result.getInt("credits"));
                temp.add(c);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return temp;
    }

    @Override
    public Course findById(long id) {
        Course c = null;
        try {
            Connection conn = CONN_WRAPPER.getConnection();
            PreparedStatement stmnt = conn.prepareStatement("SELECT code, name,description,credits FROM course WHERE code =?");
            stmnt.setLong(1, id);

            ResultSet result = stmnt.executeQuery();
            if (result.next()) {
                c = new Course();
                c.setCode(result.getInt("code"));
                c.setName(result.getString("name"));
                c.setDescription(result.getString("description"));
                c.setCredits(result.getInt("credits"));

            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        return c;
    }

    @Override
    public void create(Course course) {
        try {
            Connection conn = CONN_WRAPPER.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(
                    "INSERT INTO course (name, description, credits) VALUES (?,?,?)"
            );
            stmnt.setString(1, course.getName());
            stmnt.setString(2, course.getDescription());
            stmnt.setInt(3, course.getCredits());
            stmnt.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void edit(long id, Course edited) {
        try {
            Connection conn = CONN_WRAPPER.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(
                    "UPDATE course SET "
                    +" name = ?,"
                    +" description = ?,"
                    +" credits = ?"
                    +" WHERE code = ?"
            
            );
            stmnt.setString(1, edited.getName());
            stmnt.setString(2, edited.getDescription());
            stmnt.setInt(3, edited.getCredits());
            stmnt.setLong(4, id);
            stmnt.execute();
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        try {
            Connection conn = CONN_WRAPPER.getConnection();
            PreparedStatement stmnt = conn.prepareStatement(
                    "DELETE FROM course WHERE code = ?"
            );
            stmnt.setLong(1, id);
            stmnt.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }

}
