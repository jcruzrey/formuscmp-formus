import com.mio.formas.web.comando.GuardarForma;
import com.mio.formas.forma.AbstractForma;
import com.mio.formas.respuesta.RespuestaForma;
import com.mio.formas.peticion.PeticionForma;
import com.mio.formas.web.servicio.RepositorioServicio;
import com.mio.formas.web.datos.comando.IEjecucion;

class EjecutaGuardarForma {
    RespuestaForma ejecutar(empresa, nombreModulo, version, nombreForma, peticion, repoServicio, ejecutaDatos) {
        GuardarForma.ejecutar(empresa, nombreModulo, version, nombreForma, peticion, repoServicio, ejecutaDatos);
    }
}