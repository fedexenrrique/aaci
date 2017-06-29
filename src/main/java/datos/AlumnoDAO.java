package datos;

import java.io.Serializable;
import java.util.List;

import entidades.Alumno;

public interface AlumnoDAO extends Serializable {
	
	public List<Alumno> findAll();
	public Alumno findAlumnoById(Alumno al);
	public Alumno findAlumnoByNombre(Alumno al);
	public Alumno findAlumnoByApellido(Alumno al);
	public void insertAlumno(Alumno al);
	public void updateAlumno(Alumno al);
	public void deleteAlumno(Alumno al);

}
