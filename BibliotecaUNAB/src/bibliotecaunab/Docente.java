package bibliotecaunab;

public class Docente extends Usuario{
    private String profesion, grado;

    public Docente(String profesion, String grado, String Nombre, String Rut, char Genero) {
        super(Nombre, Rut, Genero);
        this.profesion = profesion;
        this.grado = grado;
    }

    public Docente() {
    this.profesion = "";
    this.grado = "";
    }

//MUTADORES

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
//ACCESADORES
    
    public String getProfesion() {
        return profesion;
    }

    public String getGrado() {
        return grado;
    }

    @Override
    public String toString() {
        return "Docente{" + "profesion=" + profesion + ", grado=" + grado +super.toString()+ '}';
    }
    
}
