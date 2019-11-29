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
	final Student student1 = new Student("Marina","hanzumarina@yahoo.com","5678");
	final CursuriDAO cursDAO = appContext.getBean(CursuriDAO.class);
	final Cursuri cursuri = new Cursuri("Matematica");
	final Cursuri cursuri1 = new Cursuri("Economie");		
	
	cursDAO.saveOrUpdate(cursuri);
	cursDAO.saveOrUpdate(cursuri1);
	student1.addCursuri(cursDAO.getCursuri("Matematica"));
	student1.addCursuri(cursDAO.getCursuri("Economie"));
	studentDAO.saveOrUpdate(student1);	
	studentDAO.readAll();
	
	final List<Cursuri> cursuriList = cursDAO.getStudentCurs(student1);

    System.out.println("'" + student1.getUsername()+ "'s courses are: ");
    for (final Cursuri curs: cursuriList) {
      System.out.printf("Curs: '%s'\n", curs.getDenumire());
    }
}
}