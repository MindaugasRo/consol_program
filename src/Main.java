import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Susikurti kintamąjį kuriame saugosim masyvą
        ArrayList<String> nameList = new ArrayList();
        Scanner sc = new Scanner(System.in);


        while (true) {
            menuOptionsMessage();
            int item = numberInput(sc);
            sc.nextLine();

            switch (item) {
                case 1:
                    createName(nameList, sc);
                    break;
                case 2:
                    readList(nameList, sc);
                    break;
                case 3:
                    updateItem(nameList, sc);
                    break;
                case 4:
                    deleteItem(nameList, sc);
                    break;
                case 5:
                    programExit();
                default:
                    System.out.println("Įveskite skaitmenį iš patekto meniu");

            }
        }
    }

    public static void menuOptionsMessage() {
        System.out.println();
        System.out.println("---------------");
        System.out.println(" 1 - Įvesti vardą");
        System.out.println(" 2 - Rodyti vardų sąrašą");
        System.out.println(" 3 - Redaguoti įrašą");
        System.out.println(" 4 - Trinti vardą");
        System.out.println(" 5 - Stabdyti programą");
        System.out.println("---------------");
    }

    /**
     * Įškviečia įvedimą konsolėje su tikrinimu ar įvestas skaičius
     *
     * @param sc iškviečias įvedimą konsolėje
     * @return gražina įvesta reikšmę
     */
    public static int numberInput(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("Įveskite savo pasirinkimą skaitmenimis");
                sc.nextLine();
            }
        }
    }

    /**
     * Funkcija skirta vardo įvedimui į masyvą
     *
     * @param nameList String tipo vardų sąrašas
     * @param sc       iškviečia įvedimą konsolėje
     */
    public static void createName(ArrayList<String> nameList, Scanner sc) {
        while(true) {
            System.out.println("Įveskite naują vardą");
            String input = sc.nextLine();
            if (nameList.contains(input)) {
                System.out.println("Įvestas vardas jau egzistuoja");
            } else
                nameList.add(input);
            break;
        }
    }

    /**
     * Funkcija išveda įvestų vardų sąrašą
     *
     * @param nameList
     */
    public static void readList(ArrayList<String> nameList, Scanner sc) {
        System.out.println("------ Vardų sąrašas ------");
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println(nameList.get(i));
        }
        System.out.println("------------------");
        if (nameList.isEmpty()) {
            System.out.println("Sąrašas yra tuščias");
            createName(nameList, sc);
        }
    }

    /**
     * Funkcija atnaujina įvestą vardą.
     * Kiekvieną kartą išveda vardų sąrašą
     * Esant tuščiam sąrašui iškviečiama funkcija vardo sukūrimui
     *
     * @param nameList
     * @param sc
     * @createName funkcija vardui sukurti
     * @readList funkcija sąrašo išvedimui
     * @oldName kintamasis vardo įvedimui
     */
    public static void updateItem(ArrayList<String> nameList, Scanner sc) {
        if (nameList.isEmpty()) {
            System.out.println("Sąrašas yra tuščias");
            createName(nameList, sc);
        } else {
            readList(nameList, sc);
            System.out.println();
            System.out.println("Įveskite vardą kurį norite redaguoti");
            String oldName = sc.nextLine();
            if (nameList.contains(oldName)) {
                System.out.println("Įveskite naują vardą");
                String newName = sc.nextLine();
                int index = nameList.indexOf(oldName);
                nameList.set(index, newName);
                System.out.println("Vardas pakeistas iš " + oldName + " į " + newName);

            }
        }


    }

    /**
     * Funkcija trinti įvestam masyvo elementui
     * @param nameList
     * @param sc
     */

    public static void deleteItem(ArrayList<String> nameList, Scanner sc) {
            if (nameList.isEmpty()) {
                System.out.println("Sąrašas yra tuščias");
                createName(nameList, sc);
            } else {
                readList(nameList, sc);
                System.out.println();
                System.out.println("Įveskite vardą kurį norite ištrinti");
                String deleteName = sc.nextLine();
                if (nameList.contains(deleteName)) {
                    nameList.remove(deleteName);
                    System.out.println("Vardas " + "[ " + deleteName + " ]" + " ištrintas.");
                } else {
                    System.out.println("Įvestas vardas neegzistuoja");
                }
            }
    }
    /**
     * Iškviečia funkcija programai uždaryti
     */
    public static void programExit () {
        System.out.println("Programa uždaryta");
        System.exit(1);
    }
}