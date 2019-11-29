package com.hanzu.proiect.persistence.dao;


import java.util.List;

import com.hanzu.proiect.persistence.entity.Cursuri;
import com.hanzu.proiect.persistence.entity.Student;




public interface CursuriDAO {
	void saveOrUpdate(final String denumire);

	  void saveOrUpdate(final Cursuri cursuri);

	  Cursuri getCursuri(final String denumire);

	  public List<Cursuri> getStudentCurs(final Student student);
}
