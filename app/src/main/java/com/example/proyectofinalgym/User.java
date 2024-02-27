package com.example.proyectofinalgym;

public class User {
    private String email;
    private String password;
    private String dni;
    private String nombre;
    private String peso;
    private String altura;
    private String telefono;
    private String edad;

    public User(String email, String password, String dni, String nombre, String peso, String altura, String telefono, String edad) {
       setEmail(email);
       setPassword(password);
       setDni(dni);
       setNombre(nombre);
       setPeso(peso);
       setAltura(altura);
       setTelefono(telefono);
    }

    public User(String userName, String nombre, String edad, String peso, String altura) {
        setEmail(userName);
        setNombre(nombre);
        setEdad(edad);
        setPeso(peso);
        setAltura(altura);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = (peso == null || peso.trim().isEmpty()) ? "0" : peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = (altura == null || altura.trim().isEmpty()) ? "0" : altura;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = (telefono == null || telefono.trim().isEmpty()) ? "Campo vacío" : telefono;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = (edad == null || edad.trim().isEmpty()) ? "0" : edad;
    }
}

