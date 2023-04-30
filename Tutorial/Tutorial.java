import java.util.Scanner;

public class Tutorial {
    public static void main(String[] args) {
        int a=0,b=0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Hola mundo");
            a=scanner.nextInt();
            b=scanner.nextInt();

            
        }
        System.out.println(suma(a,b));
        Animal.funcion();
    }

    public static int suma(int a, int b) {
        return a + b;
    }
}
