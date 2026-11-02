package services;

import config.HibernateConfig;
import model.Pokemon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class PokemonService {

    // CREATE
    public void create(String nome, LocalDate nacemento, int pokedexEntry, int adestrador) {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            Pokemon px = new Pokemon(nome, nacemento, pokedexEntry, adestrador);

            session.save(px);

            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // READ
    public void read() {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            List<Pokemon> lista = session.createQuery("FROM Pokemon", Pokemon.class).list();

            for (Pokemon px : lista) {
                System.out.println(px);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // UPDATE
    public void update(int id, String nome, LocalDate nacemento, int pokedexEntry, int destrador) {

        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Pokemon pokemon = session.get(Pokemon.class, id);

            if (pokemon != null) {
                pokemon.setNome(nome);
                pokemon.setNacemento(nacemento);
                pokemon.setPokedexEntry(pokedexEntry);
                pokemon.setDestrador(destrador);

                session.update(pokemon);
                transaction.commit();

                System.out.println("Pokemon actualizado correctamente.");
            } else {
                System.out.println("No existe un Pokemon con ese ID.");
                transaction.rollback();
            }

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // DELETE
    public void delete() {

        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.createQuery("DELETE FROM Pokemon").executeUpdate();

            transaction.commit();

            System.out.println("Todos los pokemons eliminados.");

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}