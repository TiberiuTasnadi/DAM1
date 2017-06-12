// GIP: Gestió Inteligent Primitives
// Dades per verificar les dades de l'arxiu hist.bin:
// Primer registre: 2017-10-24-25-31-32-36-48
// Últim registre:  1985-3-11-13-15-34-35-27
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
// Si necessiteu alguna altra llibreria la podeu afegir

public class Tasnadi {
	public static void main(String[] args) {
		Scanner leer = new Scanner ( System.in );
		//Els diferents fitxers que tenim
		// Les dades que estan guardades dins del fitxer hist.bin segueixen aquest format:
		//char[] int int int int int int int  -> sense espais 
		// Exemple 2016 8 12 25 27 29 35 42
		String FitxerHist = "C:/tmp/hist.bin";
		String FitPercent = "C:/tmp/percent.txt";
		//Aquest array guarda quantes vegades es repeteix cada valor en tots els anys. ENUNCIAT2
		int [] val_rep= new int[50]; 
		float percent;
		// la variable apostes guardarà el total d'apostes que hi ha dins el fitxer XXXX.txt
		int resp = 0, opcion=0,apostes = 0,any,total=0; 
		int entrada=0;
		
		while ( opcion != 5 ){
			System.out.println("1.Creació Fitxer any XXXX.txt"); //3 punts
			System.out.println("2.Creació Fitxer percent.txt"); //3 punts
			System.out.println("3.Mostrar dades d'un any XXXX");//3 punts
			System.out.println("5.Sortir");
			System.out.print("Opcio: ");
			opcion = leer.nextInt();
			
			if ( opcion == 1 ){
			//ENUNCIAT1: A partir de l'arxiu hist.bin caldrà crear un nou arxiu XXXX.txt amb les dades de les 
			// apostes d'aquell any XXXX. L'any es demanarà desde el main() i es passará a la funció CreacioAny(), 
			// com un dels parametres d'entrada. Aquesta funció retornara al main() la quantitat d'apostes processades
			// Aquesta informació es mostrara desde el main().	
			// Exemple: Si l'usuari entra l'any 2010, es generará el fitxer 2010.txt amb les dades de totes les apostes
			// d'aquest any, i mostrara per pantalla: "S'han processat 320 apostes durant l'any 2010."	
				
			    //AQUI HI VA EL VOSTRE CODI FONT	
				
				System.out.println("Indica l'any");
				//Preguntem l'any
				any=leer.nextInt();
				while (any>2017 || any<85){
					//Comprovem les dades
					System.out.println("Indica l'any correcte(no superior al actual ni inferior al 85)");
					any=leer.nextInt();
				}
				//Reiniciem apostes per si entrem per segon cop
				apostes=0;
				//Entrem dins de la funcio (la explicare abaix)
				apostes=CreacioAny(any,FitxerHist,apostes);
				//Mostro cantitat de dades que hi han
				System.out.println(apostes);
			
			}else if ( opcion == 2 ){
				// ENUNCIAT2: Aquesta opció processara les dades del fitxer hist.bin
				// Creareu una funció anomenada ProcesDades(), i li passareu: El nom del fitxer i l'array val_rep[]	
				// Aquesta funció retornarà la quantitat d'apostes que hi ha dins del fitxer hist.bin	
				// Desde el main mostrarem la quantitat d'apostes processades i les dades de l'array val_rep[]
				// amb el següent format:
					//Número:1--Repetit:435--Percentatge:14.423077
					//Número:2--Repetit:423--Percentatge:14.025199
					//..
					//Número:48--Repetit:449--Percentatge:14.887268
					//Número:49--Repetit:411--Percentatge:13.627321	
				
				//AQUI HI VA EL VOSTRE CODI FONT
				//Reinicio les variables per si es el 2n cop que entrem
				apostes=0;
				total=0;
				percent=0;
				//Entro dins de ProcesarDades per omplir la Array val_rep
				apostes=ProcesDades(apostes,FitxerHist,val_rep);
				System.out.println("Cantitat de apostes= "+apostes);
				//Calcula el total de totes les apostes que han sortit per despres fer el percentatge
				for (int ent=0;ent<50;ent++){
					total=total+val_rep[ent];
				}
				//Mostro els resutlats
				for (int ent=0;ent<50;ent++){
					//Primer mostro la posicio, despres el contigut (vegades reoetit i despres calculare el percentatge)
					System.out.print("Numero:"+ent+"--Repetit:"+val_rep[ent]+" Percentatge:");
					percent=(float)(val_rep[ent]*100)/total;
					//Aqui mostro el percentatge
					System.out.print(" "+percent+"%\n");
				}
				
			}else if ( opcion == 3 ){
			//ENUNCIAT3: Aquesta opció demanara a l'susari que entri un any XXXX. Desde la funció MostrarDades() ens mostrara
			// les dades de totes les apostes de l'any demanat llegint-les de l'arxiu XXXX.txt (Creat en el punt 1).
			// Si de l'any demanat per l'usuari no existeix l'arxiu, 
			// mostrara per pantalla "dades no existents per l'any XXXX" des del main().	
				
				//AQUI HI VA EL VOSTRE CODI FONT
			System.out.println("Indica un any");	
			//Primer llegeixo el any
			any = leer.nextInt();
			//reinicio entrada per si es el 2n cop que entrem
			entrada=0;
			//Entrem a la funcio MostrarDadas
			entrada=MostrarDadas(any,entrada);
			//Si entrada es major a 0, osigui que hem provat un error al buscar el fitxer, sortira el missatge
			if (entrada>0){
				System.out.println("dades no existents per l'any XXXX");
			}
			
			}else if ( opcion == 5 ){
				System.out.println();
				System.out.println("Enhorabona, Heu acabat el darrer examen d'aquest mòdul!!!!");
			}else {
				resp++;
				if(resp == 1)System.out.println("You have chosen an invalid option. For some reason?");
				else if (resp == 2)System.out.println("You have chosen an invalid opction for the second time!!!!");
				else System.out.println("We recommend you take the online course:Why do you have ten fingers in your hands?");
			}
			System.out.println();
			System.out.println();
		}
		
	}
	
