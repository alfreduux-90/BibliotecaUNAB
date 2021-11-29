package bibliotecaunab;
//Clases para entradas de datos por teclado
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Clases para entradas de datos desde fichero
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Principal {
    public static void main (String[] args) throws IOException {
        

        cargar_archivos(); //enabled / disabled
        try{
            //Leer los objetos clientes desde clientes.dat y los guarda en el arreglo arrCli
            String nombre = "usuarios.dat";   
            FileInputStream filen = new FileInputStream(nombre);
            ObjectInputStream objE = new ObjectInputStream(filen);
            Usuario[] presUser = (Usuario[])objE.readObject(); 
            objE.close();
            //Leer los objetos Libros desde libros.dat y los guarda en el arreglo presLib
            nombre = "libros.dat";   
            filen = new FileInputStream(nombre);
            objE = new ObjectInputStream(filen);
            Libro[] presLib = (Libro[])objE.readObject(); 
            objE.close();
            
            System.out.println("\n\t**** MOSTRAR USUARIOS...*****  ");
             int numero_usuarios = mostrar_usuarios(presUser);
             System.out.println("\n\t Ingrese los datos del nuevo usuario");
             InputStreamReader en = new InputStreamReader(System.in);
             BufferedReader entrada = new BufferedReader(en);

                    Usuario usr = new Usuario("Patricio Amonacid","17888830-7",'M');
                    presUser[numero_usuarios] = usr;
                    numero_usuarios = mostrar_usuarios(presUser);
             
          //  System.out.println("\n\t**** MOSTRAR LIBROS...*****  ");
          //   int numero_libros = mostrar_libros(presLib);
    }   
        catch (FileNotFoundException e) {
            System.out.println("¡ERROR 1!:¡Fichero no existe!");
        }catch (IOException e) {
            System.out.println("¡ERROR 2!:"+e.getMessage());
        }catch (ClassNotFoundException e) {
            System.out.println("Â¡ERROR 3!:"+e.getMessage());
        }catch(NumberFormatException e){
            System.out.println("\nError de tipo de datos al ingresar su opción:"+e.toString());
        }
        
    }//fin del metodo main
        public static boolean buscarUsuario(Usuario presUser[], String run){
        int i= 0;
        while (presUser[i]!=null){
        if(run.equals(presUser[i].getRut()))
            return true;
            i++;
        }
        return false;
    }
        public static int mostrar_usuarios(Usuario presUser[]){
        System.out.println("\nUSUARIOS INGRESADOS AL SISTEMA:");
        int i=0;
        while (presUser[i]!= null){
            System.out.println(" "+i+": "+presUser[i].toString());
            i++;
        }
        return i;
    }
        public static int mostrar_libros(Libro presLib[]){
        System.out.println("\nLIBROS INGRESADOS AL SISTEMA:");
        int i=0;
        while (presLib[i]!= null){
            System.out.println(" "+i+": "+presLib[i].toString());
            i++;
        }
        return i;
    
    }//fin del mÃ©todo main

    public static void cargar_archivos() throws IOException{
                //creo los objetos para insertarlos a los archivos
        Usuario[] usr = new Usuario[20];
        usr[0] = new Usuario("Patricio Amonacid","17888830-7",'M');
        usr[1] = new Usuario("Angela Trivinos","17567830-4",'F');
        usr[2] = new Usuario("Marcela Fuentealba","15678860-4",'F');
        usr[3] = new Usuario("Camila Ortiz","19888830-3",'F');
        usr[4] = new Usuario("Felipe Catalán","16810930-4",'M');
        usr[5] = new Usuario("Alfredo Cid","17888830-7",'M');
        
        
        Libro[] lib = new Libro[20];
        lib[0] = new Libro(23423,10,10,"En Silencio","David Ouimet");
        lib[1] = new Libro(22312,5,5,"Todo lo que Somos Juntos","Alice Kellen - Booket");
        lib[2] = new Libro(23423,10,10,"Nunca","Ken Follett");
        lib[3] = new Libro(23423,10,10,"Volver a Mirar","Felipe Lecannelier - Diana");
        lib[4] = new Libro(23423,10,10,"Antes de Diciembre","Joana Marcús - Montena");
        
        try{ 
            // se escriben en ususarios.dat los objetos almacenados en usr 
            String nombre = "usuarios.dat";   
            FileOutputStream fil = new FileOutputStream(nombre);
            ObjectOutputStream objS = new ObjectOutputStream(fil);
            objS.writeObject(usr);
            objS.close();
            // se escriben en libros.dat los objetos almacenados en lib 
            nombre = "libros.dat";   
            fil = new FileOutputStream(nombre);
            objS = new ObjectOutputStream(fil);
            objS.writeObject(lib);
            objS.close();
    }        catch (IOException e){
            System.out.println("ERROR 1 al escribir usuarios.dat:"+e.getMessage());
        }catch (Exception e){
            System.out.println("ERROR 2 al escribir libros.dat:"+e.getMessage());
        }
    }//fin metodo cargar_archivos()
    
    
}
