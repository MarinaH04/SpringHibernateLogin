import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hanzu.proiect.persistence.dao.CursuriDAO;
import com.hanzu.proiect.persistence.dao.StudentDAO;
import com.hanzu.proiect.persistence.entity.Cursuri;
import com.hanzu.proiect.persistence.entity.Student;




public class Application {
	public static void main(String[] args) {
		
	
	@SuppressWarnings("resource")
	final ApplicationContext appContext =
	        new ClassPathXmlApplicationContext("applicationContext.xml");
	final StudentDAO studentDAO = appContext.getBean(StudentDAO.class);
//	final Student student1 = new Student("Andreea","andre@yahoo.com","1234");
	final CursuriDAO cursDAO = appContext.getBean(CursuriDAO.class);
//	final Cursuri cursuri = new Cursuri("Matematica");
//	final Cursuri cursuri1 = new Cursuri("Economie");		
	
//	cursDAO.saveOrUpdate(cursuri);
//	cursDAO.saveOrUpdate(cursuri1);
//	student1.addCursuri(cursDAO.getCursuri("Matematica"));
//	student1.addCursuri(cursDAO.getCursuri("Economie"));
//	studentDAO.saveOrUpdate(student1);
	
	try {
	
	List<Student> detailList = studentDAO.displayStudents();
	for (final Student stud : detailList){
		
	      System.out.println("Username: "+stud.getUsername()+"; Email: " + stud.getEmail() +"; Password: "+ stud.getPassword());
	    }
	}
	catch(Exception ex) {
		
	}
	Student marina = new Student();
	marina = studentDAO.getUserByUsername("Marina");	
	
	
	final List<Cursuri> cursuriList = cursDAO.getStudentCurs(marina);

   System.out.println(marina.getUsername()+ "'s courses are: ");
  for (final Cursuri curs: cursuriList) {
    System.out.printf("Curs: '%s'\n", curs.getDenumire());
 }
 // studentDAO.deleteStudent(4);
	
}
}