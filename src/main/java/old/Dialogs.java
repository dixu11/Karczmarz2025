package old;

import java.util.ArrayList;
import java.util.Scanner;

public class Dialogs {

    // PART 1 - KATALOG DIALOGÓW I SKRYPTÓW
    // 1.1 Dialogi
    // wszystkie dialogi oraz opcje w grza, a także ich kody, przedrostki itd.
    // dial[obiekt][dialog][ [0] > treść, [1] > ID dialogu do szukania [2]
    String dial[][][] = { // dialogi:
            { // obiekt[0] GRACZ
                    // normalne dialogi
                    { "", "AB0" }, { "Pokaż mi swoje towary", "AB1" }, { "Kimnął bym się", "AB2" },
                    { "W sumie to mam inna sprawę...", "AB5" }, { "Tak", "AB8" }, { "Nie", "AB9" }, { "Tak", "AB10" },
                    { "Nie", "AB11" }, { "Tak", "AB12" }, { "Nie", "AB13" },
                    { "Już od godziny czekam na kelnera!", "sAB14" }, { "A mam, dawaj na solo!", "AB15" },
                    { "Nie, przepraszam, wasza karczma, wasze zasady.", "AB16" },
                    // {"","AB"}
                    // specjalne/uniwersalne dialogi
                    { "Bywaj!", "sAB0" }, { "Witaj! Jak się masz?", "sAB1" }, { "AB", "AB" /* pusta opcja */ },
                    { "Poproszę piwo", "sAB3" }, { "Poproszę darmowe piwo", "sAB3.1" }, { "Poproszę obiad", "sAB4" },
                    { "Tak, oto one", "sAB7" } },
            // {"","AB"} - wzór
            { // obiekt[1] GRA - [3] - przedrostek
                    { "Witaj w grze!", "A1B0", "\t*" },
                    // { "Kręci Ci sie w glowie ale smakuje niezle. To był dobry wybor", "A1B1",
                    // "\t*" },
                    { "Koniec rozmowy", "A1B3", "\t*" }, { "Śpij dobrze! IDZIESZ SPAĆ", "A1B4", "\t*" },
                    { "Budzisz się, czy chcesz wyjść z pokoju?", "A1B5", "\t*" },
                    { "Ośmiornica Cię zjada.", "sA1B6", "\t*" },
                    { "Spadł na Ciebie żyrandol z sufitu.", "sA1B7", "\t*" },
                    { "Minęło parę minut więc zapytam jeszcze raz... Wychodzisz z pokoju?", "A1B8", "\t*" },
                    { "Zakończyłeś rozmowę. Karczmarz znika a wokoło Ciebie nie ma absolutnie nic. Żadnych ludzi. Żadnej karczmy. Nie ma nawet Ciebie.",
                            "sA1B9", "\t*" } },
            // {"","A1B","\t*"}
            { // obiekt[2] KARCZMARZ [3] - przedrostek
                    { "Witaj w moim sklepie!", "A2B0", "\nKarczmarz: " },
                    { "Czego potrzebujesz?", "A2B05", "Karczmarz: " },
                    { "A doskonale, interes sie kreci! Czego potrzebujesz?", "A2B1", "Karczmarz: " },
                    { "Jest w zasadzie tylko piwo za 3 monety i danie dnia za 4... Na co masz ochotę?", "sA2B2",
                            "Karczmarz: " },
                    { "Nocleg kosztuje 5 złotych monet. Zainteresowany?", "sA2B3", "Karczmarz: " },
                    { "Dobrze powiedziane. Zamawiasz coś pan czy nie?", "sA2B4", "Karczmarz: " },
                    { "Panieeee... to nie je żodna restaurancja żeby kelnyrów zatrudniać. Masz jakiś problem?", "A2B5",
                            "Karczmarz: " },
                    { "Bez nerwów towarzyszu. Tylko żartowałem... Napijesz się pan coś na koszt firmy?", "A2B6",
                            "Karczmarz (przestraszony) : " } },
            // {"","A2B","Karczmarz: "}
            { // obiekt [3] - KORZYŚCI
                    { "", "sA3B0", "" }, // piwo
                    { "", "sA3B1", "" }, // food stare: A1B2
                    { "", "sA3B2", "" }, // room { "", "A1B4",
                    { "Ooooo... Widzę, że smakowało! Chcesz coś kupić?", "sA3B0.1", "\nKarczmarz: " }, // darmowe piwo
                    // "\t*" },
                    // { "FillerTEXT", "A3B0", "\nNPCNAME: " }
            } };

