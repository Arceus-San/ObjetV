package fr.ubordeaux.ao;

public class Name{

    public String name;

    public Name(String param){
        if(param.length()>11 || param.length()<3 || !param.matches("[a-z]*"))
            throw new IllegalArgumentException("Le nom n'est pas correct");
        else{
            this.name=param;
        }
    }


}
