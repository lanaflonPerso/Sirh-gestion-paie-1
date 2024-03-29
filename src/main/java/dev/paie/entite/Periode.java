package dev.paie.entite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "periode")

public class Periode {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "DATE_DEBUT")

	private LocalDate dateDebut;

	@Column(name = "DATE_FIN")
	private LocalDate dateFin;

	public Periode() {
	}

	public Periode(int numMois) {

		int year = LocalDate.now().getYear();
		this.dateDebut = LocalDate.of(year, numMois, 1);
		this.dateFin = dateDebut.withDayOfMonth(dateDebut.lengthOfMonth());
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
