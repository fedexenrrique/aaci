package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the alumno database table.
 * 
 */
@Entity
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAlumno;

	private String apeAlum;

	private BigInteger dni;

	@Temporal(TemporalType.DATE)
	private Date nacimiento;

	private String nomAlum;

	public Alumno() {
	}

	public int getIdAlumno() {
		return this.idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getApeAlum() {
		return this.apeAlum;
	}

	public void setApeAlum(String apeAlum) {
		this.apeAlum = apeAlum;
	}

	public BigInteger getDni() {
		return this.dni;
	}

	public void setDni(BigInteger dni) {
		this.dni = dni;
	}

	public Date getNacimiento() {
		return this.nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getNomAlum() {
		return this.nomAlum;
	}

	public void setNomAlum(String nomAlum) {
		this.nomAlum = nomAlum;
	}

}