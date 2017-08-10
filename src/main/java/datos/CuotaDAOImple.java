package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Cuota;
import entidades.CuotaPK;
import entidades.Inscripcion;

@Stateless
public class CuotaDAOImple implements CuotaDAO {
	
	@PersistenceContext(name="mysqlPU")
	private EntityManager em;

	@Override
	public List<Cuota> deInscripcion(Inscripcion ins) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuota byId(CuotaPK pk) {
		// TODO Auto-generated method stub
		return em.find(Cuota.class, pk);
	}

	@Override
	public void insertCuota(Cuota c) {
		// TODO Auto-generated method stub
		em.persist(c);
		em.flush();
	}

	@Override
	public void updateCuota(Cuota c) {
		// TODO Auto-generated method stub
		em.merge(c);
		em.flush();

	}

	@Override
	public void deleteCuota(Cuota c) {
		// TODO Auto-generated method stub
		em.remove(c);
	}

}
