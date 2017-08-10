package interfaces;

import java.util.List;

import javax.ejb.Local;

import entidades.Cuota;
import entidades.CuotaPK;
import entidades.Inscripcion;

@Local
public interface InterfaceCuota {
	
	public List<Cuota> deInscripcion(Inscripcion ins);
	public Cuota porId(CuotaPK pk);
	public void agregarCuota(Cuota c);
	public void modificarCuota(Cuota c);
	public void eliminarCuota(Cuota c);

}
