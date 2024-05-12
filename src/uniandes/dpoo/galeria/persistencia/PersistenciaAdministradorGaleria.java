package uniandes.dpoo.galeria.persistencia;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.empleado.AdministradorGaleria;

import org.json.JSONArray;

public class PersistenciaAdministradorGaleria {

    private static final String ARCHIVO_JSON = "administrador_galeria.json";

   
    public static void guardarAdministrador() throws IOException {
        JSONObject jsonObject = new JSONObject();
        AdministradorGaleria administrador = AdministradorGaleria.obternerAdmin();

       
        jsonObject.put("nombre", administrador.getNombre());
        jsonObject.put("identificacion", administrador.getIdentificacion());
        jsonObject.put("edad", administrador.getEdad());
        
        JSONArray jsonArray = new JSONArray();
        for (Pieza pieza : administrador.getInventario()) {
            JSONObject jsonPieza = new JSONObject();
            jsonPieza.put("tituloObra", pieza.getTituloObra());
            jsonPieza.put("precio", pieza.getPrecio());
            jsonPieza.put("vendida", pieza.isVendida());
         
            
 
            jsonArray.put(jsonPieza);
        }
        jsonObject.put("inventario", jsonArray);

   
        try (FileWriter writer = new FileWriter(ARCHIVO_JSON)) {
            writer.write(jsonObject.toString());
        }
    }

    
    
}
