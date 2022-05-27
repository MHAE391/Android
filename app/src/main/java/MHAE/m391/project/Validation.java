package MHAE.m391.project;

public class Validation {
    public static String EmailValidation(String Email){
        if(Email.length()==0)return "Empty";
        if(!Email.contains("@") || !Email.contains(".com") || !Email.endsWith(".com") ||
                !(Email.lastIndexOf('@')==Email.indexOf('@'))
                ||  (Email.lastIndexOf('@')== Email.indexOf('.')-1 )  || (Email.contains("..")) ||
                (Email.lastIndexOf(".com")!=Email.indexOf(".com"))|| Email.contains(" "))return "Format Error";
        if(!((Email.charAt(0)>='a'&& Email.charAt(0)<='z') ))return "Starting Error";
            return "Valid";
    }
    public static String PasswordValidation(String Password){
        if(Password.length()==0)return "Empty";
        if(Password.length()<4)return "Small Password";
        return "Valid";
    }
    public static String NameValidation(String Name){
        if(Name.length()==0)return "Empty";
        if(Name.length()<3)return "Too Small";
        if(Name.length()>15) return "Too Match";
        if(Name.contains(" "))return "Find Space";
        boolean Char=false;
        for(int i=0;i<Name.length();i++){
            if(Name.charAt(i)>='a' && Name.charAt(i)<='z')Char=true;
            else if(!(Name.charAt(i)>='0'&& Name.charAt(i)<='9')){
                return "Special Character";
            }
        }
        if(Char)return "Valid";
        return "Not Valid";
    }
    public static String AgeValidation(String Age){
        if(Age.length()==0)return "Empty";
        if(Age.indexOf('-')==0)return "Wrong Start";
        int age =Integer.parseInt(Age);
        if(age<18 || age >100)return "Not Acceptable Age";
        return "Valid";
    }
    public static String PhoneValidation(String Phone){
        if(Phone.length()==0)return "Empty";
        if(Phone.indexOf('0')!=0)return "Zero Not Founded";
        if(Phone.indexOf('1')!=1)return "No One" ;
        if(Phone.length()!=11)return "Not Acceptable Phone";
        return "Valid";
    }


}