    // 1.2. Opcje wychodzące z aktualnego dialogu
    // sOut[numer rozmowy][dialog] [[0]aktualny dialog [1-5] przypisane do niej
    // opcje
    // "AB" -pusty]
    String sOut[][][] = { // opcje do danego dialogu:
            { // rozmowa[0] PUSTE
                    { "", "", "", "", "", "" } },
            { // rozmowa[1] KARCZMARZ
                    { "A2B0", "sAB1", "AB1", "AB2", "sAB14", "sAB0" }, { "A2B05", "AB", "AB1", "AB2", "sAB14", "sAB0" },
                    { "A2B1", "sAB1", "AB1", "AB2", "sAB14", "sAB0" }, { "sA2B2", "sAB3", "sAB4", "AB5", "sAB0", "AB" },
                    { "sA2B3", "sAB7", "AB5", "sAB0", "AB", "AB" }, { "A1B1", "sAB3", "sAB4", "AB5", "sAB0", "AB" },
                    { "sA3B0.1", "sAB3", "sAB4", "AB5", "sAB0", "AB" }, { "sA3B2", "AB8", "AB9", "AB", "AB", "AB" },
                    { "A1B5", "AB10", "AB11", "AB", "AB", "AB" }, { "A1B8", "AB12", "AB13", "AB", "AB", "AB" },
                    { "sA2B4", "sAB3", "sAB4", "AB5", "AB2", "sAB0" }, { "A2B5", "AB", "AB", "AB15", "AB16", "AB" },
                    { "A2B6", "AB", "sAB3.1", "AB5", "AB", "AB" }
                    // {"AB","AB","AB","AB","AB","AB"}
            } };
    // 1.3. Dialog wychodzący z opcji
    // sDec[nr rozmowy][dialog][[0] Wybrana przez gracza opcja [1] przypisany do
    // niej dialog]
    String sDec[][][] = { // Opcja > dialog
            { // rozmowa[0] PUSTE
                    { "", "" } },
            { // rozmowa[1]
                    { "sAB0", "sA1B9" }, { "sAB1", "A2B1" }, { "A3B0", "A0B3" }, { "AB1", "sA2B2" }, { "AB2", "sA2B3" },
                    { "sAB3", "sA3B0" }, { "sAB3.1", "sA3B0.1" }, { "sAB4", "sA3B1" }, { "AB5", "A2B05" },
                    { "sAB7", "sA3B2" }, { "AB8", "A1B5" }, { "AB9", "sA1B6" }, { "AB10", "sA1B7" }, { "AB11", "A1B8" },
                    { "AB12", "sA1B7" }, { "AB13", "A1B8" }, { "sAB14", "A2B5" }, { "AB15", "A2B6" },
                    { "AB16", "sA2B4" }
                    // {"AB","AB"}
            } };

    // 1.4. Lista specjalnych opcji
    ArrayList<String> oSpec = new ArrayList<>(); // wszystkie specjalne (kod zaczyna się od 's')

    // 1.5. Pomniejsze listy - opcje specjalne
    ArrayList<String> oSpecFade = new ArrayList<>(); // opcje znikające po użyciu
    ArrayList<String> oSpecSetInt = new ArrayList<>(); // opcje zmieniające variable int
    // nie zaimplementowane:
    // ArrayList<String> oSpecChange_sDec = new ArrayList<>();
    // opcje zmieniające efekty innych opcji
    // ArrayList<String> oSpecChange_sOut = new ArrayList<>();
    // opcje wpływające na dostępność innych opcji
    // ArrayList<String> oSpecSetString = new ArrayList<>();
    // opcje zmieniające variable string

