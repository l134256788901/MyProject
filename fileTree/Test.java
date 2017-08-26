package fileTree;

import java.io.File;
import java.util.ArrayList;

public class Test 
{
	//│ ├ └ ─
	static ArrayList<Node> al=new ArrayList<Node>();
	public static void main(String[] args)
	{
		File f=new File("D:/xixi");
		printFile(f,1);
		for(int i=0;i<al.size();i++)
		{
			format1(al.get(i).grade);
			if(i!=0)
			{
				if(isLastGrade(i))
				{
					System.out.print(" └───"+al.get(i).f.getName()+" ");
				}
				else
					System.out.print(" ├───"+al.get(i).f.getName()+" ");
			}
			else
				System.out.print(al.get(i).f.getName()+" ");
			if(al.get(i).f.isFile())
			{
				System.out.println("<文件>");
			}
			else
			{
				System.out.println("<目录>");
			}
		}
	}
	public static boolean isLastGrade(int i)
	{
		int kk2;
		if(i==al.size()-1)
			return true;
		for(kk2=i+1;kk2<al.size();kk2++)
		{
			if(al.get(kk2).grade==al.get(i).grade-1)
				break;
		}
		if(i==al.size()-1)
			return true;
		for(int j=i+1;j<=kk2;j++)
		{
			if(al.get(j).grade==al.get(i).grade)
				return false;
		}
		return true;
	}
	public static void format1(int grade)
	{
		if(grade>2)
		{
			for(int i=2;i<grade;i++)
				System.out.print(" │  ");
		}
	}
	public static int printFile(File f,int grade)
	{
		Node n=new Node();
		n.f=f;
		n.grade=grade;
		al.add(n);
		if(f.isFile())
			return grade;
		if(f.listFiles().length==0)
			return grade;
		File[] ff=f.listFiles();
		grade++;
		for(int i=0;i<ff.length;i++)
		{
			printFile(ff[i],grade);
		}
		return grade;
	}
}
