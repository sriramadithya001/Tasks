
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex11{

   public static void main(String[] args){
    
       String s = "1234";
       String regex = "\\d{4}|\\d{6}|\\d{8}";
       Pattern p = Pattern.compile(regex);
       Matcher m = p.matcher(s);
       if(m.matches()){
         System.out.println("PIN is valid");
	}else{
         System.out.println("PIN is inValid");
	}
       
    }
}