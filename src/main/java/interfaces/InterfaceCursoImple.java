package interfaces;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import datos.CursoDAO;
import entidades.Curso;

@Stateless
public class InterfaceCursoImple implements InterfaceCurso, InterfaceCursoRemote {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private CursoDAO curdao;

	@Override
	public List<Curso> buscarTodos() {
		// TODO Auto-generated method stub
		return curdao.findAll();
	}

	@Override
	public Curso encontrarCursoPorId(Curso cur) {
		// TODO Auto-generated method stub
		return curdao.findCursoById(cur);
	}

	@Override
	public Curso encontrarCursoPorNombre(Curso cur) {
		// TODO Auto-generated method stub
		return curdao.findCursoByNombre(cur);
	}

	@Override
	public void agregarCurso(Curso cur) {
		// TODO Auto-generated method stub
		curdao.insertCurso(cur);
	}

	@Override
	public void actualizarCurso(Curso cur) {
		// TODO Auto-generated method stub
		curdao.updateCurso(cur);
	}

	@Override
	public void eliminarCurso(Curso cur) {
		// TODO Auto-generated method stub
		curdao.deleteCurso(cur);
	}

}
