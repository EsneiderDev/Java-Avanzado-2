import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ListaDeLaCompra {

    private ArrayList<String> lista;
    /**   2 tipos de errores:
     * No comprobados: Engloban los errores de la máquina virtual de Java que se escapan de nuestro control
     *                 y las excepciones que extienden de la clase RuntimeException que suelen corresponder a bugs en
     *                 nuestro código y en vez de manejar es mejor corregir.
     * Comprobados: el resto de  excepciones son comprobadas es decir que se comprueba en tiempo de compilación y hacemos
     *              algo para manejarlas y si no lo hacemos, no compila a esto se le llama requerimiento de manejar o
     *              especificar.
     * */
    public ListaDeLaCompra(String filename) {
        cargarLista(filename);
    }

    // Una forma de manejar el error
    private void cargarLista(String filename) {
        try {
            lista = new ArrayList<>(Files.readAllLines(Paths.get(filename))); // Arroja una excepción de tipo lectura - escritura.
        }catch( IOException e){
            e.printStackTrace();
        }
    }

    /* Otra forma de manejar el error, el throw se propaga al método que llame a cargar lista en este caso el método
       ListaDeLaCompra */
    /* private void cargarLista(String filename) throws IOException {
            lista = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
    }*/

    /* Aquí hay otro posible excepción pero en este caso es de tipo no comprobada y por lo tanto en compilador no nos está
        mostrando el problema: En el método obtener elemento estamos accediendo a una posición del array sin comprobar que
        se escapa de sus límites */

    public String obtenerElemento(int indice) {
        if( indice <= lista.size() )
        {
            return lista.get(indice);
        }else{
            return "Elemento no encontrado";
        }

    }
}
