package Models;
import java.time.LocalDateTime;
import java.util.*;

public class Transportadora implements ITransportadora {
    private String id;
    private String nome;
    private String email;
    private String password;
    private GPS gps;
    private int nif;
    private boolean livre;
    private double raio;
    private double taxaKm;
    private int numeroEnc;
    private List<Integer> classif;
    private List<Encomenda> encomendasFeitas;
    private double kmPercorridos;
    private double velocidadeMedia;
    private LocalDateTime recolha;
    private List<Encomenda> encomendasATransportar;

    /**
     * Construtor por omissão.
     */
    public Transportadora(){
        this.id = "";
        this.nome = "";
        this.email = "";
        this.password = "";
        this.gps = new GPS();
        this.nif = 0;
        this.livre = true;
        this.raio = 0;
        this.taxaKm = 0;
        this.numeroEnc = 0;
        this.classif = new ArrayList<>();
        this.encomendasFeitas = new ArrayList<>();
        this.kmPercorridos = 0;
        this.velocidadeMedia = 0;
        this.recolha = LocalDateTime.now();
        this.encomendasATransportar = new ArrayList<>();
    }

    /**
     * Construtor parametrizado.
     * @param t String que representa o código da empresa.
     * @param n String representante do nome da empresa.
     * @param gps objeto da classe GPs que representa as coordenadas de uma Transportadora.
     * @param nif Double representante do número de identificação fiscal.
     * @param raio Double que representa o raio de uma Transportadora.
     * @param taxaKm Double represetante do preço por km de uma Transportadora.
     */
    public Transportadora(String t, String n, String email, String password, GPS gps, int nif, double raio,
                          boolean livre, double taxaKm, int numeroEnc, List<Integer> classif, List<Encomenda> encomendasFeitas, double km,
                          double vel, LocalDateTime recolha, List<Encomenda> encomendasATransportar){
        this.id = t;
        this.nome = n;
        this.email = email;
        this.password = password;
        this.gps = new GPS(gps);
        this.nif = nif;
        this.livre = livre;
        this.raio = raio;
        this.taxaKm = taxaKm;
        this.numeroEnc = numeroEnc;
        this.classif = new ArrayList<>();
        for(Integer i : classif) this.classif.add(i);
        this.encomendasFeitas = new ArrayList<>();
        for(Encomenda e : encomendasFeitas) this.encomendasFeitas.add(e.clone());
        this.kmPercorridos = km;
        this.velocidadeMedia = vel;
        this.recolha = recolha;
        this.encomendasATransportar = new ArrayList<>();
        for(Encomenda e : encomendasATransportar) this.encomendasATransportar.add(e.clone());
    }

    /**
     * Construtor por cópia.
     * @param t Objeto da classe Transportadora.
     */
    public Transportadora(Transportadora t){
        this.id = t.getId();
        this.nome = t.getNome();
        this.email = t.getEmail();
        this.password = t.getPassword();
        this.gps = new GPS(t.getGps());
        this.nif = t.getNif();
        this.livre = t.getLivre();
        this.raio = t.getRaio();
        this.taxaKm = t.getTaxaKm();
        this.classif = t.getClassif();
        this.numeroEnc = t.getNumeroEnc();
        this.encomendasFeitas = t.getEncomendasFeitas();
        this.kmPercorridos = t.getKmPercorridos();
        this.velocidadeMedia = t.getVelocidadeMedia();
        this.recolha = t.getRecolha();
        this.encomendasATransportar = t.entregaEncomenda();
    }

    /**
     * Função que retorna a velocidade média da transportadora.
     * @return - Velocidade média da transportadora.
     */
    public double getVelocidadeMedia() {
        return this.velocidadeMedia;
    }

    /**
     * Função que retorna a data e hora da recolha da encomenda.
     * @return - A data e hora da recolha da encomenda.
     */
    public LocalDateTime getRecolha(){
        return this.recolha;
    }

    /**
     * Método que retorna o email da transportadora.
     * @return Email da transportadora.
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * Método que retorna o password da transportadora.
     * @return Password da transportadora.
     */
    public String getPassword(){
        return this.email;
    }

    /**
     * Método que dá o código de uma empresa.
     * @return Devolve esse código.
     */
    public String getId(){
        return this.id;
    }

    /**
     * Método que retorna o número de Kms percorridos pela transportadora.
     * @return Número de Kms percorridos.
     */
    public double getKmPercorridos() {
        return kmPercorridos;
    }

    /**
     * Método que dá a lista de encomendas que já distribuidas pela transportadora.
     * @return Lista de en
     */
    public List<Encomenda> getEncomendasFeitas() {
        List<Encomenda> ret = new ArrayList<>();
        for(Encomenda e : this.encomendasFeitas) ret.add(e.clone());
        return ret;
    }

    /**
     * Método que retorna o número de encomendas que a transportadora pode transportar.
     * @return Número de encomendas que pode trasportar.
     */
    public int getNumeroEnc(){
        return this.numeroEnc;
    }

    /**
     * Método que diz se a transportadora está livre ou não para ir buscar uma encomenda.
     * @return Devolve true se estiver livre, false caso contrário.
     */
    public boolean getLivre(){return this.livre;}

    /**
     * Método que define o código de uma empresa.
     * @param id String que representa esse código.
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     * Método que dá o nome de uma empresa.
     * @return Devolve uma String com o nome.
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Método que define o nome de uma empresa.
     * @param n Recebe uma String que corresponde ao nome.
     */
    public void setNome(String n){
        this.nome = n;
    }

