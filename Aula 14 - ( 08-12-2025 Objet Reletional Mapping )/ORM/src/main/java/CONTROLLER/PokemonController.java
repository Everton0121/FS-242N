package CONTROLLER;

import MODEL.Pokemon;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;

import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;


public class PokemonController {

    public void cadastrarPokemon(Pokemon pokemon) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            //Validações de négocio(nome,tipo,etc.)
            if (pokemon.getNome() == null || pokemon.getNome().trim().isEmpty()) {
                throw new Exception("O nome do Pokémon é obrigatório.");
            }

            if (pokemon.getTipoPrimario() == null || pokemon.getTipoPrimario().trim().isEmpty()) {
                throw new Exception("O tipo primário do Pokémon é obrigatório.");
            }

            if (pokemon.getTipoPrimario().equalsIgnoreCase(pokemon.getTipoSecundario())) {
                throw new Exception("O Tipo Secundário não pode ser igual ao Tipo Primário.");
            }

            if (pokemon.getNivel() < 0 || pokemon.getNivel() > 100) {
                throw new Exception("O nível não é válido.");
            }

            if (pokemon.getHpMaximo() < 0 || pokemon.getHpMaximo() > 100) {
                throw new Exception("O HP máximo não é válido.");
            }

            session.persist(pokemon);//Salva o objeto no banco
            transaction.commit();


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao cadastrar Pokemon" + e.getMessage());
        }
    }


    public List<Pokemon> listarTodosPokemon() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // HQL (hibernate query languege - similar ao sql, mas usa o nome da classe
            Query<Pokemon> query = session.createQuery("FROM Pokemon", Pokemon.class);
            return query.getResultList();
        }
    }


    public Pokemon buscarPorId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Pokemon.class, id); // retorna o objeto ou null
        }
    }

    public void atualizarPokemon(Pokemon pokemon) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(pokemon); // atualiza um objeto existente
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao atualizar Pokemon.", e);
        }

    }

    public void RemoverPokemon(int id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Pokemon pokemon = session.get(Pokemon.class, id);
            if (pokemon != null) {
                session.remove(pokemon); //remove o objeto
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao remover: " + e.getMessage());
        }
    }

    public Pokemon buscarPokemonPorNome(String nome) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Pokemon.class, nome);
        }

    }

    public void inserirListaPokemons(List<Pokemon> listaPokemon) throws Exception {
        for (Pokemon p : listaPokemon) {
            if (p.getNome() == null || p.getNome().trim().isEmpty()) {
                throw new Exception("Nome do Pokémon é obrigatório.");
            }
            if (p.getTipoPrimario() == null || p.getTipoPrimario().trim().isEmpty()) {
                throw new Exception("Tipo primário é obrigatório.");
            }
            if (p.getTipoPrimario().equalsIgnoreCase(p.getTipoSecundario())) {
                throw new Exception("Tipo secundário não pode ser igual ao primário.");
            }
            if (p.getNivel() < 0 || p.getNivel() > 100) {
                throw new Exception("Nível inválido.");
            }
            if (p.getHpMaximo() < 0 || p.getHpMaximo() > 300) {
                throw new Exception("HP inválido.");
            }
        }

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Persistindo cada Pokémon da lista
            for (Pokemon p : listaPokemon) {
                session.persist(p);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao inserir lista de Pokémons: " + e.getMessage(), e);
        }
    }

    public long contarPokemonsPorTipo(String tipo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Pokemon WHERE tipoPrimario = :tipo", Long.class);
            query.setParameter("tipo", tipo);
            System.out.println("Quantidade de pokemons de "+tipo+": "+query.getSingleResult());
            return query.getSingleResult();
        }

    }


}


