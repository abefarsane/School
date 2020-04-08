package ES_Biblioteca;
import java.io.IOException;

 
public class esBiblioteca{
    public static void main(String[] args) throws Biblioteca.LibroException, InterruptedException, IOException{
        UserInterface ui = new UserInterface();
        ui.mainMenu();
    }

}