    // 1.6. Lista specjalnych dialogów
    ArrayList<String> dSpec = new ArrayList<>();

    // 1.7. Pomniejsze listy - dialogi specjalne
    ArrayList<String> dSpecEnd = new ArrayList<>(); // dialogi kończące grę
    ArrayList<String> dSpecTrade = new ArrayList<>(); // dialogi wyświetlające posiadane monety
    ArrayList<String> dSpecReward = new ArrayList<>(); // dialogi dające korzyść

    // Equipment:
    int money = 10;
    int beerOwned = 0;
    int freebeerOwned = 0;
    int foodOwned = 0;
    int roomOwned = 0;

    // Ceny:
    int beerCost = 3;
    int foodCost = 4;
    int roomCost = 5;

    String sPrices[][] = { // opcje prowadzące do korzyści
            // Prices
            { "sAB3", "beer" }, { "sAB3.1", "freebeer" }, { "sAB4", "food" }, { "sAB7", "room" },
            // {"AB","AB"}
    };

    // PART 2 - SETUP

    String actualDial[] = new String[3]; // aktualny dialog

    public void setDefault() { // ustawia domyślny pierwszy dialog i tworzy listę specjalnych
        actualDial[0] = dial[2][0][0];
        actualDial[1] = dial[2][0][1];
        actualDial[2] = dial[2][0][2];
        // actualDial[3] = dial[2][0][3];
        for (int col = 0; col < dial[0].length; col++) { // lista spec. opcji
            if (dial[0][col][1].charAt(0) == 's') {
                oSpec.add(dial[0][col][1]);
            }
        }
        for (int row = 1; row < dial.length; row++) { // lista spec. dialogów
            for (int col = 0; col < dial[row].length; col++) {
                if (dial[row][col][1].charAt(0) == 's') {
                    dSpec.add(dial[row][col][1]);
                }
            }
        }
        oSpecFade.add("sAB1"); // znikające opcje
        oSpecFade.add("sAB14");
        oSpecSetInt.add("sAB3"); // opcje zmieniające wartość INT
        oSpecSetInt.add("sAB4");
        oSpecSetInt.add("sAB7");
        oSpecSetInt.add("sAB3.1");
        dSpecTrade.add("sA2B2"); // handlowe dialogi - wyświetlają aktualną kase
        dSpecTrade.add("sA2B3");
        dSpecTrade.add("sA3B0.1");
        dSpecTrade.add("sA2B4");
        dSpecReward.add("sA3B0"); // dialogi dające korzyść pod warunkiem
        dSpecReward.add("sA3B1");
        dSpecReward.add("sA3B2");
        dSpecReward.add("sA3B0.1");
        dSpecEnd.add("sA1B6"); // dialogi odpalające grę od nowa
        dSpecEnd.add("sA1B7");
        dSpecEnd.add("sA1B9");
    }

    public void opening() { // intro do programu
        System.out.println("\n\n\t\t\t\tKARCZMARZ\n" + "\t<Program demonstrujący możliwości silnika 'OnePerson'>\n\n"
                + "Engine: OnePersonBeta\n" + "Version: 0.4\n" + "Author: Daniel 'Dixu' Szlicht\n\n"
                + "\t#Naciśnij [ENTER] aby kontynuować");
        enter(); // input
        clear(); // czyści ekran
    }

    // PART 3 - DIALOG LOOP

    public void generateActualLine() { // pokazuje pierwszy dialog
        System.out.println(actualDial[2] + actualDial[0] + "\n");
        System.out.print(afterDialog); // ewentualne dopiski od spec. opcji
        afterDialog = ""; // czyści dopiski
    }

