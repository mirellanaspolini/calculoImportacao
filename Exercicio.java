import java.util.Scanner;

public class Exercicio {
    public static void main(String[] args) {
        int tipoImposto=0;      
        float precoDolar=50, valorDolar=5, precoReais=0, valImpostoFederal=0, valImpostoEstadual=0, precoTransporte=0, precoFinal=0, percImposto=0;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o preço original do produto (U$):");
        precoDolar = Float.parseFloat(leitor.nextLine());
        System.out.println("Digite o valor da cotação do dólar:");
        valorDolar = Float.parseFloat(leitor.nextLine());
        System.out.println("Digite o preço do transporte (R$):");
        precoTransporte = Float.parseFloat(leitor.nextLine());
        
        do {
            System.out.println("Informe o tipo do imposto. Sendo: 1 - IPI, 2 - ICMS, 3 - Ambos IPI e ICMS.");
            tipoImposto = Integer.parseInt(leitor.nextLine());
            if (tipoImposto > 3){
                System.out.println("Valor inválido, tente novamente: ");
            }            
        } while (tipoImposto > 3); 

        precoReais = precoDolar * valorDolar;

        switch (tipoImposto){
            case 1:
                if (precoReais <= 3000){
                    percImposto = 1.5f;
                }else if (precoReais > 3000){
                    percImposto = 2f;
                }
            break;
            case 2:
                if (precoReais < 1500){
                    percImposto = 2f;
                }else if (precoReais >= 1500){
                    percImposto = 3.5f;
                }
            break;	
            case 3:
                percImposto = 5f;
            break;        
        }
        valImpostoFederal = (precoReais * percImposto) / 100f;
        valImpostoEstadual = valImpostoFederal * (2f / 7f);
        precoFinal = precoReais + valImpostoFederal + precoTransporte + valImpostoEstadual; 

        System.out.println(String.format("Preço do produto convertido em reais: R$ %.2f", precoReais));
        System.out.println(String.format("Valor do imposto federal: R$ %.2f", valImpostoFederal));
        System.out.println(String.format("Valor do imposto estadual: R$ %.2f", valImpostoEstadual));    
        System.out.println(String.format("Preço final do produto: R$ %.2f", precoFinal));

        leitor.close();
    }
}