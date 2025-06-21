package cursispringboot.domain;

public class Customer {

    // Creamos los atributos del objeto

    private int ID;

    private String nombre;

    private String password;

    private String birthday;

    private String status;

    //Constructor
    public Customer(int ID, String nombre, String password, String birthday, String status) {
        this.ID = ID;
        this.nombre = nombre;
        this.password = password;
        this.birthday = birthday;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
