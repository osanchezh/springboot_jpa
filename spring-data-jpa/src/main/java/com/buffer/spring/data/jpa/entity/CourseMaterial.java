package com.buffer.spring.data.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
    
    public Long getCourseMaterialId() {
		return courseMaterialId;
	}

	public void setCourseMaterialId(Long courseMaterialId) {
		this.courseMaterialId = courseMaterialId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public CourseMaterial(Long courseMaterialId, String url, Course course) {
		super();
		this.courseMaterialId = courseMaterialId;
		this.url = url;
		this.course = course;
	}

	public CourseMaterial() {
		super();
	}

	@Override
	public String toString() {
		return "CourseMaterial [courseMaterialId=" + courseMaterialId + ", url=" + url + "]";
	}
	public CourseMaterial(CourseMaterialBuilder builder) {
		super();
		this.courseMaterialId = builder.courseMaterialId;
		this.url = builder.url;
		this.course = builder.course;
	}
	public static class CourseMaterialBuilder{
		public CourseMaterialBuilder setCourseMaterialId(Long courseMaterialId) {
			this.courseMaterialId = courseMaterialId;
			return this;
		}

		public CourseMaterialBuilder setUrl(String url) {
			this.url = url;
			return this;
		}

		public CourseMaterialBuilder setCourse(Course course) {
			this.course = course;
			return this;
		}
		private Long courseMaterialId;
	    private String url;
	    private Course course;
		public CourseMaterialBuilder() {
			super();
		}
	    public CourseMaterial build() {
	    	return new CourseMaterial(this);
	    }
	    
	}
}