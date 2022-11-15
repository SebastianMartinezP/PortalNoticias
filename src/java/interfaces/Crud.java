package interfaces;

import java.util.List;

public interface Crud<Generico> {
    public boolean agregar (Generico generico);
    public void eliminar (int id);
    public List<Generico> listar();
    public Generico buscar (int id);
}
