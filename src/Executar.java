public class Executar {

    public static void main(String[] args) {
     Metodos p = new Metodos();
        p.inicializatabuleiro();
        p.ImprimeTabuleiro();
        p.GerarPosInimigos();
        p.Digite();
        System.out.println("Parabéns você ganhou com "+p.getPontos()+" Pontos");
    }
 
}