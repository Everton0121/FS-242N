import CONTROLLER.ContadorController;
import MODEL.Contador;
import VIEW.ContadorView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    // cria uma instancia do model ( a logica do contador grafica )
     Contador model = new Contador();

     // cria a instancia da view ( a interface grafica )
     ContadorView view = new ContadorView();

     // cria a instancia da view ( a interface grafica )
     ContadorController Controller = new ContadorController(model, view);

     // inicia a interface grafica
     Controller.iniciarCont();


    }
}