package com.esprit.b8ks_web.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name ="category_ID")
	private int id;
	
	@Column (name ="Category_Titre")
	    private String title;
		
	public category(int id, String title) {
			super();
			this.id = id;
			this.title = title;
		}
		@Override
		public String toString() {
			return "category [id=" + id + ", title=" + title + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			category other = (category) obj;
			if (id != other.id)
				return false;
			return true;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
	    
}
