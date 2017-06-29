package interfaces;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import entidades.Alumno;

@Local
public interface InterfaceAlumno extends Serializable {
	
	public List<Alumno> buscarTodos();
	public Alumno buscarPorId(Alumno al);
	public Alumno buscarPorNombre(Alumno al);
	public Alumno buscarPorApellido(Alumno al);
	public void agregarAlumno(Alumno al);
	public void modificar(Alumno al);
	public void eliminarAlumno(Alumno al);

}
