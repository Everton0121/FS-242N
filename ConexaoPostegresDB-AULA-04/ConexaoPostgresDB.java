package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConexaoPostgresDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/biblioteca_db";
    private static final String USUARIO = "postgres"; //
    private static final String SENHA = "root"; //






        public static Connection conectar() {
            Connection conexao = null; //inicializa a conexao como nula
            try {
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
                System.out.println("conexao com o banco de dados estabelecida com sucesso!");
            } catch (SQLException e) {
                System.err.println("erro ao conectar com o bd: " + e.getMessage());
            }
            return conexao; //retorna a conexao (pode ser null em caso de erro)
        }

        public static void fecharConexao(Connection conexao) {
            if (conexao != null) { //verefica se a conexao nao e nula antes de tentar fechar
                try {
                    conexao.close(); //fehca a conexao
                    System.out.println("conexao com o bd fechada!");
                } catch (SQLException e) {
                    System.err.println("erro ao fechar a conexao com o bd: " + e.getMessage());
                }
            }
        }

        public static void setAluno(String nome, int idade, String telefone) {
        String sql = "INSERT INTO aluno (nome,idade,telefone) VALUES (?,?,?)";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = conectar();
            if (conexao != null) {
                stmt = conexao.prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setInt(2, idade);
                stmt.setString(3, telefone);
                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Aluno" + nome + "Inserido no BD com sucesso.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir aluno no PostgresSQL:" + e.getMessage());
        } finally {
        }
        try {
            if (stmt != null) stmt.close();
            if (conexao != null) fecharConexao(conexao);
        } catch (SQLException e) {
            System.err.println("Erro ao fechar recursos após inserção:" + e.getMessage());

        }
    }



        public static void getAlunos() {

            String sql = "SELECT id_aluno, nome, idade, telefone FROM aluno ORDER BY id_id_aluno";
            Connection conexao = null;
            PreparedStatement stmt = null;
            ResultSet rs = null; // objeto para armazenar os resultados da consulta

            try {
                conexao = conectar();
                if (conexao != null) {
                    stmt = conexao.prepareStatement(sql);
                    rs = stmt.executeQuery(); // executa a consulta SELECT
                    System.out.println("\n--- Alunos cadastrados no BD ---");
                    boolean encontrouAluno = false;
                    while (rs.next()) { //toop enquanto houver proximas linha no resultado
                        encontrouAluno = true;
                        int id = rs.getInt("id_aluno"); //pega o valor da coluna "id_aluno"
                        String nome = rs.getNString("nome"); //pega o valor da coluna 'nome'
                        Number idade = rs.getInt("idade");
                        String telefone = rs.getString("telefone");
                        System.out.println("ID: " + id + ", nome: " + nome + ", idade: " + idade + ", telefone: " + telefone);
                    }
                    if (!encontrouAluno) {
                        System.out.println("nenhuma aluno encontrado.");
                    }
                    System.out.println("--------------------------------\n");
                }

            } catch (SQLException e) {
                System.out.println("erro ao consultar alunos no DB: " + e.getMessage());
            } finally {
                try { // sempre fechar os recursos! na ordem inversa de abertura.
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conexao != null) fecharConexao(conexao);
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar recursos após consulta" + e.getMessage());
                }
            }
        }
        public static void main(String[] args) {
            //teste a conexai basuca
            Connection testeConexao = Conexao.ConexaoPostgresDB.conectar();
            if (testeConexao != null) {
                // se a conexao for bem sucedida, podemos fecha-la
                Conexao.ConexaoPostgresDB.fecharConexao(testeConexao);
            }

            // --- testando a insercao ---
            System.out.println("\n--- realizando insercoes ---");
            setAluno("everton", 16, "519777-2617");
            setAluno("joao", 17, "5198269-1012");

            // --- testando a consulta ---
            System.out.println("\n--- realizando consulta ---");
            getAlunos(); // chama o metodo para listar os alunos
        }
    }

