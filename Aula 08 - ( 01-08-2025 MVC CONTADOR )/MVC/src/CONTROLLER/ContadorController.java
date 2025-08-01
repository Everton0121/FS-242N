package CONTROLLER;

import MODEL.Contador;
import VIEW.ContadorView;

public class ContadorController {
    // referencia para o objeto model
    private Contador model1;


    // referencia para o obejto view
    private ContadorView view1;


    public ContadorController(Contador model, ContadorView view) {
        this.model1 = model; // armazena o model
        this.view1 = view; // armazena o view

        // adiciona umlistetenr (ouvinte) ao botao da view para incrementar o contador
        // quando o botao for clicado:
        this.view1.addIncrementarListener( e ->{
            model1.incrementar(); // atualizar o estado no model (incrementa o contador)
            view1.setValor(model1.getValor()); // atualiza o valor exibido na view
        });

        this.view1.addDecrementarListener( e ->{
            model1.decrementar(); // atualizar o estado no model (Descrementa o contador)
            view1.setValor(model1.getValor()); // atualiza o valor exibido na view
        });

        this.view1.addReiniciarListener( e ->{
            model1.reiniciar(); // atualizar o estado no model (Reinicia o contador)
            view1.setValor(model1.getValor()); // atualiza o valor exibido na view
        });

        this.view1.addAdicionarListener( e ->{
            model1.Adicionar(); // atualizar o estado no model (Reinicia o contador)
            view1.setValor(model1.getValor()); // atualiza o valor exibido na view
        });


        this.view1.addMensagemSecretaListener(e -> {
            String segredo = model1.mensagemSecreta();  // pega a mensagem secreta do model
            view1.mudarTitulo(segredo);                 // altera o título da janela
        });




        // inicializando a view com valor atual do model (0)
        view.setValor(model1.getValor());

    }
    // Método para mostrar a interface grafica ( a view ) na tela
    public void iniciarCont(){view1.setVisible(true);}
}
