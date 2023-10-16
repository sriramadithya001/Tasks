import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex8{

   public static void main(String[] args){

	String s = "I know ";
	String regex = "python";

        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Matcher m = p.matcher(s);

        if(m.find()){
  	  System.out.println("Java");
	}else{
	 System.out.println("C++");
	}
   }
}