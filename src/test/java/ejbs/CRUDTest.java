package ejbs;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import datos.AlumnoDAO;
import datos.AlumnoDAOImple;
import entidades.Alumno;
import interfaces.InterfaceAlumno;
import interfaces.InterfaceAlumnoImple;
import interfaces.InterfaceAlumnoRemote;

@RunWith(Arquillian.class)
public class CRUDTest {
	
	@EJB
	private InterfaceAlumno alum; 
	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClass(AlumnoDAOImple.class)
				.addClass(AlumnoDAO.class)
				.addClass(Alumno.class)
				.addClass(InterfaceAlumno.class)
				.addClass(InterfaceAlumnoImple.class)
				.addClass(InterfaceAlumnoRemote.class)
                .addAsManifestResource("META-INF/persistence-test.xml", "persistence.xml");
                //.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");;		
	}
	
	@Test
	public void alumnServiceTest() {
		assertNotNull(alum);
	}
	
	@Test
	public void should_crud() {
		Alumno al = new Alumno();
		al.setApeAlum("Enrrique");
		al.setNomAlum("Federico");
		//alumdao.eliminarLibro(al);
		System.out.println(al);
		
	}

}
