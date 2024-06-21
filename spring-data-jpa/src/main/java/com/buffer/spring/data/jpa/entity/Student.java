package com.buffer.spring.data.jpa.entity;

import com.buffer.spring.data.jpa.entity.Guardian.GuardianBuilder;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "email_address"
        )
)
public class Student {



	@Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailId;

    @Embedded
    private Guardian guardian;
    
    
    
    public Student() {
		super();
	}

	public Student(Long studentId, String firstName, String lastName, String emailId, Guardian guardian) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.guardian = guardian;
	}

	public Student(StudentBuilder builder) {
		super();
		this.studentId = builder.studentId;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.emailId = builder.emailId;
		this.guardian = builder.guardian;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + "]";
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Guardian getGuardian() {
		return guardian;
	}

	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}
	
	public static class StudentBuilder{
	    public StudentBuilder setStudentId(Long studentId) {
			this.studentId = studentId;
			return this;
		}
		public StudentBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		public StudentBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		public StudentBuilder setEmailId(String emailId) {
			this.emailId = emailId;
			return this;
		}
		public StudentBuilder setGuardian(Guardian guardian) {
			this.guardian = guardian;
			return this;
		}
		private Long studentId;
	    private String firstName;
	    private String lastName;
	    private String emailId;
	    private Guardian guardian;
	    
	    public Student build() {
	    	return new Student(this);
	    }
		public StudentBuilder() {
			super();
		}
	    
	}
}