    public boolean resetIfLost() { // resetuje i podsumowuje grę jeśli reset == true
        if (reset) {
            System.out.println("Wypite piwa: " + beerOwned);
            System.out.println("Wypite darmowe piwa: " + freebeerOwned);
            System.out.println("Zjadzone schabowe: " + foodOwned);
            System.out.println("Wynajęte pokoje: " + roomOwned);
            System.out.println("\n\t#Naciśnij [ENTER] aby zresetować grę.");
            enter();
            clear();
            System.out.println("\t#Gra zresetowana! Powodzenia tym razem...\n\n\n");
            return true;
        } else {
            return false;
        }
    }

    String o[][] = { { "", "" }, { "AB", "AB" }, { "AB", "AB" }, { "AB", "AB" }, { "AB", "AB" }, { "AB", "AB" } }; // opcje

    public void setActualOptionCode() { // Wyszukuje ID aktualnego dialogu i przypisuje opcjom odpowiednie kody
        String poszukiwany = actualDial[1];
        String sprawdzany = "jakiesrandomowe";
        if (oldOptions == false) { // czasem specjalny dialog wymaga powtórzenia starych opcji
            read_data: for (int row = 0; row < sOut.length; row++) {
                for (int col = 0; col < sOut[row].length; col++) {
                    sprawdzany = sOut[row][col][0]; // szuka kodu aktualnego dialogu w skrypcie
                    if (sprawdzany.equals(poszukiwany)) { // podpina przypisane mu kody opcji
                        o[1][1] = sOut[row][col][1];
                        o[2][1] = sOut[row][col][2];
                        o[3][1] = sOut[row][col][3];
                        o[4][1] = sOut[row][col][4];
                        o[5][1] = sOut[row][col][5];
                        break read_data;
                    }
                }
            }
        }
        oldOptions = false;
    }

    public void setSegregateOptions() { // przesuwa puste opcje na dół
        int oActualABRow = 0;
        int oActualTEXTRow = 0;
        String poszukiwanyAB = "AB";
        String sprawdzanyAB = "jakiesrandomowe";
        String sprawdzanyTEXT = "jakiesrandomowe";
        for (int row = 1; row < o.length; row++) { // pętla znajduje opcje AB i zamienia je z najbliższym po nich textem
            sprawdzanyAB = o[row][1];
            if (sprawdzanyAB.equals(poszukiwanyAB)) {
                oActualABRow = row;
                read_data3: for (int row2 = row; row2 < o.length; row2++) {
                    sprawdzanyTEXT = o[row2][1];
                    if (sprawdzanyTEXT != "AB") {
                        oActualTEXTRow = row2;
                        o[oActualABRow][1] = o[oActualTEXTRow][1];
                        o[oActualTEXTRow][1] = "AB";
                        row = -1;
                        break read_data3;
                    }
                }
            }
        }
    }

    public void setActualOptionLine() { // odnajduje kody i przypisuje opcjom odpowiednie sentencje oraz znacznik
        String poszukiwany[] = { "", o[1][1], o[2][1], o[3][1], o[4][1], o[5][1] };
        String sprawdzany = "jakiesrandomowe";
        int counter = 1;
        read_data: for (int col = 0; col < dial[0].length; col++) {
            sprawdzany = dial[0][col][1];
            if (sprawdzany.equals(poszukiwany[1]) && counter == 1) {// ustawia dialog do opcji 1
                o[1][0] = dial[0][col][0];
                ++counter;
                col = -1;
            }
            if (sprawdzany.equals(poszukiwany[2]) && counter == 2 && col != -1) {
                o[2][0] = dial[0][col][0];
                ++counter;
                col = -1;
            }
            if (sprawdzany.equals(poszukiwany[3]) && counter == 3 && col != -1) {
                o[3][0] = dial[0][col][0];
                ++counter;
                col = -1;
            }
            if (sprawdzany.equals(poszukiwany[4]) && counter == 4 && col != -1) {
                o[4][0] = dial[0][col][0];
                ++counter;
                col = -1;
            }
            if (sprawdzany.equals(poszukiwany[5]) && counter == 5 && col != -1) {
                o[5][0] = dial[0][col][0];
                ++counter;
                break read_data;
            }
        }
    }

