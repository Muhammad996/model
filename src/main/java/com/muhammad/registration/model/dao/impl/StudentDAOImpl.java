package com.muhammad.registration.model.dao.impl;

import com.muhammad.registration.model.dao.StudentDAO;
import com.muhammad.registration.model.dao.util.DataBaseConnect;
import com.muhammad.registration.model.entity.Student;

import java.sql.ResultSet;

public class StudentDAOImpl implements StudentDAO {
    DataBaseConnect c1 = new DataBaseConnect();
    Student s = new Student();

    public Student findById(String Id) {
        try {
            ResultSet rs = c1.returnCW().getData("select from students where Id =" + Id);
            s.setId(rs.getNString(1));
            s.setFirstName(rs.getNString(2));
            s.setLastName(rs.getNString(3));
            s.setEmail(rs.getNString(4));
            s.setPassword(rs.getNString(5));
        } catch (Exception e) {
            System.out.println("Exception in c1");
        }
        return s;
    }

    public Student findByEmail(String email) {
        try {
            ResultSet rs = c1.returnCW().getData("select from students where email =" + email);
            s.setId(rs.getNString(1));
            s.setFirstName(rs.getNString(2));
            s.setLastName(rs.getNString(3));
            s.setEmail(rs.getNString(4));
            s.setPassword(rs.getNString(5));
        } catch (Exception e) {
            System.out.println("Exception in c1");
        }
        return s;

    }

    public void create(Student s) {
        try {
            ResultSet rs = c1.returnCW().getData("insert into students);
            s.setId(rs.getNString(1));
            s.setFirstName(rs.getNString(2));
            s.setLastName(rs.getNString(3));
            s.setEmail(rs.getNString(4));
            s.setPassword(rs.getNString(5));
        } catch (Exception e) {
            System.out.println("Exception in c1");
        }
        return s;

    }

    @Override
    public Student update(Student s) {
        return null;
    }

    @Override
    public Student delete(String Id) {
        return null;
    }

}
