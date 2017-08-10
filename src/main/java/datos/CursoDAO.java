package datos;

import java.io.Serializable;
import java.util.List;

import entidades.Curso;

public interface CursoDAO extends Serializable {
	
	public List<Curso> findAll();
	public Curso findCursoById(Curso cur);
	public Curso findCursoByNombre(Curso cur);
	public void insertCurso(Curso cur);
	public void updateCurso(Curso cur);
	public void deleteCurso(Curso cur);

}
