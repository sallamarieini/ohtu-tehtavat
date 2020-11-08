package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface Kirjanpito_interface {

    void lisaaTapahtuma(String tapahtuma);
    ArrayList<String> getTapahtumat();

}
