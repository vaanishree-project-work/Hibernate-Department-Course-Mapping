package in.mecw.entity;



	import java.util.List;

	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.ManyToMany;

	@Entity
	public class Teacher {
		@Id
	       private int teacherId;
	       private String name;
	       private String email;
	       private String specialization;
	       @ManyToMany(mappedBy="teachers")
	       private List<Student>students;
		   public int getTeacherId() {
			   return teacherId;
		   }
		   public void setTeacherId(int teacherId) {
			   this.teacherId = teacherId;
		   }
		   public String getName() {
			   return name;
		   }
		   public void setName(String name) {
			   this.name = name;
		   }
		   public String getEmail() {
			   return email;
		   }
		   public void setEmail(String email) {
			   this.email = email;
		   }
		   public String getSpecialization() {
			   return specialization;
		   }
		   public void setSpecialization(String specialization) {
			   this.specialization = specialization;
		   }
		   public List<Student> getStudents() {
			   return students;
		   }
		   public void setStudents(List<Student> students) {
			   this.students = students;
		   }
	       
	       

	
}
