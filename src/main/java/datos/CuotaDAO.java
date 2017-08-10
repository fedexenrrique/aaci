package datos;

import java.util.List;

import entidades.Cuota;
import entidades.CuotaPK;
import entidades.Inscripcion;

public interface CuotaDAO {
	
	public List<Cuota> deInscripcion(Inscripcion ins);
	public Cuota byId(CuotaPK pk);
	public void insertCuota(Cuota c);
	public void updateCuota(Cuota c);
	public void deleteCuota(Cuota c);

}
