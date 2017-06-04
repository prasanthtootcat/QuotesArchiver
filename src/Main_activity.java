//Created by prasanthtootcat

import java.io.*;
public class Main_activity
{
	private String home;
	private File quotesDir,archivedDir;
	Main_activity()
	{
		home=System.getProperty("user.home");
		quotesDir=new File(home+File.separator+"Quotes");
		archivedDir=new File(home+File.separator+"Archived");
		
	}
	
	private boolean ifFilesAreThere()
	{
		String[] names;
		
		try
		{
		if(quotesDir.exists())
		{
			
			System.out.println("Directory located.....");
			System.out.println("Checking....");
			names=quotesDir.list();
			return (names.length!=0)?true:false;
			
		}
		else
		{
			System.out.print("Oops no directory found... Creating directory in home");
			quotesDir.mkdir();
			return false;
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	private void letsMove()
	{
		File[] listOfFiles,archivedList;
		int count;
		try
		{
		if(archivedDir.exists()!=true)
			archivedDir.mkdir();
		
		listOfFiles=quotesDir.listFiles();
		System.out.println("\nNumber of files:  "+listOfFiles.length);
		archivedList=archivedDir.listFiles();
		count=archivedList.length;
		for(File list:listOfFiles)
		{
			list.renameTo(new File(archivedDir+File.separator+(++count)+".jpg"));
			
		}
		System.out.println("Files moved Successfully!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args)
	{
		Main_activity obj=new Main_activity();
		boolean check=obj.ifFilesAreThere();
		System.out.print((check==true)?"\nQuotes available to be archived":"\nAll quotes already archived!");
		if(check==true)
		obj.letsMove();
		
	}
}