import java.util.Scanner;

public class Calculator {

    //Definindo metodo estático para entrada de números;
    static double readNumber(Scanner input, String mensagem){
        System.out.println(mensagem);
        return input.nextDouble();
    }

    //Definindo metodo estático para escolha de uma operação com switch;
    static double calculate(double number1, double number2, int operator){
        switch (operator){
            case 1:
                return number1 + number2;
            case 2:
                return number1 - number2;
            case 3:
                return number1 * number2;
            case 4:
                if (number2 == 0){
                    System.out.println("Não pode dividir por zero!"); // Condicional para possível problema lógico;
                    return 0;
                }
                return number1 / number2;
            default:
                System.out.println("Operação inválida!");
                return 0;
        }
    }

    static void main(String[] args) {

        // Criação de objeto para entrada de números;
        Scanner input = new Scanner(System.in);

        //Estrutura em loop infinito 'TRUE', finaliza apenas com a parada da segunda condição;
        while(true){

            System.out.println( """
                CALCULADORA
                1 - Soma
                2 - Sub
                3 - Mult
                4 - Div
                0 - Sair""");

            //Conversão de double para int (cast);
            int choice = (int) readNumber(input, "Escolha uma opção: ");

            // Condição validando as opções (1, 2, 3, 4, 0), se for diferente retorna para o inicio do loop;
            if (choice < 0 || choice > 4){
                System.out.println("Opção inválida!");
                continue;
            }

            if (choice == 0) {
                System.out.println("Operação sendo encerrada!");
                break;
            }

            //Chamada do primeiro metodo;
            double first = readNumber(input, "Informe o primeiro número: ");
            double second = readNumber(input, "Informe o segundo número");

            //Chamada do segundo metodo;
            double result = calculate(first, second, choice);

            System.out.printf("O resultado: %.2f\n",  result);
            input.close();
        }
    }
}
