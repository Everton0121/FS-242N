import Controller.PokemonController;
import Model.Pokemon;
import View.ListaPokemonsPanel;
import View.PokemonForm;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    private JDesktopPane desktopPane;
    private PokemonController pokemonController;
    int i = 0;

    public MainFrame() {
        super("Sistema de Gerenciamento de Pokémons");
        this.pokemonController = new PokemonController();

        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        createMenuBar();
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
        itemInserirListaPokemons.addActionListener(e -> {
            try {
                openInsereListaPokemonsPanel();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

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

    private void openInsereListaPokemonsPanel() throws Exception {
        List<Pokemon> listaPokemon = new ArrayList<>();

        // KANTO

        Pokemon pikachu = new Pokemon("Pikachu", "Elétrico", null, 1, 100);

        listaPokemon.add(new Pokemon("Bulbasaur", "Grama", "Venenoso", 1, 100));
        listaPokemon.add(new Pokemon("Ivysaur", "Grama", "Venenoso", 2, 120));
        listaPokemon.add(new Pokemon("Venusaur", "Grama", "Venenoso", 3, 150));
        listaPokemon.add(new Pokemon("Charmander", "Fogo", null, 4, 90));
        listaPokemon.add(new Pokemon("Charmeleon", "Fogo", null, 5, 110));
        listaPokemon.add(new Pokemon("Charizard", "Fogo", "Voador", 6, 160));
        listaPokemon.add(new Pokemon("Squirtle", "Água", null, 7, 95));
        listaPokemon.add(new Pokemon("Wartortle", "Água", null, 8, 115));
        listaPokemon.add(new Pokemon("Blastoise", "Água", null, 9, 155));
        listaPokemon.add(new Pokemon("Caterpie", "Inseto", null, 10, 45));
        listaPokemon.add(new Pokemon("Metapod", "Inseto", null, 11, 60));
        listaPokemon.add(new Pokemon("Butterfree", "Inseto", "Voador", 12, 80));
        listaPokemon.add(new Pokemon("Weedle", "Inseto", "Venenoso", 13, 50));
        listaPokemon.add(new Pokemon("Kakuna", "Inseto", "Venenoso", 14, 65));
        listaPokemon.add(new Pokemon("Beedrill", "Inseto", "Venenoso", 15, 85));
        listaPokemon.add(new Pokemon("Pidgey", "Normal", "Voador", 16, 60));
        listaPokemon.add(new Pokemon("Pidgeotto", "Normal", "Voador", 17, 80));
        listaPokemon.add(new Pokemon("Pidgeot", "Normal", "Voador", 18, 120));
        listaPokemon.add(new Pokemon("Rattata", "Normal", null, 19, 45));
        listaPokemon.add(new Pokemon("Raticate", "Normal", null, 20, 85));
        listaPokemon.add(new Pokemon("Spearow", "Normal", "Voador", 21, 55));
        listaPokemon.add(new Pokemon("Fearow", "Normal", "Voador", 22, 105));
        listaPokemon.add(new Pokemon("Ekans", "Venenoso", null, 23, 70));
        listaPokemon.add(new Pokemon("Arbok", "Venenoso", null, 24, 110));
        listaPokemon.add(new Pokemon("Raichu", "Elétrico", null, 26, 130));
        listaPokemon.add(new Pokemon("Sandshrew", "Terrestre", null, 27, 75));
        listaPokemon.add(new Pokemon("Sandslash", "Terrestre", null, 28, 115));
        listaPokemon.add(new Pokemon("Nidoran♀", "Venenoso", null, 29, 55));
        listaPokemon.add(new Pokemon("Nidorina", "Venenoso", null, 30, 85));
        listaPokemon.add(new Pokemon("Nidoqueen", "Venenoso", "Terrestre", 31, 140));
        listaPokemon.add(new Pokemon("Nidoran♂", "Venenoso", null, 32, 55));
        listaPokemon.add(new Pokemon("Nidorino", "Venenoso", null, 33, 85));
        listaPokemon.add(new Pokemon("Nidoking", "Venenoso", "Terrestre", 34, 140));
        listaPokemon.add(new Pokemon("Clefairy", "Fada", null, 35, 95));
        listaPokemon.add(new Pokemon("Clefable", "Fada", null, 36, 130));
        listaPokemon.add(new Pokemon("Vulpix", "Fogo", null, 37, 75));
        listaPokemon.add(new Pokemon("Ninetales", "Fogo", null, 38, 115));
        listaPokemon.add(new Pokemon("Jigglypuff", "Normal", "Fada", 39, 115));
        listaPokemon.add(new Pokemon("Wigglytuff", "Normal", "Fada", 40, 145));
        listaPokemon.add(new Pokemon("Zubat", "Venenoso", "Voador", 41, 60));
        listaPokemon.add(new Pokemon("Golbat", "Venenoso", "Voador", 42, 100));
        listaPokemon.add(new Pokemon("Oddish", "Grama", "Venenoso", 43, 70));
        listaPokemon.add(new Pokemon("Gloom", "Grama", "Venenoso", 44, 95));
        listaPokemon.add(new Pokemon("Vileplume", "Grama", "Venenoso", 45, 125));
        listaPokemon.add(new Pokemon("Paras", "Inseto", "Grama", 46, 60));
        listaPokemon.add(new Pokemon("Parasect", "Inseto", "Grama", 47, 100));
        listaPokemon.add(new Pokemon("Venonat", "Inseto", "Venenoso", 48, 75));
        listaPokemon.add(new Pokemon("Venomoth", "Inseto", "Venenoso", 49, 105));
        listaPokemon.add(new Pokemon("Diglett", "Terrestre", null, 50, 40));
        listaPokemon.add(new Pokemon("Dugtrio", "Terrestre", null, 51, 80));
        listaPokemon.add(new Pokemon("Meowth", "Normal", null, 52, 60));
        listaPokemon.add(new Pokemon("Persian", "Normal", null, 53, 100));
        listaPokemon.add(new Pokemon("Psyduck", "Água", null, 54, 70));
        listaPokemon.add(new Pokemon("Golduck", "Água", null, 55, 115));
        listaPokemon.add(new Pokemon("Mankey", "Lutador", null, 56, 70));
        listaPokemon.add(new Pokemon("Primeape", "Lutador", null, 57, 105));
        listaPokemon.add(new Pokemon("Growlithe", "Fogo", null, 58, 80));
        listaPokemon.add(new Pokemon("Arcanine", "Fogo", null, 59, 140));
        listaPokemon.add(new Pokemon("Poliwag", "Água", null, 60, 65));
        listaPokemon.add(new Pokemon("Poliwhirl", "Água", null, 61, 90));
        listaPokemon.add(new Pokemon("Poliwrath", "Água", "Lutador", 62, 130));
        listaPokemon.add(new Pokemon("Abra", "Psíquico", null, 63, 40));
        listaPokemon.add(new Pokemon("Kadabra", "Psíquico", null, 64, 70));
        listaPokemon.add(new Pokemon("Alakazam", "Psíquico", null, 65, 110));
        listaPokemon.add(new Pokemon("Machop", "Lutador", null, 66, 80));
        listaPokemon.add(new Pokemon("Machoke", "Lutador", null, 67, 110));
        listaPokemon.add(new Pokemon("Machamp", "Lutador", null, 68, 140));
        listaPokemon.add(new Pokemon("Bellsprout", "Grama", "Venenoso", 69, 65));
        listaPokemon.add(new Pokemon("Weepinbell", "Grama", "Venenoso", 70, 90));
        listaPokemon.add(new Pokemon("Victreebel", "Grama", "Venenoso", 71, 120));
        listaPokemon.add(new Pokemon("Tentacool", "Água", "Venenoso", 72, 70));
        listaPokemon.add(new Pokemon("Tentacruel", "Água", "Venenoso", 73, 120));
        listaPokemon.add(new Pokemon("Geodude", "Pedra", "Terrestre", 74, 80));
        listaPokemon.add(new Pokemon("Graveler", "Pedra", "Terrestre", 75, 100));
        listaPokemon.add(new Pokemon("Golem", "Pedra", "Terrestre", 76, 130));
        listaPokemon.add(new Pokemon("Ponyta", "Fogo", null, 77, 85));
        listaPokemon.add(new Pokemon("Rapidash", "Fogo", null, 78, 120));
        listaPokemon.add(new Pokemon("Slowpoke", "Água", "Psíquico", 79, 100));
        listaPokemon.add(new Pokemon("Slowbro", "Água", "Psíquico", 80, 130));
        listaPokemon.add(new Pokemon("Magnemite", "Elétrico", "Aço", 81, 60));
        listaPokemon.add(new Pokemon("Magneton", "Elétrico", "Aço", 82, 100));
        listaPokemon.add(new Pokemon("Farfetch’d", "Normal", "Voador", 83, 75));
        listaPokemon.add(new Pokemon("Doduo", "Normal", "Voador", 84, 70));
        listaPokemon.add(new Pokemon("Dodrio", "Normal", "Voador", 85, 110));
        listaPokemon.add(new Pokemon("Seel", "Água", null, 86, 85));
        listaPokemon.add(new Pokemon("Dewgong", "Água", "Gelo", 87, 120));
        listaPokemon.add(new Pokemon("Grimer", "Venenoso", null, 88, 80));
        listaPokemon.add(new Pokemon("Muk", "Venenoso", null, 89, 120));
        listaPokemon.add(new Pokemon("Shellder", "Água", null, 90, 60));
        listaPokemon.add(new Pokemon("Cloyster", "Água", "Gelo", 91, 130));
        listaPokemon.add(new Pokemon("Gastly", "Fantasma", "Venenoso", 92, 60));
        listaPokemon.add(new Pokemon("Haunter", "Fantasma", "Venenoso", 93, 80));
        listaPokemon.add(new Pokemon("Gengar", "Fantasma", "Venenoso", 94, 120));
        listaPokemon.add(new Pokemon("Onix", "Pedra", "Terrestre", 95, 100));
        listaPokemon.add(new Pokemon("Drowzee", "Psíquico", null, 96, 75));
        listaPokemon.add(new Pokemon("Hypno", "Psíquico", null, 97, 110));
        listaPokemon.add(new Pokemon("Krabby", "Água", null, 98, 60));
        listaPokemon.add(new Pokemon("Kingler", "Água", null, 99, 110));
        listaPokemon.add(new Pokemon("Voltorb", "Elétrico", null, 100, 60));
        listaPokemon.add(new Pokemon("Electrode", "Elétrico", null, 100, 90));
        listaPokemon.add(new Pokemon("Exeggcute", "Grama", "Psíquico", 100, 70));
        listaPokemon.add(new Pokemon("Exeggutor", "Grama", "Psíquico", 100, 120));
        listaPokemon.add(new Pokemon("Cubone", "Terrestre", null, 100, 65));
        listaPokemon.add(new Pokemon("Marowak", "Terrestre", null, 100, 95));
        listaPokemon.add(new Pokemon("Hitmonlee", "Lutador", null, 100, 110));
        listaPokemon.add(new Pokemon("Hitmonchan", "Lutador", null, 100, 110));
        listaPokemon.add(new Pokemon("Lickitung", "Normal", null, 100, 90));
        listaPokemon.add(new Pokemon("Koffing", "Venenoso", null, 100, 70));
        listaPokemon.add(new Pokemon("Weezing", "Venenoso", null, 100, 120));
        listaPokemon.add(new Pokemon("Rhyhorn", "Terrestre", "Pedra", 100, 95));
        listaPokemon.add(new Pokemon("Rhydon", "Terrestre", "Pedra", 100, 130));
        listaPokemon.add(new Pokemon("Chansey", "Normal", null, 100, 250));
        listaPokemon.add(new Pokemon("Tangela", "Grama", null, 100, 90));
        listaPokemon.add(new Pokemon("Kangaskhan", "Normal", null, 100, 120));
        listaPokemon.add(new Pokemon("Horsea", "Água", null, 100, 65));
        listaPokemon.add(new Pokemon("Seadra", "Água", null, 100, 95));
        listaPokemon.add(new Pokemon("Goldeen", "Água", null, 100, 70));
        listaPokemon.add(new Pokemon("Seaking", "Água", null, 100, 100));
        listaPokemon.add(new Pokemon("Staryu", "Água", null, 100, 70));
        listaPokemon.add(new Pokemon("Starmie", "Água", "Psíquico", 100, 110));
        listaPokemon.add(new Pokemon("Mr. Mime", "Psíquico", "Fada", 100, 90));
        listaPokemon.add(new Pokemon("Scyther", "Inseto", "Voador", 100, 110));
        listaPokemon.add(new Pokemon("Jynx", "Gelo", "Psíquico", 100, 95));
        listaPokemon.add(new Pokemon("Electabuzz", "Elétrico", null, 100, 110));
        listaPokemon.add(new Pokemon("Magmar", "Fogo", null, 100, 110));
        listaPokemon.add(new Pokemon("Pinsir", "Inseto", null, 100, 100));
        listaPokemon.add(new Pokemon("Tauros", "Normal", null, 100, 100));
        listaPokemon.add(new Pokemon("Magikarp", "Água", null, 100, 30));
        listaPokemon.add(new Pokemon("Gyarados", "Água", "Voador", 100, 150));
        listaPokemon.add(new Pokemon("Lapras", "Água", "Gelo", 100, 130));
        listaPokemon.add(new Pokemon("Ditto", "Normal", null, 100, 60));
        listaPokemon.add(new Pokemon("Eevee", "Normal", null, 100, 85));
        listaPokemon.add(new Pokemon("Vaporeon", "Água", null, 100, 130));
        listaPokemon.add(new Pokemon("Jolteon", "Elétrico", null, 100, 110));
        listaPokemon.add(new Pokemon("Flareon", "Fogo", null, 100, 110));
        listaPokemon.add(new Pokemon("Porygon", "Normal", null, 100, 85));
        listaPokemon.add(new Pokemon("Omanyte", "Pedra", "Água", 100, 70));
        listaPokemon.add(new Pokemon("Omastar", "Pedra", "Água", 100, 110));
        listaPokemon.add(new Pokemon("Kabuto", "Pedra", "Água", 100, 70));
        listaPokemon.add(new Pokemon("Kabutops", "Pedra", "Água", 100, 110));
        listaPokemon.add(new Pokemon("Aerodactyl", "Pedra", "Voador", 100, 130));
        listaPokemon.add(new Pokemon("Snorlax", "Normal", null, 100, 160));
        listaPokemon.add(new Pokemon("Articuno", "Gelo", "Voador", 100, 140));
        listaPokemon.add(new Pokemon("Zapdos", "Elétrico", "Voador", 100, 140));
        listaPokemon.add(new Pokemon("Moltres", "Fogo", "Voador", 100, 140));

        // ALOLA

        listaPokemon.add(new Pokemon("Rattata (Alola)", "Noturno", "Normal", 19, 45));
        listaPokemon.add(new Pokemon("Raticate (Alola)", "Noturno", "Normal", 20, 85));
        listaPokemon.add(new Pokemon("Raichu (Alola)", "Elétrico", "Psíquico", 26, 130));
        listaPokemon.add(new Pokemon("Sandshrew (Alola)", "Gelo", "Aço", 27, 75));
        listaPokemon.add(new Pokemon("Sandslash (Alola)", "Gelo", "Aço", 28, 115));
        listaPokemon.add(new Pokemon("Vulpix (Alola)", "Gelo", null, 37, 75));
        listaPokemon.add(new Pokemon("Ninetales (Alola)", "Gelo", "Fada", 38, 115));
        listaPokemon.add(new Pokemon("Diglett (Alola)", "Terrestre", "Aço", 50, 40));
        listaPokemon.add(new Pokemon("Dugtrio (Alola)", "Terrestre", "Aço", 51, 80));
        listaPokemon.add(new Pokemon("Meowth (Alola)", "Noturno", null, 52, 60));
        listaPokemon.add(new Pokemon("Persian (Alola)", "Noturno", null, 53, 100));
        listaPokemon.add(new Pokemon("Geodude (Alola)", "Pedra", "Elétrico", 74, 80));
        listaPokemon.add(new Pokemon("Graveler (Alola)", "Pedra", "Elétrico", 75, 100));
        listaPokemon.add(new Pokemon("Golem (Alola)", "Pedra", "Elétrico", 76, 130));
        listaPokemon.add(new Pokemon("Grimer (Alola)", "Venenoso", "Noturno", 88, 80));
        listaPokemon.add(new Pokemon("Muk (Alola)", "Venenoso", "Noturno", 89, 120));
        listaPokemon.add(new Pokemon("Exeggutor (Alola)", "Grama", "Dragão", 100, 120));
        listaPokemon.add(new Pokemon("Marowak (Alola)", "Fogo", "Fantasma", 100, 95));

        // GALAR

        listaPokemon.add(new Pokemon("Meowth (Galar)", "Aço", null, 52, 60));
        listaPokemon.add(new Pokemon("Ponyta (Galar)", "Psíquico", null, 77, 85));
        listaPokemon.add(new Pokemon("Rapidash (Galar)", "Psíquico", "Fada", 78, 120));
        listaPokemon.add(new Pokemon("Farfetch’d (Galar)", "Lutador", null, 83, 75));
        listaPokemon.add(new Pokemon("Weezing (Galar)", "Venenoso", "Fada", 100, 120));
        listaPokemon.add(new Pokemon("Mr. Mime (Galar)", "Gelo", "Psíquico", 100, 90));

        // HISUI

        listaPokemon.add(new Pokemon("Growlithe (Hisui)", "Fogo", "Pedra", 58, 80));
        listaPokemon.add(new Pokemon("Arcanine (Hisui)", "Fogo", "Pedra", 59, 140));
        listaPokemon.add(new Pokemon("Voltorb (Hisui)", "Elétrico", "Grama", 100, 60));
        listaPokemon.add(new Pokemon("Electrode (Hisui)", "Elétrico", "Grama", 100, 90));
        listaPokemon.add(new Pokemon("Typhlosion (Hisui)", "Fogo", "Fantasma", 100, 150)); // Não está na lista original, mas é evolução de Cyndaquil
        listaPokemon.add(new Pokemon("Qwilfish (Hisui)", "Venenoso", "Noturno", 100, 80));
        listaPokemon.add(new Pokemon("Sneasel (Hisui)", "Venenoso", "Lutador", 100, 85));

        // PALDEA

        listaPokemon.add(new Pokemon("Tauros (Paldea - Combate)", "Lutador", null, 100, 100));
        listaPokemon.add(new Pokemon("Tauros (Paldea - Água)", "Lutador", "Água", 100, 100));
        listaPokemon.add(new Pokemon("Tauros (Paldea - Fogo)", "Lutador", "Fogo", 100, 100));

        // Evoluções Exclusivas de Formas Regionais

        // Galar
        listaPokemon.add(new Pokemon("Sirfetch’d", "Lutador", null, 76, 120)); // Evolui de Farfetch’d (Galar)
        listaPokemon.add(new Pokemon("Mr. Rime", "Gelo", "Psíquico", 43, 110)); // Evolui de Mr. Mime (Galar)
        listaPokemon.add(new Pokemon("Runerigus", "Fantasma", "Terrestre", 81, 130)); // Evolui de Yamask (Galar)

        // Hisui
        listaPokemon.add(new Pokemon("Kleavor", "Inseto", "Pedra", 100, 110)); // Evolui de Scyther em Hisui
        listaPokemon.add(new Pokemon("Wyrdeer", "Normal", "Psíquico", 42, 120)); // Evolui de Stantler em Hisui
        listaPokemon.add(new Pokemon("Basculegion", "Água", "Fantasma", 84, 130)); // Evolui de Basculin (Hisui)
        listaPokemon.add(new Pokemon("Overqwil", "Venenoso", "Noturno", 18, 110)); // Evolui de Qwilfish (Hisui)
        listaPokemon.add(new Pokemon("Sneasler", "Lutador", "Venenoso", 32, 115)); // Evolui de Sneasel (Hisui)
        listaPokemon.add(new Pokemon("Ursaluna", "Terrestre", "Normal", 52, 150)); // Evolui de Ursaring em Hisui

       // Paldea
        listaPokemon.add(new Pokemon("Kingambit", "Sombrio", "Aço", 85, 140)); // Evolui de Bisharp
        listaPokemon.add(new Pokemon("Annihilape", "Lutador", "Fantasma", 93, 130)); // Evolui de Primeape
        listaPokemon.add(new Pokemon("Farigiraf", "Normal", "Psíquico", 94, 130)); // Evolui de Girafarig
        listaPokemon.add(new Pokemon("Dudunsparce", "Normal", null, 61, 120)); // Evolui de Dunsparce
        listaPokemon.add(new Pokemon("Clodsire", "Venenoso", "Terrestre", 41, 130)); // Evolui de Wooper (Paldea)
        listaPokemon.add(pikachu);


        // Pokémon-base para evoluções regionais

        // Galar
        listaPokemon.add(new Pokemon("Yamask (Galar)", "Fantasma", "Terrestre", 62, 60)); // Evolui para Runerigus


        // Obs: Você já tem o Farfetch’d (Galar) e Mr. Mime (Galar) na lista.

       // Hisui
        listaPokemon.add(new Pokemon("Stantler", "Normal", null, 22, 95)); // Evolui para Wyrdeer
        listaPokemon.add(new Pokemon("Basculin (Hisui)", "Água", null, 55, 85)); // Evolui para Basculegion
        listaPokemon.add(new Pokemon("Ursaring", "Normal", null, 17, 130)); // Evolui para Ursaluna

        //   Obs: Scyther já está na sua lista (como nº 123), então pode evoluir para Kleavor.

        // Paldea
        listaPokemon.add(new Pokemon("Wooper (Paldea)", "Venenoso", "Terrestre", 19, 55)); // Evolui para Clodsire
        listaPokemon.add(new Pokemon("Girafarig", "Normal", "Psíquico", 39, 95)); // Evolui para Farigiraf
        listaPokemon.add(new Pokemon("Dunsparce", "Normal", null, 6, 80)); // Evolui para Dudunsparce
        listaPokemon.add(new Pokemon("Bisharp", "Sombrio", "Aço", 25, 100)); // Evolui para Kingambit
        pokemonController.inserirListaPokemons(listaPokemon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}