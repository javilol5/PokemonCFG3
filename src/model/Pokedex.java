package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pokedex")
public class Pokedex implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "peso", nullable = false)
    private double peso;

    @Column(name = "misc", length = 200, nullable = true)
    private String misc;

    public Pokedex() {
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setMisc(String misc) {
        this.misc = misc;
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public double getPeso() {
        return peso;
    }
    public String getMisc() {
        return misc;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                " | Nome: " + nome +
                " | Peso: " + peso +
                " | Misc: " + misc;
    }
}