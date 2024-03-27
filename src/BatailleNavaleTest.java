import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BatailleNavaleTest {

    @Test
    void testEspaceDisponible() {
        char[][] tabJeu= BatailleNavale.plateau(10,10);

        assertFalse(BatailleNavale.espaceDisponible(tabJeu, 15, 9, 5,true));
        assertFalse(BatailleNavale.espaceDisponible(tabJeu, 10, 10, 5,true));
        assertFalse(BatailleNavale.espaceDisponible(tabJeu, 5, 11, 5,true));
        assertFalse(BatailleNavale.espaceDisponible(tabJeu, 9, 9, 5,true));
        assertTrue(BatailleNavale.espaceDisponible(tabJeu, 4,5,4,false));
        assertTrue(BatailleNavale.espaceDisponible(tabJeu, 5,5,4,true));
        assertFalse(BatailleNavale.espaceDisponible(tabJeu, 15, 9, 5,false));
        assertFalse(BatailleNavale.espaceDisponible(tabJeu, 5, 19, 5,false));
        assertFalse(BatailleNavale.espaceDisponible(tabJeu, 9, 9, 5,false));
    }
    @Test
    void testTourJoueur() {
        assertFalse(BatailleNavale.tourJoueur(1));
        assertFalse(BatailleNavale.tourJoueur(9));
        assertTrue(BatailleNavale.tourJoueur(2));
        assertTrue(BatailleNavale.tourJoueur(0));
    }
}

/*

    Trace des jeux de tests

Test de la méthode "plateau tir"
Résultat attendu : placement du tir en coordonné (5,1), et demande  d'entré de nouvelles coordonnées
car les coordonnées sont déjà utiisées.

    Entrer les coordonnées de votre missile
    Saisisser les coordonées x du tir
    5
    Saisisser les coordonées y du tir
    1
    Vous avez touché!
       1 |2 |3 |4 |5 |6 |7 |8 |9 |10
    1  ~  ~  ~  ~  X  ~  ~  ~  ~  ~
    2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

    Entrer les coordonnées de votre missile
    Saisisser les coordonées x du tir
    5
    Saisisser les coordonées y du tir
    1
    Vous avez déjà tirer ici
    Saisisser de nouveaux les coordonées x du tir




Test de la méthode "bateauCoule"
Résultat attendu : "destroyer coulé !"

test:

    Entrer les coordonnées de votre missile
    Saisisser les coordonées x du tir
    5
    Saisisser les coordonées y du tir
    2
    Vous avez touché!
    destroyer coulé !
       1 |2 |3 |4 |5 |6 |7 |8 |9 |10
    1  ~  ~  ~  ~  X  ~  ~  ~  ~  ~
    2  ~  ~  ~  ~  X  ~  ~  ~  ~  ~
    3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~


Test de la méthode remplirPlateau
Résultat attendu : saisie des coordonnées et place le bateau aux coordennées saisie.

test:

    Voulez-vous placez votre bateau verticalement ? Tapez 1 pour oui
    2
    entrer cordonnée x  du bateau :
    4
    entrer cordonnée y :
    5
       1 |2 |3 |4 |5 |6 |7 |8 |9 |10
    1  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    5  ~  ~  ~  a  a  a  a  a  ~  ~
    6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    Voulez-vous placez votre bateau verticalement ? Tapez 1 pour oui


Test de la méthode remplirPlateau
Résultat attendu : redemande la saisie des coordonnées car ces dernières ne sont pas dans le tableau.

test:

    Voulez-vous placez votre bateau verticalement ? Tapez 1 pour oui
    1
    entrer cordonnée x  du bateau :
    11
    entrer cordonnée y :
    1
    Erreur sur la saisie des coordonnées
    entrer de nouveau les cordonnées x  du bateau :
    4
    entrer de nouveau les cordonnées y du bateau :
    9
    Erreur sur la saisie des coordonnées
    entrer de nouveau les cordonnées x  du bateau :
    4
    entrer de nouveau les cordonnées y du bateau :
    5
       1 |2 |3 |4 |5 |6 |7 |8 |9 |10
    1  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    5  ~  ~  ~  a  ~  ~  ~  ~  ~  ~
    6  ~  ~  ~  a  ~  ~  ~  ~  ~  ~
    7  ~  ~  ~  a  ~  ~  ~  ~  ~  ~
    8  ~  ~  ~  a  ~  ~  ~  ~  ~  ~
    9  ~  ~  ~  a  ~  ~  ~  ~  ~  ~
    10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~


Test d'une fin de partie
Résultat attendu : "j2 à gagné la partie"

test :

    j2 Entrer les coordonnées de votre missile
    Saisisser les coordonées x du tir
    5
    Saisisser les coordonées y du tir
    2
    Vous avez touché!
    destroyer coulé !
       1 |2 |3 |4 |5 |6 |7 |8 |9 |10
    1  X  X  X  X  X  ~  ~  ~  ~  ~
    2  X  X  X  X  X  ~  ~  ~  ~  ~
    3  X  X  X  X  ~  ~  ~  ~  ~  ~
    4  X  X  O  ~  ~  ~  ~  ~  ~  ~
    5  X  ~  ~  ~  ~  ~  ~  ~  ~  ~
    6  ~  ~  ~  ~  ~  O  ~  ~  ~  ~
    7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~
    j2 a gagné la partie
 */
