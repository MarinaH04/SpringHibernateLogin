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
//	final Student student1 = new Student("Alina","alina@yahoo.com","1234");
//	final CursuriDAO cursDAO = appContext.getBean(CursuriDAO.class);
//	final Cursuri cursuri = new Cursuri("Matematica");
//	final Cursuri cursuri1 = new Cursuri("Economie");		
	
//	cursDAO.saveOrUpdate(cursuri);
//	cursDAO.saveOrUpdate(cursuri1);
//	student1.addCursuri(cursDAO.getCursuri("Matematica"));
//	student1.addCursuri(cursDAO.getCursuri("Economie"));
//	studentDAO.saveOrUpdate(student1);
//	studentDAO.insera("Andrei", "andreil@yahoo.com", "stpd");
	try {
	
	List<Student> detailList = studentDAO.displayStudent();
	for (final Student stud : detailList){
		
	      System.out.println(stud.toString());
	    }
	}
	catch(Exception ex) {
		
	}
	
	System.out.println(studentDAO.getUserByUsername("Marina").toString());
//	Student marina = new Student();

//	
//	
//	final List<Cursuri> cursuriList = cursDAO.getStudentCurs(marina);
//
//   System.out.println(marina.getUsername()+ "'s courses are: ");
//  for (final Cursuri curs: cursuriList) {
//    System.out.printf("Curs: '%s'\n", curs.getDenumire());
// }
  studentDAO.deleteStudent(7);
	
}
}