package in.mecw.dao;




	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	
	import javax.persistence.TypedQuery;

	import in.mecw.entity.Course;
	import in.mecw.entity.Department;


	public class DepartmentDao {
	   private   EntityManagerFactory emf ;//for every project only EMF 
	   public DepartmentDao(EntityManagerFactory emf)   //singleton class  jpql query
	   {
		  this.emf=emf; 
	   }
	   
	   public String addDepartment(Department depart)
	   {
		   EntityManager em=emf.createEntityManager();
		   EntityTransaction et =em.getTransaction();
		   et.begin();
		   em.persist(depart);
		   et.commit();
		   return"Record inserted";
	   }
	   
	   
	   public Department updateDepart(int id,String name,String location)
	   {
		   EntityManager em=emf.createEntityManager();
		   EntityTransaction et =em.getTransaction();  //castate type multiple type persistence
		   Department dep =em.find(Department.class, id);
		
		   if(dep !=null)                                            //return type crud
		   {
			   if(name!=null)
			   {
				  dep.setDepartName(name);  
			   }
			   if(location!=null)
			   {
				dep.setLocation(location);
			   }
		  
		   et.begin();
		   dep=em.merge(dep);
		   et.commit();
		
		   
	   }
		   return dep;
	   }
	   public Department updateDept(Department dept) {
		   EntityManager em=emf.createEntityManager();
		   EntityTransaction et=em.getTransaction();
		   et.begin();
		   dept =em.merge(dept);
		   et.commit();
		   return dept;
	   }
	   
	  public Department deleteDept(Department dept) {
		  EntityManager em=emf.createEntityManager();
		  EntityTransaction et=em.getTransaction();
		  et.begin();
		  em.merge(dept);
		  em.remove(dept);
		  et.commit();
		  return dept;
		  
	  }
	  public Department findDeptById(int id) {
		  EntityManager em=emf.createEntityManager();
		  return em.find(Department.class,id);
	  }
	  public List<Department> findAllDepartment(){
		  EntityManager em=emf.createEntityManager();
		TypedQuery<Department>result= em. createQuery("select d from Depatment d",Department.class);
		return result.getResultList();
	  }
	   public List<Course> findAllCoursesInDept(int deptId){
		   EntityManager em=emf.createEntityManager();
		   TypedQuery <Course>result=em.createQuery("select d.courses from Department d where d.departmentId=:deptId",Course.class);
		   result.setParameter("deptId",deptId);  
		   return result.getResultList();
		   }
	   
	   
	   
	   
	   
	   
	
}
