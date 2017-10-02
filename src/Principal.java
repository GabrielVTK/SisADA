
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Gabriel Vinicius
 **/

public class Principal extends Application {
    
    public static void main(String[] args) {
        launch(args);
    } 
    
    @Override
    public void start(Stage primaryStage) {
        TelaInicialController telaInicial = new TelaInicialController();
        primaryStage.setMinWidth(610);
        primaryStage.setMaxWidth(610);
        primaryStage.setMinHeight(530);
        primaryStage.setMaxHeight(530);
        primaryStage.setTitle("SisADA");
        GerenciadorJanela.obterInstancia().inicializaPalco(primaryStage, telaInicial);
    }
    
}