public class Moneda {
    private String siglas;
    private String nombreCompleto;
    private String Continente;

    public Moneda(String siglas, String nombreCompleto, String continente) {
        this.siglas = siglas;
        this.nombreCompleto = nombreCompleto;
        Continente = continente;
    }

    public String getSiglas() {
        return siglas;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getContinente() {
        return Continente;
    }

    @Override
    public String toString() {
        return nombreCompleto + " ("+siglas+")";
    }
}
