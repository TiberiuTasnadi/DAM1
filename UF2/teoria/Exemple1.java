import java.util.Scanner;

public class Exemple1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int num1,num2,total,opcio, conta;
      Scanner llegir=new Scanner(System.in);
      
      num1 = num2 = total = conta =0;
      
      do {
    	  	System.out.println("Onpcions:");
    	  	System.out.println("1.Entrar dos nombres.");
    	  	System.out.println("2.Sumar");
    	  	System.out.println("3.Restar");
    	  	System.out.println("4.Multiplicar");
    	  	System.out.println("9.Sortir");
      
    	  	System.out.println("Escull una opció:");
    	  	opcio = llegir.nextInt();
      
    	  	if(opcio == 1){
    	  		System.out.println("Entra dos nombres:");
    	  		num1 = llegir.nextInt();
    	  		num2 = llegir.nextInt();
    	  	}
    	  	else if (opcio == 2){
    	  		total = num1 + num2;
    	  		conta++;
    	    }
    	  	else if (opcio == 3){
    	  		total = num1-num2;
    	  		conta++;
    	  	}
    	  	else if (opcio == 4){
    	  		total = num1*num2;
    	  		conta++;
    	  	}
            if (opcio != 9)
            		System.out.println("El resultat és:"+ total);
           
      }while (opcio!=9);
      
      System.out.println("S'han realitzat "+conta+" operacions.");
      
      llegir.close();
	}

}
