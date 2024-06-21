package com.buffer.spring.data.jpa.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile")
        )
})
public class Guardian {

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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	private String name;
    private String email;
    private String mobile;
	@Override
	public String toString() {
		return "Guardian [name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
	}
	public Guardian(String name, String email, String mobile) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
	public Guardian(GuardianBuilder builder) {
		super();
		this.name = builder.name;
		this.email = builder.email;
		this.mobile = builder.mobile;
	}
	
	public Guardian() {
		super();
	}

	public static class GuardianBuilder{
		public GuardianBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public GuardianBuilder setEmail(String email) {
			this.email = email;
			return this;
		}
		public GuardianBuilder setMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}
		private String name;
	    private String email;
	    private String mobile;
	    
	    public Guardian build() {
	    	return new Guardian(this);
	    }
		public GuardianBuilder() {
			super();
		}
	    
		
	}
    
}