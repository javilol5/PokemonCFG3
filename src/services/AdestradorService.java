package services;

import config.HibernateConfig;
import model.Adestrador;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.*;
import java.time.LocalDate;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.NodeList;

public class AdestradorService {

    // CREATE
    public void create(String nome, LocalDate nacemento) {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            Adestrador ad = new Adestrador(nome, nacemento);

            session.save(ad);

            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // READ
    public void read() {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            List<Adestrador> lista = session.createQuery("FROM Adestrador", Adestrador.class).list();

            for (Adestrador ad : lista) {
                System.out.println(ad);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // UPDATE
    public void update(int id, String nome, LocalDate nacemento) {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            Adestrador ad = session.get(Adestrador.class, id);

            if (ad != null) {
                ad.setNome(nome);
                ad.setNacemento(nacemento);

                session.update(ad);
            }

            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // TO XML
    public void toXML() {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            List<Adestrador> lista = session.createQuery("FROM Adestrador", Adestrador.class).list();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document documento = builder.newDocument();

            Element raiz = documento.createElement("adestradores");
            documento.appendChild(raiz);

            for (Adestrador ad : lista) {

                Element adestrador = documento.createElement("adestrador");

                Element id = documento.createElement("id");
                id.setTextContent(String.valueOf(ad.getId()));

                Element nome = documento.createElement("nome");
                nome.setTextContent(ad.getNome());

                Element nacemento = documento.createElement("nacemento");
                nacemento.setTextContent(ad.getNacemento().toString());

                adestrador.appendChild(id);
                adestrador.appendChild(nome);
                adestrador.appendChild(nacemento);

                raiz.appendChild(adestrador);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File("adestradores.xml"));

            transformer.transform(source, result);

            System.out.println("XML de adestradores creado correctamente.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // DELETE
    public void delete() {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            session.createQuery("DELETE FROM Adestrador").executeUpdate();

            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void toXML(int id1, int id2) {

        try {
            Session session = HibernateConfig.getSessionFactory().openSession();

            Adestrador ad1 = session.get(Adestrador.class, id1);
            Adestrador ad2 = session.get(Adestrador.class, id2);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();

            Element raiz = documento.createElement("adestradores");
            documento.appendChild(raiz);

            Adestrador[] adestradores = {ad1, ad2};

            for (Adestrador ad : adestradores) {

                if (ad != null) {
                    Element adestrador = documento.createElement("adestrador");

                    Element id = documento.createElement("id");
                    id.setTextContent(String.valueOf(ad.getId()));
                    adestrador.appendChild(id);

                    Element nome = documento.createElement("nome");
                    nome.setTextContent(ad.getNome());
                    adestrador.appendChild(nome);

                    Element nacemento = documento.createElement("nacemento");
                    nacemento.setTextContent(ad.getNacemento().toString());
                    adestrador.appendChild(nacemento);

                    raiz.appendChild(adestrador);
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File("adestradores_parte3.xml"));

            transformer.transform(source, result);

            session.close();

            System.out.println("Adestradores exportados a XML.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // IMPORTAR XML
    public void importarXML() {

        try {
            File archivo = new File("adestradores_parte3.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(archivo);

            NodeList lista = documento.getElementsByTagName("adestrador");

            for (int i = 0; i < lista.getLength(); i++) {

                Element elemento = (Element) lista.item(i);

                int id = Integer.parseInt(elemento.getElementsByTagName("id").item(0).getTextContent());
                String nome = elemento.getElementsByTagName("nome").item(0).getTextContent();
                LocalDate nacemento = LocalDate.parse(
                        elemento.getElementsByTagName("nacemento").item(0).getTextContent()
                );

                System.out.println("ID: " + id + " | Nome: " + nome + " | Nacemento: " + nacemento);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // RESTAURAR DESDE XML
    public void restaurarXML() {

        try {
            File archivo = new File("adestradores_parte3.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(archivo);

            NodeList lista = documento.getElementsByTagName("adestrador");

            Session session = HibernateConfig.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            for (int i = 0; i < lista.getLength(); i++) {

                Element elemento = (Element) lista.item(i);

                int id = Integer.parseInt(elemento.getElementsByTagName("id").item(0).getTextContent());
                String nome = elemento.getElementsByTagName("nome").item(0).getTextContent();
                LocalDate nacemento = LocalDate.parse(
                        elemento.getElementsByTagName("nacemento").item(0).getTextContent()
                );

                Adestrador ad = session.get(Adestrador.class, id);

                if (ad != null) {
                    ad.setNome(nome);
                    ad.setNacemento(nacemento);
                }
            }

            transaction.commit();
            session.close();

            System.out.println("Adestradores restaurados correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}