import java.util.Scanner;
import java.util.*;
class Level3Test
{
	static String[][] board;
	static String[][] point;
	static HashMap<Integer,Integer> ladder=new HashMap<>();
	static HashMap<Integer,Integer> snacks=new HashMap<>();
	static HashMap<Integer,String> ladder_poos=new HashMap<>();
	static HashMap<Integer,String> snacks_pos=new HashMap<>();
	static LinkedHashMap<Character,Integer> player=new LinkedHashMap<>();
	Level3Test()
	{
		int val=100;
		point=new String[10][10];
		board=new String[10][10];
		int start=0;
		int count=0;
		while(val!=1)
		{
			if(count%2==0)
			{
				for(int i=0;i<10;i++)
				{
					board[start][i]=""+val;
					val--;
				}
			}
			else
			{
				for(int i=9;i>=0;i--)
				{
					board[start][i]=""+val;
					val--;
				}
			}
			if(count==9)
				break;
			start++;
			count++;
		}
	}
	void printboard()
	{
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(point[i][j]==null)
				{
					System.out.print(board[i][j]+" ");
				}
				else
				{
					System.out.print(point[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
	void printboard1()
	{
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				int val=Integer.parseInt(board[i][j]);
				if(snacks.containsKey(val))
				{
					System.out.print(snacks_pos.get(val)+"    ");
				}
				else if(ladder.containsKey(val))
				{
					System.out.print(ladder_poos.get(val)+"    ");
				}
				else if(point[i][j]!=null)
				{
					System.out.print(point[i][j]+"   ");
				}
				else
				{
					System.out.print(board[i][j]+"    ");
				}
			}
			System.out.println();
			System.out.println();
		}
	}
	String getIndex(int val)
	{
		String ind="";
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(board[i][j].equals(""+val))
				{
					ind=""+i+""+j;
				}
			}
		}
		return ind;
	}
	void remove(char play)
	{
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(point[i][j]==null)
				{
					continue;
				}
				else 
				{
					if(point[i][j].equals(""+play))
						point[i][j]=null;
				}
			}
		}
	}
	void addpo()
	{
		snacks.put(40,3);
		snacks_pos.put(40,"s1");
		snacks.put(43,18);
		snacks_pos.put(43,"s2");
		snacks.put(27,5);
		snacks_pos.put(27,"s3");
		snacks.put(54,31);
		snacks_pos.put(54,"s4");
		snacks.put(89,53);
		snacks_pos.put(89,"s5");
		snacks.put(66,45);
		snacks_pos.put(66,"s6");
		snacks.put(76,58);
		snacks_pos.put(76,"s7");
		snacks.put(99,41);
		snacks_pos.put(99,"s8");
		ladder.put(4,25);
		ladder_poos.put(4,"l1");
		ladder.put(13,46);
		ladder_poos.put(13,"l2");
		ladder.put(33,49);
		ladder_poos.put(33,"l3");
		ladder.put(50,69);
		ladder_poos.put(50,"l4");
		ladder.put(42,63);
		ladder_poos.put(42,"l5");
		ladder.put(62,81);
		ladder_poos.put(62,"l6");
		ladder.put(74,92);
		ladder_poos.put(74,"l7");
	}
	public static void main(String[] args)
	{
		Level3Test test=new Level3Test();
		test.addpo();
		test.printboard1();
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		for(char i='A';i<('A'+n);i++)
		{
			player.put(i,1);
		}
		System.out.println(player);
		Random ran=new Random();
		outer:
		while(true)
		{
			for(Character play:player.keySet())
			{
				System.out.println("Player :"+play);
				int val=s.nextInt();
				int pos=player.get(play);
				System.out.println("Position :"+pos);
				String newpos="";
				if(snacks.containsKey(pos+val))
				{
					pos=snacks.get(pos+val);
					newpos=test.getIndex(pos);
					player.put(play,pos);
				}
				else if(ladder.containsKey(pos+val))
				{
					pos=ladder.get(pos+val);
					newpos=test.getIndex(pos);
					player.put(play,pos);
				}
				else
				{
					newpos=test.getIndex(pos+val);
					player.put(play,pos+val);
				}
				test.remove(play);
				System.out.println("new Position :"+newpos);
				System.out.println(newpos);
				point[Character.getNumericValue(newpos.charAt(0))][Character.getNumericValue(newpos.charAt(1))]=""+play;
				test.printboard1();
				if(newpos.equals("00"))
				{
					System.out.println("Player "+play+" Reached a Position First!");
					break outer ;
				}
			}
		}
	}
}