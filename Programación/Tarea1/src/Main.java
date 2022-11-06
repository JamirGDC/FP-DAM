import java.util.Scanner;
import java.util.stream.Stream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner Keyboard = new Scanner(System.in);
        //Pedimos que introduzca la serie de palabras con una coma

        System.out.println("Introduzca palabras separadas por una coma (en Blanco para Finalizar):");
        String item = Keyboard.nextLine();
        String itemok = "";
        itemok = item.replaceAll(" ", "");//reemplazamos todos los espacios en blanco antes despues e intermedios
        String[] Items = itemok.split(",");

        System.out.println("la lista de palabras introducidas es:");
        System.out.println(Arrays.asList(Items));

        //filtrar y dividir

        String option = "";
        Scanner KeyboardOption = new Scanner(System.in);

        char filter;
        Scanner KeyboardFilter = new Scanner(System.in);

        String[] FilterArray = null;

        while (true) {
            System.out.println("Eliga una opción F para filtrar y D para dividir"); //pedimos una letra para filtrar o dividir
            option = KeyboardOption.nextLine();
            if (option.equalsIgnoreCase("F")){                          //filtrado
                //filtrado
                System.out.println("Introduzca Palabra o Letra para Filtar:");
                filter = KeyboardFilter.nextLine().charAt(0);

                String character = Character.toString(filter);
                FilterArray = Stream.of(Items).filter(str -> str.startsWith(character)).toArray(String[]::new);
                Arrays.sort(FilterArray);
                System.out.println(Arrays.toString(FilterArray));
                break;

            } else if (option.equalsIgnoreCase("D")) {          //dividimos

                System.out.println("Introduzca Palabra para Dividir:");
                String filterSplit = "";
                filterSplit = KeyboardFilter.nextLine();

                int length_Var = Items.length;

                String[] NewArray = new String[length_Var + 1];     //defino un nuevo array para añadir la palabra ingresada para dividir

                for (int i = 0; i < Items.length; i++) {
                    NewArray[i] = Items[i];
                }
                NewArray[NewArray.length - 1] = filterSplit;

                Items = NewArray;

                Arrays.sort(Items);
                int index = Arrays.asList(Items).indexOf(filterSplit); //obtengo el indice de la palabra dentro del nuevo array

                System.out.println("las Palabras anteriores a " + filterSplit + " son: ");
                for (int i = 0; i < index; i++) {
                    System.out.println(Items[i]);
                }

                System.out.println("las Palabras Posteriores a " + filterSplit + " son: ");
                for (int i = index; i < Items.length; i++) {
                    System.out.println(Items[i]);
                }

                break;
            }
        }
    }
}
