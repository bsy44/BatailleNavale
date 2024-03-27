import java.util.Scanner;

public class BatailleNavale {

    final static int ligne = 10;
    final static int colonne = 10;
    final static int airCraft = 5;
    final static int battleship = 4;
    final static int cruiser = 3;
    final static int submarine = 3;
    final static int destroyer = 2;

    public static void derouleJeu() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        String j1, j2;
        char[][] plateauJ1 = plateau(ligne, colonne);
        char[][] plateauJ2 = plateau(ligne, colonne);
        char[][] plateauJ1Tir = plateau(ligne, colonne);
        char[][] plateauJ2Tir = plateau(ligne, colonne);
        int compteurJoueur = 0;
        boolean touche;

        System.out.println("Saisissez votre pseudo joueur n°1 : ");
        j1 = scanner.nextLine();
        System.out.println("Saisissez votre pseudo joueur n°2 : ");
        j2 = scanner.nextLine();

        System.out.println();

        while (j1.length() < 2 || j2.length() < 2) {
            System.out.println("Erreur sur la saisie des pseudos");
            System.out.println("Saisissez de nouveau votre pseudo joueur n°1 : ");
            j1 = scanner.nextLine();
            System.out.println("Saisissez de nouveau votre votre pseudo joueur n°2 : ");
            j2 = scanner.nextLine();
        }

        System.out.println();

        System.out.println("Placer vos bateaux " + j1);
        afficherPlateau(plateauJ1);
        remplirPlateau(plateauJ1);
        afficherPlateau(plateauJ1);

        System.out.println();

        System.out.println("Placer vos bateaux " + j2);
        afficherPlateau(plateauJ2);
        remplirPlateau(plateauJ2);
        afficherPlateau(plateauJ2);

        System.out.println();

        System.out.println("La partie peut commencer");

        System.out.println();

        while (!finDePartie(plateauJ1) && (!finDePartie(plateauJ2))) {
            if (tourJoueur(compteurJoueur)) {
                System.out.println("C'est au tour de " + j1 + " de jouer");
                touche = plateauTir(plateauJ2, plateauJ2Tir);

                if (!touche) {
                    compteurJoueur++;
                }
                afficherPlateau(plateauJ2Tir);
                System.out.println();
            }
            else {
                System.out.println("C'est au tour de " + j2 + " de jouer");
                touche = plateauTir(plateauJ1, plateauJ1Tir);

                if (!touche) {
                    compteurJoueur++;
                }
                afficherPlateau(plateauJ1Tir);
                System.out.println();
            }
        }

