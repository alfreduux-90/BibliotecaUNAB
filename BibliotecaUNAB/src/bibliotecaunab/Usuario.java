package bibliotecaunab;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements java.io.Serializable{

    private String Nombre, Run;
    private char Genero;
    private int prestamo;
    //Constructor
    public Usuario(String Nombre, String Run, char Genero) {
        this.Nombre = Nombre;
        setRut(Run);//this.Run = Run;
        setGenero(Genero);//this.Genero = Genero;
        setPrestamo(prestamo);//this.prestamo = 0;
    }
    //El constructor sin parámetros sirve para cuando se creal el objeto y los datos los setea con el set.
    public Usuario() {
        this.Nombre = "";
        this.Run = "";
        this.Genero=' ';
        this.prestamo= 0;
    }
    //MUTADORES

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setRut(String Run) {
        if(validarCedula(Run)&& ValidarExisRun (Run))
        this.Run = Run;
    }

    public void setGenero(char Genero) {
        if (validarGenero(Genero))
        this.Genero = Genero;
    }

    public void setPrestamo(int prestamo) {
        if (validarPrestamo(prestamo));
        this.prestamo = prestamo;
    }
    //ACCESADORES

    public String getNombre() {
        return Nombre;
    }

    public String getRut() {
        return Run;
    }

    public char getGenero() {
        return Genero;
    }

    public int getPrestamo() {
        return prestamo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Nombre=" + Nombre + ", Rut=" + Run + ", Genero=" + Genero + ", prestamo=" + prestamo + '}';
    }
    //VALIDACIONES
    //VALIDAR RUT ejecutadas por set
    public boolean validarCedula (String _ced){
        char penChar, lastChar;
        penChar = _ced.charAt(8);
        lastChar = _ced.charAt(9);
        boolean digit = (Character.isDigit(lastChar));
        boolean K = 'K'==lastChar;
        if (_ced.length() != 10){
            sendMsj(" \nERROR... RUT Cliente mal ingresado, distinto de 10 caracteres");
            return false;
            }else{
                    if ('-'!=penChar){
                        sendMsj(" \nERROR... RUT Cliente mal ingresado, sin guíon");
                        return false;
                        }else{
                            if (!digit && !K){
                                sendMsj(" \nERROR... RUT Cliente mal ingresado, no es número ni K");
                                return false;
                        }
                    }   
            return true;
        }     
    }
    
    //public boolean ValidarExisRun(String _ced){
    //    boolean retVal = true;
    //    if(getRut() == null ? _ced == null : getRut().equals(_ced)){
    //        System.out.println("El numero de rut que ingreso ya existe!!!, registre uno nuevo");
    //    }else{
    //    retVal = false;
    //        System.out.println("Nuevo rut ingresado!!!");
    //    }
    //    return retVal;
    //}
    
    public boolean ValidarExisRun(String _ced){
        Usuario usr[] = new u[20];
        for (int i=0;i<usr.length;i++){
            usr[i] = u;
            if(_ced.equals(usr[i].getRut())){
                 return false;
            }
        }
        return true;
    }
    
    
     // public boolean ValidarExisRun(String _ced){
     //   List<Usuario> u=new ArrayList<>();
     //   int i;
     //   Usuario usuario=null;
     //       for (i=0;i>u.size();i++){             
     //             usuario=u.get(i);
     //             System.out.println("param found: "+usuario.getNombre());
     //               if(usuario.getRut() == null ? _ced == null : usuario.getRut().equals(_ced)){
     //                   sendMsj(" \nERROR... RUT ya existente");
     //                   return false;
     //               }
     //       } 
     //   return true;
    //}
    
    public boolean validarGenero(char gen){
        if ((gen== 'F') || (gen=='M'))
            return true;
        else{
        System.out.println("El genero ingresado no es correcto");
        return false;
        }
    }
    
        public boolean validarPrestamo (int numP){
        boolean retVal = true;
        if (numP!=0){
            retVal = false;
            System.out.println("Este usuario ya tiene asignado un libro");
        }
        return retVal;
    }
        
        //Metodo que recibe el mensaje a mostrar en la clase
        public void sendMsj(String msj){
            System.out.println(msj);
    }
}
