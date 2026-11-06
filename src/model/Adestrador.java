package model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "adestrador")
public class Adestrador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private LocalDate nacemento;

    public Adestrador() {
    }

    public Adestrador(String nome, LocalDate nacemento) {
        this.nome = nome;
        this.nacemento = nacemento;
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

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public LocalDate getNacemento() {
        return nacemento;
    }


    @Override
    public String toString() {
        return "Id: " + id +
                " | Nome: " + nome +
                " | Nacemento: " + nacemento;
    }
}