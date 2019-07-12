package campominado;

import java.awt.Color;
import java.util.Vector;
import javax.swing.JOptionPane;

public class CampoExterno {

    int xInt;
	int yInt;
	public CampoExterno(int x, int y){
		xInt = x;
		yInt = y;
	}
	
    void MostraBotao(int x,int y, Botao b[][]){
        
        if(b[x][y].valor == -1){
            for(int i = 0;i<xInt;i++){
                for(int j=0;j<yInt;j++){
                    if(b[i][j].valor == -1){
                        b[i][j].Desativar();
                    }
                }
            }
            return;
        }
        
        b[x][y].Desativar();
        
        if(b[x][y].valor == 0){
            if(x != 0) {
                if(y != 0 && b[x-1][y-1].on){
                    MostraBotao(x-1,y-1,b);
                }
                if(b[x-1][y].on){
                    MostraBotao(x-1,y,b);
                }
                               
                if(y != (yInt-1) && b[x-1][y+1].on){
                    MostraBotao(x-1,y+1,b);
                }
            }
            if(x != (xInt-1)) {
                if(y != 0 && b[x+1][y-1].on){
                    MostraBotao(x+1,y-1,b);
                }
                if(b[x+1][y].on){
                    MostraBotao(x+1,y,b);
                }
                if(y != (yInt-1) && b[x+1][y+1].on){
                    MostraBotao(x+1,y+1,b);
                }
            }
            if(y != 0 && b[x][y-1].on){
                MostraBotao(x,y-1,b);
            }
            if(y != (yInt-1) && b[x][y+1].on){
                MostraBotao(x,y+1,b);
            }
        }
    }
    
    void Testar(Botao b[][], int xInt, int yInt){
        for(int i=0;i<xInt;i++){
            for(int j=0;j<yInt;j++){
                if(b[i][j].valor!=-1 && b[i][j].on)return;
            }
        }
        for(int i=0;i<xInt;i++){
            for(int j=0;j<yInt;j++){
                b[i][j].Desativar();
            }
        }
        JOptionPane.showMessageDialog(null,"Parabens, voce venceu!");
    }
}