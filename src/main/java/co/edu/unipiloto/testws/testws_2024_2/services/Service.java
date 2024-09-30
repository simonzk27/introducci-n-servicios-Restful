package co.edu.unipiloto.testws.testws_2024_2.services;

import co.edu.unipiloto.testws.testws_2024_2.entidad.Person;
import co.edu.unipiloto.testws.testws_2024_2.entidad.Person.SalarioPromedio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("services")
public class Service {

    private static Map<Integer, Person> personas = new HashMap<Integer, Person>();

    static {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            int id = i + 1;
            person.setId(id);
            person.setFullName("Apreciado Amigo " + id);
            person.setAge(new Random().nextInt(40) + 1);
            personas.put(id, person);
        }
    }

    @GET
    @Path("/getAllPersonsInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonsInJson() {
        return new ArrayList<Person>(personas.values());
    }

    @GET
    @Path("/getAllPersonsInXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML() {
        return new ArrayList<Person>(personas.values());
    }

    @GET
    @Path("/getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJson(@PathParam("id") int id) {
        return personas.get(id);
    }

    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id") int id) {
        return personas.get(id);
    }

    @POST
    @Path("/addPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPersonInJson(Person person) {
        personas.put(new Integer(person.getId()), person);
        return person;
    }

    @GET
    @Path("/getSalarioPromedioXML")
    @Produces(MediaType.APPLICATION_XML)
    public SalarioPromedio getSalarioPromedioEnXML() {
        double totalSalario = 0;
        int totalPersonas = personas.size();
        Person[] personasArray = personas.values().toArray(new Person[0]);

        for (int i = 0; i < totalPersonas; i++) {
            totalSalario += personasArray[i].getSalario();
        }

        double salarioPromedio = (totalPersonas > 0) ? (totalSalario / totalPersonas) : 0;
        return new SalarioPromedio(salarioPromedio);
    }

    @GET
    @Path("/getSumaSalariosJson")
    @Produces(MediaType.APPLICATION_JSON)
    public double getSumaSalariosJson() {
        double sumaSalarios = 0;

        for (Person person : personas.values()) {
            sumaSalarios += person.getSalario();
        }

        return sumaSalarios;
    }

}
