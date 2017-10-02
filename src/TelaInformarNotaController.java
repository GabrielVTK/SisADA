
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * @author Gabriel Vinicius
 **/

public class TelaInformarNotaController extends InterfaceUsuario {

    private Avaliacao avaliacao;
    
    @FXML
    private Label detalhes;
    
    @FXML
    private TextField nota;
            
    public TelaInformarNotaController(Avaliacao av) {
        super("TelaInformarNota.fxml");
        
        this.avaliacao = av;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        String informacoes = "Nome: " + this.avaliacao.getNome() + "\n";
        informacoes += "Disciplina: " + this.avaliacao.getDisciplina() + "\n";
        informacoes += "Média: " + this.avaliacao.getMedia() + "\n";
        informacoes += "Peso: " + this.avaliacao.getPeso() + "\n";
        
        this.detalhes.setText(informacoes);
        
        if(this.avaliacao.getNota() != null) {
            this.nota.setText(String.valueOf(this.avaliacao.getNota()));
        }
    }
    
    @FXML
    public void salvar() {
        
        String notaConvertida = this.nota.getText().replace(",", ".");
        
        if(notaConvertida.equals("") || Double.parseDouble(notaConvertida) < 0 || Double.parseDouble(notaConvertida) > 10) {
            JOptionPane.showMessageDialog(null, "Digite uma nota válida!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        this.avaliacao.setNota(Double.parseDouble(notaConvertida));
        
        this.avaliacao.atualizar();
        
        this.voltar();
    }
    
    @FXML
    public void voltar() {
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}
