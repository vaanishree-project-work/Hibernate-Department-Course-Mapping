package in.mecw1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import in.mecw.dao.DepartmentDao;
import in.mecw.entity.Course;
import in.mecw.entity.Department;

public class ApplicationDriver {
     public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		DepartmentDao deptDao=new DepartmentDao(emf);
		Department d= new Department();
		d.setDepartmentId(1);
		d.setDepartName("CSE");
		d.setLocation("salem");
		List<Course> courses=new ArrayList<Course>();
		Course c1=new Course(1,"Java",4);
		Course c2=new Course(2,"AIML",4);
		Course c3=new Course(3,"DataScience",4);
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		
		d.setCourses(courses); 
		deptDao.addDepartment(d);
		
	}
}