package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the profesor database table.
 * 
 */
@Entity
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProfesor;

	private String apeProf;

	@Temporal(TemporalType.DATE)
	private Date nacimiento;

	private String nomProf;

	public Profesor() {
	}

	public int getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getApeProf() {
		return this.apeProf;
	}

	public void setApeProf(String apeProf) {
		this.apeProf = apeProf;
	}

	public Date getNacimiento() {
		return this.nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getNomProf() {
		return this.nomProf;
	}

	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}

}