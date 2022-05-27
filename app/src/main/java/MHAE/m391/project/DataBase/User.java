package MHAE.m391.project.DataBase;

public class User {

    private  int Id;
    private  String Name;
    private  String Email;
    private  int Admin;
    private String Phone;
    private String Password;
    private  int Age;

    public User(int id, String name, int age, String email, String phone, String password,int admin) {
        this.Id = id;
        this.Name = name;
        this.Email = email;
        this.Admin = admin;
        this.Phone = phone;
        this.Password = password;
        this.Age = age;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public int getAdmin() {
        return Admin;
    }

    public void setAdmin(int admin) {
        this.Admin = admin;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }
}