    /**
     * Método que dá as coordenadas de uma Transportadora.
     * @return Devolve as coordenadas.
     */
    public GPS getGps(){
        return this.gps;
    }

    /**
     * Método que define as coordenadas de uma Transportadora.
     * @param g Recebe um objeto da classe GPS
     */
    public void setGps(GPS g){
        this.gps = g;
    }

    /**
     * Método que dá o número de identificação fiscal.
     * @return Devolve o nif.
     */
    public int getNif(){
        return this.nif;
    }

    /**
     * Método que define o número de identificação fiscal.
     * @param nif Devolve o nif.
     */
    public void setNif(int nif){
        this.nif = nif;
    }

    /**
     * Método que dá o raio de uma Transportadora.
     * @return Devolve esse raio.
     */
    public double getRaio(){
        return this.raio;
    }

    /**
     * Método que define o raio de uma Transportadora.
     * @param raio Double representante do raio.
     */
    public void setRaio(double raio){
        this.raio = raio;
    }

    /**
     * Método que dá o preço por km de uma Transportadora.
     * @return Devolve esse preço.
     */
    public double getTaxaKm(){
        return this.taxaKm;
    }

    /**
     * Método que define o preço por km de uma Transportadora.
     * @param taxaKm Devolve esse preço.
     */
    public void setTaxaKm(double taxaKm){
        this.taxaKm = taxaKm;
    }

    /**
     * Método que dá a lista de classificações.
     * @return Devolve uma lista de Integers que representa a lista de classificações.
     */
    public List<Integer> getClassif() {
        List<Integer> ret = new ArrayList<>();
        for(Integer i : ret)
            ret.add(i);
        return ret;
    }

    /**
     * Método que define a lista de classificações.
     * @param classif Recebe uma lista de Integers
     */
    public void setClassif(List<Integer> classif) {
        this.classif = classif;
    }

    /**
     * Função que verfica se o objeto recebido é idêntico ao da classse Transportadora.
     * @param o Recebe um objeto.
     * @return Devolve um boolean que corresponde a essa verificação.
     */
    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Transportadora v = (Transportadora) o;
        return v.getId().equals(this.id) &&
                v.getNome().equals(this.nome) &&
                v.getGps().equals(this.gps) &&
                v.getNif()==(this.nif) &&
                v.getRaio()==(this.raio) &&
                v.getTaxaKm()==(this.taxaKm) &&
                v.getClassif().equals(this.classif);
    }

    /**
     * Função que traduz a classe Transportadora.
     * @return Devolve uma String com a respetiva tradução.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Código da Empresa: ").append(this.id)
                .append("\nNome da Empresa: ").append(this.nome)
                .append("\nGPS: ").append(this.gps)
                .append("\nNIF: ").append(this.nif)
                .append("\nRaio: ").append(this.raio)
                .append("\nPreço por Km: ").append(this.taxaKm)
                .append("\nLista de Classificações:  ").append(this.classif);
        return sb.toString();
    }

    /**
     * Função que faz um clone da classe Transportadora.
     * @return Devolve esse clone.
     */
    @Override
    public Transportadora clone(){
        return new Transportadora(this);
    }

    /**
     * Função que adiciona uma classificação à lista de classificações.
     * @param classificacao Recebe um Inteiro representante do valor da classificação a adicionar.
     */
    public void addClassificacao(int classificacao) {
        this.classif.add(classificacao);
    }

    /**
     * Função que calcula a distância percorrida da transportadora à loja e da loja à casa do utilizador.
     * @param loja - Loja onde a encomenda está.
     * @param utilizador - Casa do utilizador que fez a encomenda.
     * @return - Distância percorrida.
     */
    public double distEntrega(GPS loja, GPS utilizador) {
        double dist1 = auxDist(this.gps,loja);
        double dist2 = auxDist(loja,utilizador);
        return dist1 + dist2;
    }

    /**
     * Função auxiliar que calcula a distância entre duas coordenadas GPS.
     * @param gps1 - Primeira coordenada.
     * @param gps2 - Segunda coordenada.
     * @return - Distância entre os dois pontos.
     */
    public double auxDist(GPS gps1, GPS gps2){
        double firstLatToRad = Math.toRadians(gps1.getX());
        double secondLatToRad = Math.toRadians(gps2.getX());
        double deltaLongitudeInRad = Math.toRadians(gps2.getY() - gps1.getY());
        return Math.acos(Math.cos(firstLatToRad) * Math.cos(secondLatToRad) * Math.cos(deltaLongitudeInRad) + Math.sin(firstLatToRad)
                * Math.sin(secondLatToRad)) * 6371.01;
    }

    /**
     * Função que calula o preço do transporte da encomenda.
     * @param loja - Coordenadas GPS da loja.
     * @param utilizador - Coordenadas GPS do utilizador.
     * @return - Preço do transporte.
     */
    public double precoEntrega(GPS loja, GPS utilizador){
        return this.taxaKm * distEntrega(loja,utilizador);
    }

    /**
     * Função que sinaliza que as encomendas foram entregues.
     * @return - Lista da encomendas entregues.
     */
    public List<Encomenda> entregaEncomenda(){
        List<Encomenda> ret = new ArrayList<>();
        for(Encomenda e : this.encomendasATransportar) ret.add(e.clone());
        this.encomendasATransportar = new ArrayList<>();
        return ret;
    }

}