	//AQUI HI VAN LES DIFERENTS FUNCIONS QUE CREAREU
	public static int MostrarDadas(int any,int entrada){
		//Aquesta Funcio mostrara per pantalla el contigut de un fitxer que li indiquem
		String fitxer="c:/tmp/"+any+".txt";
		String s;
		try{
		FileReader fr = new FileReader(fitxer);
		BufferedReader br = new BufferedReader(fr);
		do { 
			//llegim la linia
			s = br.readLine();
		   	if (s != null){
		   		//Aque el mostrem
			System.out.println(s);
		   	}
		   }while(s != null);
		   fr.close();
	       br.close();
		}catch(IOException e){
			//En cas de trobar un error, entrarem aqui i pujarem entrada a 1, lo que fara que despres al mein, surti el error
			entrada=entrada+1;
			return entrada;
			
		}
		return entrada;
	}
	
	
	public static int CreacioAny (int any, String FitxerHist,int apostes){
		//Aqui crearem el fitxer
		String dadac;
		int dada;
		String fitxer_nou;
		int dada1,dada2,dada3,dada4,dada5,dada6,dada7;
		//Indiquem la ruta
		fitxer_nou="c:/tmp/"+any+".txt";
		boolean entrada=false;
		
		try{
			    DataInputStream LeeFichero=new DataInputStream(new FileInputStream(FitxerHist));
			   //Aqui començara la lectura
			    do{
			    	FileWriter fw = new FileWriter(fitxer_nou,true);
					BufferedWriter bw = new BufferedWriter(fw);
					//primer llegim el fitxer dadac, que indicara el any
			    	dadac=LeeFichero.readUTF();
			    	try{
			    		//Ara el passarem a int per despres compararlo amb el que nosaltres indiquem
			    		//Tambe llegirem les altres dadas
			    		dada=Integer.parseInt(dadac);
			    		dada1=LeeFichero.readInt();
			    		dada2=LeeFichero.readInt();
			    		dada3=LeeFichero.readInt();
			    		dada4=LeeFichero.readInt();
			    		dada5=LeeFichero.readInt();
			    		dada6=LeeFichero.readInt();
			    		dada7=LeeFichero.readInt();
			    		entrada=false;
			    		//entrada sera per sortir del do a la primera volta
			    		if (dada==any){
			    			//Si la pirmera dada de la fila (any) es el que nosaltres volem, entrarem aqui
			    			do{
			    				//Escrivim tot el que conte la linia de la nostra dada
			    				bw.write(any+" ");
			    				bw.write(dada1+" ");
			    				bw.write(dada2+" ");
			    				bw.write(dada3+" ");
			    				bw.write(dada4+" ");
			    				bw.write(dada5+" ");
			    				bw.write(dada6+" ");
			    				bw.write(dada7+" ");
			    				bw.newLine();
			    				entrada=true;
			    				//Tambe pujem apostes a +7, per indicar quantes dades hi han
			    				apostes=apostes+7;
			    			}while(entrada==false);
			    		bw.close();
						fw.close();
			    	}
			    	}catch (NumberFormatException f){
			    		return apostes;
			    	}
			    }while(true);
				
			} catch (IOException e) {
				
				return apostes;
			}	
				 
		
		
	}
	
	public static int ProcesDades(int apostes,String FitxerHist,int [] val_rep){
		//Aquesta funcio carregara la array val_rep de informacio sobre la cantitat de dades
		String dadac;
		int dada;
		int dada1,dada2,dada3,dada4,dada5,dada6,dada7;
		try{
		    DataInputStream LeeFichero=new DataInputStream(new FileInputStream(FitxerHist));
		    //primer inicialitzarem l array per si es el segon que entrem
		    for (int ent=0; ent<50;ent++){
		    	val_rep[ent]=0;
		    }
		    do{
		    	//Ara llegirem dada a dada el fitxer
		    	dadac=LeeFichero.readUTF();
		    	dada1=LeeFichero.readInt();
		    	dada2=LeeFichero.readInt();
		    	dada3=LeeFichero.readInt();
		    	dada4=LeeFichero.readInt();
		    	dada5=LeeFichero.readInt();
		    	dada6=LeeFichero.readInt();
		    	dada7=LeeFichero.readInt();
		    	//A la posicio de la dada dins de l'array list pujarem un +1 per cada cop que la trovem, de tal manera que al final, cada numero tindra la cantitat que ha sortit
		    	val_rep[dada1]=val_rep[dada1]+1;
		    	val_rep[dada2]=val_rep[dada2]+1;
		    	val_rep[dada3]=val_rep[dada3]+1;
		    	val_rep[dada4]=val_rep[dada4]+1;
		    	val_rep[dada5]=val_rep[dada5]+1;
		    	val_rep[dada6]=val_rep[dada6]+1;
		    	val_rep[dada7]=val_rep[dada7]+1;
		    	//Tornarem a contar les dades pujant apostes +7
		    	apostes=apostes+7;
		    }while(true);	    
		    
		}catch(IOException e){
			return apostes;
		}
	}
	
	
	
	
	
	
	
}
