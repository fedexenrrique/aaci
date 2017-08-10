package cliente;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entidades.Alumno;
import interfaces.InterfaceAlumno;
import interfaces.InterfaceAlumnoImple;
import interfaces.InterfaceAlumnoRemote;

public class Cliente {

	public static void main(String[] args) throws NamingException {
		llamarStatelessAlumno();
	}

	private static void llamarStatelessAlumno() throws NamingException {
		// TODO Auto-generated method stub
		final InterfaceAlumnoRemote intAlu = llamarIntAlu();
		
		Alumno al = new Alumno();
		al.setNomAlum("Fede");
		al.setApeAlum("Enrrique");
		al.setDni(38188305);
		intAlu.agregarAlumno(al);
	}

	@SuppressWarnings("unchecked")
	private static InterfaceAlumnoRemote llamarIntAlu() throws NamingException {
		// TODO Auto-generated method stub
		@SuppressWarnings("rawtypes")
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

        jndiProperties.put("jboss.naming.client.ejb.context", false);
        jndiProperties.put("org.jboss.ejb.client.scoped.context", true);

        jndiProperties.put("endpoint.name", "client-endpoint");
        jndiProperties.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", false);
        jndiProperties.put("remote.connections", "default");
        jndiProperties.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", false);

        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");    

        //jndiProperties.put( Context.SECURITY_PRINCIPAL, "admin" );
        //jndiProperties.put( Context.SECURITY_CREDENTIALS, "admin" );
        //if (context == null) {
           Context context = new InitialContext(jndiProperties);
        //}
		// The app name is the application name of the deployed EJBs. This is
		// typically the ear name
		// without the .ear suffix. However, the application name could be
		// overridden in the application.xml of the
		// EJB deployment on the server.
		// Since we haven't deployed the application as a .ear, the app name for
		// us will be an empty string
		final String appName = "prueba";
		// This is the module name of the deployed EJBs on the server. This is
		// typically the jar name of the
		// EJB deployment, without the .jar suffix, but can be overridden via
		// the ejb-jar.xml
		// In this example, we have deployed the EJBs in a
		// jboss-as-ejb-remote-app.jar, so the module name is
		// jboss-as-ejb-remote-app
		final String moduleName = "ejbs";
		// AS7 allows each deployment to have an (optional) distinct name. We
		// haven't specified a distinct name for
		// our EJB deployment, so this is an empty string
		final String distinctName = "";
		// The EJB name which by default is the simple class name of the bean
		// implementation class
		final String beanName = InterfaceAlumnoImple.class.getSimpleName();
		// the remote view fully qualified class name
		final String viewClassName = InterfaceAlumnoRemote.class.getName();
		// let's do the lookup
		System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
		return (InterfaceAlumnoRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
	}

}
