
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * @author Gabriel Vinicius
 **/

public class TelaInicialController extends InterfaceUsuario {

    public TelaInicialController() {
        super("TelaInicial.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
    
    @FXML
    public void irMinhasAvaliacoes(ActionEvent evento) {
        TelaMinhasAvaliacoesController tela = new TelaMinhasAvaliacoesController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
    
    @FXML
    public void irMeuDesempenho(ActionEvent evento) {
        TelaDesempenhoController tela = new TelaDesempenhoController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
    
}
