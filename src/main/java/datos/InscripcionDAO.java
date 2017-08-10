package datos;

import java.io.Serializable;

import entidades.Inscripcion;

public interface InscripcionDAO extends Serializable {
	
	public void insertInscripcion(Inscripcion in);
	public void updateInscripcion(Inscripcion in);
	public void deleteInscripcion(Inscripcion in);

}
