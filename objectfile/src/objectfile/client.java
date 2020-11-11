package objectfile;

import java.io.Serializable;

public class client implements Serializable{
     private String nombre;
     private transient String passWord;
     
     public client(String nombre, String passWord) {
              this.nombre=nombre;
              this.passWord= passWord;
     }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
}