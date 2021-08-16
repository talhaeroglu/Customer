package sample;
public class Customer {
private String first;
private String last;
private String email;

public Customer() {
        this.first = "";
        this.last = "";
        this.email = "";

        }
public Customer(String first, String last, String email) {
        this.first = first;
        this.last = last;
        this.email = email;
        }
//getter and  setters
public String getFirst() {
        return first;
        }
public void setFirst(String first) {
        this.first = first;
        }
public String getLast() {
        return last;
        }
public void setLast(String last) {
        this.last = last;
        }
public String getEmail() {
        return email;
        }
public void setEmail(String email) {
        this.email = email;
        }

        }