package in.mecw.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import in.mecw.entity.Address;
import in.mecw.entity.Course;
import in.mecw.entity.Department;
import in.mecw.entity.Student;
import in.mecw.entity.Teacher;
public class StudentDao {
	

	

			private EntityManagerFactory emf;

			public StudentDao(EntityManagerFactory emf) {
				this.emf = emf;
			}

			
			public String addStudent(Student student) {

				EntityManager em = emf.createEntityManager();
				EntityTransaction et = em.getTransaction();

				et.begin();
				em.persist(student);
				et.commit();

				return "Student inserted";
			}

			
			public Student updateStudent(Student student) {

				EntityManager em = emf.createEntityManager();
				EntityTransaction et = em.getTransaction();

				et.begin();
				student = em.merge(student);
				et.commit();

				return student;
			}

		
			public Student deleteStudent(Student student) {

				EntityManager em = emf.createEntityManager();
				EntityTransaction et = em.getTransaction();

				et.begin();

				Student s = em.merge(student);
				em.remove(s);

				et.commit();

				return s;
			}

			
			public Student findStudentById(int id) {

				EntityManager em = emf.createEntityManager();

				return em.find(Student.class, id);
			}

			
			public List<Student> findAllStudents() {

				EntityManager em = emf.createEntityManager();

				TypedQuery<Student> result =
						em.createQuery("select s from Student s", Student.class);

				return result.getResultList();
			}

			
			public Course findCourseByStudent(int studentId) {

				EntityManager em = emf.createEntityManager();

				TypedQuery<Course> result =
						em.createQuery(
								"select s.courses from Student s where s.studentId=:id",
								Course.class);

				result.setParameter("id", studentId);

				return result.getSingleResult();
			}

			
			public Department findDepartmentByStudent(int studentId) {

				EntityManager em = emf.createEntityManager();

				TypedQuery<Department> result =
						em.createQuery(
								"select s.courses.dept from Student s where s.studentId=:id",
								Department.class);

				result.setParameter("id", studentId);

				return result.getSingleResult();
			}

			
			public Address findAddressByStudent(int studentId) {

				EntityManager em = emf.createEntityManager();

				TypedQuery<Address> result =
						em.createQuery(
								"select s.address from Student s where s.studentId=:id",
								Address.class);

				result.setParameter("id", studentId);

				return result.getSingleResult();
			}

			
			public List<Teacher> findTeachersByStudent(int studentId) {

				EntityManager em = emf.createEntityManager();

				TypedQuery<Teacher> result =
						em.createQuery(
								"select t from Student s join s.teachers t where s.studentId=:id",
								Teacher.class);

				result.setParameter("id", studentId);

				return result.getResultList();
			}

		
			public List<Student> findStudentsAboveAge(int age) {

				EntityManager em = emf.createEntityManager();

				TypedQuery<Student> result =
						em.createQuery(
								"select s from Student s where s.age > :age",
								Student.class);

				result.setParameter("age", age);

				return result.getResultList();
			}

			
			public List<Student> findStudentsByCity(String city) {

				EntityManager em = emf.createEntityManager();

				TypedQuery<Student> result =
						em.createQuery(
								"select s from Student s where s.address.city=:city",
								Student.class);

				result.setParameter("city", city);

				return result.getResultList();
			}
		
}
