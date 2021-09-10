import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
public class Metodos {
    private int[] Linha = new int[9];
    private String[][] Alvo = new String[9][9];
    private static List<Integer> Ale = new ArrayList<Integer>();
    private int[][] Inimigos = new int[9][9];
    private int Numero, Pontos = 0;
    private int Navios = 5;
 
    public Metodos(int[] linha, String[][] alvo, int[][] inimigos, int numero, int pontos, int navios) {
        super();
        Linha = linha;
        Alvo = alvo;
        Inimigos = inimigos;
        Numero = numero;
        Pontos = pontos;
        Navios = navios;
    }
 
    public Metodos() {
    }
 
    public int getPontos() {
        return Pontos;
    }
 
    public void inicializatabuleiro() {
        for (int x = 0; x < Alvo.length; x++)
            Arrays.fill(Alvo[x], " ");
    }
 
    public String Alvo(int i, int c) {
        return Alvo[i][c];
    }
 
    public void setAlvo(int i, int c, String Letra) {
        Alvo[i][c] = Letra;
    }
 
    public void GerarPosInimigos() {
        for (int i = 0; i <= 8; i++) {
            if (i == 0) {
                Ale.add(i + 1);
            } else {
                Ale.add(i);
            }
        }
        Collections.shuffle(Ale);
        Inimigos[Ale.get(0)][Ale.get(1)] = 1;
        Inimigos[Ale.get(3)][Ale.get(4)] = 1;
        Inimigos[Ale.get(5)][Ale.get(6)] = 2;
        Inimigos[Ale.get(7)][Ale.get(8)] = 2;
        Inimigos[Ale.get(1)][Ale.get(3)] = 3;
 
    }
 
    public void ImprimeTabuleiro() {
        System.out.println("  |A|B|C|D|E|F|G|H|");
 
        for (int i = 1; i < Linha.length; i++) {
 
            System.out.println("|" + i + "|" + Alvo[1][i] + "|" + Alvo[2][i] + "|" + Alvo[3][i] + "|" + Alvo[4][i] + "|"
                    + Alvo[5][i] + "|" + Alvo[6][i] + "|" + Alvo[7][i] + "|" + Alvo[8][i] + "|");
            System.out.println("-------------------");
        }
    }
 
    public void Digite() {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        String digito = sc.next();
        String Letra = digito.substring(0, 1);
 
        try {
            if (digito.length() > 1) {
                String subdigito = digito.substring(1, 2);
                Numero = Integer.parseInt(subdigito);
            } else {
                System.out.println("Invalido,Insira uma letra e numero Exemplo: d5");
                Digite();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Invalido,Insira uma letra e numero Exemplo: d5");
            Digite();
        }
 
        if (Character.isDigit(Letra.charAt(0)) == true) {
            System.out.println("Invalido,Insira uma letra e numero Exemplo: d5");
            Digite();
        }
 
        if (Numero > 8 || Numero == 0) {
            System.out.println("invalido,o numero precisa ser menor ou igual a 8 e maior q 0");
            Digite();
        }
 
        int posnumeroletra = 0;
 
        switch (Letra.charAt(0)) {
        case 'a':
            posnumeroletra = 1;
            break;
        case 'b':
            posnumeroletra = 2;
            break;
        case 'c':
            posnumeroletra = 3;
            break;
        case 'd':
            posnumeroletra = 4;
            break;
        case 'e':
            posnumeroletra = 5;
            break;
        case 'f':
            posnumeroletra = 6;
            break;
        case 'g':
            posnumeroletra = 7;
            break;
        case 'h':
            posnumeroletra = 8;
            break;
        default:
            System.out.println("letra invalida");
        }
 
        int escolha = Inimigos[posnumeroletra][Numero];
 
        if (Alvo(posnumeroletra, Numero) == " ") {
            switch (escolha) {
            case 0:
                System.out.println("voce atirou na agua, tente novamente");
                setAlvo(posnumeroletra, Numero, "O");
                ImprimeTabuleiro();
                break;
            case 1:
                System.out.println("voce acertou um navio");
                setAlvo(posnumeroletra, Numero, "X");
                Navios--;
                Pontos = Pontos + 2;
                ImprimeTabuleiro();
                break;
            case 2:
                System.out.println("voce acertou um navio");
                setAlvo(posnumeroletra, Numero, "X");
                Navios--;
                Pontos = Pontos + 3;
                ImprimeTabuleiro();
                break;
            case 3:
                System.out.println("voce acertou um navio");
                setAlvo(posnumeroletra, Numero, "X");
                Navios--;
                Pontos = Pontos + 4;
                ImprimeTabuleiro();
                break;
            }
        } else {
            System.out.println("Esse alvo ja foi atingido");
        }
        if (Navios != 0) {
            Digite();
        }
    }
}

