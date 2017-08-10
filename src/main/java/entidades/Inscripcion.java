package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inscripcion database table.
 * 
 */
@Entity
@NamedQuery(name="Inscripcion.findAll", query="SELECT i FROM Inscripcion i")
public class Inscripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InscripcionPK id;

	private byte[] abonado;

	private double montoCuota;

	//bi-directional many-to-one association to Cuota
	@OneToMany(mappedBy="inscripcion")
	private List<Cuota> cuotas;

	//uni-directional many-to-one association to Alumno
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="IdAlumno", insertable = false, updatable = false)
	private Alumno alumno;

	//bi-directional many-to-one association to Curso
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="IdCurso", insertable = false, updatable = false)
	private Curso curso;

	public Inscripcion() {
	}

	public InscripcionPK getId() {
		return this.id;
	}

	public void setId(InscripcionPK id) {
		this.id = id;
	}

	public byte[] getAbonado() {
		return this.abonado;
	}

	public void setAbonado(byte[] abonado) {
		this.abonado = abonado;
	}

	public double getMontoCuota() {
		return this.montoCuota;
	}

	public void setMontoCuota(double montoCuota) {
		this.montoCuota = montoCuota;
	}

	public List<Cuota> getCuotas() {
		return this.cuotas;
	}

	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	public Cuota addCuota(Cuota cuota) {
		getCuotas().add(cuota);
		cuota.setInscripcion(this);

		return cuota;
	}

	public Cuota removeCuota(Cuota cuota) {
		getCuotas().remove(cuota);
		cuota.setInscripcion(null);

		return cuota;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}