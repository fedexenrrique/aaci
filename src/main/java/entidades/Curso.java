package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCurso;

	private Double costo;

	private String dias;

	private Double inscripcion;

	private String nomCurso;

	private int nroCuotas;

	private int profesor;

	//bi-directional many-to-one association to Inscripcion
	@OneToMany(fetch = FetchType.EAGER, mappedBy="curso")
	private List<Inscripcion> inscripcions;

	public Curso() {
	}

	public int getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public Double getCosto() {
		return this.costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getDias() {
		return this.dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public Double getInscripcion() {
		return this.inscripcion;
	}

	public void setInscripcion(Double insc) {
		this.inscripcion = insc;
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

	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", costo=" + costo + ", dias=" + dias + ", inscripcion=" + inscripcion
				+ ", nomCurso=" + nomCurso + ", nroCuotas=" + nroCuotas + ", profesor=" + profesor + ", inscripcions="
				+ inscripcions + "]";
	}
	
	

}