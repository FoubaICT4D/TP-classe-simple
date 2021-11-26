
import java.time.Period;
import java.time.LocalDate;
public class Etudiant {



    public String matricule;
    public String nom ;
    public char genre;
    public   LocalDate birth;
    public double moyenne;


    public  Etudiant()
    {
        this.matricule = "00@0000";
        this.nom = "NEANN";
        this.genre = 'm';
       this.birth = LocalDate.of(1980,10,12);
        this.moyenne = 10.5;

    }

    public Etudiant(String nMatricule, String nNom,char genres ,LocalDate bith, double nMoyenne)
    {
        this.matricule = nMatricule;
        this.nom = nNom;
        this.birth = bith;
        this.moyenne = nMoyenne;
        this.genre = genres;
    }

    public int calculAge()
    {

        LocalDate today = LocalDate.now();

        return Period.between(this.birth,today).getYears();

    }

    public void bonifier(double bonus)
    {
        this.moyenne = bonus;

    }
    public String toString()
    {
        return "Matricule: " + matricule + " Nom: " + nom + " Genre: "+genre+ " Moyenne: "+moyenne;
    }




}
