/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.testws.testws_2024_2.entidad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "persona")
@XmlType(propOrder = {"id", "fullName", "age"})
public class Person {

    private int id;
    private String fullName;
    private int age;
    private double salario;
    private double salario_minimo = 1300000;

    public Person() {
       this.salario = 0.0;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        CalcularSalario();
    }

    public double getSalario() {
        return salario;
    }

    private void CalcularSalario() {
        this.salario = (this.age * salario_minimo) / 3;
    }

    @XmlRootElement
    public static class SalarioPromedio {

        private double promedio;

        public SalarioPromedio() {
        }

        public SalarioPromedio(double promedio) {
            this.promedio = promedio;
        }

        @XmlElement
        public double getPromedio() {
            return promedio;
        }

        public void setPromedio(double promedio) {
            this.promedio = promedio;
        }

    }

}
