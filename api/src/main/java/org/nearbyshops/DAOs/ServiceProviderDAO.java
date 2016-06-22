package org.nearbyshops.DAOs;

import org.nearbyshops.ContractClasses.EndUserContract;
import org.nearbyshops.ContractClasses.JDBCContract;
import org.nearbyshops.ContractClasses.ServiceProviderContract;
import org.nearbyshops.Model.EndUser;
import org.nearbyshops.Model.Service;
import org.nearbyshops.Model.ServiceProvider;

import java.sql.*;
import java.util.ArrayList;


public class ServiceProviderDAO {

	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();	
	}
	
	
	
	public int saveServiceProvider(ServiceProvider serviceProvider)
	{	
		
		Connection conn = null;
		Statement stmt = null;
		int rowIdOfInsertedRow = -1;

		String insertEndUser = "INSERT INTO "
				+ ServiceProviderContract.TABLE_NAME
				+ "("  
				+ ServiceProviderContract.SERVICE_PROVIDER_NAME
				+ ") VALUES("
				+ "'" + serviceProvider.getServiceProviderName()	+ "')";
		
		try {
			
			conn = DriverManager.getConnection(JDBCContract.CURRENT_CONNECTION_URL,
					JDBCContract.CURRENT_USERNAME,JDBCContract.CURRENT_PASSWORD);
			
			stmt = conn.createStatement();
			
			rowIdOfInsertedRow = stmt.executeUpdate(insertEndUser,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rs = stmt.getGeneratedKeys();

			if(rs.next())
			{
				rowIdOfInsertedRow = rs.getInt(1);
			}
			
			
			
			System.out.println("Key autogenerated SaveDistributor: " + rowIdOfInsertedRow);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			
			try {
			
				if(stmt!=null)
				{stmt.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				
				if(conn!=null)
				{conn.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		return rowIdOfInsertedRow;
	}
	

	public int updateServiceProvider(ServiceProvider serviceProvider)
	{	
		String updateStatement = "UPDATE " + ServiceProviderContract.TABLE_NAME
				+ " SET " + ServiceProviderContract.SERVICE_PROVIDER_NAME + " = "
				+ "'" + serviceProvider.getServiceProviderName() + "'"
				+ " WHERE ID = "
				+ serviceProvider.getServiceProviderID();
		
		Connection conn = null;
		Statement stmt = null;
		int updatedRows = -1;
		
		try {
			
			conn = DriverManager.getConnection(JDBCContract.CURRENT_CONNECTION_URL,
					JDBCContract.CURRENT_USERNAME,JDBCContract.CURRENT_PASSWORD);
			
			stmt = conn.createStatement();
			
			updatedRows = stmt.executeUpdate(updateStatement);
			
			
			System.out.println("Total rows updated: " + updatedRows);	
			
			//conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		
		{
			
			try {
			
				if(stmt!=null)
				{stmt.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				
				if(conn!=null)
				{conn.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return updatedRows;
		
	}
	

	public int deleteServiceProvider(int serviceProviderID)
	{
		
		String deleteStatement = "DELETE FROM " + ServiceProviderContract.TABLE_NAME + " WHERE ID = "
				+ serviceProviderID;
		
		
		Connection conn= null;
		Statement stmt = null;
		int rowsCountDeleted = 0;
		try {
			
			conn = DriverManager.getConnection(JDBCContract.CURRENT_CONNECTION_URL,
					JDBCContract.CURRENT_USERNAME,JDBCContract.CURRENT_PASSWORD);
			
			stmt = conn.createStatement();
			
			rowsCountDeleted = stmt.executeUpdate(deleteStatement);
			
			System.out.println(" Deleted Count: " + rowsCountDeleted);	
			
			conn.close();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		
		{
			
			try {
			
				if(stmt!=null)
				{stmt.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				
				if(conn!=null)
				{conn.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		return rowsCountDeleted;
	}
	
	
	
	
	
	public ArrayList<ServiceProvider> getServiceProvider()
	{
		String query = "SELECT * FROM " + ServiceProviderContract.TABLE_NAME;
		ArrayList<ServiceProvider> serviceProvidersList = new ArrayList<ServiceProvider>();
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DriverManager.getConnection(JDBCContract.CURRENT_CONNECTION_URL
					,JDBCContract.CURRENT_USERNAME
					, JDBCContract.CURRENT_PASSWORD);
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			
			while(rs.next())
			{

				ServiceProvider serviceProvider = new ServiceProvider();

				serviceProvider.setServiceProviderID(rs.getInt(ServiceProviderContract.SERVICE_PROVIDER_ID));
				serviceProvider.setServiceProviderName(rs.getString(ServiceProviderContract.SERVICE_PROVIDER_NAME));

				serviceProvidersList.add(serviceProvider);

			}
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		finally
		
		{
			
			try {
					if(rs!=null)
					{rs.close();}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			try {
			
				if(stmt!=null)
				{stmt.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				
				if(conn!=null)
				{conn.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
								
		return serviceProvidersList;
	}

	
	public ServiceProvider getServiceProvider(int serviceProviderID)
	{
		
		String query = "SELECT * FROM " + ServiceProviderContract.TABLE_NAME
						+ " WHERE " + ServiceProviderContract.SERVICE_PROVIDER_ID  + " = " + serviceProviderID;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
	
		//Distributor distributor = null;
		ServiceProvider serviceProvider = null;
		
		try {
			
			conn = DriverManager.getConnection(JDBCContract.CURRENT_CONNECTION_URL,
					JDBCContract.CURRENT_USERNAME,JDBCContract.CURRENT_PASSWORD);
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				serviceProvider = new ServiceProvider();

				serviceProvider.setServiceProviderID(rs.getInt(ServiceProviderContract.SERVICE_PROVIDER_ID));
				serviceProvider.setServiceProviderName(rs.getString(ServiceProviderContract.SERVICE_PROVIDER_NAME));

			}
			
			
			//System.out.println("Total itemCategories queried " + itemCategoryList.size());	
	
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		
		{
			
			try {
					if(rs!=null)
					{rs.close();}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			try {
			
				if(stmt!=null)
				{stmt.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				
				if(conn!=null)
				{conn.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return serviceProvider;
	}	
}
