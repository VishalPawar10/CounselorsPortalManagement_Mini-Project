package in.ashokit.repo;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "counsellors_tbl")
public class Counsellors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long counsellorId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String pwd;

	private String phno;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	// Getters and Setters

	@PreUpdate
	protected void onUpdate() {
		updatedDate = new Date();
	}

	public Long getCounsellorId() {
		return counsellorId;
	}

	public void setCounsellorId(Long counsellorId) {
		this.counsellorId = counsellorId;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
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

	@Override
	public String toString() {
		return "Counsellor [counsellorId=" + counsellorId + ", name=" + name + ", email=" + email + ", pwd=" + pwd
				+ ", phno=" + phno + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

	// Constructors, toString(), hashCode(), equals() methods
}
