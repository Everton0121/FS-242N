package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement; //Importa preparedStatement
import java.sql.ResultSet; //importa ResultSet para consutas



public class ConexaoPostgresDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/biblioteca_db";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "root";


    public static Connection conectar() {
        Connection conexao = null;//Inicializa a conexao como nulaa
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexao com o db Completa");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o bd: " + e.getMessage());
        }
        return conexao;// retorna a conexao, pode ser nula em caso de erro
    }

    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            //Verifica se a conexao nao e nula antes de tentar fechar:
            try {
                conexao.close();
                System.out.println("Conexao com o db encerrado ");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


/*


    public static void main(String[] args){
//        Connection testeConexao = ConexaoPostgresDB.conectar();
//        if(testeConexao != null){ConexaoPostgresDB.fecharConexao(testeConexao);}
//        }
//

        //DELETE(3);
        //setAluno(3,"Joseph",14,"31 999999999");

    }
}


 */



