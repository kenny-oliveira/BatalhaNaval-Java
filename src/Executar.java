public class Executar {

    public static void main(String[] args) {
     Metodos p = new Metodos();
        p.inicializatabuleiro();
        p.ImprimeTabuleiro();
        p.GerarPosInimigos();
        p.Digite();
        System.out.println("Parab�ns voc� ganhou com "+p.getPontos()+" Pontos");
    }
 
}