    boolean firstOptions = true;

    public void generateInterface() { // Interfejs
        if (firstOptions) { // za pierwszym razem wyświetla dokładniejsze info - tutorial
            System.out.println("\t#Wpisz odpowiadającą opcji cyfrę [1-5] a następnie naciśnij [ENTER]\n");
            firstOptions = false;
        } else {
            System.out.println("\t#Wybierz jedną z opcji:\n");
        }
    }

    String aviableOptions[] = { "filler", "AB", "AB", "AB", "AB", "AB" }; // [1]-[5]

    public void generateOptions() { // prezentuje opcje inne niż pusta i przypisuje numer
        int optionCount = 0;
        if (o[1][0] != null && o[1][0] != "AB") {
            ++optionCount;
            System.out.println(optionCount + ". " + o[1][0]);
        }
        if (o[2][0] != null && o[2][0] != "AB") {
            ++optionCount;
            System.out.println(optionCount + ". " + o[2][0]);
        }
        if (o[3][0] != null && o[3][0] != "AB") {
            ++optionCount;
            System.out.println(optionCount + ". " + o[3][0]);
        }
        if (o[4][0] != null && o[4][0] != "AB") {
            ++optionCount;
            System.out.println(optionCount + ". " + o[4][0]);
        }
        if (o[5][0] != null && o[5][0] != "AB") {
            ++optionCount;
            System.out.println(optionCount + ". " + o[5][0]);
        }
    }

    Scanner oDecisionScan = new Scanner(System.in); // scanner do wybierania opcji
    String actualDecision[] = new String[10]; // ostatnio wybrana opcja

    public void setDecision() { // odpala scanner i interpretuje wybrana opcje przypisujac kod
        int oDecision;
        boolean gate1 = false;
        String error = "\n\t#Nie rozumiem Twojego polecenia. Wybierz jedną z dostępnych opcji.";
        do {
            if (oDecisionScan.hasNextInt()) { // czy user wpisał cyfre?
                oDecision = oDecisionScan.nextInt();
                if (oDecision >= 1 && oDecision <= 5) { // czy jest to cyfra 1-5?
                    switch (oDecision) {
                        case 1:
                            if (o[1][1] != "AB" && o[1][1] != null) { // czy opcja ma kod?
                                actualDecision[0] = o[1][0];
                                actualDecision[1] = o[1][1];
                                gate1 = true;
                            } else {
                                System.out.println(error);
                            }
                            break;
                        case 2:
                            if (o[2][1] != "AB" && o[2][1] != null) {
                                actualDecision[0] = o[2][0];
                                actualDecision[1] = o[2][1];
                                gate1 = true;
                            } else {
                                System.out.println(error);
                            }
                            break;
                        case 3:
                            if (o[3][1] != "AB" && o[3][1] != null) {
                                actualDecision[0] = o[3][0];
                                actualDecision[1] = o[3][1];
                                gate1 = true;
                            } else {
                                System.out.println(error);
                            }
                            break;
                        case 4:
                            if (o[4][1] != "AB" && o[4][1] != null) {
                                actualDecision[0] = o[4][0];
                                actualDecision[1] = o[4][1];
                                gate1 = true;
                            } else {
                                System.out.println(error);
                            }
                            break;
                        case 5:
                            if (!o[5][1].equals("AB") && !o[5][1].equals(null)) {
                                actualDecision[0] = o[5][0];
                                actualDecision[1] = o[5][1];
                                gate1 = true;
                            } else {
                                System.out.println(error);
                            }
                            break;
                        default:
                            System.out.println(error);
                            break;
                    }
                } else {
                    System.out.println(error);
                }
            } else {
                System.out.println(error);
                oDecisionScan.next();
            }
        } while (gate1 == false);
    }

