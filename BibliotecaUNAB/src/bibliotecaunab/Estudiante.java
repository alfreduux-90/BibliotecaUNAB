package bibliotecaunab;

public class Estudiante extends Usuario{
    String Carrera;

    public Estudiante(String Carrera, String Nombre, String Rut, char Genero) {
        super(Nombre, Rut, Genero);
        this.Carrera = Carrera;
    }

   
    public Estudiante() {
    this.Carrera = "";
    }  

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    public String getCarrera() {
        return Carrera;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "Carrera=" + Carrera +" "+ super.toString()+"}";
    }
    
}

