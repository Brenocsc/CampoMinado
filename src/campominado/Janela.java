package campominado;

import java.awt.*;
import javax.swing.*;

public class Janela {
    JFrame janela = new JFrame("Campo Minado");
    
    public void criaJanela(){
        Campo c = new Campo();
        c.criaCampo(8,8,10);
        janela.setSize(400, 400);
        janela.setVisible(true);
        janela.add(c.top,BorderLayout.NORTH);
        janela.add(c.camp,BorderLayout.CENTER);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
    }
    
    static public void main(String[] args){
        Janela j = new Janela();
        j.criaJanela();
    }
}