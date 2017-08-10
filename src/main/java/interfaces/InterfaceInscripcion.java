package interfaces;

import java.io.Serializable;

import javax.ejb.Local;

import entidades.Inscripcion;

@Local
public interface InterfaceInscripcion extends Serializable {
	
	public void agregarInscripcion(Inscripcion in);
	public void modificarInscripcion(Inscripcion in);
	public void eliminarInscripcion(Inscripcion in);

}
