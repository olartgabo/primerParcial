import java.util.Scanner;

public class SumaDigitos {

    public static int sumaDigitos(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumaDigitos(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa un numero: ");
        int numero = sc.nextInt();
        System.out.println("La suma de sus digitos es: " + sumaDigitos(numero));
    }
}
