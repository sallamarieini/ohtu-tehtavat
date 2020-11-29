package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento{

    private int arvo;

    public Nollaa(TextField tuloskentta, TextField syotekentta,  Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        this.arvo = Integer.parseInt(tuloskentta.getText());

        this.sovellus.nollaa();

        int laskunTulos = this.sovellus.tulos();

        syotekentta.setText("");
        this.tuloskentta.setText(""+laskunTulos);

        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);

    }

    @Override
    public void peru() {
        this.tuloskentta.setText(""+this.arvo);
        this.syotekentta.setText("");
    }

}
