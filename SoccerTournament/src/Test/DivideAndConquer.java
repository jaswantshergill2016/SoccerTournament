package Test;

public class DivideAndConquer {
	
	public static void main(String[] args) {

	    int nPlayers = 9;
	    int nPlayersAux = nPlayers;

	    if (nPlayers <= 0) {
	        throw new IllegalArgumentException();
	    }

	    if (nPlayers % 2 != 0) {
	        nPlayersAux++;
	    }

	    int nWeeks = nPlayersAux - 1;

	    int[] ciclo = new int[nPlayersAux];
	    int n = nPlayersAux / 2;
	    for (int i = 0; i < n; i++) {
	        ciclo[i] = i + 1;
	        ciclo[nPlayersAux - i - 1] = ciclo[i] + n;
	    }

	    for (int i = 1; i <= nWeeks; i++) {
	        System.out.println("Week " + i);


	        for (int j = 0; j < n; j++) {
	            System.out.println("team " + ciclo[j] + " - team " + ciclo[nPlayersAux - j - 1]);
	        }


	        int aux = ciclo[1];
	        for (int j = 1; j < nPlayersAux - 1; j++) {
	            int step = ciclo[j + 1];
	            ciclo[j + 1] = aux;
	            aux = step;
	        }
	        ciclo[1] = aux;
	    }
	}

}



