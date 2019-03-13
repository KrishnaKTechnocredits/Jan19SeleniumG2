package seleniumPractise.shashank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebTableHomework 
{
	int tableRows=0, tableCols=0;
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Work Docs\\Java\\Class\\3rd Weekend\\Eclipse\\resources\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.automationbykrishna.com/#");
		driver.manage().window().maximize();
		WebTableHomework wdh = new WebTableHomework();
		wdh.locateWebTable(driver);   
		//wdh.printWebTable(driver);
		wdh.managerInfo(driver);    // code related to task 1 and 2
		wdh.employeeInfo(driver);   // code related to task 3 and 4
		wdh.findDuplicateEntry(driver);   // code related to task 5
		wdh.empDeptInfo(driver);   // code related to task 6
		driver.close();
	}
	
	WebElement locateWebTable(WebDriver driver)
	{
		driver.findElement(By.id("demotable")).click();
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table[class='table table-striped']")));
		WebElement e = driver.findElement(By.cssSelector("table[class='table table-striped']"));
		tableRows = driver.findElements(By.cssSelector("table[class='table table-striped']>tbody tr")).size();
		tableCols = driver.findElements(By.cssSelector("table[class='table table-striped']>thead th")).size();
		return e;
	}
	
	void printWebTable(WebDriver driver)
	{
		//WebDriverHomework.locateWebTable(driver);
		//System.out.println(e.getText());
	
		System.out.println("Web table is ==>");
		for (int j=1; j<=tableCols ; j++)
		{
				System.out.print(driver.findElement(By.cssSelector("table[class='table table-striped'] th:nth-of-type("+j+")")).getText()+"\t");		
	
		}
		
		for (int i=1; i<=tableRows ; i++)
		{
			System.out.println();
			for (int j=1; j<=tableCols ; j++)
			{
				System.out.print(driver.findElement(By.cssSelector("table[class='table table-striped']>tbody tr:nth-child("+i+") td:nth-child("+j+")")).getText()+"\t");
			}
		}
	}
	
	void empDeptInfo(WebDriver driver)
	{
		System.out.println("\n"+"Employee department information is as follows ==>");
		HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
		
		for(int i=1; i<=tableRows; i++)
		{
			String tempText = driver.findElement(By.cssSelector("table[class='table table-striped']>tbody tr:nth-child("+i+") td:nth-child(5)")).getText();
			if(hm1.containsKey(tempText))
			{
				hm1.put(tempText, hm1.get(tempText)+1);
			}
			else
				hm1.put(tempText, 1);
		}
		
		Set<String> s1= hm1.keySet();
		for (String temp:s1)
		{
			System.out.println("Department name - "+temp+" : "+"Number of employees - "+hm1.get(temp));
		}
		
		List<String> emp = new ArrayList<String>();
		List<String> dept = new ArrayList<String>(s1);
		int arr[] = new int[dept.size()];
		
		int curr_count=0;
		int orig_count=0;
		
			for(int j=0; j<dept.size(); j++)
			{				
				orig_count=curr_count;
				for (int i=1; i<=tableRows; i++)
				{
					String insertText = driver.findElement(By.cssSelector("table[class='table table-striped']>tbody tr:nth-child("+i+") td:nth-child(3)")).getText();
					String testText= driver.findElement(By.cssSelector("table[class='table table-striped']>tbody tr:nth-child("+i+") td:nth-child(5)")).getText();
					if(testText.equals(dept.get(j)))
					{
						emp.add(insertText);
						curr_count++;
					}
				}
				arr[j]=curr_count-orig_count;
			}
		
		int num=0, k=0;
		System.out.println("\n"+"Total departments : "+s1.size());
			
				for (String temp:s1)
				{	
					System.out.println((num+1) +") "+temp+" : "+hm1.get(temp));
					int l=0;
					for (; k<emp.size(); k++)
					{
						if(l<arr[num])
						{
							//if(l==0)
								
							System.out.println("\t"+emp.get(k));
							l++;
						}
						else if(l==arr[num])
						break;
					}
					num++;
					System.out.println("-----------------------------------------");
				}
		}
		
		
			
	
	void managerInfo(WebDriver driver)
	{
		Set<String> s1= new HashSet<String>();
		for(int i=1; i<=tableRows; i++)
		{
			s1.add(driver.findElement(By.cssSelector("table[class='table table-striped']>tbody tr:nth-child("+i+") td:nth-child(4)")).getText());
		}
		System.out.println("\n"+"Number of managers is : "+s1.size()+" with ids as : "+s1);
	}
	
	void employeeInfo(WebDriver driver)
	{
	
		Set<String> s1 = new HashSet<String>();		
		List<String> emp = new ArrayList<String>();
		
		for(int i=1; i<=tableRows; i++)
		{
			s1.add(driver.findElement(By.cssSelector("table[class='table table-striped']>tbody tr:nth-child("+i+") td:nth-child(4)")).getText());
		}
		List<String> mng = new ArrayList<String>(s1);
		int arr[] = new int[mng.size()];
		
		int curr_count=0;
		int orig_count=0;
		
			for(int j=0; j<mng.size(); j++)
			{				
				orig_count=curr_count;
				for (int i=1; i<=tableRows; i++)
				{
					String insertText = driver.findElement(By.cssSelector("table[class='table table-striped']>tbody tr:nth-child("+i+") td:nth-child(3)")).getText();
					String testText= driver.findElement(By.cssSelector("table[class='table table-striped']>tbody tr:nth-child("+i+") td:nth-child(4)")).getText();
					if(testText.equals(mng.get(j)))
					{
						emp.add(insertText);
						curr_count++;
					}
				}
				arr[j]=curr_count-orig_count;
			}
		
		HashMap<String, Integer> hm1 = new HashMap<String, Integer>();	
		System.out.println();	
		for (int i=0; i<mng.size(); i++)
		{
			//System.out.println("Manager having id "+mng.get(i)+" has "+arr[i]+" employees working under him/her");
			hm1.put(mng.get(i),arr[i]);
		}
		
		int k=0;
		for(int j=0; j<mng.size(); j++)
		{	
			int l=0;
			for (; k<emp.size(); k++)
			{
				if(l<arr[j])
				{
					if(l==0)
						System.out.println("Manager having id "+mng.get(j)+" has below "+arr[j]+" employees working under him/her");
					System.out.println(emp.get(k));
					l++;
				}
				else if(l==arr[j])
					break;
			}
		}
		
		int maxEmp=0; 
		String maxMng=null;
		Set<String> s2 = hm1.keySet();
		
		for(String key:s2)
		{
			if(hm1.get(key)>maxEmp)
			{
				maxEmp=hm1.get(key);
				maxMng=key;
			}
		}
		
		System.out.println("\n"+maxMng+ " is the id of manager having maximum i.e. "+maxEmp+" employee assigned.");
	
	}	
		void findDuplicateEntry(WebDriver driver)
		{
			HashMap<String, String> hm2 = new HashMap<String, String>();
			for(int i=1; i<=tableRows; i++)
			{
				String key = driver.findElement(By.cssSelector("table[class='table table-striped']>tbody tr:nth-child("+i+") td:nth-child(2)")).getText();
				String value = driver.findElement(By.cssSelector("table[class='table table-striped']>tbody tr:nth-child("+i+") td:nth-child(3)")).getText();
				if (hm2.put(key, value)!=null)
					System.out.println("\n"+"Record with employee id "+key+" having employee name "+value+" is duplicate entry!");
			}
		}
}
