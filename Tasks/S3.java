public class S3{

	public static void main(String[] args){
	  Scanner sc = new Scanner(System.in);
	  String s = sc.next();
	 
	  int c=0,r=0, o=0,a=0,k=0;
          int ans = 0;
          int af = 0;
	  boolean b = false;
	  for(char c : s.toCharArray()){
	     switch(c){
	      case 'c': c++;
	 		af++;
			break;
		case 'r': r++;
			  break;
	  	case 'o' : o++;
			  break;
		case 'a' : a++;
			  break;
		case 'k' : k++;
			   af--;
			   break;
	     }
	    ans  = Math.max(ans, af);
	    if(c<r || r<o || o<a || a<k){
		 b= true;
	    }
	  }          
          if(af==0 && !b){
	    System.out.println(ans);
	  }else{
	    System.out.println(-1);
	  }


	}
}