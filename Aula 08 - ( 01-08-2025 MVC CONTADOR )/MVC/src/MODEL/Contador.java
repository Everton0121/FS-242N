package MODEL;

public class Contador {

    private int valor;
    //construtor da classe contador

    public Contador(){this.valor= 0;} //9
    public int getValor(){ return valor;}
    public void incrementar() {this.valor++;}
    public void decrementar() {this.valor--;}
    public void reiniciar() {this.valor = 0;}
    public void Adicionar() {this.valor = +999999999;}
    public String mensagemSecreta() { return " Voce Ficara com Frio Quando Sair Pra Rua haha " ;}


}
