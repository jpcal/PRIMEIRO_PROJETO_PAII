import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Sudoku {
    //Preenchimento matriz
    static void matriz(int [][]array){

        Random r = new Random();
        int myRand = r.nextInt(10);
        for(int i = 0;i <= 8;i++){
            for(int j = 0; j <= 8;j++)
            {
                array[i][j]=myRand;
                for(int o = 0;o <= 8;o++){
                    if(array[i][j] == array[o][j] && array[o][j] != 0 && o != i){
                        array[i][j]=0;
                        break;
                    }
                }
                for(int k = 0;k <= 8;k++)
                {
                    if(array[i][j] == array[i][k] && array[i][k] != 0 && k != j)
                    {
                        array[i][j]=0;
                        break;
                    }
                }
            }
        }
        for(int l = 0;l <= 8;l++)
        {
            for(int c = 0;c <= 8;c++){
                System.out.print(array[l][c]+" ");
            }
            System.out.println();
        }
    }

    static ArrayList<Integer> possiveis(int x, int y, int [][] array){
        ArrayList<Integer> vetor = new ArrayList<>();
        int r = 0;
        for(int h = 1;h <= 9;h++){
            vetor.add(h);
        }
        for(int i = 1;i <= 9;i++){
            for(int j = 0;j <= 8;j++){
                if(array[j][y]==i){
                    r = 1;
                    break;
                }
            }
            for(int k = 0;k <= 8;k++){
                if(array[x][k]==i){
                    r = 1;
                    break;
                }
            }
            if(r == 1){
                for(int n = 0;n <= 8;n++){
                    if(vetor.get(n) == i){
                        vetor.remove(n);
                        break;
                    }
                }
                r = 0;
            }
        }

        return vetor;
    }

    static void Inserir(int x, int y, int [][] array,int n)
    {
        array[x][y]=n;
        for(int l = 0;l <= 8;l++)
        {
            for(int c = 0;c <= 8;c++)
            {
                System.out.print(array[l][c]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){

        int [][] grid = new int [9][9];
        Scanner ler = new Scanner(System.in);
        int x=10,y=10,v = 0;

        System.out.println("\nRegras do jogo:\nFoi gerada uma matriz 9x9 com n??meros aleat??rios entre 1 e 9, o objetivo consiste em preencher as c??lulas vazias marcadas como 0, sabendo que, n??o podem existir n??meros repetidos na mesma coluna e linha.\nBoa Sorte!\n");

        matriz(grid);

        System.out.println("\nTer?? que introduzir as coordenadas da c??lula que quer introduzir um n??mero. A seguir ser?? lhe mostrado quais os n??meros que podem ocupar a posi????o.");
        while(true){
            while(x < 0 || x > 9){
                System.out.print("Introduza a linha da posi????o(1 a 9): ");

                x = ler.nextInt() - 1;
                ler.nextLine();
            }
            while(y < 0 || y > 9){
                System.out.print("Introduza a coluna da posi????o(1 a 9): ");
                while(!ler.hasNextInt()){
                    ler.nextLine();
                    System.out.print("N??mero inv??lido, por favor introduza a coluna da posi????o: ");
                }
                y = ler.nextInt() - 1;
                ler.nextLine();
            }
            if(grid[x][y] != 0){
                System.out.println("A c??lula que escolheu j?? est?? preenchida, por favor escolha um c??lula vazia(marcada com 0)");
                x = 10;
                y = 10;
            }
            if(possiveis(x,y,grid).get(0) == null){
                System.out.println("N??o existem n??meros possiveis para esta posi????o, por favor escolha outra.");
                x = 10;
                y = 10;
            }
            else{
                break;
            }
        }
        System.out.println("Os n??meros disponiveis para a posi????o "+(x+1)+","+(y+1)+" s??o: ");
        System.out.println(possiveis(x,y,grid));
        while(!possiveis(x,y,grid).contains(v)){
            System.out.print("Introduza o n??mero deseja inserir: ");
            while(!ler.hasNextInt()){
                ler.nextLine();
                System.out.println("N??mero inv??lido, por favor introduza um dos seguintes n??meros: "+possiveis(x,y,grid));
            }
            v = ler.nextInt();
            ler.nextLine();
        }
        Inserir(x,y,grid,v);
    }
}
