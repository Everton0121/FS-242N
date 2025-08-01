package VIEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ContadorView extends JFrame {
    private JLabel lblContador;
    private JButton btnIncrementar;
    private JButton btnDecrementar;
    private JButton btnReiniciar;
    private JButton btnAdicionar;
    private JButton btnMensagemSecreta;

    public ContadorView(){
        setTitle(" | --- Contador de MVC --- | ");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centraliza a janela na tela
        setLayout( new FlowLayout(FlowLayout.CENTER, 20, 20));



        lblContador = new JLabel("0");
        lblContador.setFont( new Font("Arialmes", Font.BOLD, 48));


        btnIncrementar = new JButton( "  INCREMENTAR  ");
        btnIncrementar.setFont( new Font("Times New Roman", Font.ITALIC, 18));

        btnDecrementar = new JButton( "  DECREMENTAR  ");
        btnDecrementar.setFont( new Font("Times New Roman", Font.ITALIC, 18));

        btnReiniciar = new JButton( "  REINICIAR  ");
        btnReiniciar.setFont( new Font("Times New Roman", Font.ITALIC, 18));

        btnAdicionar = new JButton( " ¿ ADICIONAR ?  ");
        btnAdicionar.setFont( new Font("Times New Roman", Font.ITALIC, 18));

        btnMensagemSecreta = new JButton("🎁 MENSAGEM SECRETA 🎁");
        btnMensagemSecreta.setFont(new Font("Times New Roman", Font.ITALIC, 16));


        add(lblContador);
        add(btnIncrementar);
        add(btnDecrementar);
        add(btnReiniciar);
        add(btnAdicionar);
        add(btnMensagemSecreta);

    }
    public void setValor( int valor){ lblContador.setText(String.valueOf(valor));}
    public void addIncrementarListener(ActionListener listener){btnIncrementar.addActionListener((listener));}
    public void addDecrementarListener(ActionListener listener){btnDecrementar.addActionListener((listener));}
    public void addReiniciarListener(ActionListener listener){btnReiniciar.addActionListener((listener));}
    public void addAdicionarListener(ActionListener listener){btnAdicionar.addActionListener((listener));}
    public void addMensagemSecretaListener(ActionListener listener){btnMensagemSecreta.addActionListener((listener));}
    public void mudarTitulo(String novoTitulo) {setTitle(novoTitulo);}
}
