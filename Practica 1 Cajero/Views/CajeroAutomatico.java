
package views;

import Controllers.CajeroController;
import models.CajeroModel;

public class CajeroAutomatico {
    public static void main(String[] args){

        CajeroModel model = new CajeroModel();
        CajeroView view = new CajeroView();
        CajeroController controller = new CajeroController(model,view);
        controller.iniciarSistema();
        
        /**
        - Esto asegura que si cierre el scanner al final
        - @author Karina Ramirez
         */
        view.cerrarScanner();
    }

}
