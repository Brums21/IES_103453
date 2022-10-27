package ex3_1a.demo;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Name is mandatory")
    private String name;
    
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Phone is mandatory")
    private String phone_number;

    // standard constructors / setters / getters / toString

    public String getName(){
        return this.name;
    }

    public String getPhone_number(){
        return this.phone_number;
    }

    public String getEmail(){
        return this.email;
    }

    public Long getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setPhone_number(String phone){
        this.phone_number = phone;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone" + phone_number + "]";
    }

}
