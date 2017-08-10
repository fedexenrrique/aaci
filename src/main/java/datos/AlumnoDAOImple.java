package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Alumno;
import entidades.Curso;

@Stateless	
public class AlumnoDAOImple implements AlumnoDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(name="mysqlPU")
	private EntityManager em;
	
	@Override
	public List<Alumno> findAll() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Alumno> resultList = (List<Alumno>) em.createNamedQuery("Alumno.findAll").getResultList();
		return resultList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Alumno> noInscriptos() {
		String sq = "Select a from Alumno a where a.idAlumno not in"
				+ " (select i.id.idAlumno from Inscripcion i)";
		Query q = em.createQuery(sq);
		return q.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Alumno> delCurso(Curso cur){
		System.out.print(cur.getIdCurso());		
		String sq = "from Alumno a where a.idAlumno in"
				+ " (select i.id.idAlumno from Inscripcion i where i.id.idCurso = :curid )";
		Query q = em.createQuery(sq);
		q.setParameter("curid", cur.getIdCurso());
		return q.getResultList();
	}

	@Override
	public Alumno findAlumnoById(Alumno al) {
		// TODO Auto-generated method stub
		return em.find(Alumno.class, al.getIdAlumno());
	}

	@Override
	public Alumno findAlumnoByNombre(Alumno al) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("Select alu from Alumno alu where NomAlum= :nomb");
		query.setParameter("nomb", al.getNomAlum());
		//book = (Book) query.getFirstResult();
		//System.out.println(book);
		@SuppressWarnings("unchecked")
		List<Alumno> resultList = query.getResultList();
		if (!resultList.isEmpty()) {
			return (Alumno) resultList.get(0);
		}
		return null;
	}

	@Override
	public Alumno findAlumnoByApellido(Alumno al) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("Select alu from Alumno alu where ApeAlum= :ape");
		query.setParameter("ape", al.getApeAlum());
		//book = (Book) query.getFirstResult();
		//System.out.println(book);
		@SuppressWarnings("unchecked")
		List<Alumno> resultList = query.getResultList();
		if (!resultList.isEmpty()) {
			return (Alumno) resultList.get(0);
		}
		return null;
	}

	@Override
	public void insertAlumno(Alumno al) {
		// TODO Auto-generated method stub
		em.persist(al);
		em.flush();
		em.joinTransaction();
	}

	@Override
	public void updateAlumno(Alumno al) {
		// TODO Auto-generated method stub
		em.merge(al);
	}

	@Override
	public void deleteAlumno(Alumno al) {
		// TODO Auto-generated method stub
		al = em.find(Alumno.class, al.getIdAlumno());
		em.remove(al);
	}

}
