
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * @author Gabriel Vinicius
 **/

public class TelaNovaAvaliacaoController extends InterfaceUsuario {

    @FXML
    private TextField nome; 
    
    @FXML
    private TextField peso; 
    
    @FXML
    private ComboBox disciplina; 
    
    @FXML
    private ComboBox media; 
    
    public TelaNovaAvaliacaoController() {
        super("TelaNovaAvaliacao.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        disciplina.getItems().addAll(
            "ADMINISTRAÇÃO DE NEGÓCIOS DE BASE TECNOLÓGICA",
            "ÁLGEBRA I",
            "ÁLGEBRA II",
            "ALGORITMOS E PROGRAMAÇÃO I",
            "ALGORITMOS E PROGRAMAÇÃO II",
            "ANÁLISE DE CIRCUITOS ELÉTRICOS",
            "ANÁLISE E CONTROLE DE PROCESSOS", 
            "ARQUITETURA DE COMPUTADORES I",
            "ARQUITETURA DE COMPUTADORES  II",
            "BANCO DE DADOS", 
            "CIRCUITOS DIGITAIS", 
            "COMUNICAÇÃO DIGITAL", 
            "CONTROLE LÓGICO DE SISTEMAS", 
            "CÁLCULO I",
            "CÁLCULO II",
            "CÁLCULO III",
            "CÁLCULO NUMERICO",
            "DESENHO TÉCNICO",
            "ELETRÔNICA APLICADA", 
            "ELETRÔNICA BÁSICA",
            "ENGENHARIA DE SOFTWARE I",
            "ENGENHARIA DE SOFTWARE II",
            "ENGENHARIA ECONÔMICA", 
            "ESTRUTURAS DE DADOS", 
            "ÉTICA EM INFORMÁTICA",
            "FÍSICA GERAL", 
            "FÍSICA III",
            "GERÊNCIA DE PROJETOS", 
            "GRAFOS",
            "INICIAÇÃO TÉCNICO-CIENTÍFICA", 
            "INTELIGÊNCIA ARTIFICIAL", 
            "INTERFACE HUMANO - COMPUTADOR", 
            "INTRODUÇÃO A ENGENHARIA DE COMPUTAÇÃO", 
            "INTRODUÇÃO AO CÁLCULO", 
            "INTRODUÇÃO À FÍSICA", 
            "LINGUAGENS FORMAIS",
            "MATEMÁTICA APLICADA À ENGENHARIA", 
            "MATEMÁTICA COMPUTACIONAL", 
            "MICROCONTROLADORES",
            "ÓTICA E FÍSICA PARA SEMICONDUTORES", 
            "PROBABILIDADE E ESTATÍSTICA",
            "PROCESSADOR DIGITAL DE SINAIS",
            "PROGRAMAÇÃO ORIENTADA A OBJETOS I",
            "PROGRAMAÇÃO ORIENTADA A OBJETOS II",
            "PROJETO DE SISTEMAS DIGITAIS",
            "PROJETO DE SISTEMAS EMBARCADOS", 
            "QUÍMICA I",
            "QUÍMICA II",
            "REDES DE COMPUTADORES I",
            "REDES DE COMPUTADORES II",
            "RESISTÊNCIA DOS MATERIAIS", 
            "SIMULAÇÃO DISCRETA", 
            "SISTEMAS DISTRIBUÍDOS",
            "SISTEMAS EM TEMPO REAL",
            "SISTEMAS OPERACIONAIS", 
            "SISTEMAS ROBÓTICOS", 
            "TCC I",
            "TCC II",
            "TCC III",
            "TÓP. ESPECIAIS EM INTEGRAÇÃO SOFTWARE HARDWARE",
            "TÓPICOS ESPECIAIS EM ENGENHARIA DE COMPUTAÇÃO", 
            "TÓPICOS ESPECIAIS EM HARDWARE"
        );
        
        media.getItems().addAll("M1", "M2", "M3");
    }
    
    @FXML
    public void salvar() {
        
        if(disciplina.getValue() == null || media.getValue() == null || nome.getText().equals("") || peso.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Avaliacao av = new Avaliacao(disciplina.getValue().toString(), media.getValue().toString(), nome.getText(), Double.parseDouble(peso.getText().replace(",", ".")));

        TelaMinhasAvaliacoesController.avaliacoes.add(av);
        
        av.salvar();
        this.voltar();
    }
    
    @FXML
    public void voltar() {
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}
