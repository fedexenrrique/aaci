package interfaces;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import datos.CuotaDAO;
import entidades.Cuota;
import entidades.CuotaPK;
import entidades.Inscripcion;

@Stateless
public class InterfaceCuotaImple implements InterfaceCuota {
	
	@EJB
	private CuotaDAO cdao;

	@Override
	public List<Cuota> deInscripcion(Inscripcion ins) {
		// TODO Auto-generated method stub
		return cdao.deInscripcion(ins);
	}

	@Override
	public Cuota porId(CuotaPK pk) {
		// TODO Auto-generated method stub
		return cdao.byId(pk);
	}

	@Override
	public void agregarCuota(Cuota c) {
		// TODO Auto-generated method stub
		cdao.insertCuota(c);		
	}

	@Override
	public void modificarCuota(Cuota c) {
		// TODO Auto-generated method stub
		cdao.updateCuota(c);
	}

	@Override
	public void eliminarCuota(Cuota c) {
		// TODO Auto-generated method stub
		cdao.deleteCuota(c);
	}

}
