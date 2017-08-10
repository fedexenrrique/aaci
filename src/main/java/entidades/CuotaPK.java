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

	private int nroCuota;

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
	public int getNroCuota() {
		return this.nroCuota;
	}
	public void setNroCuota(int nroCuota) {
		this.nroCuota = nroCuota;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAlumno;
		result = prime * result + idCurso;
		result = prime * result + nroCuota;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuotaPK other = (CuotaPK) obj;
		if (idAlumno != other.idAlumno)
			return false;
		if (idCurso != other.idCurso)
			return false;
		if (nroCuota != other.nroCuota)
			return false;
		return true;
	}

}