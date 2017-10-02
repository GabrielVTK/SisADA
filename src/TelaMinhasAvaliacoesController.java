
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * @author Gabriel Vinicius
 **/

public class TelaMinhasAvaliacoesController extends InterfaceUsuario {

    @FXML
    private TableView<Avaliacao> tabelaAvaliacoes;
    
    @FXML
    private TableColumn<Avaliacao, String> colunaNome;
    
    @FXML
    private TableColumn<Avaliacao, String> colunaDisciplina;
    
    @FXML
    private TableColumn<Avaliacao, String> colunaMedia;
    
    @FXML
    private TableColumn<Avaliacao, Double> colunaPeso;
    
    @FXML
    private TableColumn<Avaliacao, Double> colunaNota;
    
    public static ObservableList<Avaliacao> avaliacoes;
    
    public TelaMinhasAvaliacoesController() {
        super("TelaMinhasAvaliacoes.fxml");
        avaliacoes = FXCollections.observableArrayList(Avaliacao.obterListaAvaliacoes());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaDisciplina.setCellValueFactory(new PropertyValueFactory<>("disciplina"));
        colunaMedia.setCellValueFactory(new PropertyValueFactory<>("media"));
        colunaPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colunaNota.setCellValueFactory(new PropertyValueFactory<>("nota"));
        
        tabelaAvaliacoes.setItems(avaliacoes);
    }
    
    @Override
    public void retornar() {
        avaliacoes = FXCollections.observableArrayList(Avaliacao.obterListaAvaliacoes());
        tabelaAvaliacoes.setItems(avaliacoes);
    }
    
    @FXML
    public void novaAvaliacao() {
        TelaNovaAvaliacaoController tela = new TelaNovaAvaliacaoController();
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
    
    @FXML
    public void informarNota() {
        
        if(tabelaAvaliacoes.getSelectionModel().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma avaliação!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        TelaInformarNotaController tela = new TelaInformarNotaController(tabelaAvaliacoes.getSelectionModel().getSelectedItem());
        GerenciadorJanela.obterInstancia().abreJanela(tela);
    }
    
    @FXML
    public void voltar(ActionEvent evento ){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}
