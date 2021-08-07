package ma.iga.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "personne")
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nom;
	private String prenom;
	private String matricule;
	private String titre;
	private Double salaireBase;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date recrutement;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date demission;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
	public Double getSalaireBase() {
		return salaireBase;
	}
	public void setSalaireBase(Double salaireBase) {
		this.salaireBase = salaireBase;
	}
	public Date getRecrutement() {
		return recrutement;
	}
	public void setRecrutement(Date recrutement) {
		this.recrutement = recrutement;
	}
	public Date getDemission() {
		return demission;
	}
	public void setDemission(Date demission) {
		this.demission = demission;
	}
	
	 
	
}
