package com.hanzu.proiect.persistence.dao;

import com.hanzu.proiect.persistence.entity.Student;

public interface StudentDAO {
	  void saveOrUpdate(final Student student);

	  void readAll();
}
