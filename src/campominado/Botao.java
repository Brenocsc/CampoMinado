package campominado;

import java.awt.Color;
import javax.swing.*;

public class Botao {
    JButton button;
    int x;
    int y;
    int valor;
    boolean on;
    public Botao(int y, int x){
        this.button = new JButton("");
        this.y = y;
        this.x = x;
        on = true;
    }
    
    public void Reativar(){
        on = true;
        button.setText("");
        button.setEnabled(true);
    }
    
    public void Desativar(){
        on = false;
        if(valor == -1)button.setText("•");
        else button.setText(Integer.toString(valor));
        button.setEnabled(false);
    }
    
    public void CliqueD(){
        if(button.getText()=="B"){
            button.setText("");
            button.setEnabled(true);
        }
        else {
            if(on == true){
                button.setText("B");
                button.setEnabled(false);
            }
        }
    }
}