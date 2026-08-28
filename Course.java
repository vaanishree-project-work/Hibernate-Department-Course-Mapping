package in.mecw.entity;


	

	import java.util.List;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.ManyToOne;
	import javax.persistence.OneToMany;

	@Entity
	public class Course {
		@Id
		@Column(name="Course_Id")
	     private int courseId;
		@Column(name="Course_Name")
	     private String courseName;
	     private int duration;
	     @ManyToOne
	     private Department dept;
	     @OneToMany(mappedBy="courses")
	     private List<Student> students; 
	     
		 public List<Student> getStudents() {
			return students;
		}
		 public void setStudents(List<Student> students) {
			 this.students = students;
		 }
		 public Department getDept() {
			return dept;
		}
		 public void setDept(Department dept) {
			 this.dept = dept;
		 }
		 public int getCourseId() {
			 return courseId;
		 }
		 public void setCourseId(int courseId) {
			 this.courseId = courseId;
		 }
		 public String getCourseName() {
			 return courseName;
		 }
		 public void setCourseName(String courseName) {
			 this.courseName = courseName;
		 }
		 public int getDuration() {
			 return duration;
		 }
		 public void setDuration(int duration) {
			 this.duration = duration;
		 }
		 Course()
		 {
			 
		 }
		 public Course(int courseId, String courseName, int duration) {
			super();
			this.courseId = courseId;
			this.courseName = courseName;
			this.duration = duration;
		
		 }
		
	     
	}

