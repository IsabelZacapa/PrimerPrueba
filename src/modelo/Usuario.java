/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author MINEDUCYT
 */
public class Usuario {
    
    private int id;             // Almacena el ID del usuario
    private String nombre;      // Almacena el nombre del usuario
    private String apellido;    // Almacena el apellido del usuario
    private int edad;           // Almacena la edad del usuario
    private String genero;      // Almacena el género del usuario
    private String correo;      // Almacena el correo electrónico del usuario
    private String telefono;    // Almacena el número de teléfono del usuario

    public Usuario (int id,String nombre, String apellido,int edad ,String genero,String correo,String telefono){
        this.id = id;           // Asigna el valor del parámetro "id" a la variable de instancia "id"
        this.nombre = nombre;   // Asigna el valor del parámetro "nombre" a la variable de instancia "nombre"
        this.apellido = apellido;   // Asigna el valor del parámetro "apellido" a la variable de instancia "apellido"
        this.edad = edad;       // Asigna el valor del parámetro "edad" a la variable de instancia "edad"
        this.genero = genero;    // Asigna el valor del parámetro "genero" a la variable de instancia "genero"
        this.correo = correo;   // Asigna el valor del parámetro "correo" a la variable de instancia "correo"
        this.telefono = telefono;   // Asigna el valor del parámetro "telefono" a la variable de instancia "telefono"
    }
    public int getId() {    //getId()devuelve el valor actual del atributoidde un objeto Usuario.
        return id;
    }
    public void setId(int id) { //setId()establece un nuevo valor para el atributo id de un objeto Usuario
        this.id = id;
    }
    public String getNombre() { //getNombre() devuelve nombre de un objeto Usuario
        return nombre;
    }
    public void setNombre(String nombre) {  //setNombre()establece un nuevo valor para el atributo nombre de un objeto Usuario
        this.nombre = nombre;
    }
    public String getApellido() {  //getApellido()devuelve apellido de un objeto Usuario.
        return apellido;
    }
    public void serApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