        if (tourJoueur(compteurJoueur))
            System.out.println("Félécitation " + j1 + " vous avez gagner la partie ");
        else
            System.out.println("Félécitation " + j2 + " vous avez gagner la partie ");
    }

    public static char[][] plateau(int ligne, int colonne) { //création du plateau de jeu

        char[][] tabJeu;
        tabJeu = new char[ligne][colonne];
        for (int i = 0; i < tabJeu.length; i++) {
            for (int j = 0; j < tabJeu[i].length; j++) {
                tabJeu[i][j] = '~';
            }
        }
        return tabJeu;
    }

    public static void afficherPlateau(char[][] tab) { // affichage du plateau de jeu

        System.out.println("    1 |2 |3 |4 |5 |6 |7 |8 |9 |10");  // on utilisera des nombres pour les coordonées
        for (int i = 0; i < tab.length; i++) {
            if (i + 1 != 10) {
                System.out.print(" " + (i + 1) + " ");
            }
            else {
                System.out.print(10 + " ");
            }

            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(" " + tab[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void remplirPlateau(char[][] tab) { // remplissage du plateau de jeu
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        int x;
        int y;
        boolean verticale;
        int saisie;

        int[] tailleBat = {airCraft, battleship, cruiser, submarine, destroyer};
        char[] nomBat = {'a', 'b', 'c', 's', 'd'};

        for (int i = 0; i < tailleBat.length; i++) {
            System.out.println("Voulez-vous placez votre bateau verticalement ?" + " Tapez 1 pour oui");
            saisie = scanner.nextInt();

            if (saisie == 1)
                verticale = true;
            else
                verticale = false;

            System.out.println("entrer cordonnée x  du bateau : ");
            x = scanner.nextInt() - 1;
            System.out.println("entrer cordonnée y :");
            y = scanner.nextInt() - 1;

            while (!(espaceDisponible(tab, x, y, tailleBat[i], verticale))) {
                System.out.println("Erreur sur la saisie des coordonnées");
                System.out.println("entrer de nouveau les cordonnées x  du bateau : ");
                x = scanner.nextInt() - 1;
                System.out.println("entrer de nouveau les cordonnées y du bateau :");
                y = scanner.nextInt() - 1;
            }

            if (verticale) {
                for (int ligne = y; ligne < y + tailleBat[i]; ligne++) {
                    tab[ligne][x] = nomBat[i];
                }
            }
            else {
                for (int collone = x; collone < x + tailleBat[i]; collone++) {
                    tab[y][collone] = nomBat[i];
                }
            }
            afficherPlateau(tab);
        }
    }

    public static boolean espaceDisponible(char[][] tab, int x, int y, int tailleBat, boolean verticale) { // vérifie si l'espace est disponible sur le plateau

        if (x < 0 || y < 0 || x > 9 || y > 9)
            return false;

        if (verticale) {
            if (x > 9 || y < 0)
                return false;
            if (y + tailleBat > tab.length)
                return false;
            if (y > 9 || x < 0)
                return false;
        }

        if (verticale && (y + tailleBat) > tab.length) {
            return false;
        }
        else if ((!verticale) && (x + tailleBat) > tab.length) {
            return false;
        }

        if (verticale) {
            for (int ligne = y; ligne < y + tailleBat; ligne++) {
                if (tab[ligne][x] != '~') {
                    return false;
                }
            }
        }
        else {
            for (int collone = x; collone < x + tailleBat; collone++) {
                if (tab[y][collone] != '~') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean plateauTir(char[][] tab, char[][] tabTir) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        int x;
        int y;
        char caseTouchee;

        System.out.println("Saisisser les coordonées x du tir");
        x = scanner.nextInt() - 1;
        System.out.println("Saisisser les coordonées y du tir");
        y = scanner.nextInt() - 1;


        while (x > 9 || y > 9 || x < 0 || y < 0) {
            System.out.println("Erreur saisissez de nouvelles coordonnées");
            System.out.println("Saisisser les coordonées x du tir");
            x = scanner.nextInt() - 1;
            System.out.println("Saisisser les coordonées y du tir");
            y = scanner.nextInt() - 1;
        }

        while (tabTir[y][x] == 'O' || tabTir[y][x] == 'X') {
            System.out.println("Vous avez déjà tirer ici");
            System.out.println("Saisisser de nouveaux les coordonées x du tir");
            x = scanner.nextInt() - 1;
            System.out.println("Saisisser de nouveaux les coordonées y du tir");
            y = scanner.nextInt() - 1;
        }

        if (tab[y][x] == '~') {
            tab[y][x] = 'O';
            tabTir[y][x] = 'O';
            System.out.println("Vous avez loupez!");

            System.out.println();

            return false;
        }

        else {
            caseTouchee = tab[y][x];
            tab[y][x] = 'X';
            tabTir[y][x] = 'X';
            System.out.println("Vous avez touché!");

            System.out.println();

            if (!bateauCoule(tab, caseTouchee)) {
                if (caseTouchee == 'a') {
                    System.out.println("porte-avion coulé !");
                }
                else if (caseTouchee == 'b') {
                    System.out.println("battleship coulé !");
                }
                else if (caseTouchee == 'c') {
                    System.out.println("croiseur coulé !");
                }
                else if (caseTouchee == 's') {
                    System.out.println("sous-marin coulé !");
                }
                else {
                    System.out.println("destroyer coulé !");
                }
            }
        }
        return true;
    }

    public static boolean bateauCoule (char [][] tab, char caseTouchee) {

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] == caseTouchee) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean tourJoueur(int compteurJoueur) {

        if (compteurJoueur % 2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean finDePartie (char[][] tab) {

        char[] nomBat = {'a', 'b', 'c', 's', 'd'};
        for (int c = 0; c < nomBat.length; c++) {
            for (int i = 0; i < tab.length; i++) {
                for (int j = 0; j < tab[i].length; j++) {
                    if (nomBat[c] == tab[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
