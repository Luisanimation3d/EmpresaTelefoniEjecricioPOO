package reto1;

public class SIMCard {
    private String empresaTelefonia = "Hi";
    double saldo = 0;
    private String numeroTelefono;
    private boolean celularApagado = true;
    private boolean modoAvionActivado = false;
    private boolean datosActivados = false;
    private int saldoDatos = 0;

    public SIMCard(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmpresaTelefonia() {
        return empresaTelefonia;
    }

    public void setEmpresaTelefonia(String empresaTelefonia) {
        this.empresaTelefonia = empresaTelefonia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public boolean isCelularApagado() {
        return celularApagado;
    }

    public void setCelularApagado(boolean celularApagado) {
        this.celularApagado = celularApagado;
    }

    public boolean isModoAvionActivado() {
        return modoAvionActivado;
    }

    public void setModoAvionActivado(boolean modoAvionActivado) {
        this.modoAvionActivado = modoAvionActivado;
    }

    public boolean isDatosActivados() {
        return datosActivados;
    }

    public void setDatosActivados(boolean datosActivados) {
        this.datosActivados = datosActivados;
    }

    public int getSaldoDatos() {
        return saldoDatos;
    }

    public void setSaldoDatos(int saldoDatos) {
        this.saldoDatos = saldoDatos;
    }

    void comprarDatos(int c){
        int excedente = 0;
        int acumPrice = 0;
        this.saldoDatos += c;
        if (c <= 10){
            acumPrice += c * 3000;
        } else if (c > 10 && c <= 30) {
            excedente = c - 10;
            acumPrice += (excedente * 2500) + (10 * 3000);
        } else if (c > 30) {
            excedente = c - 20;
            acumPrice += (excedente * 1500) + (20 * 3000);
        }
        this.saldo -= this.saldo < acumPrice ? 0 : acumPrice;
    }

    void consumirDatos(int c){
        if(!!celularApagado || !!modoAvionActivado || !datosActivados){
            this.saldoDatos = this.saldoDatos;
        }else{
            this.saldoDatos -= this.saldoDatos < c ? 0 : c;
        }
    }

    void llamar(int s){

        double acumTotal = 0;
        int excedente = 0;
        if(!!this.celularApagado || !!this.modoAvionActivado){
            this.saldoDatos = this.saldoDatos;
        }else{
            if(s <= 60){
                acumTotal = s;
            }else if (s > 60){
                excedente = s - 60;
                acumTotal = ((excedente * 0.5) + 60);
            }
        }

        this.saldo -= this.saldo < acumTotal ? 0 : acumTotal;

    }

    void recargarSaldo(double s){
        this.saldo += s;
    }

    void gestionarEncendidoCelular(){
        this.celularApagado = !this.celularApagado;
        this.modoAvionActivado = false;
        this.datosActivados = false;
    }

    void gestionarModoAvion(){
        if(!!this.celularApagado){
            this.modoAvionActivado = false;
        }else{
            this.modoAvionActivado = !this.modoAvionActivado;
            this.datosActivados = false;
        }
    }

    void gestionarDatos(){
        if(!!this.celularApagado || !!this.modoAvionActivado){
            this.datosActivados = false;
        }else{
            this.datosActivados = !this.datosActivados;
        }
    }

    @Override
    public String toString() {
        return "SIMCard{" +
                "empresaTelefonia='" + empresaTelefonia + '\'' +
                ", saldo=" + saldo +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", celularApagado=" + celularApagado +
                ", modoAvionActivado=" + modoAvionActivado +
                ", datosActivados=" + datosActivados +
                ", saldoDatos=" + saldoDatos +
                '}';
    }
}
