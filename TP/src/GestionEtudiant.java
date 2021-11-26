import java.awt.desktop.AboutEvent;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDate;


public class GestionEtudiant
{

    public static void affiche_merite(Etudiant[] etudiants,int taille)
    {
        int i,j;
        Etudiant tmp;
        if (etudiants == null)
        {
            System.out.println("List Etudiant vide !");
        }
        else {
            for (i = 0; i < taille-1; i++) {
                for (j = i + 1; j < taille; j++) {
                    if (etudiants[i].moyenne < etudiants[j].moyenne) {
                        tmp = etudiants[i];
                        etudiants[i] = etudiants[j];
                        etudiants[j] = tmp;
                    }
                }
            }

            for (i = 0; i < taille; i++) {

                int age = etudiants[i].calculAge();
                System.out.println(etudiants[i] + " Age: " + age);
            }
        }
    }

    public static void info_premier(Etudiant[] etudiants,int taille)
    {
        int i,j;
        Etudiant tmp;
        if (etudiants == null)
        {
            System.out.println("List Etudiant vide !");
        }
        else {
            for (i = 0; i < taille-1; i++) {
                for (j = i + 1; j < taille; j++) {
                    if (etudiants[i].moyenne < etudiants[j].moyenne) {
                        tmp = etudiants[i];
                        etudiants[i] = etudiants[j];
                        etudiants[j] = tmp;
                    }
                }
            }
            int age = etudiants[0].calculAge();
            System.out.println(etudiants[0] + "Age : " + age);
        }

    }

    public static void info_dernier(Etudiant[] etudiants,int taille)
    {
        int i,j;
        Etudiant tmp;
        if (etudiants == null)
        {
            System.out.println("List Etudiant vide !");
        }
        else {
            for (i = 0; i < taille-1; i++) {
                for (j = i + 1; j < taille; j++) {
                    if (etudiants[i].moyenne > etudiants[j].moyenne) {
                        tmp = etudiants[i];
                        etudiants[i] = etudiants[j];
                        etudiants[j] = tmp;
                    }
                }
            }

            int age = etudiants[0].calculAge();
            System.out.println(etudiants[0] + "Age : " + age);

        }

    }

    public static void main(String[] args) {

        Etudiant[] etudiants;
        LocalDate birth;
        double avg = 0;
        System.out.print("Entrez le nombre eleves svp: ");
        Scanner sc1 = new Scanner(System.in);
        int num = sc1.nextInt();
        int day = 0 ,month =0,year;
        boolean ok = false;
        String nom,mac ="19M2633";
        char genre = 'm';
        etudiants = new Etudiant[num];

      for (int i = 0 ; i < num ; i++) {

          while (!ok) {
              System.out.print("Entrez le Matricule : ");
              Scanner sc2 = new Scanner(System.in);
               mac = sc2.nextLine();
              if (mac.length() < 7) {
                  ok = false;
              } else {
                  ok = true;
              }
          }
          ok = false;
          System.out.print("Entrez le Nom : ");
          Scanner sc3 = new Scanner(System.in);
           nom = sc3.nextLine();
          while (!ok) {
              System.out.print("Entrez le jour de naissance : ");
              Scanner sc4 = new Scanner(System.in);
              day = sc4.nextInt();
              if (day < 0 || day > 32) {
                  ok = false;
              } else {
                  ok = true;
              }
          }
          ok = false;
          while (!ok) {
              System.out.print("Entrez le mois de naissance : ");
              Scanner sc5 = new Scanner(System.in);
              month = sc5.nextInt();
              if (month < 0 || month > 13) {
                  ok = false;
              } else {
                  ok = true;
              }
          }

          ok = false;

          System.out.print("Entrez l'annee de naissance : ");
          Scanner sc6 = new Scanner(System.in);
          year = sc6.nextInt();
           birth = LocalDate.of(year, month, day);
          while (!ok) {
              System.out.print("Entrez le genre :");
              Scanner sc7 = new Scanner(System.in);
              genre = sc7.nextLine().toLowerCase().charAt(0);
              if (genre == 'm' || genre == 'f') {
                  ok = true;
              } else {
                  ok = false;
              }
          }
          ok = false;
          while (!ok) {
              System.out.print("Entrez la moyenne : ");
              Scanner sc8 = new Scanner(System.in);
               avg = sc8.nextDouble();
              if (avg < 0 || avg > 21) {
                  ok = false;
              } else {
                  ok = true;
              }
          }
             etudiants[i] = new Etudiant(mac,nom,genre,birth,avg);
          ok = false;
      }

        boolean control = false;
      while(!control) {
          System.out.println("1- Afficher en Ordre de Merite");
          System.out.println("2- Afficher information Premier de la Classe");
          System.out.println("3- Afficher information Dernier de la Classe");
          System.out.println("4- Reniesiliser La Liste");
          System.out.println("5- Quitter Le Programe");

          System.out.println("Entrez Votre Choix : ");
          Scanner chois = new Scanner(System.in);
          int choix = chois.nextInt();

          switch (choix)
          {
              case 1 :
                  affiche_merite(etudiants,num);
                  break;
              case 2 :
               info_premier(etudiants,num);
                  break;
              case 3:
                  info_dernier(etudiants,num);
                  break;
              case 4:
                    etudiants = null;
                  break;
              case 5:
                  control = true;
                   break;

          }

      }

    }

}
