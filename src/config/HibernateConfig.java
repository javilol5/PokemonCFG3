package config;

import model.Pokedex;
import model.Adestrador;
import model.Pokemon;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.io.*;

public class HibernateConfig {

    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    static {
        try {
            // Se elimina "resources/" para que busque directamente en el classpath
            standardServiceRegistry = new StandardServiceRegistryBuilder().configure("resources/properties.xml").build();
            MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);

            // Registramos explícitamente las entidades mapeadas con @Entity
           // metadataSources.addAnnotatedClass(Pokedex.class);
            // metadataSources.addAnnotatedClass(javier.casal.model.Adestrador.class); // Descomentar cuando la anotes
            // metadataSources.addAnnotatedClass(javier.casal.model.Pokemon.class);    // Descomentar cuando la anotes

            Metadata metadata = metadataSources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();

        } catch (Exception e) {
            // Mostramos el error real en la consola en lugar de ocultarlo
            System.err.println("Erro ao inicializar a SessionFactory de Hibernate:");
            e.printStackTrace();

            if (standardServiceRegistry != null) {
                StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
            }
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}