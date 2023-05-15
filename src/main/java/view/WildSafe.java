package view;

import java.io.IOException;
import java.net.URISyntaxException;


public class WildSafe {
    /*
     * Apenas instacia um objeto formulário e inicializa
     */

    public static void main(String[] args) throws URISyntaxException, IOException {
        FormView formView = new FormView();
        formView.inicialize();
    }
}
