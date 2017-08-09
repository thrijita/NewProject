package com.stackroute.datamunger;

import java.util.Arrays;
import java.util.Scanner;

public class DataMunger {

	public static void main(String[] args) {
		
		//creation of object for the current class DataMunger
		DataMunger dataMunger = new DataMunger();
		// read the query from the user into queryString variable
		String queryString="select * from ipl.csv where season > 2014 and city ='Bangalore'";
		
		// call the parseQuery method and pass the queryString variable as a parameter
		dataMunger.parseQuery(queryString);
	}
	

	public void parseQuery(String queryString) {
		//call the methods
		getSplitStrings(queryString);
		getFile(queryString);
		getBaseQuery(queryString);
		getConditionsPartQuery(queryString);
		getConditions(queryString);
		getLogicalOperators(queryString);
		getFields(queryString);
		getOrderByFields(queryString);
		getGroupByFields(queryString);
		getAggregateFunctions(queryString);
	}
	
	// parse the queryString into words and display
	public String[] getSplitStrings(String queryString) {
				//split of string according to space
				queryString = queryString.toLowerCase();
				String[] splittedString = queryString.split("\\s+");
				return splittedString;
	}

	// get and display the filename
	public String getFile(String queryString) {
				// code to get the file name
				queryString = queryString.toLowerCase();
				String fileName = queryString.split("from")[1].split("\\s+")[1];
				queryString = queryString.toLowerCase();
				String[] fields = queryString.split("select")[1].trim().split("from")[0].split("[\\s,]+");

				return fileName;
	}
	
	// getting the baseQuery and display
	public String getBaseQuery(String queryString) {
		//getting base query
		queryString = queryString.toLowerCase();
		String baseQuery = queryString.split("where |order by|group by")[0];
		return baseQuery;
	}
	
	// get and display the where conditions part(if where condition exists)
	public String getConditionsPartQuery(String queryString) {
		
	
		return null;

	}
	
	/* parse the where conditions and display the propertyName, propertyValue and
	 conditionalOperator for each conditions*/
	public String[] getConditions(String queryString) {
		
	
		return null;
	}
	
	// get the logical operators(applicable only if multiple conditions exist)
	public String[] getLogicalOperators(String queryString) {

		
		
		return null;
		
	}
	
	/*get the fields from the select clause*/
	public String[] getFields(String queryString) {
				//split according to select , from and storing separately
				queryString = queryString.toLowerCase();
				String[] fields = queryString.split("select")[1].trim().split("from")[0].split("[\\s,]+");

				return fields;
		
	}
	// get order by fields if order by clause exists
	public String[] getOrderByFields(String queryString) {
		//code to split order by
		queryString = queryString.toLowerCase();
		String [] orderByFields=queryString.split("order by")[1].split("[\\s,]+");
		return orderByFields;
	}
	
	// get group by fields if group by clause exists
	public String[] getGroupByFields(String queryString) {
		//code to split group by and to store separately
		queryString = queryString.toLowerCase();
		String [] groupByFields=queryString.split("group by\\s+")[1].split("[\\s,]+");	

		return groupByFields;
	}
	
	// parse and display aggregate functions(if applicable)
	public String[] getAggregateFunctions(String queryString) {
		

		return null;
	}

	
	
	
	
}