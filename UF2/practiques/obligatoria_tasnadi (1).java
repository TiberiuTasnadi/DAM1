//Tibi
import java.util.Scanner;
import java.util.Random;
public class obligatoria_tasnadi {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char[][] cadena1 = new char [8][8];
		boolean[][] cadena2 = new boolean [8][8];
		int sortida1=0,decisio,flag_nivell=0,flag_asterisc=0,flag_maquina=0;
		//Entrada2 servira per sortir del bucle de jugar, osigui quan acava el joc, tornarem al menu
		//asterisc serveix per mirar si el usuari vol o no asterisc
		//maquina serveix per mirar si el usuari vol jugar o no contra la maquina
		//entrada 3 servira per sortir del programa
		boolean entrada2=true,asterisc=false,entrada3=true,maquina=false;
		//Primer de tot omplirem la cadena2, que es la que guardara una imatge de la dels caracters pero amb booleans.
		OmplirCadena2(cadena2);
		System.out.println("Benvingut!\nEntra en cada apartat i indica la opcio que escullis, un cop passat per tots els apartats, entra a l'apartat de JUGAR");
		do{
			//depenent de la decisio del usuari, entrarem en un if que fara una cosa o una altra
				decisio=Menu();
				//decisio 1 va dedicada al nivell
				if (decisio==1){
					sortida1=Nivell();
					flag_nivell++;
				}
				//decisio 2 va dedicada al asterisc
				if (decisio==2){
					asterisc=SiONoAsterisc(asterisc);
					flag_asterisc++;
				}
				//decisio 3 va dedicada a la maquina
				if (decisio==3){
					maquina=SiONoMaquina(maquina);
					flag_maquina++;
				}
				//decisio 4 servira per jugar
				if (decisio==4){
					//En cas de no hacver passat per cada apartat anterior, no pujara el seu contador i el programa ens fa tornar per entrar-hi
					if(flag_maquina>0 && flag_nivell>0 && flag_asterisc>0){
						//En cas de haver entrat, entrada2 es posara a false i podrem jugar
						entrada2=false;
						OmplirMatriu(sortida1,cadena1,asterisc,cadena2);
					}else{
						System.out.println("Et fa falta entra a les opcions/opcio:");
						if (flag_maquina==0){
							System.out.println("Maquina");
						}
						if (flag_nivell==0){
							System.out.println("Nivell");
						}
						if (flag_asterisc==0){
							System.out.println("Asterisc");
						}
					}
				}
				if (decisio==5){
					//En cas de que la nostra decisio sigui 5, sortirem del joc
					entrada3=false;
				}
				
				while(entrada2==false){
					//Aqui comença la jugada
				entrada2=Jugar(sortida1, cadena1, cadena2,asterisc,maquina);
				entrada2=true;
				}
									
		}while(entrada3==true);
	}
	//Aquesta funcio va dedicada al menu, que es mostra a la part superior
	public static int Menu(){
		Scanner sc=new Scanner(System.in);
		int decisio=0;
		System.out.print("-----------------------------------------------------");
		System.out.print("\n1.Nivell\n2.Asterisc\n3.Maquina\n4.Jugar\n5.Sortir");
		System.out.print("\n-----------------------------------------------------\n");
		decisio=sc.nextInt();
		//Aqui comprovem que els parametres intorduits son els correctes
		while (decisio!=1&&decisio!=2&&decisio!=3&&decisio!=4&&decisio!=5){
			System.out.println("\nSol pots les seguents opcions: \n1.Nivell\n2.Asterisc\n3.Maquina\n4.Jugar");
			decisio=sc.nextInt();
		}
		return decisio;
	}
	//Aquesta funcio pregutnara al usuari si vol o no jugar am la maquina
	public static boolean SiONoMaquina(boolean maquina){
		Scanner sc=new Scanner(System.in);
		int decisio;
		System.out.println("Indica si vols o no la opcio de jugar amb la maquina\n1.Si\n2.No");
		decisio=sc.nextInt();
		//Aqui comprovem que els parametres intorduits son els correctes
		while(decisio!=1 && decisio!=2){
			System.out.println("Indica la opcio correcta(sol 1 o 2)\n1.Si\n2.No");
			decisio=sc.nextInt();
		}
		//Aqui donem els valor depenent de la decisio del usuari
		if (decisio==1){
			maquina=true;
		}else if(decisio==2){
			maquina=false;
		}
		return maquina;
	}
	//Aquesta funcio mirara si el usuari vol o no jugar amb un asterisc
	public static boolean SiONoAsterisc(boolean asterisc){
		Scanner sc=new Scanner(System.in);
		int decisio;
		System.out.println("Indica si vols o no la opcio de asterisc(es barrejara la taula en cas de no trovar la seva parella)\n1.Si\n2.No");
		decisio=sc.nextInt();
		//Aqui comprovem que els parametres intorduits son els correctes
		while(decisio!=1 && decisio!=2){
			System.out.println("Indica la opcio correcta(sol 1 o 2)\n1.Si\n2.No");
			decisio=sc.nextInt();
		}
		//Aqui asignarem el els valor depenent dfe la decisio del usuari
		if (decisio==1){
			asterisc=true;
		}else if(decisio==2){
			asterisc=false;
		}
		return asterisc;
	}
	//Aquesta funcio omplira la cadena de booleans a false, per en un futur mirar si s'ha endevinat la casella respectiva	
	public static void OmplirCadena2(boolean cadena[][]){
		int entrada1=0,entrada2=0,sortida=8;
		for (entrada1=0;entrada1<sortida;entrada1++){
			for (entrada2=0;entrada2<sortida;entrada2++){
				cadena[entrada1][entrada2]=false;
			}
		}
		
	}
	//Aquesta funcio mirara el nivell que vol el usuari
	public static int Nivell(){
		int sortida;
		Scanner sc=new Scanner(System.in);
		System.out.println("Indica el nivell de dificultat \n1.4x4\n2.6x6\n3.8x8");
		sortida=sc.nextInt();
		//Aqui comprovem que els parametres intorduits son els correctes
		while (sortida!=1 && sortida!=2 && sortida !=3){
			System.out.println("Sol poden ser els que es mostra abaix \nIndica el nivell de dificultat \n1.4x4\n2.6x6\n3.8x8");
			sortida=sc.nextInt();
		}
		//Depenent de la decisio, es cambiara els parametres dde sortida, ja que sol juguem amb 4,6 o 8 (sortida=maxim caselles per fila)
		if (sortida==1){
			sortida=4;
		}
		if (sortida==2){
			sortida=6;
		}
		if (sortida==3){
			sortida=8;
		}
		return sortida;
		
	}
	//Omplir matriu ficara dins de la matriu les lletres que pertoquen
	public static boolean OmplirMatriu(int sortida, char cadena1[][],boolean asterisc, boolean cadena_boolean[][]){
		Random rnd=new Random();
		int entrada=0,entrada2=0;
		boolean entrada5=false;
		int lletra,cantitat,aux_cantitat,posicio_parella_n,posicio_parella_m,entrada3,entrada4,posicio_ast1_m,posicio_ast1_n,posicio_ast2_m,posicio_ast2_n;
		//cantitat sera la cantitat de llestres que hi hauran
		cantitat=(sortida*sortida)/2;
		//En cas de que a la posicio de la matriu de booleans hi ha un false, ficare en la matriu de caracters un 0
		for (entrada=0;entrada<sortida;entrada++){
			for(entrada2=0;entrada2<sortida;entrada2++){
				if (cadena_boolean[entrada][entrada2]==false){
					cadena1[entrada][entrada2]=0;
				}
				 
			}
		}
		if (asterisc==true){
			entrada5=true;
			
		}
		//En cas de tenir la opcio dels asterics, farem aquests bucles, que serveix per inidcar un aposuicio random al asterisc
		while (entrada5==true){
			posicio_ast1_m=rnd.nextInt(sortida);
			posicio_ast2_m=rnd.nextInt(sortida);
			posicio_ast1_n=rnd.nextInt(sortida);
			posicio_ast2_n=rnd.nextInt(sortida);
			//Aqui comprovem que els parametres son els correctes
			while (posicio_ast1_m==posicio_ast2_m && posicio_ast1_n==posicio_ast2_n){
				posicio_ast1_m=rnd.nextInt(sortida);
				posicio_ast2_m=rnd.nextInt(sortida);
				posicio_ast1_n=rnd.nextInt(sortida);
				posicio_ast2_n=rnd.nextInt(sortida);
			}
			cadena1[posicio_ast1_m][posicio_ast1_n]='*';
			cadena1[posicio_ast2_m][posicio_ast2_n]='*';
			entrada5=false;
		}
		//Aqui començare a omlir la matriu
		for (entrada=0;entrada<sortida;entrada++){
			for (entrada2=0;entrada2<sortida;entrada2++){
				//En cas de tenir un 0 a la matriu dels caracters(anteriorment intorduit) i no hi ha cap asterisc, aqui intoruire una lletra
				if (cadena1[entrada][entrada2]==0 && cadena1[entrada][entrada2]!='*' && cadena_boolean[entrada][entrada2]==false ){
					//la lletra es un random de cantitat que li sumare un 65 per tal de coincidir amb el codi ASCII
					lletra=rnd.nextInt(cantitat);
					aux_cantitat=65+lletra;
					//En cas de la opcio de 8x8 haurem de intoruir nimuscules tambe netrant en aquest parametre sumat 6 per saltar els caracters en cas de que dona mes de 90
					if (aux_cantitat>90 && aux_cantitat<97){
						aux_cantitat=aux_cantitat+6;
					}
					//En cas de tenir el el caracter repetit, ja que es posible perque es un random, entrarem aqui i el cambiarem
					for (entrada3=0;entrada3<sortida;entrada3++){
						for (entrada4=0;entrada4<sortida;entrada4++){
							while (cadena1[entrada3][entrada4]==aux_cantitat){
								lletra=rnd.nextInt(cantitat);
								aux_cantitat=65+lletra;
								if (aux_cantitat>90 && aux_cantitat<97){
									aux_cantitat=aux_cantitat+6;
								}
								entrada4=0;
								entrada3=0;
							}
						}
					}
					//Aqui intorueixo el caracter dins de la matriu
					cadena1[entrada][entrada2]=(char)aux_cantitat;
					//Tambe fico la seva parella en una latra posicio random
					posicio_parella_n=rnd.nextInt(sortida);
					posicio_parella_m=rnd.nextInt(sortida);
					//Aqui comprovem que els parametres son els correctes
					while (cadena1[posicio_parella_n][posicio_parella_m]!=0 || cadena1[posicio_parella_n][posicio_parella_m]=='*'){
						posicio_parella_n=rnd.nextInt(sortida);
						posicio_parella_m=rnd.nextInt(sortida);
					}
					//Aqui introdueixo la parella
					cadena1[posicio_parella_n][posicio_parella_m]=(char)aux_cantitat;
				}
			
				
			}
		}
		
		return asterisc;
		
	}
	//Aquesta funcio es la que cridara altres funcions per poder jugar
	public static boolean Jugar(int sortida,char cadena[][], boolean cadena_boolean[][],boolean asterisc, boolean maquina){
		Scanner sc=new Scanner(System.in);
		Random rnd=new Random();
		char [][] memoria_maquina = new char [8][8];
		int intents=0,seguir,puntuacio_usuari=0,qui_comença,puntuacio_maquina=0,entrada1=0,entrada3=0;
		boolean sortida2=false,entrada2=false;
		//Tornem a omplir la matriu de booleans a false, per si acas aquesta es la segona volta i es guarda a la l'anterior
		OmplirCadena2(cadena_boolean);
		//Tambe tornem a omplir la matriu en cas de que sigui la segona volta
		OmplirMatriu(sortida,cadena,asterisc,cadena_boolean);
		//En cas de no voler jugar amb la maquina entrara aqui
		if (maquina==false){
			do{
				//Primer haurem de apretar qualsevol caracter per continuar
				System.out.println("Presiona qulsevol numero per continuar");
				seguir=sc.nextInt();
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				//Despres es mostrara el taulell tal i qual com queda amb les parelles fetes i amb les que no
				MostrarTaulell(cadena,sortida,cadena_boolean);
				//Ara el usuari indicara les cordenades
				puntuacio_usuari=Cordenades(cadena,sortida,cadena_boolean,asterisc,puntuacio_usuari,memoria_maquina);
				//Pujarem el cotnador de intents per mirar les rondes que farem
				intents++;
				//Al final comprovarem si la cantitat de caselles que haurien de estar a TRUE ho estan (explico millor quan toca la funcio)
				entrada2=ComprovarTaulell(cadena_boolean,sortida,asterisc);
				//En cas de que sigui corecte el anterior, sortirem del joc i donarem info sobre els intents. Tambe tornarem al menu
			}while(entrada2==true);
			System.out.println("JOC FINALITZAT\nRondes: "+intents);
		}
		//En cas de voler jguar amb la maquina, entrarem aqui
		if (maquina==true){
			//qui_comença definira si començes tu o la maquina
			qui_comença=rnd.nextInt(2);
			//En cas de que el resultat es 0 començaras tu
			if (qui_comença==0){
				System.out.println("Jugues tu primer");
				//Ara reiniciarem la memoria de la maqui a espais en blanc per si acas es la segona volta
				for (entrada1=0;entrada1<sortida;entrada1++){
					for (entrada3=0;entrada3<sortida;entrada3++){
						memoria_maquina[entrada1][entrada3]=' ';
						}
					}
				do{
					//Igual que amb jugar solirari, seguirem el seguent:
					System.out.println("Presiona qulsevol numero per continuar");
					seguir=sc.nextInt();
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					puntuacio_usuari=Cordenades(cadena,sortida,cadena_boolean,asterisc,puntuacio_usuari,memoria_maquina);
					intents++;
					System.out.println("Presiona qulsevol numero per continuar");
					seguir=sc.nextInt();
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("Taulell definitiu: ");
					MostrarTaulell(cadena,sortida,cadena_boolean);
					entrada2=ComprovarTaulell(cadena_boolean,sortida,asterisc);
					//En cas de que no s'haigui acavat el joc i entrada sigui igual a true jugara la maquina
					if (entrada2==true){
						//aqui jugara la maquina
						puntuacio_maquina=CordenadesMaquina(cadena,sortida,cadena_boolean,asterisc,puntuacio_maquina,memoria_maquina);
						System.out.println("Presiona qulsevol numero per continuar");
						seguir=sc.nextInt();
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						System.out.println("Taulell definitiu: ");
						//mostrare el taulell definitiu per que el puguis memoritzar
						MostrarTaulell(cadena,sortida,cadena_boolean);
						//tornem a comprovar si esta acavat el joc per poder sortir
						entrada2=ComprovarTaulell(cadena_boolean,sortida,asterisc);
					}
				}while(entrada2==true);
				//en cas de acavar, mostrerem els segeunts resultats:
				//si hem tret mes puntiacio que la maquina entrem aqui
				if (puntuacio_usuari>puntuacio_maquina){
					System.out.println("JOC FINALITZAT\nHas Guanyat Tu\nRondes: "+intents+"\nPuntuacio Maquina: "+puntuacio_maquina+"\nPuntuacio Usuari: "+puntuacio_usuari);
				//si la maquina ha tret mes puntuacio entrem aqui
				}else if (puntuacio_usuari<puntuacio_maquina){
					System.out.println("JOC FINALITZAT\nHa guanyat la maquina\nRondes: "+intents+"\nPuntuacio Maquina: "+puntuacio_maquina+"\nPuntuacio Usuari: "+puntuacio_usuari);
				}else if (puntuacio_usuari==puntuacio_maquina){
					System.out.println("JOC FINALITZAT\nHeu quedat empat\nRondes: "+intents+"\nPuntuacio Maquina: "+puntuacio_maquina+"\nPuntuacio Usuari: "+puntuacio_usuari);
				}
				//Ara tornarem un altre cop al menu
			}
			//En cas de que començi primer la maquina entrem aqui
			if(qui_comença==1){
				System.out.println("Jugue la maquina primer");
				//per si acas reiniciem la memoria de la maquina en cas de que sigui ñla segona volta
				for (entrada1=0;entrada1<sortida;entrada1++){
					for (entrada3=0;entrada3<sortida;entrada3++){
						memoria_maquina[entrada1][entrada3]=' ';
						}
					}
				do{
					//Aqui igaul que en jugar a solitari fem els seguetns passos
					System.out.println("Presiona qulsevol numero per continuar");
					seguir=sc.nextInt();
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					//jugue la maquina aqui
					puntuacio_maquina=CordenadesMaquina(cadena,sortida,cadena_boolean,asterisc,puntuacio_maquina,memoria_maquina);
					System.out.println("Presiona qulsevol numero per continuar");
					seguir=sc.nextInt();
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("Taulell definitiu: ");
					//mostra el taulell
					MostrarTaulell(cadena,sortida,cadena_boolean);
					entrada2=ComprovarTaulell(cadena_boolean,sortida,asterisc);
					if (entrada2==true){
						//ara jugara el usuari
						puntuacio_usuari=Cordenades(cadena,sortida,cadena_boolean,asterisc,puntuacio_usuari,memoria_maquina);
						System.out.println("Presiona qulsevol numero per continuar");
						seguir=sc.nextInt();
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						System.out.println("Taulell definitiu: ");
						//Es mostra el taulell tal com queda
						MostrarTaulell(cadena,sortida,cadena_boolean);
						//Pujem el contador de rondes
						intents++;
						//Comprovem si sa acavat el joc
						entrada2=ComprovarTaulell(cadena_boolean,sortida,asterisc);
					}
				}while(entrada2==true);
				//En cas de que s'ha terminat, mirem la puntuacio i mostrem els segeuts:
				if (puntuacio_usuari>puntuacio_maquina){
					System.out.println("JOC FINALITZAT\nHas Guanyat Tu\nRondes: "+intents+"\nPuntuacio Maquina: "+puntuacio_maquina+"\nPuntuacio Usuari: "+puntuacio_usuari);
				}else if (puntuacio_usuari<puntuacio_maquina){
					System.out.println("JOC FINALITZAT\nHa guanyat la maquina\nRondes: "+intents+"\nPuntuacio Maquina: "+puntuacio_maquina+"\nPuntuacio Usuari: "+puntuacio_usuari);
				}else if (puntuacio_usuari==puntuacio_maquina){
					System.out.println("JOC FINALITZAT\nHeu quedat empat\nRondes: "+intents+"\nPuntuacio Maquina: "+puntuacio_maquina+"\nPuntuacio Usuari: "+puntuacio_usuari);
				}
			
			}
			
		}
		//Tornem al menu i tornem a elegir el que fem
		return entrada2;
	}
	//Aquesta fucnio mostrare el taulell com qeuda un cop elegides les cordenades amb els interogants i les parelles
	public static void MostrarTaulell(char cadena[][],int sortida,boolean cadena_boolean[][]){
		int entrada1=0,entrada2=0;
		for (entrada1=0;entrada1<sortida;entrada1++){
			for (entrada2=0;entrada2<sortida;entrada2++){
				//En cas de que a la posicio indicada a la matriu de booleans hi ha un false, mostrara un interrogant
				if (cadena_boolean[entrada1][entrada2]==false){
					System.out.print("?\t");
				}
				//sino, mostrara el contigut
				if (cadena_boolean[entrada1][entrada2]==true){
					System.out.print(cadena[entrada1][entrada2]+"\t");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n\n\n");
	}
	//Aqui juga la maquina
	public static int CordenadesMaquina(char cadena[][],int sortida,boolean cadena_boolean[][],boolean asterisc, int puntuacio_maquina, char memoria_maquina[][]){
		Random rnd=new Random();
		int ufila=0,ucolumna=0,dosfila=0,doscolumna=0,entrada1=0,entrada2=0,entrada8=0,entrada9=0,cont_parelles=0;
		boolean entrada10,continuar=true,entrada3=false,entrada4,entrada5=false,entrada6=false,entrada7;
		char aux='x',igual=' ';
		//fem servir un do, per si endivina una parella, que torni a fer tot el recorregut un altre cop
		do{
			System.out.println("Resultat de la maquina:");
			continuar=false;
			entrada4=true;
			entrada7=true;
			aux='x';
			//Aqui mirarem si hi ha una parella dins de la seva memoria que no haigui sigut endevinada
			for (entrada1=0;entrada1<sortida;entrada1++){
				for (entrada2=0;entrada2<sortida;entrada2++){
					if (memoria_maquina[entrada1][entrada2]!=' '&&cadena_boolean[entrada1][entrada2]==false){
						aux=(char)memoria_maquina[entrada1][entrada2];
						for (entrada8=0;entrada8<sortida;entrada8++){
							for(entrada9=0;entrada9<sortida;entrada9++){
								if (entrada1!=entrada8||entrada2!=entrada9){
									if(aux==(char)memoria_maquina[entrada8][entrada9]&&cadena_boolean[entrada8][entrada9]==false){
										//En cas de trovar una parella ,entrada7 es posa en false i guardem el digit en un altra variable
										entrada7=false;
										igual=aux;
										entrada9=sortida;
										entrada8=sortida;
										entrada2=sortida;
										entrada1=sortida;
										
										
									}
								}
							}
						}
					}
				}
				
			}
			//Si s'ha trovat una parella es posara entrada7 en false i entrem aqui
			if (entrada7==false){
				cont_parelles=0;
				for (entrada1=0;entrada1<sortida;entrada1++){
					for(entrada2=0;entrada2<sortida;entrada2++){
						//Busco disn de la memoria on esta aquesta lletra
						if (igual==(char)memoria_maquina[entrada1][entrada2]&&cadena_boolean[entrada1][entrada2]==false){
							//Si es el primer cop que la trovem, entrem aqui i despres pujem el contador, per tal de que si trovem la parella, entresam en el seguent if
							if (cont_parelles==0){
								ufila=entrada1;
								ucolumna=entrada2;
							}
							if (cont_parelles!=0){
								dosfila=entrada1;
								doscolumna=entrada2;
								entrada2=sortida;
								entrada1=sortida;
								
							}
							cont_parelles++;
						}
					}
				}
				
			}
			//En cas de no trovar cap parella, entrarem aqui i donarem posicions random
			else if (entrada7==true){
			ufila=rnd.nextInt(sortida);
			ucolumna=rnd.nextInt(sortida);
			dosfila=rnd.nextInt(sortida);
			doscolumna=rnd.nextInt(sortida);
			}
			//tambe comprovem en els seguents if si el resutlat del random es correcte
			if(ufila==dosfila&&ucolumna==doscolumna){
				ufila=rnd.nextInt(sortida);
				ucolumna=rnd.nextInt(sortida);
				dosfila=rnd.nextInt(sortida);
				doscolumna=rnd.nextInt(sortida);
			}
		
			if (ufila<0||dosfila<0||ucolumna<0||doscolumna<0){
				ufila=rnd.nextInt(sortida);
				ucolumna=rnd.nextInt(sortida);
				dosfila=rnd.nextInt(sortida);
				doscolumna=rnd.nextInt(sortida);
			}
			if (cadena_boolean[ufila][ucolumna]==true||cadena_boolean[dosfila][doscolumna]){
				ufila=rnd.nextInt(sortida);
				ucolumna=rnd.nextInt(sortida);
				dosfila=rnd.nextInt(sortida);
				doscolumna=rnd.nextInt(sortida);
			}
			//Aqui miro si a la posicio que ha indicat la maquina hi ha un asterisc i no trova la seva parella		
			if ((cadena[ufila][ucolumna]=='*' && cadena[dosfila][doscolumna]!='*')||(cadena[dosfila][doscolumna]=='*' && cadena[ufila][ucolumna]!='*')){
				System.out.print("\nUna de les parelles que ha trovat la maquina era un asterisc i no ha trovat la parella dell. Es tornara a barrejar la taula\n");
				//Ensenyo les fitxes de les posicions indicades
				for (entrada1=0;entrada1<sortida;entrada1++){
					for(entrada2=0;entrada2<sortida;entrada2++){
						if (entrada1==ufila && entrada2==ucolumna){
							System.out.print(cadena[ufila][ucolumna]+"\t");
						}else if(entrada1==dosfila && entrada2==doscolumna){
							System.out.print(cadena[dosfila][doscolumna]+"\t");
						}else{
							if (cadena_boolean[entrada1][entrada2]==true){
								System.out.print(cadena[entrada1][entrada2]+"\t");
							}else{
							System.out.print("?\t");
							}
						}
					}
					System.out.print("\n");
				}
				//torno a barejar la matriu i no podrem entrar el l'apartat de abaix, que es la de comprovar els resutlats de les cordenades
				OmplirMatriu(sortida,cadena,asterisc,cadena_boolean);
				
				entrada4=false;
			}
			//En cas de no trovar un asterisc, entro aqui
			while (entrada4==true){
			//Aqui comprovo si el resultat de les cordenades dona dos parelles
			if (cadena[ufila][ucolumna]==cadena[dosfila][doscolumna]){
				if (cadena[ufila][ucolumna]!='*'&&cadena[dosfila][doscolumna]!='*'){
				cadena_boolean[ufila][ucolumna]=true;
				cadena_boolean[dosfila][doscolumna]=true;
				puntuacio_maquina=puntuacio_maquina+10;
				continuar=true;
				}
				//En cas de  que el resutlat son dos asterisc dono mes punts
				if (cadena[ufila][ucolumna]=='*' && cadena[dosfila][doscolumna]=='*'){
					cadena_boolean[ufila][ucolumna]=true;
					cadena_boolean[dosfila][doscolumna]=true;
					puntuacio_maquina=puntuacio_maquina+25;
					continuar=true;
				}
			//En cas de trovar 2 parelles, continuar es tornara true, que es el final del do, on si es cert, tornem a fer el do, ja que hem endevinat dos parelles
			}
			//Aqui mostro el resultat de les cordenades per que el usuari pugui memoritzar
			for (entrada1=0;entrada1<sortida;entrada1++){
				for(entrada2=0;entrada2<sortida;entrada2++){
					if (entrada1==ufila && entrada2==ucolumna){
						System.out.print(cadena[ufila][ucolumna]+"\t");
					}else if(entrada1==dosfila && entrada2==doscolumna){
						System.out.print(cadena[dosfila][doscolumna]+"\t");
					}else{
						if (cadena_boolean[entrada1][entrada2]==true){
							System.out.print(cadena[entrada1][entrada2]+"\t");
						}else{
						System.out.print("?\t");
						}
					}
				}
				System.out.print("\n");
			}
			//surto de la opcio de jugar
			entrada4=false;
			}
			//guardo a la memoria de la maqui les cordenades indicades
			memoria_maquina[ufila][ucolumna]=cadena[ufila][ucolumna];
			memoria_maquina[dosfila][doscolumna]=cadena[dosfila][doscolumna];
			//miro si s'ha acavat el joc per no tornoar a jugar en cas de trovar una parella
			entrada10=ComprovarTaulell(cadena_boolean,sortida,asterisc);
			if (entrada10==false){
				continuar=false;
			}
		}while(continuar==true);
		//retorno la puntuacio de la maquina
		return puntuacio_maquina;
	}
	
	//En aquesta funcio jugara el usuari
	public static int Cordenades(char cadena[][],int sortida,boolean cadena_boolean[][],boolean asterisc, int puntuacio_usuari,char memoria_maquina[][]){
		Scanner sc=new Scanner(System.in);
		int ufila,ucolumna,dosfila,doscolumna,entrada1=0,entrada2=0,ultima_cord;
		boolean entrada10,continuar=true,entrada3=false,entrada4,entrada5=false,entrada6=false;
		entrada4=true;
		ultima_cord=sortida-1;
		//ultima_cord es perque el usuari recordi quina es la ultima posicio que pot donar i no passarse
		//do es perque si endivina una parella, tornara a jugar
		do{
			entrada4=true;
			continuar=false;
			//Indico les cordenades aqui
		System.out.println("Indica les cordenades(Recorda que el primer es el 0 i el ultim es el "+ultima_cord+")\nLa primera parella:\nFila: ");
		ufila=sc.nextInt();
		System.out.println("Columna: ");
		ucolumna=sc.nextInt();
		System.out.println("Segona parella:\nFila: ");
		dosfila=sc.nextInt();
		System.out.println("Columna");
		doscolumna=sc.nextInt();
		//Ara comprovare si el que ha introduit es correcte amb els if que venen a continuacio:
		if(ufila==dosfila&&ucolumna==doscolumna){
			entrada3=true;
		}
		while(entrada3==true){
			do{
				System.out.println("Has introduit dos cops la mateixa casella. Tornaho a provar\nFila:");
				ufila=sc.nextInt();
				System.out.println("Columna: ");
				ucolumna=sc.nextInt();
				System.out.println("Segona parella:\nFila: ");
				dosfila=sc.nextInt();
				System.out.println("Columna");
				doscolumna=sc.nextInt();
			}while(ufila==dosfila&&ucolumna==doscolumna);
			entrada3=false;
		}
		if (ufila<0||dosfila<0||ucolumna<0||doscolumna<0){
			entrada5=true;
		}
		while(entrada5==true){
			do{
				System.out.println("Has introduit un numero negatiu, torna a intorudir\nFila:");
				ufila=sc.nextInt();
				System.out.println("Columna: ");
				ucolumna=sc.nextInt();
				System.out.println("Segona parella:\nFila: ");
				dosfila=sc.nextInt();
				System.out.println("Columna");
				doscolumna=sc.nextInt();
			}while(ufila<0||dosfila<0||ucolumna<0||doscolumna<0);
			entrada5=false;
		}
		if (ufila>ultima_cord||dosfila>ultima_cord||ucolumna>ultima_cord||doscolumna>ultima_cord){
			entrada6=true;
		}
		while(entrada6==true){
			do{
				System.out.println("Has introduit un numero superior al permes (no pot ser mes gran que "+ultima_cord+")\nFila:");
				ufila=sc.nextInt();
				System.out.println("Columna: ");
				ucolumna=sc.nextInt();
				System.out.println("Segona parella:\nFila: ");
				dosfila=sc.nextInt();
				System.out.println("Columna");
				doscolumna=sc.nextInt();
			}while(ufila>ultima_cord||dosfila>ultima_cord||ucolumna>ultima_cord||doscolumna>ultima_cord);
			entrada6=false;
		}
		
		//Aqui començara el joc.
		//Primer de tot miro si has trobat un asterisc i no la seva parella. Osigui es torna a barejar
		if ((cadena[ufila][ucolumna]=='*' && cadena[dosfila][doscolumna]!='*')||(cadena[dosfila][doscolumna]=='*' && cadena[ufila][ucolumna]!='*')){
			System.out.print("\nUna de les parelles era un asterisc i no has trovat la parella dell. Es tornara a barrejar la taula\n");
			//Mostro on has indicat les cordenades per veure que no es fals
			for (entrada1=0;entrada1<sortida;entrada1++){
				for(entrada2=0;entrada2<sortida;entrada2++){
					if (entrada1==ufila && entrada2==ucolumna){
						System.out.print(cadena[ufila][ucolumna]+"\t");
					}else if(entrada1==dosfila && entrada2==doscolumna){
						System.out.print(cadena[dosfila][doscolumna]+"\t");
					}else{
						if (cadena_boolean[entrada1][entrada2]==true){
							System.out.print(cadena[entrada1][entrada2]+"\t");
						}else{
						System.out.print("?\t");
						}
					}
				}
				System.out.print("\n");
			}
			//aqui barrejem i no podrem entrar a la opcio de abaix per comprobar
			OmplirMatriu(sortida,cadena,asterisc,cadena_boolean);
			entrada4=false;
		}
		while (entrada4==true){
		if (cadena[ufila][ucolumna]==cadena[dosfila][doscolumna]){
			//En cas de trovar una parella  netrarem aqui i donarem la puntuacio
			if (cadena[ufila][ucolumna]!='*'&&cadena[dosfila][doscolumna]!='*'){
			cadena_boolean[ufila][ucolumna]=true;
			cadena_boolean[dosfila][doscolumna]=true;
			puntuacio_usuari=puntuacio_usuari+10;
			continuar=true;
			}
			//En cas de trovar un asterisc i la seva parella entrem aqui
			if (cadena[ufila][ucolumna]=='*' && cadena[dosfila][doscolumna]=='*'){
				cadena_boolean[ufila][ucolumna]=true;
				cadena_boolean[dosfila][doscolumna]=true;
				puntuacio_usuari=puntuacio_usuari+25;
				continuar=true;
			}
			//Si hem entreat aqui, continuar se posa a true i podrem tornar a jugar la ronda al final
		}
		//Aqui mostro el resultat de les cordenades perque pugui memoritzar
		for (entrada1=0;entrada1<sortida;entrada1++){
			for(entrada2=0;entrada2<sortida;entrada2++){
				if (entrada1==ufila && entrada2==ucolumna){
					System.out.print(cadena[ufila][ucolumna]+"\t");
				}else if(entrada1==dosfila && entrada2==doscolumna){
					System.out.print(cadena[dosfila][doscolumna]+"\t");
				}else{
					if (cadena_boolean[entrada1][entrada2]==true){
						System.out.print(cadena[entrada1][entrada2]+"\t");
					}else{
					System.out.print("?\t");
					}
				}
			}
			System.out.print("\n");
		}
		//Aqui sortirem del bucle
		entrada4=false;
		}
		//Guardem les posuicions a la memoria de la maquina
		memoria_maquina[ufila][ucolumna]=cadena[ufila][ucolumna];
		memoria_maquina[dosfila][doscolumna]=cadena[dosfila][doscolumna];
		//comprovem si ja hem acavat, per si tenim opcio de torna a repetir la ronda pero ja hem acavat el taulell
		entrada10=ComprovarTaulell(cadena_boolean,sortida,asterisc);
		if (entrada10==false){
			continuar=false;
		}
		}while(continuar==true);
		//retorno la puntuacio del usuari
		return puntuacio_usuari;
		
				
	}
	//Aquesta es la funcio que ens comprovara si el joc esta acavat
	public static boolean ComprovarTaulell(boolean cadena_boolean[][],int sortida,boolean asterisc){
		int entrada1=0,entrada2=0,cont_bones=0,total_bones=0;
		boolean sortida2=true;
		total_bones=(sortida*sortida);
		for (entrada1=0;entrada1<sortida;entrada1++){
			for (entrada2=0;entrada2<sortida;entrada2++){
				//Faig un contador per contar dins de la cadena de booleans quantes hi han amb true
				if (cadena_boolean[entrada1][entrada2]==true){
					cont_bones++;
				}
			}
		}
		//Si aquesta cantiat es igual a la cantiat total, soreirem i anirem al menu
		if (cont_bones==total_bones){
			sortida2=false;
		}
		return sortida2;
	}
	
	
}
