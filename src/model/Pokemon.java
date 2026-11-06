package model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "pokemon")
public class Pokemon implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private LocalDate nacemento;
    private int pokedexEntry;
    private int destrador;

    public Pokemon() {
    }

    public Pokemon(String nome, LocalDate nacemento, int pokedexEntry, int destrador) {
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokedexEntry = pokedexEntry;
        this.destrador = destrador;
    }



    public void setId(int id) {
        this.id = id;
    }
        public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNacemento(LocalDate nacemento) {
        this.nacemento = nacemento;
    }
    public void setPokedexEntry(int pokedexEntry) {
        this.pokedexEntry = pokedexEntry;
    }
    public void setDestrador(int destrador) {
        this.destrador = destrador;
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public LocalDate getNacemento() {
        return nacemento;
    }
    public int getPokedexEntry() {
        return pokedexEntry;
    }
    public int getDestrador() {
        return destrador;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                " | Nome: " + nome +
                " | Nacemento: " + nacemento +
                " | Pokedex Entry: " + pokedexEntry +
                " | Destrador: " + destrador;
    }
}