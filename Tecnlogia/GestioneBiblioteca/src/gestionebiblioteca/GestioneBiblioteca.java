/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionebiblioteca;
import java.time.LocalDate;
/**
 *
 * @author abefa
 */
public class GestioneBiblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Biblioteca.LibroException{
        // TODO code application logic here
        Biblioteca bib = new Biblioteca();
        Biblioteca.Libro l1 = bib.new Libro("La sabbia e le stelle.", "SEI", "9788805070794", LocalDate.of(2000, 5, 7));
        Biblioteca.Libro l2 = bib.new Libro("Divina Commedia.", "Mondadori Education", "9788800228572", LocalDate.of(2017, 3, 2));
        Biblioteca.Libro l3 = bib.new Libro("Storia e storiografia plus. ", "D'Anna", "788881049820", LocalDate.of(2019, 9, 23));
        Biblioteca.Libro l4 = bib.new Libro("Grammar files.", "Trinity Whitebridge", "9788889950098", LocalDate.of(2020, 11, 7));
        Biblioteca.Libro l5 = bib.new Libro("First masterclass.", "Oxford University Press", "9780194512831", LocalDate.of(2020, 1, 22));
        
        bib.addAtHead(l1);
        bib.addAtHead(l2);
        bib.showAll();
        bib.showAll();
        
        bib.searchByEditor("Oxford University Press");
        bib.searchByYear(2000);
        bib.searchByCode("9780194512831");
    }
    
}
