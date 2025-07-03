package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USUARIO = "root"; //
    private static final String SENHA = "root"; //

    public static Connection conectar() {
        Connection conexao = null; //inicializa a conexao como nula
        try{
            conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
            System.out.println("conexao com o banco de dados estabelecida com sucesso!");
        } catch (SQLException e){
            System.err.println("erro ao conectar com o bd: " + e.getMessage());
        } return conexao; //retorna a conexao (pode ser null em caso de erro)
    }

    public static void fecharConexao(Connection conexao) {
        if (conexao != null) { //verefica se a conexao nao e nula antes de tentar fechar
            try{
                conexao.close(); //fehca a conexao
                System.out.println("conexao com o bd fechada!");
            } catch (SQLException e) {
                System.err.println("erro ao fechar a conexao com o bd: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Connection testeConexao = ConexaoDB.conectar();
        if (testeConexao != null) {
            // se a conexao for bem sucedida, podemos fecha-la
            ConexaoDB.fecharConexao(testeConexao);
        }
    }




}
