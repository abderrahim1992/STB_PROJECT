package stb.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="exigence")
public class StbExigence {
	/**
	 * Attributs
	 */
	@XmlElement
	private int id_exigence;

	@XmlElement
	private String descriptionExigence;

	@XmlElement
	private int prioriteExigence;

	@XmlElement
	private int id_fonctionnalite;

	/**
	 * Constructors
	 */
	public StbExigence(int id_exigence, String description, int priorite, int id_fonctionnalite) {
		this.id_exigence = id_exigence;
		this.descriptionExigence = description;
		this.prioriteExigence = priorite;
		this.id_fonctionnalite = id_fonctionnalite;
	}

	public StbExigence() {

	}

	/**
	 * Getters
	 */
	public int getIdExigence() {
		return id_exigence;
	}

	public String getDescription() {
		return descriptionExigence;
	}

	public int getPriorite() {
		return prioriteExigence;
	}

	public int getIdFonctionnalite() {
		return id_fonctionnalite;
	}

	/**
	 * Setters
	 */
	public void setIdExigence(int id_exigence) {
		this.id_exigence = id_exigence;
	}

	public void setDescription(String description) {
		this.descriptionExigence = description;
	}

	public void setPriorite(int priorite) {
		this.prioriteExigence = priorite;
	}

	public void setIdFonctionnalite(int id_fonctionnalite) {
		this.id_fonctionnalite = id_fonctionnalite;
	}

}
