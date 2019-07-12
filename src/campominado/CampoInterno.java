package campominado;

import java.util.Random;

public class CampoInterno {

    int xInt;
    int yInt;
    int[][] campoInt;

    public void criaCampoInterno(int x, int y, int nBomb) {
        xInt = x;
        yInt = y;
        campoInt = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                campoInt[i][j] = 0;//0 vale sem bomba perto
            }
        }
        Random rand = new Random();
        int nx, ny;
        
        criaBomba(x, y, nBomb, rand);
        
        criaNumero(x, y);
    }

	private void criaNumero(int x, int y) {
		for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (campoInt[i][j] == 0) {
                    if (i != 0) {
                        if (j != 0) {
                            if (campoInt[i - 1][j - 1] == -1) {
                                campoInt[i][j]++;
                            }
                        }
                        if (campoInt[i - 1][j] == -1) {
                            campoInt[i][j]++;
                        }
                        if (j != y - 1) {
                            if (campoInt[i - 1][j + 1] == -1) {
                                campoInt[i][j]++;
                            }
                        }
                    }
                    if (i != x - 1) {
                        if (j != 0) {
                            if (campoInt[i + 1][j - 1] == -1) {
                                campoInt[i][j]++;
                            }
                        }
                        if (campoInt[i + 1][j] == -1) {
                            campoInt[i][j]++;
                        }
                        if (j != y - 1) {
                            if (campoInt[i + 1][j + 1] == -1) {
                                campoInt[i][j]++;
                            }
                        }
                    }
                    if (j != 0) {
                        if (campoInt[i][j - 1] == -1) {
                            campoInt[i][j]++;
                        }
                    }
                    if (j != y - 1) {
                        if (campoInt[i][j + 1] == -1) {
                            campoInt[i][j]++;
                        }
                    }
                }
            }
        }
	}

	private void criaBomba(int x, int y, int nBomb, Random rand) {
		int nx;
		int ny;
		for (int i = 0; i < nBomb; i++) {
            nx = rand.nextInt(x);
            ny = rand.nextInt(y);
            if (campoInt[nx][ny] == -1) {
                i--;
            } else {
                campoInt[nx][ny] = -1;
            }
        }
	}
}