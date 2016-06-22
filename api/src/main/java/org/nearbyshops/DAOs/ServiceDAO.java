package org.nearbyshops.DAOs;

import org.nearbyshops.ContractClasses.CartContract;
import org.nearbyshops.ContractClasses.JDBCContract;
import org.nearbyshops.ContractClasses.ServiceContract;
import org.nearbyshops.ContractClasses.ShopContract;
import org.nearbyshops.Model.Cart;
import org.nearbyshops.Model.Service;

import java.sql.*;
import java.util.ArrayList;


public class ServiceDAO {

	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();	
	}
	



	
	public int saveService(Service service)
	{

		Connection conn = null;
		Statement stmt = null;
		int rowIdOfInsertedRow = -1;

		String insertItemCategory = "INSERT INTO "
				+ ServiceContract.TABLE_NAME
				+ "("

				+ ServiceContract.IMAGE_PATH + ","
				+ ServiceContract.LOGO_IMAGE_PATH + ","
				+ ServiceContract.BACKDROP_IMAGE_PATH + ","

				+ ServiceContract.SERVICE_NAME + ","
				+ ServiceContract.HELPLINE_NUMBER + ","
				+ ServiceContract.ADDRESS + ","

				+ ServiceContract.CITY + ","
				+ ServiceContract.PINCODE + ","
				+ ServiceContract.LANDMARK + ","

				+ ServiceContract.STATE + ","
				+ ServiceContract.COUNTRY + ","
				+ ServiceContract.ISO_COUNTRY_CODE + ","

				+ ServiceContract.ISO_LANGUAGE_CODE + ","
				+ ServiceContract.SERVICE_TYPE + ","
				+ ServiceContract.SERVICE_LEVEL + ","

				+ ServiceContract.LAT_CENTER + ","
				+ ServiceContract.LON_CENTER + ","
				+ ServiceContract.SERVICE_RANGE + ","

				+ ServiceContract.IS_ETHICAL_SERVICE_PROVIDER + ","
				+ ServiceContract.IS_VERIFIED + ","
				+ ServiceContract.LAT_MAX + ","

				+ ServiceContract.LON_MAX + ","
				+ ServiceContract.LAT_MIN + ","
				+ ServiceContract.LON_MIN + ","

				+ ServiceContract.CONFIGURATION_NICKNAME + ","
				+ ServiceContract.UPDATED + ","

				+ ServiceContract.SERVICE_URL + ""

				+ " ) VALUES ( "

				+ "'" + service.getImagePath()	+ "',"
				+ "'" + service.getLogoImagePath()	+ "',"
				+ "'" + service.getBackdropImagePath()	+ "',"

				+ "'" + service.getServiceName()	+ "',"
				+ "'" + service.getHelplineNumber()	+ "',"
				+ "'" + service.getAddress()	+ "',"

				+ "'" + service.getCity()	+ "',"
				+ "" + service.getPincode()	+ ","
				+ "'" + service.getLandmark()	+ "',"

				+ "'" + service.getState()	+ "',"
				+ "'" + service.getCountry()	+ "',"
				+ "'" + service.getISOCountryCode()	+ "',"

				+ "'" + service.getISOLanguageCode()	+ "',"
				+ "" + service.getServiceType()	+ ","
				+ "" + service.getServiceLevel()	+ ","

				+ "" + service.getLatCenter()	+ ","
				+ "" + service.getLonCenter()	+ ","
				+ "" + service.getServiceRange()	+ ","

				+ "" + service.getEthicalServiceProvider()	+ ","
				+ "" + service.getVerified()	+ ","
				+ "" + service.getLatMax()	+ ","

				+ "" + service.getLonMax()	+ ","
				+ "" + service.getLatMin()	+ ","
				+ "" + service.getLonMin()	+ ","

				+ "'" + service.getConfigurationNickname()	+ "',"

				+ "'" + "now()"	+ "',"

				+ "'" + service.getServiceURL()	+ "'"

				+ ")";
		
		try {
			
			conn = DriverManager.getConnection(JDBCContract.CURRENT_CONNECTION_URL,
					JDBCContract.CURRENT_USERNAME,JDBCContract.CURRENT_PASSWORD);
			
			stmt = conn.createStatement();
			
			rowIdOfInsertedRow = stmt.executeUpdate(insertItemCategory,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rs = stmt.getGeneratedKeys();

			if(rs.next())
			{
				rowIdOfInsertedRow = rs.getInt(1);
			}
			
			
			
			System.out.println("Key autogenerated Save Service: " + rowIdOfInsertedRow);
			
			
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




	public int updateService(Service service)
	{	
		String updateStatement = "UPDATE " + ServiceContract.TABLE_NAME

				+ " SET "

				+ ServiceContract.IMAGE_PATH + " = " + "'" + service.getImagePath() + "'" + ","
				+ ServiceContract.LOGO_IMAGE_PATH + " = " + "'" + service.getLogoImagePath() + "'" + ","
				+ ServiceContract.BACKDROP_IMAGE_PATH + " = " + "'" + service.getBackdropImagePath() + "'" + ","

				+ ServiceContract.SERVICE_NAME + " = " + "'" + service.getServiceName() + "'" + ","
				+ ServiceContract.HELPLINE_NUMBER + " = " + "'" + service.getHelplineNumber() + "'" + ","
				+ ServiceContract.ADDRESS + " = " + "'" + service.getAddress() + "'" + ","

				+ ServiceContract.CITY + " = " + "'" + service.getCity() + "'" + ","
				+ ServiceContract.PINCODE + " = " + "" + service.getPincode() + "" + ","
				+ ServiceContract.LANDMARK + " = " + "'" + service.getLandmark() + "'" + ","

				+ ServiceContract.STATE + " = " + "'" + service.getState() + "'" + ","
				+ ServiceContract.COUNTRY + " = " + "'" + service.getCountry() + "'" + ","
				+ ServiceContract.ISO_COUNTRY_CODE + " = " + "'" + service.getISOCountryCode() + "'" + ","

				+ ServiceContract.ISO_LANGUAGE_CODE + " = " + "'" + service.getISOLanguageCode() + "'" + ","
				+ ServiceContract.SERVICE_TYPE + " = " + "" + service.getServiceType() + "" + ","
				+ ServiceContract.SERVICE_LEVEL + " = " + "" + service.getServiceLevel() + "" + ","

				+ ServiceContract.LAT_CENTER + " = " + "" + service.getLatCenter() + "" + ","
				+ ServiceContract.LON_CENTER + " = " + "" + service.getLonCenter() + "" + ","
				+ ServiceContract.SERVICE_RANGE + " = " + "" + service.getServiceRange() + "" + ","

				+ ServiceContract.IS_ETHICAL_SERVICE_PROVIDER + " = " + "" + service.getEthicalServiceProvider() + "" + ","
				+ ServiceContract.IS_VERIFIED + " = " + "" + service.getVerified() + "" + ","
				+ ServiceContract.LAT_MAX + " = " + "" + service.getLatMax() + "" + ","

				+ ServiceContract.LON_MAX + " = " + "" + service.getLonMax() + "" + ","
				+ ServiceContract.LAT_MIN + " = " + "" + service.getLatMin() + "" + ","
				+ ServiceContract.LON_MIN + " = " + "" + service.getLonMin() + "" + ","

				+ ServiceContract.CONFIGURATION_NICKNAME + " = " + "'" + service.getConfigurationNickname() + "'" + ","
				+ ServiceContract.UPDATED + " = " + "'" + "now()" + "'" + ","
				+ ServiceContract.SERVICE_URL + " = " + "'" + service.getServiceURL() + "'" + ""

				+ " WHERE "

				+ ServiceContract.SERVICE_ID + " = " + service.getServiceID();


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




	public int deleteService(int serviceID)
	{
		
		String deleteStatement = "DELETE FROM " + ServiceContract.TABLE_NAME + " WHERE " + ServiceContract.SERVICE_ID + " = "
				+ serviceID;
		
		
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
	


	
	
	
	public ArrayList<Service> readServices(Integer serviceLevel,Integer serviceType,
										   Double latCenterQuery,Double lonCenterQuery,
										   String sortBy,
										   int limit, int offset)
	{


		String queryNormal = "SELECT " + " 6371 * acos(cos( radians("
							+ latCenterQuery + ")) * cos( radians( " + ServiceContract.LAT_CENTER
							+ ")) * cos(radians( "
							+ ServiceContract.LON_CENTER + ") - radians(" + lonCenterQuery + "))"
							+ " + sin( radians(" + latCenterQuery+ ")) * sin(radians(" + ServiceContract.LAT_CENTER + "))) as distance" + ","
							+ " * FROM " + ServiceContract.TABLE_NAME;


		boolean isFirst = true;


		if(serviceLevel > 0)
		{
			queryNormal = queryNormal + " WHERE " + ServiceContract.SERVICE_LEVEL + " = " + serviceLevel;

			isFirst = false;
		}



		if(serviceType > 0 )
		{
			if(isFirst)
			{
				queryNormal = queryNormal + " WHERE " + ServiceContract.SERVICE_TYPE + " = " + serviceType;

				isFirst = false;

			}else
			{
				queryNormal = queryNormal + " AND " + ServiceContract.SERVICE_TYPE + " = " + serviceType;

			}

		}



		// apply visibility filter


		if(latCenterQuery>0 && lonCenterQuery >0)
		{

			String queryPartVisibilityFilter = "";




			// filter using Haversine formula using SQL math functions
			queryPartVisibilityFilter = queryPartVisibilityFilter
					+ " (6371.01 * acos(cos( radians("
					+ latCenterQuery
					+ ")) * cos( radians("
					+ ServiceContract.LAT_CENTER
					+ " )) * cos(radians( "
					+ ServiceContract.LON_CENTER
					+ ") - radians("
					+ lonCenterQuery
					+ "))"
					+ " + sin( radians("
					+ latCenterQuery
					+ ")) * sin(radians("
					+ ServiceContract.LAT_CENTER
					+ ")))) <= "
					+ ServiceContract.SERVICE_RANGE ;



			if(isFirst)
			{
				queryNormal = queryNormal + " WHERE ";

				// reset the flag
				isFirst = false;

			}else
			{
				queryNormal = queryNormal + " AND ";
			}



			queryNormal = queryNormal + queryPartVisibilityFilter;


		}





		if(sortBy!=null)
		{
			if(!sortBy.equals(""))
			{
				String queryPartSortBy = " ORDER BY " + sortBy;

				queryNormal = queryNormal + queryPartSortBy;
			}
		}



		if(limit > 0)
		{

			String queryPartLimitOffset = "";

			if(offset>0)
			{
				queryPartLimitOffset = " LIMIT " + limit + " " + " OFFSET " + offset;

			}else
			{
				queryPartLimitOffset = " LIMIT " + limit + " " + " OFFSET " + 0;
			}


			queryNormal = queryNormal + queryPartLimitOffset;
		}



		ArrayList<Service> servicesList = new ArrayList<Service>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DriverManager.getConnection(JDBCContract.CURRENT_CONNECTION_URL
					,JDBCContract.CURRENT_USERNAME
					, JDBCContract.CURRENT_PASSWORD);
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(queryNormal);
			
			while(rs.next())
			{
				Service service = new Service();

				service.setRt_distance(rs.getDouble("distance"));

				service.setServiceID(rs.getInt(ServiceContract.SERVICE_ID));
				service.setImagePath(rs.getString(ServiceContract.IMAGE_PATH));
				service.setLogoImagePath(rs.getString(ServiceContract.LOGO_IMAGE_PATH));

				service.setBackdropImagePath(rs.getString(ServiceContract.BACKDROP_IMAGE_PATH));
				service.setServiceName(rs.getString(ServiceContract.SERVICE_NAME));
				service.setHelplineNumber(rs.getString(ServiceContract.HELPLINE_NUMBER));

				service.setAddress(rs.getString(ServiceContract.ADDRESS));
				service.setCity(rs.getString(ServiceContract.CITY));
				service.setPincode(rs.getLong(ServiceContract.PINCODE));

				service.setLandmark(rs.getString(ServiceContract.LANDMARK));
				service.setState(rs.getString(ServiceContract.STATE));
				service.setCountry(rs.getString(ServiceContract.COUNTRY));

				service.setISOCountryCode(rs.getString(ServiceContract.ISO_COUNTRY_CODE));
				service.setISOLanguageCode(rs.getString(ServiceContract.ISO_LANGUAGE_CODE));
				service.setServiceType(rs.getInt(ServiceContract.SERVICE_TYPE));

				service.setServiceLevel(rs.getInt(ServiceContract.SERVICE_LEVEL));
				service.setLatCenter(rs.getDouble(ServiceContract.LAT_CENTER));
				service.setLonCenter(rs.getDouble(ServiceContract.LON_CENTER));

				service.setServiceRange(rs.getInt(ServiceContract.SERVICE_RANGE));
				service.setEthicalServiceProvider(rs.getBoolean(ServiceContract.IS_ETHICAL_SERVICE_PROVIDER));
				service.setVerified(rs.getBoolean(ServiceContract.IS_VERIFIED));

				service.setLatMax(rs.getDouble(ServiceContract.LAT_MAX));
				service.setLonMax(rs.getDouble(ServiceContract.LON_MAX));
				service.setLatMin(rs.getDouble(ServiceContract.LAT_MIN));

				service.setLonMin(rs.getDouble(ServiceContract.LON_MIN));
				service.setConfigurationNickname(rs.getString(ServiceContract.CONFIGURATION_NICKNAME));
				service.setServiceURL(rs.getString(ServiceContract.SERVICE_URL));

				service.setCreated(rs.getTimestamp(ServiceContract.CREATED));
				service.setUpdated(rs.getTimestamp(ServiceContract.UPDATED));


				servicesList.add(service);
				
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
		
								
		return servicesList;
	}





	public Service readService(int serviceID)
	{
		
		String query = "SELECT * FROM " + ServiceContract.TABLE_NAME
						+ " WHERE " + ServiceContract.SERVICE_ID + " = " + serviceID;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;


		Service service = null;

		
		try {
			
			conn = DriverManager.getConnection(JDBCContract.CURRENT_CONNECTION_URL,
					JDBCContract.CURRENT_USERNAME,JDBCContract.CURRENT_PASSWORD);
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				service = new Service();

				service.setServiceID(rs.getInt(ServiceContract.SERVICE_ID));
				service.setImagePath(rs.getString(ServiceContract.IMAGE_PATH));
				service.setLogoImagePath(rs.getString(ServiceContract.LOGO_IMAGE_PATH));

				service.setBackdropImagePath(rs.getString(ServiceContract.BACKDROP_IMAGE_PATH));
				service.setServiceName(rs.getString(ServiceContract.SERVICE_NAME));
				service.setHelplineNumber(rs.getString(ServiceContract.HELPLINE_NUMBER));

				service.setAddress(rs.getString(ServiceContract.ADDRESS));
				service.setCity(rs.getString(ServiceContract.CITY));
				service.setPincode(rs.getLong(ServiceContract.PINCODE));

				service.setLandmark(rs.getString(ServiceContract.LANDMARK));
				service.setState(rs.getString(ServiceContract.STATE));
				service.setCountry(rs.getString(ServiceContract.COUNTRY));

				service.setISOCountryCode(rs.getString(ServiceContract.ISO_COUNTRY_CODE));
				service.setISOLanguageCode(rs.getString(ServiceContract.ISO_LANGUAGE_CODE));
				service.setServiceType(rs.getInt(ServiceContract.SERVICE_TYPE));

				service.setServiceLevel(rs.getInt(ServiceContract.SERVICE_LEVEL));
				service.setLatCenter(rs.getDouble(ServiceContract.LAT_CENTER));
				service.setLonCenter(rs.getDouble(ServiceContract.LON_CENTER));

				service.setServiceRange(rs.getInt(ServiceContract.SERVICE_RANGE));
				service.setEthicalServiceProvider(rs.getBoolean(ServiceContract.IS_ETHICAL_SERVICE_PROVIDER));
				service.setVerified(rs.getBoolean(ServiceContract.IS_VERIFIED));

				service.setLatMax(rs.getDouble(ServiceContract.LAT_MAX));
				service.setLonMax(rs.getDouble(ServiceContract.LON_MAX));
				service.setLatMin(rs.getDouble(ServiceContract.LAT_MIN));

				service.setLonMin(rs.getDouble(ServiceContract.LON_MIN));
				service.setConfigurationNickname(rs.getString(ServiceContract.CONFIGURATION_NICKNAME));
				service.setServiceURL(rs.getString(ServiceContract.SERVICE_URL));

				service.setCreated(rs.getTimestamp(ServiceContract.CREATED));
				service.setUpdated(rs.getTimestamp(ServiceContract.UPDATED));


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
	
		return service;
	}	
}
