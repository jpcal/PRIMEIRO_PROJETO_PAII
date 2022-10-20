import java.util.Random;
import java.util.Scanner;
import java.lang.System;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        Scanner ler = new Scanner(System.in);
        String escolha="";
        int escolhaN = 0, flag =0;
        int [][] grid = new int [9][9];
        boolean sair = false;
        //Ciclo principal do menu
        do
        {
                System.out.println("\n(1) Desenho de padrões \n (2) Jogo do adivinha \n (3) Sudoku Simplificado \n (4) Sair \nInsira a sua escolha:");
                    escolha = ler.nextLine();
                    /*Condição para o menu:
                    * Se o valor inserido for um número inteiro, e esse número corresponder ao valor entre 1 e 4,
                    * o programa guarda o número inserido numa variável inteira em que nesse processo, o valor da string
                    * é convertido em inteiro*/
                    if(VerificaVal(escolha) == 1 && ( Integer.parseInt(escolha) >= 1 && Integer.parseInt(escolha) <= 4 ))
                    {
                        //Switch..case serve para realizar a ação consoante a escolha do número pelo utilizador.
                        //Para o caso 1 a 3, invoca os devidos métodos que correspondem à sua função no menu.
                        //O caso 4 faz com que o programa termine o ciclo e encerre o programa.
                        escolhaN = Integer.parseInt(escolha);
                        switch (escolhaN)
                        {
                            case 1:
                                ConstroiPiramide();
                                break;
                            case 2:
                                NumRandom();
                                break;
                            case 3:
                                break;
                        }
                    }
                    else
                    {
                        System.out.println("Insira um número de 1-4!");
                    }

        }
        while (escolhaN != 4);
    }
    //VerificaVal: Esta função serve para verificar se o valor de input corresponde a um valor inteiro
    public static int VerificaVal(String n)
    {
        //try...catch: Serve para
        try
        {
            Integer.parseInt(n);
            return 1;
        }
        catch(Exception e)
        {
            return 0;
        }
    }
    public static void NumRandom()
    {
        //Variável para guardar o valor inserido pelo user
        String n;
        //Gera um número random e guarda na variável r
        Random r = new Random();
        /*myRand: Gera números entre 0 e 1000
          cnt: contador de x vezes que o utilizador tentou acertar
          nConvert: serve para guardar o valor convertido do utilizador se o mesmo estiver certo*/
        int myRand = r.nextInt(1001), cnt=1, nConvert=0;
        Scanner ler = new Scanner(System.in);
        /*Ciclo principal:
        * 1º passo: leitura do número do user
        * 2º passo: Verifica se o utilizador inseriu um número inteiro, e se for converte o valor para int
        * 3º passo: Verifica se o número corresponde ao número random que a máquina selecionou, e cada vez
        *           que o user insere errado, adiciona +1 valor ao contador. */
        while (nConvert != myRand)
        {
            //1º passo
            System.out.println("Insira um número (0 a 1000): ");
            n = ler.nextLine();
            //2º passo
            if(VerificaVal(n) == 1)
            {
                nConvert = Integer.parseInt(n);
                System.out.println(myRand);
                //3º passo
                if (nConvert != myRand)
                {
                    System.out.println("Número errado, tenta outra vez.");
                    cnt++;
                }
                else
                {
                    System.out.println("Número certo: " + myRand + " . Realizou " + cnt + " tentativas.");
                }
            }
            else
            {
                System.out.println("Insira um número inteiro!");
            }
        }
    }
    public static void ConstroiPiramide()
    {
        /* String n: guarda o valor que o utilizador insere
        *  valor: guarda o valor que o utilizador insere, se o mesmo colocar um valor inteiro
        *  */
        String n = "";
        int valor, flag = 0, i, j, k=1;
        Scanner ler = new Scanner(System.in);
        System.out.println("Para criar os padrões introduza um número inteiro positivo entre 1 e 10: ");
        //Ciclo para verificar se o utilizador inseriu um número ou não.
        while(flag == 0)
        {
            n = ler.nextLine();
            if(VerificaVal(n) == 0 || (Integer.parseInt(n) < 1 || Integer.parseInt(n) > 10 ))
            {
                System.out.println("Insira outra vez um número: ");
            }
            else
            {
                flag = 1;
            }
        }
        //Guarda na variável valor o número inserido pelo utilizador, convertendo o valor da string em int
        valor = Integer.parseInt(n);
        System.out.println("#Padrão A");
        /*Ciclos para fazer o padrão A:
        * O primeiro ciclo FOR controla as linhas
        * O segundo ciclo FOR controla as colunas*/
        //1º ciclo FOR
        for(i = 1;i <= valor;i++)
        {
            //2º ciclo FOR
            for(j = 1;j <= i;j++)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println("#Padrão B");
        for(i = 1;i <= valor;i++)
        {
            for(j = valor;j >= i;j--)
            {
                System.out.print(k + " ");
                k++;
            }
            k=1;
            System.out.println();
        }
        System.out.println("\n#Padrão C");
        for(i = 1;i <= valor;i++)
        {
            for(j = valor;j > i;j--)
            {
                System.out.print("  ");
            }
            for(k = i;k >= 1;k--)
            {
                if(k == 10)
                {
                    System.out.print(k);
                }
                else
                {
                    System.out.print(" " + k);
                }
            }
            System.out.println();
        }

    }

}