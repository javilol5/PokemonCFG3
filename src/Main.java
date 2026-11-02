import services.AdestradorService;
import services.PokedexService;
import services.PokemonService;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {

        //1
/*
        PokedexService pokeSer = new PokedexService();

        //Inserir 10 pokemons en la tabla pokedex

        pokeSer.create(1, "Pikachu", 25, "El raton electrico");
        pokeSer.create(2, "Bulbasaur", 1, "El pokemon planta");
        pokeSer.create(3, "Charmander", 4, "El pokemon fuego");
        pokeSer.create(4, "Squirtle", 7, "El pokemon agua");
        pokeSer.create(5, "Jigglypuff", 39, "El pokemon hada");
        pokeSer.create(6, "Meowth", 52, "El gato salvaje");
        pokeSer.create(7, "Psyduck", 54, "El pokemon agua");
        pokeSer.create(8, "Mankey", 56, "El pokemon primate");
        pokeSer.create(9, "Growlithe", 58, "El pokemon perro");
        pokeSer.create(10, "Poliwag", 60, "El pokemon agua");

        //Listar pokemons na pokedex

        pokeSer.read();

        //Modificar duas entradas na pokedex

        pokeSer.update(1, "Pikachu Modificado", 250, "Pokemon electrico modificado");
        pokeSer.update(2, "Bulbasaur Modificado", 15, "Pokemon planta modificado");

        //Listar pokemons na pokedex

        pokeSer.read();

        //Eliminar tódo-los pokemons na pokedex

        pokeSer.delete();
*/
        //2
/*
        PokedexService pokeSer = new PokedexService();
        AdestradorService adSer = new AdestradorService();

        //Inserir 10 pokemons en la tabla pokedex

        pokeSer.create(1, "Pikachu", 25, "El raton electrico");
        pokeSer.create(2, "Bulbasaur", 1, "El pokemon planta");
        pokeSer.create(3, "Charmander", 4, "El pokemon fuego");
        pokeSer.create(4, "Squirtle", 7, "El pokemon agua");
        pokeSer.create(5, "Jigglypuff", 39, "El pokemon hada");
        pokeSer.create(6, "Meowth", 52, "El gato salvaje");
        pokeSer.create(7, "Psyduck", 54, "El pokemon agua");
        pokeSer.create(8, "Mankey", 56, "El pokemon primate");
        pokeSer.create(9, "Growlithe", 58, "El pokemon perro");
        pokeSer.create(10, "Poliwag", 60, "El pokemon agua");

        //Inserir 2 adestradores na taboa adestrador

        adSer.create("Ash Ketchum", LocalDate.of(2000, 5, 22));
        adSer.create("Misty", LocalDate.of(2001, 6, 15));

        //Listar pokemons na pokedex

        pokeSer.read();

        //Listar adestradores

        adSer.read();

        //Modificar dous adestradores

        adSer.update(1, "Ash Modificado", LocalDate.of(2000, 8, 10));
        adSer.update(2, "Misty Modificada", LocalDate.of(2001, 9, 20));

        //Modificar duas entradas na pokedex

        pokeSer.update(3, "Charmander Modificado", 8, "Pokemon fuego modificado");
        pokeSer.update(4, "Squirtle Modificado", 10, "Pokemon agua modificado");

        //Listar pokemons na pokedex

        pokeSer.read();

        //Listar adestradores

        adSer.read();

        //(toXML pokemons)

        pokeSer.toXML();

        //(toXML adestradores)

        adSer.toXML();

        //Eliminar tódo-los datos das táboas

        pokeSer.delete();
        adSer.delete();
*/
        //3

        PokedexService pokeSer = new PokedexService();
        AdestradorService adSer = new AdestradorService();
        PokemonService pokemonSer = new PokemonService();

        //Inserir 10 pokemons en la tabla pokedex

        pokeSer.create(1, "Pikachu", 25, "El raton electrico");
        pokeSer.create(2, "Bulbasaur", 1, "El pokemon planta");
        pokeSer.create(3, "Charmander", 4, "El pokemon fuego");
        pokeSer.create(4, "Squirtle", 7, "El pokemon agua");
        pokeSer.create(5, "Jigglypuff", 39, "El pokemon hada");
        pokeSer.create(6, "Meowth", 52, "El gato salvaje");
        pokeSer.create(7, "Psyduck", 54, "El pokemon agua");
        pokeSer.create(8, "Mankey", 56, "El pokemon primate");
        pokeSer.create(9, "Growlithe", 58, "El pokemon perro");
        pokeSer.create(10, "Poliwag", 60, "El pokemon agua");

        //Inserir 2 adestradores na taboa adestrador

        adSer.create("Ash Ketchum", LocalDate.of(2000, 5, 22));
        adSer.create("Misty", LocalDate.of(2001, 6, 15));

        //Inserir 12 pokemons na taboa de pokemon (6 para cada adestrador)

        // Adestrador 1
        pokemonSer.create("Pikachu", LocalDate.of(2020, 1, 10), 1, 1);
        pokemonSer.create("Raichu", LocalDate.of(2020, 2, 15), 2, 1);
        pokemonSer.create("Bulbasaur", LocalDate.of(2020, 3, 20), 3, 1);
        pokemonSer.create("Ivysaur", LocalDate.of(2020, 4, 25), 4, 1);
        pokemonSer.create("Charmander", LocalDate.of(2020, 5, 10), 5, 1);
        pokemonSer.create("Charmeleon", LocalDate.of(2020, 6, 15), 6, 1);

        // Adestrador 2
        pokemonSer.create("Squirtle", LocalDate.of(2020, 1, 12), 7, 2);
        pokemonSer.create("Wartortle", LocalDate.of(2020, 2, 17), 8, 2);
        pokemonSer.create("Jigglypuff", LocalDate.of(2020, 3, 22), 9, 2);
        pokemonSer.create("Meowth", LocalDate.of(2020, 4, 27), 10, 2);
        pokemonSer.create("Psyduck", LocalDate.of(2020, 5, 12), 11, 2);
        pokemonSer.create("Mankey", LocalDate.of(2020, 6, 17), 12, 2);

        //Listar pokemons na pokedex

        pokemonSer.read();

        //Listar adestradores

        adSer.read();

        //Listar pokemons na táboa pokemon

        pokemonSer.read();

        //Exportar nun arquivo duas entradas da pokedex serializadas

        pokeSer.serializar(1, 2);

        //Exportar en XML duas entradas de adestrador

        adSer.toXML(1, 2);

        //Modificar duas entradas na pokedex (as mesmas serializadas)

        pokeSer.update(1, "Pikachu Modificado", 30, "Datos modificados");
        pokeSer.update(2, "Bulbasaur Modificado", 10, "Datos modificados");

        //Modificar dous adestradores(os mesmos exportados a xml)

        adSer.update(1, "Ash Modificado", LocalDate.of(2005, 5, 22));
        adSer.update(2, "Misty Modificada", LocalDate.of(2006, 6, 15));

        //Modificar 4 pokemons

        pokemonSer.update(1, "Pikachu Modificado", LocalDate.of(2021, 1, 10), 1, 1);
        pokemonSer.update(2, "Raichu Modificado", LocalDate.of(2021, 2, 15), 2, 1);
        pokemonSer.update(7, "Squirtle Modificado", LocalDate.of(2021, 1, 12), 7, 2);
        pokemonSer.update(8, "Wartortle Modificado", LocalDate.of(2021, 2, 17), 8, 2);

        //Listar pokemons na pokedex

        pokeSer.read();

        //Listar adestradores

        adSer.read();

        //Listar pokemons na táboa pokemon

        pokemonSer.read();

        //Importar os datos serializados

        pokeSer.deserializar();

        //Modifica-las entradas da pokédex coos datos serializados (de xeito que queden igual que despois do primeiro insert)

        pokeSer.restaurarSerializados();

        //Importar os datos xml

        adSer.importarXML();

        //Modifica-las entradas de adestradores coos datos do arquivo (de xeito que queden igual que despois do primeiro insert)

        adSer.restaurarXML();

        //Lista-los datos das táboas

        pokeSer.read();
        adSer.read();
        pokemonSer.read();

        //Eliminar tódo-los datos das táboas

        pokemonSer.delete();
        pokeSer.delete();
        adSer.delete();

    }
}