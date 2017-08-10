package interfaces;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import entidades.Alumno;
import entidades.Curso;

@Remote
public interface InterfaceAlumnoRemote extends Serializable {

	public List<Alumno> buscarTodos();
	public List<Alumno> noInscriptos();
	public Alumno buscarPorId(Alumno al);
	public List<Alumno> delCurso(Curso cur);
	public Alumno buscarPorNombre(Alumno al);
	public Alumno buscarPorApellido(Alumno al);
	public void agregarAlumno(Alumno al);
	public void modificar(Alumno al);
	public void eliminarAlumno(Alumno al);
	
}
