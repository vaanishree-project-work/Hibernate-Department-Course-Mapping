package in.mecw.entity;



	import java.util.List;

	import javax.persistence.Entity;
	
	import javax.persistence.Id;
	import javax.persistence.ManyToMany;
	import javax.persistence.ManyToOne;
	import javax.persistence.OneToOne;

	@Entity
	public class Student {
		@Id
	      private int studentId;
	      private String name;
	      private String email;
	      private long phone;
	      private int age;
	      @OneToOne
	      private Address address;
	      
	      @ManyToOne
	      private Course courses;
	      @ManyToMany
	      private List<Teacher> teachers;
	      
		  public List<Teacher> getTeachers() {
			return teachers;
		}
		  public void setTeachers(List<Teacher> teachers) {
			  this.teachers = teachers;
		  }
		  public Address getAddress() {
			return address;
		}
		  public void setAddress(Address address) {
			  this.address = address;
		  }
		  public Course getCourses() {
			return courses;
		}
		  public void setCourses(Course courses) {
			  this.courses = courses;
		  }
		  public int getStudentId() {
			  return studentId;
		  }
		  public void setStudentId(int studentId) {
			  this.studentId = studentId;
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
		  public long getPhone() {
			  return phone;
		  }
		  public void setPhone(long phone) {
			  this.phone = phone;
		  }
		  public int getAge() {
			  return age;
		  }
		  public void setAge(int age) {
			  this.age = age;
		  }
		  
	      
	}

