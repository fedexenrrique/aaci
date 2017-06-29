package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the cuota database table.
 * 
 */
@Embeddable
public class CuotaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idCurso;

	@Column(insertable=false, updatable=false)
	private int idAlumno;

	private String nroCuota;

	public CuotaPK() {
	}
	public int getIdCurso() {
		return this.idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public int getIdAlumno() {
		return this.idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	public String getNroCuota() {
		return this.nroCuota;
	}
	public void setNroCuota(String nroCuota) {
		this.nroCuota = nroCuota;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CuotaPK)) {
			return false;
		}
		CuotaPK castOther = (CuotaPK)other;
		return 
			(this.idCurso == castOther.idCurso)
			&& (this.idAlumno == castOther.idAlumno)
			&& this.nroCuota.equals(castOther.nroCuota);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCurso;
		hash = hash * prime + this.idAlumno;
		hash = hash * prime + this.nroCuota.hashCode();
		
		return hash;
	}
}