    public void generateDecisionLine() { // drukuje decyzje gracza i czyści ekran
        clear();
        System.out.println("" + "\nGracz: " + actualDecision[0] + "\n");
    }

    boolean specialOption = false;

    public void testSpecialOption() { // sprawdzanie czy wybrana opcja posiada specjalne właściwości
        if (actualDecision[1].charAt(0) == 's') {
            specialOption = true;
        } else {
            specialOption = false;
        }
    }

    boolean broke = false;
    String bought = "";

    public void setSpecialOptionEffects() { // wyszukuje przy jakich efektach znajduje się dana opcja
        if (specialOption) { // jeśli przeszła poprzedni test odpalamy jej spec. właściwości!
            if (oSpecFade.contains(actualDecision[1])) { // czy jest na liście znikających opcji?
                String poszukiwany = actualDecision[1];
                String sprawdzany = "jakiesrandomowe";
                for (int row = 0; row < sOut.length; row++) { // odnajdujemy jej kod w skrypcie i usuwamy drogi do niego
                    for (int col = 0; col < sOut[row].length; col++) {
                        for (int pos = 1; pos < sOut[row][col].length; pos++) {
                            sprawdzany = sOut[row][col][pos];
                            if (sprawdzany.equals(poszukiwany)) {
                                sOut[row][col][pos] = "AB";
                            }
                        }
                    }
                }
            }
            if (oSpecSetInt.contains(actualDecision[1])) { // czy jest na liście opcji zmieniających int?
                String poszukiwany = actualDecision[1];
                String sprawdzany = "jakiesrandomowe";
                read_data: for (int row = 0; row < sPrices.length; row++) { // jaki int ma zmieniać?
                    sprawdzany = sPrices[row][0];
                    if (sprawdzany.equals(poszukiwany)) {
                        bought = sPrices[row][1];
                        switch (bought) {
                            case "beer":
                                if (money - beerCost >= 0) { // czy cię stać?
                                    money = money - beerCost; // ssiemy kasę
                                    System.out.println("\t#Wydane monety: " + beerCost);
                                    System.out.println("\t#Pozostałe monety: " + money + "\n");
                                } else {
                                    System.out.println("\t#Nie stać Cię!\n");
                                    oldOptions = true; // odcina drogę dalej
                                    broke = true; // daje status niewypłacalnego
                                }
                                break;
                            case "food":
                                if (money - foodCost >= 0) {
                                    money = money - foodCost;
                                    System.out.println("\t#Wydane monety:  " + foodCost);
                                    System.out.println("\t#Pozostałe monety: " + money + "\n");
                                } else {
                                    System.out.println("\t#Nie stać Cię!\n");
                                    oldOptions = true;
                                    broke = true;
                                }
                                break;
                            case "room":
                                if (money - roomCost >= 0) {
                                    money = money - roomCost;
                                    System.out.println("\t#Wydane monety:  " + roomCost);
                                    System.out.println("\t#Pozostałe monety: " + money + "\n");
                                } else {
                                    System.out.println("\t#Nie stać Cię!\n");
                                    oldOptions = true;
                                    broke = true;
                                }
                                break;
                            case "freebeer":
                                System.out.println("\t#Dostałeś darmowe piwo\n");
                                break;
                        }
                        break read_data;

                    }
                }
            }
        }
    }

    public void setNewActualDialCode() { // Wyszukuje ID decyzji i przypisuje jej dialog
        String poszukiwany = actualDecision[1];
        String sprawdzany = "jakiesrandomowe";
        read_data: for (int row = 0; row < sDec.length; row++) { // szukamy dialogu do którego prowadzi decyzja
            for (int col = 0; col < sDec[row].length; col++) {
                sprawdzany = sDec[row][col][0];
                if (sprawdzany.equals(poszukiwany)) {
                    actualDial[1] = sDec[row][col][1]; // ustawiamy go jako aktualny dialog
                    break read_data;
                }
            }
        }
    }

