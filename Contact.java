import java.io.Serializable;

public final class Contact  implements  Comparable<Contact>, Serializable {
    private String name;
    private String email;
    private String phone;

    public Contact(String name, String email, String phone) {
        if (name == null) throw new NullPointerException();
        if (name.equals("")) throw new IllegalArgumentException();
        this.name = name;
        if (email == null) {
            this.email = "";
        } else  this.email = email;
        if (phone == null){
            this.phone = "";
        } else
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + " " + email + " "+ phone;
    }

    public String name(){
        return name;
    }
    public String email(){
        return email;
    }
    public String phone(){
        return phone;
    }
    public Contact changeName(String newName)
    {
        return new Contact(newName, email, phone);
    }

    public Contact changeEmail(String newEmail){

        return new Contact(name, newEmail, phone);
    }

    public Contact changePhone(String newPhone){

        return new Contact(name, email, newPhone);
    }

    public int compareTo(Contact other){
        return name.compareTo(other.name);

    }

    public boolean equals(Object other){
        if ((other == null) || !(other instanceof Contact))
            return false;
        return name.equals(((Contact) other).name);

    }

    public int hashCode(){

        return name.hashCode();
    }






}
