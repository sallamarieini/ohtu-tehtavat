package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento{

    private int arvo;

    public Summa(TextField tuloskentta, TextField syotekentta,  Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        this.arvo = Integer.parseInt(tuloskentta.getText());
        int syote = Integer.parseInt(syotekentta.getText());

        this.sovellus.plus(syote);
        int laskunTulos = this.sovellus.tulos();

        this.tuloskentta.setText("" + laskunTulos);
        this.syotekentta.setText("");

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
