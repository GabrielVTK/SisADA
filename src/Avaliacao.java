
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Gabriel Vinicius
 **/

public class Avaliacao {
    
    private String nome;
    private String disciplina;
    private double peso;
    private String media;
    private Double nota;
    
    public Avaliacao(String disciplina, String media, String nome, double peso) {
        this.nome = nome;
        this.disciplina = disciplina;
        this.peso = peso;
        this.media = media;
    }
    
    public void salvar() {
        try {
        
            File arquivo = new File("avaliacoes.csv");
            FileWriter fw;
            
            if(arquivo.exists()) {
                fw = new FileWriter(arquivo, true);
            } else {
                fw = new FileWriter(arquivo);
            }
                    
            fw.write(disciplina+";"+String.valueOf(media)+";"+nome+";"+peso+"\n");
            
            fw.close();
            
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void atualizar() {
        try {
        
            String linha = "";
            
            for(Avaliacao av : TelaMinhasAvaliacoesController.avaliacoes) {
                linha += av.disciplina+";"+String.valueOf(av.media)+";"+av.nome+";"+av.peso;

                if(av.nota != null) {
                    linha += ";"+av.nota;
                }

                linha += "\n";
            }
            
            File arquivo = new File("avaliacoes.csv");
            FileWriter fw = new FileWriter(arquivo);
            
            fw.write(linha);
            fw.close();
            
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public static ArrayList<Avaliacao> obterListaAvaliacoes() {
        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
        
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("avaliacoes.csv"));
            
            while(buffer.ready()) {
                
                String[] dados = buffer.readLine().split(";");
                
                Avaliacao av = new Avaliacao(dados[0], dados[1], dados[2], Double.parseDouble(dados[3]));
                
                if(dados.length == 5) {
                    av.setNota(Double.parseDouble(dados[4]));
                }
                
                avaliacoes.add(av);
            }
            
            buffer.close();
            
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
        
        return avaliacoes;
    }
    
    public static double calculaMediaDaDisciplina(String disciplina, String media) {
        
        double resultado = 0;
        double peso = 0;
        
        if(!media.equals("MF")) {
            
            for(Avaliacao av : obterListaAvaliacoes()) {
                if(av.disciplina.equals(disciplina) && av.media.equals(media) && av.nota != null) {
                    resultado += av.nota * av.peso;
                    peso += av.peso;
                }
            }

            resultado /= peso;
            
        } else {
            resultado = (calculaMediaDaDisciplina(disciplina, "M1") + calculaMediaDaDisciplina(disciplina, "M2") + calculaMediaDaDisciplina(disciplina, "M3")) / 3;
        }
        
        if(Double.isNaN(resultado)) {
            resultado = 0;
        }

        return resultado;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
    
}