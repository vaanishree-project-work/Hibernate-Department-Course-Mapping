package in.mecw1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import in.mecw.dao.AddressDao;
import in.mecw.dao.CourseDao;
import in.mecw.dao.DepartmentDao;
import in.mecw.dao.StudentDao;
import in.mecw.dao.TeacherDao;
import in.mecw.dao.TeacherStudentDao;
import in.mecw.entity.Address;
import in.mecw.entity.Course;
import in.mecw.entity.Department;
import in.mecw.entity.Student;
import in.mecw.entity.Teacher;
public class ApplicationDriver {
     public static void main(String[] args) {

    	 		
    	 		EntityManagerFactory emf =
    	 				Persistence.createEntityManagerFactory("dev");

    	 		
    	 		DepartmentDao deptDao = new DepartmentDao(emf);
    	 		CourseDao courseDao = new CourseDao(emf);
    	 		StudentDao studentDao = new StudentDao(emf);
    	 		AddressDao addressDao = new AddressDao(emf);
    	 		TeacherDao teacherDao = new TeacherDao(emf);
    	 		TeacherStudentDao teacherStudentDao =
    	 				new TeacherStudentDao(emf);



    	 		Department d = new Department();

    	 		d.setDepartmentId(1);
    	 		d.setDepartName("CSE");
    	 		d.setLocation("Salem");



    	 		Course c1 = new Course(1, "Java", 4);
    	 		Course c2 = new Course(2, "AIML", 4);
    	 		Course c3 = new Course(3, "DataScience", 4);

    	 		
    	 		c1.setDept(d);
    	 		c2.setDept(d);
    	 		c3.setDept(d);

    	 		
    	 		List<Course> courses = new ArrayList<Course>();

    	 		courses.add(c1);
    	 		courses.add(c2);
    	 		courses.add(c3);

    	 		d.setCourses(courses);

    	 	
    	 		System.out.println(deptDao.addDepartment(d));


    	 		

    	 		Address a1 = new Address();

    	 		a1.setAddressId(1);
    	 		a1.setHouse("10");
    	 		a1.setStreet("Main Road");
    	 		a1.setCity("Salem");
    	 		a1.setState("Tamil Nadu");
    	 		a1.setPincode(636001);

    	 		System.out.println(addressDao.addAddress(a1));



    	 		Student s1 = new Student();

    	 		s1.setStudentId(101);
    	 		s1.setName("Arun");
    	 		s1.setEmail("arun@gmail.com");
    	 		s1.setPhone(9876543210L);
    	 		s1.setAge(21);

    	 		
    	 		s1.setCourses(c1);

    	 		
    	 		s1.setAddress(a1);

    	 		
    	 		s1.setTeachers(new ArrayList<Teacher>());

    	 		System.out.println(studentDao.addStudent(s1));


    	

    	 		Student s2 = new Student();

    	 		s2.setStudentId(102);
    	 		s2.setName("Priya");
    	 		s2.setEmail("priya@gmail.com");
    	 		s2.setPhone(9876543211L);
    	 		s2.setAge(22);

    	 		s2.setCourses(c2);

    	 		s2.setTeachers(new ArrayList<Teacher>());

    	 		System.out.println(studentDao.addStudent(s2));


    	 		
    	 		Teacher t1 = new Teacher();

    	 		t1.setTeacherId(201);
    	 		t1.setName("Ravi");
    	 		t1.setEmail("ravi@gmail.com");
    	 		t1.setSpecialization("Java");

    	 		System.out.println(teacherDao.addTeacher(t1));


    	 		Teacher t2 = new Teacher();

    	 		t2.setTeacherId(202);
    	 		t2.setName("Kumar");
    	 		t2.setEmail("kumar@gmail.com");
    	 		t2.setSpecialization("AIML");

    	 		System.out.println(teacherDao.addTeacher(t2));


    	 	
    	 		System.out.println(
    	 				teacherStudentDao.assignTeacherToStudent(101, 201));

    	 		System.out.println(
    	 				teacherStudentDao.assignTeacherToStudent(101, 202));

    	 		System.out.println(
    	 				teacherStudentDao.assignTeacherToStudent(102, 202));


    	 		
    	 		Student student =
    	 				studentDao.findStudentById(101);

    	 		System.out.println(
    	 				"Student Name : " + student.getName());


    	 	
    	 		Course course =
    	 				studentDao.findCourseByStudent(101);

    	 		System.out.println(
    	 				"Course : " + course.getCourseName());


    	 		

    	 		Department department =
    	 				studentDao.findDepartmentByStudent(101);

    	 		System.out.println(
    	 				"Department : " + department.getDepartName());


    	 	
    	 		Address address =
    	 				studentDao.findAddressByStudent(101);

    	 		System.out.println(
    	 				"City : " + address.getCity());



    	 		List<Teacher> teachers =
    	 				studentDao.findTeachersByStudent(101);

    	 		System.out.println("Teachers of Arun:");

    	 		for (Teacher t : teachers) {

    	 			System.out.println(
    	 					t.getName() + " - "
    	 					+ t.getSpecialization());
    	 		}


    	 	

    	 		List<Student> students =
    	 				teacherDao.findStudentsByTeacher(202);

    	 		System.out.println("Students of Kumar:");

    	 		for (Student s : students) {

    	 			System.out.println(
    	 					s.getName() + " - "
    	 					+ s.getEmail());
    	 		}


    	 	

    	 		List<Course> allCourses =
    	 				courseDao.findAllCourses();

    	 		System.out.println("All Courses:");

    	 		for (Course c : allCourses) {

    	 			System.out.println(
    	 					c.getCourseId() + " - "
    	 					+ c.getCourseName());
    	 		}


    	 	

    	 		List<Student> allStudents =
    	 				studentDao.findAllStudents();

    	 		System.out.println("All Students:");

    	 		for (Student s : allStudents) {

    	 			System.out.println(
    	 					s.getStudentId() + " - "
    	 					+ s.getName());
    	 		}


    	 	

    	 		List<Teacher> allTeachers =
    	 				teacherDao.findAllTeachers();

    	 		System.out.println("All Teachers:");

    	 		for (Teacher t : allTeachers) {

    	 			System.out.println(
    	 					t.getTeacherId() + " - "
    	 					+ t.getName());
    	 		}


    	 		

    	 		List<Student> courseStudents =
    	 				courseDao.findAllStudentsInCourse(1);

    	 		System.out.println("Students in Java Course:");

    	 		for (Student s : courseStudents) {

    	 			System.out.println(
    	 					s.getName());
    	 		}


    	 

    	 		emf.close();
    	 	}
    	 
 		
	}