package com.muhammad.registration.model.dao;

import com.muhammad.registration.model.entity.Student;

public interface StudentDAO {
    Student findById(String Id);

    Student findByEmail(String email);

    void create(Student s);

    void update(Student s);

    void delete(String Id);
}
