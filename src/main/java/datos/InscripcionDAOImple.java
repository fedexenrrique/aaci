package datos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Inscripcion;

@Stateless
public class InscripcionDAOImple implements InscripcionDAO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="mysqlPU")
	private EntityManager em;

	@Override
	public void insertInscripcion(Inscripcion in) {
		// TODO Auto-generated method stub
		em.persist(in);
		em.flush();
	}

	@Override
	public void updateInscripcion(Inscripcion in) {
		// TODO Auto-generated method stub
		em.merge(in);
		em.flush();
		em.joinTransaction();
	}

	@Override
	public void deleteInscripcion(Inscripcion in) {
		// TODO Auto-generated method stub
		Inscripcion ins = em.find(Inscripcion.class, in.getId());
		em.remove(ins);
	}

}
