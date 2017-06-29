package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCurso;

	private BigDecimal costo;

	private String dias;

	private BigDecimal inscripcion;

	private String nomCurso;

	private int nroCuotas;

	private int profesor;

	//bi-directional many-to-one association to Inscripcion
	@OneToMany(mappedBy="curso")
	private List<Inscripcion> inscripcions;

	public Curso() {
	}

	public int getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public BigDecimal getCosto() {
		return this.costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public String getDias() {
		return this.dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public BigDecimal getInscripcion() {
		return this.inscripcion;
	}

	public void setInscripcion(BigDecimal inscripcion) {
		this.inscripcion = inscripcion;
	}

	public String getNomCurso() {
		return this.nomCurso;
	}

	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
	}

	public int getNroCuotas() {
		return this.nroCuotas;
	}

	public void setNroCuotas(int nroCuotas) {
		this.nroCuotas = nroCuotas;
	}

	public int getProfesor() {
		return this.profesor;
	}

	public void setProfesor(int profesor) {
		this.profesor = profesor;
	}

	public List<Inscripcion> getInscripcions() {
		return this.inscripcions;
	}

	public void setInscripcions(List<Inscripcion> inscripcions) {
		this.inscripcions = inscripcions;
	}

	public Inscripcion addInscripcion(Inscripcion inscripcion) {
		getInscripcions().add(inscripcion);
		inscripcion.setCurso(this);

		return inscripcion;
	}

	public Inscripcion removeInscripcion(Inscripcion inscripcion) {
		getInscripcions().remove(inscripcion);
		inscripcion.setCurso(null);

		return inscripcion;
	}

}