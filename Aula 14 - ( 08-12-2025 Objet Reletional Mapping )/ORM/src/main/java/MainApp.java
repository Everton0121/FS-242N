

import CONTROLLER.PokemonController;
import MODEL.Aluno;
import MODEL.Pokemon;
import VIEW.ListaPokemonsPanel;
import VIEW.PokemonForm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class  MainApp extends JFrame {

    private JDesktopPane desktopPane;
    private PokemonController pokemonController = new PokemonController();

    public MainApp() {
        super("Sistema de Gerenciamento de Pokémons");
        this.pokemonController = new PokemonController();

        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        createMenuBar();

        System.out.println(pokemonController.contarPokemonsPorTipo("Fogo"));
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Menu Pokémons
        JMenu menuPokemons = new JMenu("Pokémons");
        JMenuItem itemCadastrarPokemon = new JMenuItem("Cadastrar Pokémon");
        JMenuItem itemListarPokemons = new JMenuItem("Listar Pokémons");
        JMenuItem itemInserirListaPokemons = new JMenuItem("Inserir Pokémons");

        itemCadastrarPokemon.addActionListener(e -> openPokemonForm(null));
        itemListarPokemons.addActionListener(e -> openListaPokemonsPanel());
        itemInserirListaPokemons.addActionListener(e -> openInsereListaPokemonsPanel());

        menuPokemons.add(itemCadastrarPokemon);
        menuPokemons.add(itemListarPokemons);
        menuPokemons.add(itemInserirListaPokemons);

        menuBar.add(menuPokemons);

        // Menu Sair
        JMenu menuSair = new JMenu("Sair");
        JMenuItem itemSair = new JMenuItem("Sair do Sistema");
        itemSair.addActionListener(e -> System.exit(0));
        menuSair.add(itemSair);
        menuBar.add(menuSair);

        setJMenuBar(menuBar);
    }

    private void openPokemonForm(Integer idPokemon) {
        PokemonForm pokemonForm = new PokemonForm(pokemonController, idPokemon);
        desktopPane.add(pokemonForm);
        pokemonForm.setVisible(true);
        pokemonForm.toFront();
    }

    private void openListaPokemonsPanel() {
        ListaPokemonsPanel listaPokemons = new ListaPokemonsPanel(pokemonController);
        desktopPane.add(listaPokemons);
        listaPokemons.setVisible(true);
        listaPokemons.toFront();
    }

    private void openInsereListaPokemonsPanel() {

        ///pokemon da pokedex
        Configuration configPokemon = new Configuration();
        configPokemon.configure("hibernatePokemon.cfg.xml");
        configPokemon.addAnnotatedClass(Pokemon.class);

        ///pokemon da pokedex
        SessionFactory sessionFactoryPokemon = configPokemon.buildSessionFactory();
        Session sessionPokemon = sessionFactoryPokemon.openSession();

        ///pokemon da pokedex
        sessionPokemon.beginTransaction();

        ///pokemon da pokedex
        //     Pokemon pokemon = new Pokemon("squirtle", "Agua", null, 5, 200);


        try {
            List<Pokemon> listaPokemon = new ArrayList<>();



            // ADICIONE SEUS POKÉMONS AQUI:

            listaPokemon.add(new Pokemon("Bulbasaur", "Grama", "Venenoso", 1,       100));
            listaPokemon.add(new Pokemon("Ivysaur", "Grama", "Venenoso", 2,        120));
            listaPokemon.add(new Pokemon("Venusaur", "Grama", "Venenoso", 3,       150));
            listaPokemon.add(new Pokemon("Charmander", "Fogo", null, 4,            90));
            listaPokemon.add(new Pokemon("Charmeleon", "Fogo", null, 5,           110));
            listaPokemon.add(new Pokemon("Charizard", "Fogo", "Voador", 6,        160));
            listaPokemon.add(new Pokemon("Squirtle", "Água", null, 7,             95));
            listaPokemon.add(new Pokemon("Wartortle", "Água", null, 8,           115));
            listaPokemon.add(new Pokemon("Blastoise", "Água", null, 9,           155));
            listaPokemon.add(new Pokemon("Caterpie", "Inseto", null, 10,          45));
            listaPokemon.add(new Pokemon("Metapod", "Inseto", null, 11,           60));
            listaPokemon.add(new Pokemon("Butterfree", "Inseto", "Voador", 12,     80));
            listaPokemon.add(new Pokemon("Weedle", "Inseto", "Venenoso", 13,       50));
            listaPokemon.add(new Pokemon("Kakuna", "Inseto", "Venenoso", 14,        65));
            listaPokemon.add(new Pokemon("Beedrill", "Inseto", "Venenoso", 15,      85));
            listaPokemon.add(new Pokemon("Pidgey", "Normal", "Voador", 16,          60));
            listaPokemon.add(new Pokemon("Pidgeotto", "Normal", "Voador", 17,       80));
            listaPokemon.add(new Pokemon("Pidgeot", "Normal", "Voador", 18,         120));
            listaPokemon.add(new Pokemon("Rattata", "Normal", null, 19,             45));
            listaPokemon.add(new Pokemon("Raticate", "Normal", null, 20,            85));
            listaPokemon.add(new Pokemon("Spearow", "Normal", "Voador", 21,          55));
            listaPokemon.add(new Pokemon("Fearow", "Normal", "Voador", 22,          105));
            listaPokemon.add(new Pokemon("Ekans", "Venenoso", null, 23,              70));
            listaPokemon.add(new Pokemon("Arbok", "Venenoso", null, 24,             110));
            listaPokemon.add(new Pokemon("Pikachu", "Elétrico", null, 25,           100));
            listaPokemon.add(new Pokemon("Raichu", "Elétrico", null, 26,            130));
            listaPokemon.add(new Pokemon("Sandshrew", "Terrestre", null, 27,        75));
            listaPokemon.add(new Pokemon("Sandslash", "Terrestre", null, 28,        115));
            listaPokemon.add(new Pokemon("Nidoran♀", "Venenoso", null, 29,           55));
            listaPokemon.add(new Pokemon("Nidorina", "Venenoso", null, 30,           85));
            listaPokemon.add(new Pokemon("Nidoqueen", "Venenoso", "Terrestre", 31,  140));
            listaPokemon.add(new Pokemon("Nidoran♂", "Venenoso", null, 32,           55));
            listaPokemon.add(new Pokemon("Nidorino", "Venenoso", null, 33,           85));
            listaPokemon.add(new Pokemon("Nidoking", "Venenoso", "Terrestre", 34,    140));
            listaPokemon.add(new Pokemon("Clefairy", "Fada", null, 35,               95));
            listaPokemon.add(new Pokemon("Clefable", "Fada", null, 36,              130));
            listaPokemon.add(new Pokemon("Vulpix", "Fogo", null, 37,                75));
            listaPokemon.add(new Pokemon("Ninetales", "Fogo", null, 38,            115));
            listaPokemon.add(new Pokemon("Jigglypuff", "Normal", "Fada", 39,         115));
            listaPokemon.add(new Pokemon("Wigglytuff", "Normal", "Fada", 40,        145));
            listaPokemon.add(new Pokemon("Zubat", "Venenoso", "Voador", 41,          60));
            listaPokemon.add(new Pokemon("Golbat", "Venenoso", "Voador", 42,        100));
            listaPokemon.add(new Pokemon("Oddish", "Grama", "Venenoso", 43,           70));
            listaPokemon.add(new Pokemon("Gloom", "Grama", "Venenoso", 44,           95));
            listaPokemon.add(new Pokemon("Vileplume", "Grama", "Venenoso", 45,       125));
            listaPokemon.add(new Pokemon("Paras", "Inseto", "Grama", 46,             60));
            listaPokemon.add(new Pokemon("Parasect", "Inseto", "Grama", 47,         100));
            listaPokemon.add(new Pokemon("Venonat", "Inseto", "Venenoso", 48,        75));
            listaPokemon.add(new Pokemon("Venomoth", "Inseto", "Venenoso", 49,      105));
            listaPokemon.add(new Pokemon("Diglett", "Terrestre", null, 50,           40));
            listaPokemon.add(new Pokemon("Dugtrio", "Terrestre", null, 51,           80));
            listaPokemon.add(new Pokemon("Meowth", "Normal", null, 52,               60));
            listaPokemon.add(new Pokemon("Persian", "Normal", null, 53,             100));
            listaPokemon.add(new Pokemon("Psyduck", "Água", null, 54,                70));
            listaPokemon.add(new Pokemon("Golduck", "Água", null, 55,               115));
            listaPokemon.add(new Pokemon("Mankey", "Lutador", null, 56,              70));
            listaPokemon.add(new Pokemon("Primeape", "Lutador", null, 57,           105));
            listaPokemon.add(new Pokemon("Growlithe", "Fogo", null, 58,              80));
            listaPokemon.add(new Pokemon("Arcanine", "Fogo", null, 59,             140));
            listaPokemon.add(new Pokemon("Poliwag", "Água", null, 60,                65));
            listaPokemon.add(new Pokemon("Poliwhirl", "Água", null, 61,              90));
            listaPokemon.add(new Pokemon("Poliwrath", "Água", "Lutador", 62,         130));
            listaPokemon.add(new Pokemon("Abra", "Psíquico", null, 63,               40));
            listaPokemon.add(new Pokemon("Kadabra", "Psíquico", null, 64,           70));
            listaPokemon.add(new Pokemon("Alakazam", "Psíquico", null, 65,          110));
            listaPokemon.add(new Pokemon("Machop", "Lutador", null, 66,              80));
            listaPokemon.add(new Pokemon("Machoke", "Lutador", null, 67,            110));
            listaPokemon.add(new Pokemon("Machamp", "Lutador", null, 68,            140));
            listaPokemon.add(new Pokemon("Bellsprout", "Grama", "Venenoso", 69,      65));
            listaPokemon.add(new Pokemon("Weepinbell", "Grama", "Venenoso", 70,      90));
            listaPokemon.add(new Pokemon("Victreebel", "Grama", "Venenoso", 71,     120));
            listaPokemon.add(new Pokemon("Tentacool", "Água", "Venenoso", 72,        70));
            listaPokemon.add(new Pokemon("Tentacruel", "Água", "Venenoso", 73,      120));
            listaPokemon.add(new Pokemon("Geodude", "Pedra", "Terrestre", 74,        80));
            listaPokemon.add(new Pokemon("Graveler", "Pedra", "Terrestre", 75,     100));
            listaPokemon.add(new Pokemon("Golem", "Pedra", "Terrestre", 76,         130));
            listaPokemon.add(new Pokemon("Ponyta", "Fogo", null, 77,                 85));
            listaPokemon.add(new Pokemon("Rapidash", "Fogo", null, 78,              120));
            listaPokemon.add(new Pokemon("Slowpoke", "Água", "Psíquico", 79,        100));
            listaPokemon.add(new Pokemon("Slowbro", "Água", "Psíquico", 80,         130));
            listaPokemon.add(new Pokemon("Magnemite", "Elétrico", "Aço", 81,         60));
            listaPokemon.add(new Pokemon("Magneton", "Elétrico", "Aço", 82,         100));
            listaPokemon.add(new Pokemon("Farfetch’d", "Normal", "Voador", 83,       75));
            listaPokemon.add(new Pokemon("Doduo", "Normal", "Voador", 84,            70));
            listaPokemon.add(new Pokemon("Dodrio", "Normal", "Voador", 85,          110));
            listaPokemon.add(new Pokemon("Seel", "Água", null, 86,                  85));
            listaPokemon.add(new Pokemon("Dewgong", "Água", "Gelo", 87,             120));
            listaPokemon.add(new Pokemon("Grimer", "Venenoso", null, 88,            80));
            listaPokemon.add(new Pokemon("Muk", "Venenoso", null, 89,               120));
            listaPokemon.add(new Pokemon("Shellder", "Água", null, 90,              60));
            listaPokemon.add(new Pokemon("Cloyster", "Água", "Gelo", 91,            130));
            listaPokemon.add(new Pokemon("Gastly", "Fantasma", "Venenoso", 92,       60));
            listaPokemon.add(new Pokemon("Haunter", "Fantasma", "Venenoso", 93,      80));
            listaPokemon.add(new Pokemon("Gengar", "Fantasma", "Venenoso", 94,      120));
            listaPokemon.add(new Pokemon("Onix", "Pedra", "Terrestre", 95,          100));
            listaPokemon.add(new Pokemon("Drowzee", "Psíquico", null, 96,            75));
            listaPokemon.add(new Pokemon("Hypno", "Psíquico", null, 97,             110));
            listaPokemon.add(new Pokemon("Krabby", "Água", null, 98,                60));
            listaPokemon.add(new Pokemon("Kingler", "Água", null, 99,               110));
            listaPokemon.add(new Pokemon("Voltorb", "Elétrico", null, 100,           60));
            listaPokemon.add(new Pokemon("Electrode", "Elétrico", null, 11,         90));
            listaPokemon.add(new Pokemon("Exeggcute", "Grama", "Psíquico", 12,       70));
            listaPokemon.add(new Pokemon("Exeggutor", "Grama", "Psíquico", 13,     120));
            listaPokemon.add(new Pokemon("Cubone", "Terrestre", null, 14,            65));
            listaPokemon.add(new Pokemon("Marowak", "Terrestre", null, 15,          95));
            listaPokemon.add(new Pokemon("Hitmonlee", "Lutador", null, 16,         110));
            listaPokemon.add(new Pokemon("Hitmonchan", "Lutador", null, 17,        110));
            listaPokemon.add(new Pokemon("Lickitung", "Normal", null, 18,           90));
            listaPokemon.add(new Pokemon("Koffing", "Venenoso", null, 19,           70));
            listaPokemon.add(new Pokemon("Weezing", "Venenoso", null, 10,          120));
            listaPokemon.add(new Pokemon("Rhyhorn", "Terrestre", "Pedra", 11,        95));
            listaPokemon.add(new Pokemon("Rhydon", "Terrestre", "Pedra", 12,       130));
            listaPokemon.add(new Pokemon("Chansey", "Normal", null, 13,            250));
            listaPokemon.add(new Pokemon("Tangela", "Grama", null, 14,              90));
            listaPokemon.add(new Pokemon("Kangaskhan", "Normal", null, 15,         120));
            listaPokemon.add(new Pokemon("Horsea", "Água", null, 16,               65));
            listaPokemon.add(new Pokemon("Seadra", "Água", null, 17,              95));
            listaPokemon.add(new Pokemon("Goldeen", "Água", null, 18,              70));
            listaPokemon.add(new Pokemon("Seaking", "Água", null, 19,             100));
            listaPokemon.add(new Pokemon("Staryu", "Água", null, 20,               70));
            listaPokemon.add(new Pokemon("Starmie", "Água", "Psíquico", 21,        110));
            listaPokemon.add(new Pokemon("Mr. Mime", "Psíquico", "Fada", 22,         90));
            listaPokemon.add(new Pokemon("Scyther", "Inseto", "Voador", 23,       110));
            listaPokemon.add(new Pokemon("Jynx", "Gelo", "Psíquico", 24,            95));
            listaPokemon.add(new Pokemon("Electabuzz", "Elétrico", null, 25,       110));
            listaPokemon.add(new Pokemon("Magmar", "Fogo", null, 26,               110));
            listaPokemon.add(new Pokemon("Pinsir", "Inseto", null, 27,             100));
            listaPokemon.add(new Pokemon("Tauros", "Normal", null, 28,             100));
            listaPokemon.add(new Pokemon("Magikarp", "Água", null, 29,             30));
            listaPokemon.add(new Pokemon("Gyarados", "Água", "Voador", 30,         150));
            listaPokemon.add(new Pokemon("Lapras", "Água", "Gelo", 31,             130));
            listaPokemon.add(new Pokemon("Ditto", "Normal", null, 32,               60));
            listaPokemon.add(new Pokemon("Eevee", "Normal", null, 33,               85));
            listaPokemon.add(new Pokemon("Vaporeon", "Água", null, 34,            130));
            listaPokemon.add(new Pokemon("Jolteon", "Elétrico", null, 35,          110));
            listaPokemon.add(new Pokemon("Flareon", "Fogo", null, 36,              110));
            listaPokemon.add(new Pokemon("Porygon", "Normal", null, 37,            85));
            listaPokemon.add(new Pokemon("Omanyte", "Pedra", "Água", 38,           70));
            listaPokemon.add(new Pokemon("Omastar", "Pedra", "Água", 39,         110));
            listaPokemon.add(new Pokemon("Kabuto", "Pedra", "Água", 40,             70));
            listaPokemon.add(new Pokemon("Kabutops", "Pedra", "Água", 41,          110));
            listaPokemon.add(new Pokemon("Aerodactyl", "Pedra", "Voador", 42,      130));
            listaPokemon.add(new Pokemon("Snorlax", "Normal", null, 43,            160));
            listaPokemon.add(new Pokemon("Articuno", "Gelo", "Voador", 44,         140));
            listaPokemon.add(new Pokemon("Zapdos", "Elétrico", "Voador", 45,        140));
            listaPokemon.add(new Pokemon("Moltres", "Fogo", "Voador", 46,            140));
            listaPokemon.add(new Pokemon("Dratini", "Dragão", null, 47,            90));
            listaPokemon.add(new Pokemon("Dragonair", "Dragão", null, 48,          125));
            listaPokemon.add(new Pokemon("Dragonite", "Dragão", "Voador", 49,      160));
            listaPokemon.add(new Pokemon("Mewtwo", "Psíquico", null, 50,          200));
            listaPokemon.add(new Pokemon("Mew", "Psíquico", null, 51,              200));



            // Insere lista no banco usando o controller
            pokemonController.inserirListaPokemons(listaPokemon);

            JOptionPane.showMessageDialog(this, "Pokémons inseridos com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao inserir Pokémons: " + e.getMessage());
            e.printStackTrace();
        }

    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp().setVisible(true));

}
}












         /*

        // aluno da bibloteca
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Aluno.class);

        // aluno da bibloteca
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // aluno da bibloteca
        session.beginTransaction();

        // aluno da bibloteca
        Aluno aluno = new Aluno();
        aluno.setNome("Éverton");
        aluno.setIdade(16);
        aluno.setTelefone("97772617");

        session.save(aluno);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

 */








