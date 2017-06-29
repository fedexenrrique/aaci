package interfaces;

import java.util.List;

import javax.ejb.EJB;

import datos.AlumnoDAO;
import entidades.Alumno;

public class InterfaceAlumnoImple implements InterfaceAlumno, InterfaceAlumnoRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AlumnoDAO alumdao;
	
	@Override
	public List<Alumno> buscarTodos() {
		// TODO Auto-generated method stub
		return alumdao.findAll();
	}

	@Override
	public Alumno buscarPorId(Alumno al) {
		// TODO Auto-generated method stub
		return alumdao.findAlumnoByNombre(al);
	}

	@Override
	public Alumno buscarPorNombre(Alumno al) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno buscarPorApellido(Alumno al) {
		// TODO Auto-generated method stub
		return alumdao.findAlumnoByApellido(al);
	}

	@Override
	public void agregarAlumno(Alumno al) {
		// TODO Auto-generated method stub
		alumdao.insertAlumno(al);
	}

	@Override
	public void modificar(Alumno al) {
		// TODO Auto-generated method stub
		alumdao.updateAlumno(al);
	}

	@Override
	public void eliminarAlumno(Alumno al) {
		// TODO Auto-generated method stub
		alumdao.deleteAlumno(al);
	}

}
