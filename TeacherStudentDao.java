package in.mecw.dao;


	import java.util.ArrayList;
	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.TypedQuery;

	import in.mecw.entity.Student;
	import in.mecw.entity.Teacher;
	public class TeacherStudentDao {

			private EntityManagerFactory emf;

			public TeacherStudentDao(EntityManagerFactory emf) {
				this.emf = emf;
			}

			
			public String assignTeacherToStudent(
					int studentId, int teacherId) {

				EntityManager em = emf.createEntityManager();
				EntityTransaction et = em.getTransaction();

				Student student = em.find(Student.class, studentId);
				Teacher teacher = em.find(Teacher.class, teacherId);

				if (student != null && teacher != null) {

					if (student.getTeachers() == null) {
						student.setTeachers(new ArrayList<Teacher>());
					}

					student.getTeachers().add(teacher);

					et.begin();
					em.merge(student);
					et.commit();

					return "Teacher assigned to Student";
				}

				return "Student or Teacher not found";
			}

		
			public List<Teacher> findTeachersByStudent(int studentId) {

				EntityManager em = emf.createEntityManager();

				TypedQuery<Teacher> result =
						em.createQuery(
								"select t from Student s join s.teachers t "
								+ "where s.studentId=:id",
								Teacher.class);

				result.setParameter("id", studentId);

				return result.getResultList();
			}

			
			public List<Student> findStudentsByTeacher(int teacherId) {

				EntityManager em = emf.createEntityManager();

				TypedQuery<Student> result =
						em.createQuery(
								"select s from Teacher t join t.students s "
								+ "where t.teacherId=:id",
								Student.class);

				result.setParameter("id", teacherId);

				return result.getResultList();
			}

			
			public String removeTeacherFromStudent(
					int studentId, int teacherId) {

				EntityManager em = emf.createEntityManager();
				EntityTransaction et = em.getTransaction();

				Student student = em.find(Student.class, studentId);
				Teacher teacher = em.find(Teacher.class, teacherId);

				if (student != null && teacher != null) {

					student.getTeachers().remove(teacher);

					et.begin();
					em.merge(student);
					et.commit();

					return "Teacher removed from Student";
				}

				return "Student or Teacher not found";
			}
		}

