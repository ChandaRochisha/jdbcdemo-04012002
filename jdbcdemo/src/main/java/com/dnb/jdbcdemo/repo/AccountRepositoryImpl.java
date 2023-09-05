package com.dnb.jdbcdemo.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.utils.DBUtils;

public class AccountRepositoryImpl implements AccountRepository {

	private AccountRepositoryImpl() {

	}

	private static AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account)
	{
		// TODO Auto-generated method stub
		Optional<Connection> connection = DBUtils.getConnection();

        String createAccountStatement = "insert into account "+"(accountId, accountHolderName, accountType, balance, contactNumber, address, accountCreatedDate, dob)"+

        "values(?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = null;

        if(connection.isPresent())

        {

        try

        {

        preparedStatement = connection.get().prepareStatement(createAccountStatement);

        preparedStatement.setString(1,  account.getAccountId());

        preparedStatement.setString(2, account.getAccountHolderName());

        preparedStatement.setString(3,  account.getAccountType());

        preparedStatement.setFloat(4,  account.getBalance());

        preparedStatement.setString(5,  account.getContactNumber());

        preparedStatement.setString(6,  account.getAddress());

        preparedStatement.setDate(7,  Date.valueOf(account.getAccountCreatedDate()));

        preparedStatement.setDate(8,  Date.valueOf(account.getDob()));

        preparedStatement.setBoolean(1,  account.isAccountStatus());

        int result = preparedStatement.executeUpdate();

        if(result>0)

        {

            return account;

        }

        }

        catch(SQLException e)

        {

            e.printStackTrace();

        }

        finally

        {

            if(connection.isPresent())

            {

                DBUtils.closeConnection(connection.get());

            }

        }

        }

        else

        {

            return null;
		}
		return account;
	}
	
	
	
	
	
	public static AccountRepository getInstance() {
		synchronized (AccountRepositoryImpl.class) {
			if (accountRepository == null) {
				accountRepository = new AccountRepositoryImpl();
			}
		}
		return accountRepository;
	}

	
	
	
	
	@Override
	public Optional<Account> getAccountById(String accountId) {
		
		Optional<Connection> connection = DBUtils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;
        String query = "select * from account where accountId=?";

        if(connection.isPresent())  {

        try

        {

        preparedStatement = connection.get().prepareStatement(query);

        preparedStatement.setString(1, accountId);

        resultSet = preparedStatement.executeQuery();

       
        if(resultSet.next())

        {
         Account account = new Account();
         account.setAccountId(resultSet.getString("accountId"));
         account.setAccountHolderName(resultSet.getString("accountHolderName"));
         account.setAccountType(resultSet.getString("accountType"));
         account.setBalance(resultSet.getFloat("balance"));
         account.setContactNumber(resultSet.getString("contactNumber"));
         account.setAccountStatus(resultSet.getBoolean("accountStatus"));
         account.setAddress(resultSet.getString("address"));
         account.setAccountCreatedDate(resultSet.getDate("accountCreatedDate").toLocalDate());
         account.setDob(resultSet.getDate("dob").toLocalDate());
        
		return Optional.of(account);
            

        }

        }

        catch(SQLException e)

        {

            e.printStackTrace();

        }

        finally

        {

            if(connection.isPresent())

            {

                DBUtils.closeConnection(connection.get());

            }

        }

        }else {
        	return null;
        }

        return Optional.empty();
	}





	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		Optional<Connection> connection = DBUtils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;
        String query = "select * from account";
        List<Account> accounts=new ArrayList();

        if(connection.isPresent())  {

        try

        {

        preparedStatement = connection.get().prepareStatement(query);

       // preparedStatement.setString(1, accountId);

        resultSet = preparedStatement.executeQuery();

       
        while(resultSet.next())

        {
         Account account = new Account();
         account.setAccountId(resultSet.getString("accountId"));
         account.setAccountHolderName(resultSet.getString("accountHolderName"));
         account.setAccountType(resultSet.getString("accountType"));
         account.setBalance(resultSet.getFloat("balance"));
         account.setContactNumber(resultSet.getString("contactNumber"));
         account.setAccountStatus(resultSet.getBoolean("accountStatus"));
         account.setAddress(resultSet.getString("address"));
         account.setAccountCreatedDate(resultSet.getDate("accountCreatedDate").toLocalDate());
         account.setDob(resultSet.getDate("dob").toLocalDate());
        accounts.add(account);
		
            

        }
        return accounts;
        }

        catch(SQLException e)

        {

            e.printStackTrace();

        }

        finally

        {

            if(connection.isPresent())

            {

                DBUtils.closeConnection(connection.get());

            }

        }

        }else {
        	return null;
        }		
		return null;
	}

}

