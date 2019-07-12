package campominado;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Campo {
    JPanel camp = new JPanel();
    JPanel top = new JPanel();
    Botao[][] b;
    boolean fimCampo;
    public void criaCampo(int x,int y,int nBomb){
        GridLayout layout = new GridLayout(x,y);
        camp.setLayout(layout);
        b = new Botao[x][y];
        fimCampo = false;
        CampoExterno campE = new CampoExterno(x,y);
        CampoInterno campI = new CampoInterno();
        campI.criaCampoInterno(x,y,nBomb);
        
        MouseAdapter trataD = new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(fimCampo== false){
                    JButton botaoClicado = (JButton)e.getSource();
                    if(e.getButton() == MouseEvent.BUTTON3) {
                        for(int i=0;i<x;i++){
                            for(int j=0;j<y;j++){
                                if(b[i][j].button==botaoClicado){
                                    b[i][j].CliqueD();
                                }
                            }
                        }
                    }   
                }
            }
        };
        
        ActionListener trataE = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(fimCampo== false){
                    JButton botaoClicado = (JButton)e.getSource();
                    for(int i=0;i<x;i++){
                        for(int j=0;j<y;j++){
                            if(b[i][j].button==botaoClicado){
                                campE.MostraBotao(i, j, b);
                                if(b[i][j].valor==-1)fimCampo = true;
                                campE.Testar(b, x, y);
                            }
                        }
                    }
                }
            }
        };
        
        JButton reset = new JButton("reset");
        top.add(reset);
        reset.addActionListener(
            new ActionListener () {
                public void actionPerformed(ActionEvent e) {
                fimCampo = false;
                campI.criaCampoInterno(x,y,nBomb);    
                    for(int i=0;i<x;i++){
                        for(int j=0;j<y;j++){
                            b[i][j].Reativar();
                            b[i][j].valor = campI.campoInt[i][j];
                        }
                    }
                }
            }
        );
        
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                b[i][j] = new Botao(i,j);
                b[i][j].valor = campI.campoInt[i][j];
                b[i][j].button.addActionListener(trataE);
                b[i][j].button.addMouseListener(trataD);
                camp.add(b[i][j].button);
            }
        }
    }
}