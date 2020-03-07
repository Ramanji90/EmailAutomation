package com.ram.emailautomation.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.emailautomation.model.AutoCreationReport;
import com.ram.emailautomation.model.EmailDTO;
import com.ram.emailautomation.model.InnetDTO;
import com.ram.emailautomation.repository.EmailAutoCreationRepository;
import com.ram.emailautomation.repository.ImportRepository;

@Service
public class EmailAutoCreationService 
{
	@Autowired
	private EmailAutoCreationRepository repository;
	
	@Autowired
	private ImportRepository importRepository;
	public AutoCreationReport emailAutoCreation(String serverFilePath, String course)
	{
		AutoCreationReport report=new AutoCreationReport();
		long insertions=0L;
		long duplicates=0L;
		long creations=0L;
		File file = new File(serverFilePath);
		

		try {

			FileInputStream excelFile = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
			XSSFSheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			
			while (iterator.hasNext())
			{
				EmailDTO dto = new EmailDTO();
				Row currentRow = iterator.next();
				if (currentRow.getRowNum() != 0) 
				{
					EmailDTO dtoDB=null;
					try
					{
						System.out.println(currentRow.getCell(0).getStringCellValue());
					dtoDB=repository.fetchByCompany(currentRow.getCell(0).getStringCellValue());
					}
					catch(NullPointerException e)
					{
						
					}
					if(dtoDB!=null)
					{
						System.out.println(dtoDB);
					System.out.println("Enter the Full Name");
					String full=dtoDB.getContactName();
					System.out.println(full);
					System.out.println("Enter the Email");
					String email=dtoDB.getEmail();
					System.out.println(email);
					System.out.println("Enter Contact name");
					String cn=null;
					try
					{
						cn=currentRow.getCell(1).getStringCellValue();
						if(cn!="" || cn!=null)
						{
						System.out.println(cn);
						String nmail="";
						
						String cns[]=cn.split(" ");
						String cnf=cns[0].toLowerCase();
						System.out.println(cnf);
						String cnss=cns[cns.length-1].toLowerCase();
						System.out.println(cnss);
						
						String nsplit[]=full.split(" ");
						String fName=nsplit[0].toLowerCase();
						System.out.println(fName);
						String lName=nsplit[nsplit.length-1].toLowerCase();
						System.out.println(lName);
						
						String esplit[]=email.split("@");
						String ef=esplit[0].toLowerCase();
						System.out.println(ef);
						String es=esplit[esplit.length-1].toLowerCase();
						System.out.println(es);
						char special=0;
						
						//System.out.println(esplit[0].charAt(esplit[0].lastIndexOf(lName)-1));
						
						if((ef.startsWith(fName) && ef.endsWith(lName)) && (ef.contains(".")))
						{
							 //nmail=fName+esplit[0].charAt(esplit[0].indexOf(esplit[0].charAt(esplit[0].lastIndexOf(lName)-1)))+lName+"@"+esplit[esplit.length-1];
							nmail=cnf+ef.charAt(esplit[0].indexOf(ef.charAt(ef.lastIndexOf(lName)-1)))+cnss+"@"+es;
							System.out.println(nmail);
							System.out.println("F.L");
						}
						else if((ef.startsWith(fName) && ef.endsWith(lName)) && (ef.contains("-")))
						{
							 //nmail=fName+esplit[0].charAt(esplit[0].indexOf(esplit[0].charAt(esplit[0].lastIndexOf(lName)-1)))+lName+"@"+esplit[esplit.length-1];
							nmail=cnf+ef.charAt(esplit[0].indexOf(ef.charAt(ef.lastIndexOf(lName)-1)))+cnss+"@"+es;
							//System.out.println(nmail);
							System.out.println("F-L");
						}
						else if((ef.startsWith(fName) && ef.endsWith(lName)) && (ef.contains("_")))
						{
							 //nmail=fName+esplit[0].charAt(esplit[0].indexOf(esplit[0].charAt(esplit[0].lastIndexOf(lName)-1)))+lName+"@"+esplit[esplit.length-1];
							nmail=cnf+ef.charAt(esplit[0].indexOf(ef.charAt(ef.lastIndexOf(lName)-1)))+cnss+"@"+es;
							//System.out.println(nmail);
							System.out.println("F_L");
						}
						else if((ef.startsWith(lName) && ef.endsWith(fName))  && (ef.contains(".")))
						{
							 //nmail=fName+esplit[0].charAt(esplit[0].indexOf(esplit[0].charAt(esplit[0].lastIndexOf(lName)-1)))+lName+"@"+esplit[esplit.length-1];
							nmail=cnss+ef.charAt(ef.indexOf(ef.charAt(ef.lastIndexOf(fName)-1)))+cnf+"@"+es;
							//System.out.println(nmail);
							System.out.println("L.F");
						}
						else if((ef.startsWith(lName) && ef.endsWith(fName))  && (ef.contains("-")))
						{
							 //nmail=fName+esplit[0].charAt(esplit[0].indexOf(esplit[0].charAt(esplit[0].lastIndexOf(lName)-1)))+lName+"@"+esplit[esplit.length-1];
							nmail=cnss+ef.charAt(ef.indexOf(ef.charAt(ef.lastIndexOf(fName)-1)))+cnf+"@"+es;
							//System.out.println(nmail);
							System.out.println("L-F");
						}
						else if((ef.startsWith(lName) && ef.endsWith(fName))  && (ef.contains("_")))
						{
							 //nmail=fName+esplit[0].charAt(esplit[0].indexOf(esplit[0].charAt(esplit[0].lastIndexOf(lName)-1)))+lName+"@"+esplit[esplit.length-1];
							nmail=cnss+ef.charAt(ef.indexOf(ef.charAt(ef.lastIndexOf(fName)-1)))+cnf+"@"+es;
							//System.out.println(nmail);
							System.out.println("L_F");
						}
						else if(ef.contentEquals(fName))
						{
							nmail=cnf+"@"+es;
							System.out.println("F");
						}
						else if(ef.contentEquals(lName))
						{
							nmail=cnss+"@"+es;
							System.out.println("L");
						}
						else if(ef.contentEquals(fName+lName))
						{
							nmail=cnf+cnss+"@"+es;
							System.out.println("F+L");
						}
						else if(ef.contentEquals(lName+fName))
						{
							nmail=cnss+cnf+"@"+es;
							System.out.println("L+F");
						}
						else if(ef.startsWith(fName.charAt(0)+"") && ef.endsWith(lName) && (!(ef.contains(".")) ) && (!(ef.contains("-")) ) && (!(ef.contains("_")) ))
						{
							nmail=cnf.charAt(0)+cnss+"@"+es;
							System.out.println("fINIT+L");
						}
						else if((ef.startsWith(fName.charAt(0)+"") && ef.endsWith(lName)) && (ef.contains(".")))
						{
							nmail=cnf.charAt(0)+"."+cnss+"@"+es;
							System.out.println("fINIT . L");
						}
						else if((ef.startsWith(fName.charAt(0)+"") && ef.endsWith(lName)) && (ef.contains("-")))
						{
							nmail=cnf.charAt(0)+"-"+cnss+"@"+es;
							System.out.println("fINIT - L");
						}
						else if((ef.startsWith(fName.charAt(0)+"") && ef.endsWith(lName)) && (ef.contains("_")))
						{
							nmail=cnf.charAt(0)+"_"+cnss+"@"+es;
							System.out.println("fINIT _ L");
						}
						else if(ef.startsWith(lName.charAt(0)+"") && ef.endsWith(fName) && (!(ef.contains(".")) ) && (!(ef.contains("-")) ) && (!(ef.contains("_")) ))
						{
							nmail=cnss.charAt(0)+cnf+"@"+es;
							System.out.println("lINIT+F");
						}
						else if((ef.startsWith(lName.charAt(0)+"") && ef.endsWith(fName)) && (ef.contains(".")))
						{
							nmail=cnss.charAt(0)+"."+cnf+"@"+es;
							System.out.println("lINIT . F");
						}
						else if((ef.startsWith(lName.charAt(0)+"") && ef.endsWith(fName)) && (ef.contains("-")))
						{
							nmail=cnss.charAt(0)+"-"+cnf+"@"+es;
							System.out.println("lINIT - F");
						}
						else if((ef.startsWith(lName.charAt(0)+"") && ef.endsWith(fName)) && (ef.contains("_")))
						{
							nmail=cnss.charAt(0)+"_"+cnf+"@"+es;
							System.out.println("lINIT _ F");
						}
						else if(ef.startsWith(fName) && ef.endsWith(lName.charAt(0)+"") && (!(ef.contains(".")) ) && (!(ef.contains("-")) ) && (!(ef.contains("_")) ))
						{
							nmail=cnf+cnss.charAt(0)+"@"+es;
							System.out.println("F+lINIT");
						}
						else if((ef.startsWith(fName) && ef.endsWith(lName.charAt(0)+"")) && (ef.contains(".")))
						{
							nmail=cnf+"."+cnss.charAt(0)+"@"+es;
							System.out.println("F . lINIT");
						}
						else if((ef.startsWith(fName) && ef.endsWith(lName.charAt(0)+"")) && (ef.contains("-")))
						{
							nmail=cnf+"-"+cnss.charAt(0)+"@"+es;
							System.out.println("F - lINIT");
						}
						else if((ef.startsWith(fName) && ef.endsWith(lName.charAt(0)+"")) && (ef.contains("_")))
						{
							nmail=cnf+"_"+cnss.charAt(0)+"@"+es;
							System.out.println("F _ lINIT");
						}
						else if(ef.startsWith(lName) && ef.endsWith(fName.charAt(0)+"") && (!(ef.contains(".")) ) && (!(ef.contains("-")) ) && (!(ef.contains("_")) ))
						{
							nmail=cnss+cnf.charAt(0)+"@"+es;
							System.out.println("L+fINIT");
						}
						else if((ef.startsWith(lName) && ef.endsWith(fName.charAt(0)+"")) && (ef.contains(".")))
						{
							nmail=cnss+"."+cnf.charAt(0)+"@"+es;
							System.out.println("L . fINIT");
						}
						else if((ef.startsWith(lName) && ef.endsWith(fName.charAt(0)+"")) && (ef.contains("-")))
						{
							nmail=cnss+"-"+cnf.charAt(0)+"@"+es;
							System.out.println("L - fINIT");
						}
						else if((ef.startsWith(lName) && ef.endsWith(fName.charAt(0)+"")) && (ef.contains("_")))
						{
							nmail=cnss+"_"+cnf.charAt(0)+"@"+es;
							System.out.println("L _ fINIT");
						}
						
						
						System.out.println("email= "+nmail);
						//System.out.println(new Date(System.currentTimeMillis()+50000));
						try
						{
							dto.setCompany(currentRow.getCell(0).getStringCellValue());
						}
						catch(NullPointerException e)
						{
							dto.setCompany("");
						}
						try
						{
							dto.setContactName(currentRow.getCell(1).getStringCellValue());
						}
						catch(NullPointerException e)
						{
							dto.setContactName("");
						}
						try
						{
							dto.setDesignation(currentRow.getCell(2).getStringCellValue());
						}
						catch(NullPointerException e)
						{
							dto.setDesignation("");
						}
						try
						{
							dto.setLocation(currentRow.getCell(3).getStringCellValue());
						}
						catch(NullPointerException e)
						{
							dto.setLocation("");
						}
						try
						{
							dto.setIndustry(currentRow.getCell(4).getStringCellValue());
						}
						catch(NullPointerException e)
						{
							dto.setIndustry("");
						}
						dto.setFirstName(cns[0]);
						dto.setEmail(nmail);
						dto.setCourse("");
						dto.setCreatedBy("tool");
						dto.setMailerStatus("UN");
						dto.setDate(new Date());
						dto.setFileName(file.getName());
						dto.setValidation("ac");
						try 
						{
						EmailDTO dtodb = repository.save(dto);
						if(dtodb!=null)
						{
						creations+=1;
						//if(emailDB!=0)
						//insertions+=1;

						// getCellTypeEnum shown as deprecated for version 3.15 //getCellTypeEnum ill
						// be renamed to getCellType starting from version 4.0
						}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							duplicates+=1;
						}
					}
				}
					catch(NullPointerException e)
					{
						
					}
					
			}
					else
					{
						String comp=null;
						String contact=null;
						try
						{
							comp=currentRow.getCell(0).getStringCellValue();
							contact=currentRow.getCell(1).getStringCellValue();
						}
						catch(NullPointerException e)
						{
							
						}
						if(comp!=null && contact!=null)
						{
							InnetDTO innet=new InnetDTO();
							innet.setCompany(comp);
							innet.setContactName(contact);
							
							try
			                {
								innet.setDesignation(currentRow.getCell(2).getStringCellValue());
			                }
			                catch(NullPointerException e)
			                {
			                	innet.setDesignation("");
			                }
			                try
			                {
			                	innet.setLocation(currentRow.getCell(3).getStringCellValue());
			                }
			                catch(NullPointerException e)
			                {
			                	innet.setLocation("");
			                }
			                try
			                {
			                	innet.setIndustry(currentRow.getCell(4).getStringCellValue());
			                }
			                catch(NullPointerException e)
			                {
			                	innet.setIndustry("");
			                }
		                innet.setDate(new Date());
		                innet.setCreatedBy("");
		                innet.setCourse("");
		                innet.setFileName(file.getName());
		                InnetDTO innetDB=importRepository.save(innet);
		                if(innetDB!=null)
		                {
		                	insertions+=1;
		                }
							
						}
						
					}
				
			}

			}
			workbook.close();
			
		}
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		
		finally
		{
			
		}
		
		report.setCreations(creations);
		 report.setInsertions(insertions);
		 report.setDuplicates(duplicates);
		 return report;
	}

}
