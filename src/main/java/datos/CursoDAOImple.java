package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Curso;

@Stateless
public class CursoDAOImple implements CursoDAO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="mysqlPU")
	private EntityManager em;

	@Override
	public List<Curso> findAll() {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("Curso.findAll");
		@SuppressWarnings("unchecked")
		List<Curso> resultList = q.getResultList();
		return resultList;
	}

	@Override
	public Curso findCursoById(Curso cur) {
		// TODO Auto-generated method stub
		return em.find(Curso.class, cur.getIdCurso());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Curso findCursoByNombre(Curso cur) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select c from Curso c where c.NomCurso = :curnom");
		q.setParameter("curnom", cur.getNomCurso());
		List<Curso> rl = q.getResultList();
		return rl.get(0);
	}

	@Override
	public void insertCurso(Curso cur) {
		// TODO Auto-generated method stub
		em.persist(cur);
		em.flush();
	}

	@Override
	public void updateCurso(Curso cur) {
		// TODO Auto-generated method stub
		em.merge(cur);
	}

	@Override
	public void deleteCurso(Curso cur) {
		// TODO Auto-generated method stub
		cur = em.find(Curso.class, cur.getIdCurso());
		em.remove(cur);
	}

}
