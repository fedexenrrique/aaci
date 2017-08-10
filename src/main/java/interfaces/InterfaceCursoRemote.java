package interfaces;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import entidades.Curso;

@Remote
public interface InterfaceCursoRemote extends Serializable {
	
	public List<Curso> buscarTodos();
	public Curso encontrarCursoPorId(Curso cur);
	public Curso encontrarCursoPorNombre(Curso cur);
	public void agregarCurso(Curso cur);
	public void actualizarCurso(Curso cur);
	public void eliminarCurso(Curso cur);

}
