package com.dnb.jdbcdemo;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.repo.AccountRepositoryImpl;
import com.dnb.jdbcdemo.utils.DBUtils;

public class JDBCApplication {
	
 public static void main(String args[])
 {
//	 String a="abhi";
//	 String b=null;
//	 
//	 Optional<String> optional = Optional.ofNullable(b);
//	 System.out.println(optional.isPresent());
	 
	 
	 //Local to java.sql.Date
	
//	 java.sql.Date date = Date.valueOf(LocalDate.now());
//	 System.out.println(date);

	 Account account = new Account();
	 
	 
	 
	 Scanner sc = new Scanner(System.in);
	 while(true)
	 {
		 System.out.println("1. account creation, 2. account details by id, "
		 		+ "3 . account  details by account holder name");
		 System.out.println("enter your choice ");
		int b = sc.nextInt();
		if(b>3)
		{
			break;
		}
		 switch(b)
		 {
		 case 1: 
			 System.out.println("Enter account id");
			 String accountId= sc.next();
			 System.out.println("Enter account Holder name");
			 String accountHolderName= sc.next();
			 System.out.println("Enter account Type");
			 String accountType= sc.next();
			 System.out.println("Enter balance");
			 float balance= sc.nextFloat();
			 System.out.println("Enter Contact Number");
			 String contactNumber= sc.nextLine();
			 System.out.println("Enter account status");
			 String accountStatus= sc.nextLine();
			 System.out.println("Enter address");
			 String address= sc.nextLine(); 
			 System.out.println("Enter accountCreatedDate");
			 String accountCreatedDate = sc.next();

             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");         
			 LocalDate formattedString = LocalDate.parse(accountCreatedDate,formatter);
			 
			 
			 System.out.println("Enter Dob");
			 String dob = sc.next();

             DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yy-MM-dd");         
			 LocalDate formattedString1 = LocalDate.parse(accountCreatedDate,formatter1);
			 
			 
			 account.setAccountId(accountId);

             account.setAccountHolderName(accountHolderName);

             account.setAccountType(accountType);

             account.setAccountStatus(true);

             account.setAddress(address);

             account.setBalance(balance);

             account.setContactNumber(contactNumber);

             account.setAccountCreatedDate(formattedString);

             account.setDob(formattedString1);

          
				 
			 
			 System.out.println(AccountRepositoryImpl.getInstance().createAccount(account));
			 			 
			 
		 case 2:
			 String id= sc.next();
			 System.out.println(AccountRepositoryImpl.getInstance().getAccountById(id));
		
		 }
		 
	 }
	
	 
 }
}
