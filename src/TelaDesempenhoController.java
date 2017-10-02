
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;

/**
 * @author Gabriel Vinicius
 **/

public class TelaDesempenhoController extends InterfaceUsuario {

    @FXML
    private BarChart<String, Number> desempenho;
    
    @FXML
    private ComboBox disciplinas;
    
    public TelaDesempenhoController() {
        super("TelaDesempenho.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        for(Avaliacao av : Avaliacao.obterListaAvaliacoes()) {
            
            if(!this.disciplinas.getItems().contains(av.getDisciplina()) && av.getNota() != null) {
                this.disciplinas.getItems().add(av.getDisciplina());
            }
        }
        
    }
    
    @FXML
    public void puxarDesempenho() {
    
        this.desempenho.getData().clear();
        this.desempenho.setTitle("Desempenho");
        
        double m1 = Avaliacao.calculaMediaDaDisciplina(this.disciplinas.getSelectionModel().getSelectedItem().toString(), "M1");
        double m2 = Avaliacao.calculaMediaDaDisciplina(this.disciplinas.getSelectionModel().getSelectedItem().toString(), "M2");
        double m3 = Avaliacao.calculaMediaDaDisciplina(this.disciplinas.getSelectionModel().getSelectedItem().toString(), "M3");
        double mf = Avaliacao.calculaMediaDaDisciplina(this.disciplinas.getSelectionModel().getSelectedItem().toString(), "MF");
 
        XYChart.Series seriesM1 = new XYChart.Series();
        seriesM1.setName("M1("+String.format("%.2f", m1)+")");       
        seriesM1.getData().add(new XYChart.Data(this.disciplinas.getSelectionModel().getSelectedItem().toString(), m1));
        
        XYChart.Series seriesM2 = new XYChart.Series();
        seriesM2.setName("M2("+String.format("%.2f", m2)+")");
        seriesM2.getData().add(new XYChart.Data(this.disciplinas.getSelectionModel().getSelectedItem().toString(), m2));
        
        XYChart.Series seriesM3 = new XYChart.Series();
        seriesM3.setName("M3("+String.format("%.2f", m3)+")");
        seriesM3.getData().add(new XYChart.Data(this.disciplinas.getSelectionModel().getSelectedItem().toString(), m3));
        
        XYChart.Series seriesMF = new XYChart.Series();
        seriesMF.setName("MF("+String.format("%.2f", mf)+")");
        seriesMF.getData().add(new XYChart.Data(this.disciplinas.getSelectionModel().getSelectedItem().toString(), mf));
        
        this.desempenho.getData().addAll(seriesM1, seriesM2, seriesM3, seriesMF);
    }
    
    @FXML
    public void voltar() {
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}