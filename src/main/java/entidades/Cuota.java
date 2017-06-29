package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the cuota database table.
 * 
 */
@Entity
@NamedQuery(name="Cuota.findAll", query="SELECT c FROM Cuota c")
public class Cuota implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CuotaPK id;

	private byte[] estado;

	private BigDecimal monto;

	//bi-directional many-to-one association to Inscripcion
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="IdAlumno", referencedColumnName="IdAlumno"),
		@JoinColumn(name="IdCurso", referencedColumnName="IdCurso")
		})
	private Inscripcion inscripcion;

	public Cuota() {
	}

	public CuotaPK getId() {
		return this.id;
	}

	public void setId(CuotaPK id) {
		this.id = id;
	}

	public byte[] getEstado() {
		return this.estado;
	}

	public void setEstado(byte[] estado) {
		this.estado = estado;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Inscripcion getInscripcion() {
		return this.inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}

}