package in.mecw.dao;


	
	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.TypedQuery;

	import in.mecw.entity.Student;
	import in.mecw.entity.Teacher;
	public class TeacherDao {
		

		

		

			private EntityManagerFactory emf;

			public TeacherDao(EntityManagerFactory emf) {
				this.emf = emf;
			}

			public String addTeacher(Teacher teacher) {

				EntityManager em = emf.createEntityManager();
				EntityTransaction et = em.getTransaction();

				et.begin();
				em.persist(teacher);
				et.commit();

				return "Teacher inserted";
			}

			public Teacher updateTeacher(Teacher teacher) {

				EntityManager em = emf.createEntityManager();
				EntityTransaction et = em.getTransaction();

				et.begin();
				teacher = em.merge(teacher);
				et.commit();

				return teacher;
			}

			public Teacher deleteTeacher(Teacher teacher) {

				EntityManager em = emf.createEntityManager();
				EntityTransaction et = em.getTransaction();

				et.begin();

				Teacher t = em.merge(teacher);
				em.remove(t);

				et.commit();

				return t;
			}

			public Teacher findTeacherById(int id) {

				EntityManager em = emf.createEntityManager();

				return em.find(Teacher.class, id);
			}

			public List<Teacher> findAllTeachers() {

				EntityManager em = emf.createEntityManager();

				TypedQuery<Teacher> result =
						em.createQuery(
								"select t from Teacher t",
								Teacher.class);

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
		
}
