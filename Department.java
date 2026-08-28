package in.mecw.entity;



	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;

	@Entity
	@Table(name = "department")
	public class Department {
		@Id	 
		@Column(name="department_id")
		private int departmentId;
		@Column(name="department_name",unique =true,nullable=false)
		private String departName;
		
		private String location;
		@OneToMany (mappedBy="dept",cascade=CascadeType.ALL)
	  private List<Course> courses;
	  
		public List<Course> getCourses() {
			return courses;
		}
		public void setCourses(List<Course> courses) {
			this.courses = courses;
		}
		public int getDepartmentId() {
			return departmentId;
		}
		public void setDepartmentId(int departmentId) {
			this.departmentId = departmentId;
		}
		public String getDepartName() {
			return departName;
		}
		public void setDepartName(String departName) {
			this.departName = departName;
		}
		
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		

	}

