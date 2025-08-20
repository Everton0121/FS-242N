package MODEL;

import jakarta.persistence.*;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // para ids t
    @Column(name = "id_aluno", nullable = false)
    private int id_aluno ;

    @Column(name = "nome", nullable = false)
    private String nome ;

    @Column(name = "idade", nullable = false)
    private int idade ;

    @Column(name = "telefone", nullable = false)
    private String telefone ;




    public int getId_aluno() {
        return id_aluno;
    }
    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
