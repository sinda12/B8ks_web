package com.esprit.b8ks_web.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class usedbook implements Serializable {
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name ="Book_ID")
	private int id;
	@Column (name ="Book_Titre")
	private String titre;
	@Column (name ="Book_Prix")
	private double prix;
	@Column (name ="Book_Auteur")
	private String auteur;
	@Column (name ="Book_Description")
	private String description;
	@Column (name ="Book_DatePub")
	private String datepub;
	@Column (name = "book label")
	private String label;
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public usedbook(int id, String titre, double prix, String auteur, String description, String datepub) {
		super();
		this.id = id;
		this.titre = titre;
		this.prix = prix;
		this.auteur = auteur;
		this.description = description;
		this.datepub = datepub;
	}

	@Override
	public String toString() {
		return "usedbook [label=" + label + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDatepub() {
		return datepub;
	}

	public void setDatepub(String datepub) {
		this.datepub = datepub;
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
		usedbook other = (usedbook) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public List<usedbook> getcategories() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCategories(List<usedbook> categories) {
		// TODO Auto-generated method stub
		
	}





}