    boolean specialDialog = false;

    public void testSpecialDialog() { // sprawdzanie czy wybrany dialog posiada specjalne właściwości
        if (actualDial[1].charAt(0) == 's') { // czy pierwsza litera kodu to 's'?
            specialDialog = true;
        } else {
            specialDialog = false;
        }
    }

    String afterDialog = "";
    boolean reset = false;
    boolean oldOptions = false;

    public void setSpecialDialogEffects() { // wyszukuje przy jakich efektach znajduje się dany specjalny dialog
        if (specialDialog) { // czy zdał test na specjalny dialog?
            if (dSpecTrade.contains(actualDial[1])) { // czy jest na liście opcji handlowych?
                afterDialog = "\t#Posiadane monety: " + money + "\n\n";
            }
            if (dSpecEnd.contains(actualDial[1])) { // czy jest na liście dialogów kończących grę?
                afterDialog = "\t#GAME OVER\n\n";
                reset = true;
            }
            if (dSpecReward.contains(actualDial[1])) { // czy jest na liście dialogów z nagrodami?
                if (broke == false) { // jesteś wypłacalny?
                    switch (bought) {
                        case "beer":
                            beerOwned++; // dostajesz piwo!
                            oldOptions = true; // niektóre dialogi z tej kategorii prowadzą tylko do nagrody - ślepe zaułki
                            System.out.println(
                                    "\t*Kręci Ci się w glowie ale trunek smakuje całkiem niezle. To był dobry wybór!");
                            break;
                        case "food":
                            foodOwned++;
                            oldOptions = true;
                            System.out.println("\t*Dzisiaj schabowe. Smakują wybornie!");
                            break;
                        case "room":
                            roomOwned++;
                            System.out.println(
                                    "\t*Masz sen - Jesteś na statku, widzisz przed sobą wielką osmiornicę. Uciekasz pod pokład?");
                            break;
                        case "freebeer":
                            freebeerOwned++;
                            System.out.println(
                                    "\t*Kręci Ci się w glowie ale trunek smakuje całkiem niezle. To był dobry wybór!");
                            break;
                    }
                }
            }
        }
    }

    public void setNewActualDialLine() { // znajduje aktualny dialog po kodzie i podpisuje mu tekst i przedrostek
        String poszukiwany = actualDial[1];
        String sprawdzany = "jakiesrandomowe";

        read_data: for (int row = 1; row < dial.length; row++) { // szukam który dialog ma taki kod
            for (int col = 0; col < dial[row].length; col++) {
                sprawdzany = dial[row][col][1];
                if (sprawdzany.equals(poszukiwany)) {
                    actualDial[0] = dial[row][col][0];
                    actualDial[2] = dial[row][col][2];
                    // actualDial[3] = dial[row][col][3];
                    break read_data;
                }
            }
        }
    }

    /*
     * public void resetOldOptions() { // czyści dostępne opcje przed ponownym
     * zapełnieniem if (oldOptions == false) { o[1][0] = "AB"; o[1][1] = "AB";
     * o[2][0] = "AB"; o[2][1] = "AB"; o[3][0] = "AB"; o[3][1] = "AB"; o[4][0] =
     * "AB"; o[4][1] = "AB"; o[5][0] = "AB"; o[5][1] = "AB"; } }
     */

    // PART 4 - METODY POMOCNICZE

    Scanner enter = new Scanner(System.in);

    public void enter() { // wciśnij enter aby przejść dalej
        enter.nextLine();
    }

    static void clear() { // czyści ekran
        for (int i = 0; i < 50; ++i)
            System.out.println();
    }

    /*
     * static void clearMedium() { for (int i = 0; i < 40; ++i)
     * System.out.println(); }
     *
     * static void clearSmall() { for (int i = 0; i < 30; ++i) System.out.println();
     * }
     */
}