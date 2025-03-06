package old;

public class Tree {
    public static void main(String[] args) {
        boolean restart;
        do {
            restart = new Tree().launch();
        } while (restart);
    }

    public boolean launch() {
        Dialogs dialogs = new Dialogs(); // tworzy instancje dialogów i metod
        dialogs.setDefault(); // ustawia domyślny start i tworzy listę specjalnych opcji
        dialogs.opening(); // intro do programu

        boolean dialGate = false;
        do {
            dialogs.generateActualLine(); 											    	// pokazuje pierwszy dialog

            dialGate = dialogs.resetIfLost();           // Jeśli był specjalny dialog kończący grę - rozpoczyna ją od nowa

            if(dialGate == false) {

                dialogs.setActualOptionCode(); 		 // Wyszukuje ID aktualnego dialogow i przypisuje opcjom odpowiednie kody

                dialogs.setSegregateOptions();					// odnajduje kody i przypisuje opcjom odpowiednie sentencje

                dialogs.setActualOptionLine(); 							// prezentuje opcje inne niż pusta i przypisuje numer

                dialogs.generateInterface(); 																	// Interfejs

                dialogs.generateOptions(); 									    	// segreguje i wyświetla aktualne opcje

                dialogs.setDecision(); 						// odpala scanner i interpretuje wybrana opcje przypisujac kod

                dialogs.generateDecisionLine();														// drukuje decyzje gracza

                dialogs.testSpecialOption();                  // sprawdzanie czy wybrana opcja posiada specjalne właściwości

                dialogs.setNewActualDialCode();								// Wyszukuje ID decyzji i przypisuje jej dialog

                dialogs.setSpecialOptionEffects();                 // wyszukuje przy jakich efektach znajduje się dana opcja

                dialogs.testSpecialDialog();                 // sprawdzanie czy wybrany dialog posiada specjalne właściwości

                dialogs.setSpecialDialogEffects();                // wyszukuje przy jakich efektach znajduje się dany dialog

                dialogs.setNewActualDialLine();			// znajduje aktualny dialog po kodzie i podpisuje mu inne parametry

                //dialogs.resetOldOptions();          	               // czyści dostępne opcje przed ponownym zapełnieniem

            }
        } while (dialGate == false);
        return true;
    }
}

/* nie użyte rzeczy:
 !non public class - inne obiekty postacie powinny mieć własny obiekt itd..
 !Constructors
 !Static
 !Geters and seters
 !Dziedziczenie
 !This
 !String Builder

 printf
*/
