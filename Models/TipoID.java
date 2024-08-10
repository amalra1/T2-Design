import java.util.UUID;

public class TipoID {
    private String id;

    // Construtor privado para garantir a geração de ID único
    private TipoID(String id) {
        this.id = id;
    }

    // Método para criar um novo TipoID com um valor único
    public static TipoID gerarNovoID() {
        return new TipoID(UUID.randomUUID().toString());
    }

    // Método para obter o valor do ID
    public String getID() {
        return id;
    }

    // Método para comparar IDs
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TipoID tipoID = (TipoID) obj;
        return id.equals(tipoID.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    // Método para representar o ID como uma string
    @Override
    public String toString() {
        return id;
    }
}
