public class OpcionMonedas {
    private Moneda monedaOrigen;
    private Moneda monedaObjetivo ;

    public OpcionMonedas() {}

    public Moneda getMonedaOrigen() {
        return monedaOrigen;
    }

    public Moneda getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public OpcionMonedas(Moneda monedaOrigen, Moneda monedaObjetivo) {
        this.monedaOrigen = monedaOrigen;
        this.monedaObjetivo = monedaObjetivo;
    }
}
