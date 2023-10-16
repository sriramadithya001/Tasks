public class HashMapImp {

    public static void main(String[] args){

       ArrayList<HashClass> list = new ArrayList<>();
        
	HashMapImp h = new HashMapImp();
        h.put("Andu", 1);
	h.put("Senthi",2);
        h.ContainsKey("Senthil");
        h.put("Rajan", 3);
        h.remove("Rajan");
        

        public void put(String s, int c){
          list.add(new HashClass(s,c));
        }

        public String get(String s){
          for( HashClass hash: list){
             if(hash.key.equals(s)){
                return hash.value;
	      }
	  }
           return null;
        }

        public boolean ConstainsKey(String s){
          for( HashClass hash: list){
             if(hash.key.equals(s)){
                return true;
	      }
	  }
           return false;
        }

       public void remove (String s){
         for( HashClass hash: list){
             if(hash.key.equals(s)){
                list.remove(hash);
	      }
	  }
       }
    }
}

class HashClass{
  String key;
  int value;

    public HashClass(String key, int value){
      this.key = key;
      this.value = value;
    }

    
}