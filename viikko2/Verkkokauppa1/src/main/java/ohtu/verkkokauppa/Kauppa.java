package ohtu.verkkokauppa;

public class Kauppa {

    private Varasto_interface varasto;
    private Pankki_interface pankki;
    private Ostoskori ostoskori;
    private Viitegeneraattori_interface viitegeneraattori;
    private String kaupanTili;

    public Kauppa(Varasto_interface varasto, Pankki_interface pankki, Viitegeneraattori_interface viitegeneraattori) {
        this.varasto = varasto;
        this.pankki = pankki;
        this.viitegeneraattori = viitegeneraattori;
        this.kaupanTili = "33333-44455";
    }

    /*public Kauppa() {
        varasto = Varasto.getInstance();
        pankki = Pankki.getInstance();
        viitegeneraattori = Viitegeneraattori.getInstance();
        kaupanTili = "33333-44455";
    }*/

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
