package com.hanzu.proiect.persistence.dao.impl;



import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanzu.proiect.common.PersistanceOperations;
import com.hanzu.proiect.persistence.dao.CursuriDAO;
import com.hanzu.proiect.persistence.entity.Cursuri;
import com.hanzu.proiect.persistence.entity.Student;


@Repository
@Transactional
public class CursuriDAOImpl implements CursuriDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveOrUpdate(String denumire) {
		final Cursuri curs = new Cursuri(denumire);
	    saveOrUpdate(curs);
	}

	@Override
	public void saveOrUpdate(Cursuri cursuri) {
		 new PersistanceOperations().saveOrUpdate(sessionFactory, cursuri, " Curs: " + cursuri.getDenumire() + " saved!");
	}

	@Override
	public Cursuri getCursuri(String denumire) {
		final Query q = sessionFactory.getCurrentSession().createQuery("FROM Cursuri WHERE denumire=:denumire");
	    q.setParameter("denumire", denumire);
		
	    Cursuri curs = null;
	    try {
	        curs = (Cursuri) q.uniqueResult();
	        if (curs == null) {
	          System.out.println("Course with name '" + denumire + "' not Found !");
	        }
	      } catch (Exception ex) {
	        System.out.printf("Exception in getCursuri: %s \n", ex.getMessage());
	      }
	    return curs;
		
	}
	 @SuppressWarnings("unchecked")
	public List<Cursuri> getStudentCurs(final Student student) {
		    final List<Cursuri> curslist = new ArrayList<Cursuri>();

		    final Query q = sessionFactory.getCurrentSession().createQuery("SELECT s FROM Student p JOIN p.cursuri s WHERE p.id=:studentID");
		    q.setParameter("studentID", student.getStudentID());

		    try {
		      curslist.addAll((List<Cursuri>) q.list());
		    } catch (Exception ex) {
		      System.out.printf("Exception in getStudentCurs: %s \n", ex.getMessage());
		    }

		    return curslist;
		  }

	
}
