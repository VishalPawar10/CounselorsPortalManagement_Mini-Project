package in.ashokit.repo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "enquiries_tbl")
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enqId;

	@Column(nullable = false)
	private String studentName;

	@Column(nullable = false)
	private String studentPhno;

	@Column(nullable = false)
	private String courseName;

	@Column(nullable = false)
	private String classMode;

	@Column(nullable = false)
	private String enqStatus;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@ManyToOne
	@JoinColumn(name = "counsellor_id", nullable = false)
	private Counsellors counsellor;

	@PreUpdate
	protected void onUpdate() {
		updatedDate = new Date();
	}

	public Long getEnqId() {
		return enqId;
	}

	public void setEnqId(Long enqId) {
		this.enqId = enqId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentPhno() {
		return studentPhno;
	}

	public void setStudentPhno(String studentPhno) {
		this.studentPhno = studentPhno;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getClassMode() {
		return classMode;
	}

	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}

	public String getEnqStatus() {
		return enqStatus;
	}

	public void setEnqStatus(String enqStatus) {
		this.enqStatus = enqStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Counsellors getCounsellor() {
		return counsellor;
	}

	public void setCounsellor(Counsellors counsellor) {
		this.counsellor = counsellor;
	}

	@Override
	public String toString() {
		return "Enquiry [enqId=" + enqId + ", studentName=" + studentName + ", studentPhno=" + studentPhno
				+ ", courseName=" + courseName + ", classMode=" + classMode + ", enqStatus=" + enqStatus
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", counsellor=" + counsellor + "]";
	}

}
