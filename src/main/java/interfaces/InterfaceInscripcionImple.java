package interfaces;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import datos.InscripcionDAO;
import entidades.Inscripcion;

@Stateless
public class InterfaceInscripcionImple implements InterfaceInscripcion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private InscripcionDAO insdao;
	
	@Override
	public void agregarInscripcion(Inscripcion in) {
		// TODO Auto-generated method stub
		insdao.insertInscripcion(in);
	}

	@Override
	public void modificarInscripcion(Inscripcion in) {
		// TODO Auto-generated method stub
		insdao.updateInscripcion(in);
	}

	@Override
	public void eliminarInscripcion(Inscripcion in) {
		// TODO Auto-generated method stub
		insdao.deleteInscripcion(in);
	}

}
