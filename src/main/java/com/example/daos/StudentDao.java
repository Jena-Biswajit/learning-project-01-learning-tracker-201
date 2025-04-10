package com.example.daos;

import com.example.dto.Student;

public interface StudentDao {
    public boolean save(Student student) throws ClassNotFoundException;
}
