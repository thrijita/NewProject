package com.stackroute.datamunger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataMunger {

	public static void main(String[] args) {
		
		// read the query from the user into queryString variable
		Scanner scanner=new Scanner(System.in);
		String queryString=scanner.nextLine();
		DataMunger dataMunger=new DataMunger();
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
				String[] splittedString = queryString.split(" ");
				return splittedString;
	}

	// get and display the filename
	public String getFile(String queryString) {
				// code to get the file name
				String fileName = queryString.split("from")[1].split("where")[0];
				//String[] fields = queryString.split("select")[1].trim().split("from")[0].split("[\\s,]+");
				return fileName;
	}
	
	// getting the baseQuery and display
	public String getBaseQuery(String queryString) {
		//getting base query
		String baseQuery=null;
		if(queryString.contains("where"))
		{
		baseQuery=(queryString.split("where")[0].trim());
		}
		else if(queryString.contains("group by")||queryString.contains("order by"))
		{
			baseQuery=(queryString.split("order by|group by")[0].trim());	
		}
		
		
		
		return baseQuery;

	}
	
	// get and display the where conditions part(if where condition exists)
	public String getConditionsPartQuery(String queryString) {
		//getting only where with order,group by
		if(queryString.contains("where"))
		{
		String conditionsQuery=(queryString.split("where")[1].trim()).split("order by|group by")[0].trim().toLowerCase();
		return conditionsQuery;
		}
		else
		{
		return null;
		}


	}
	
	/* parse the where conditions and display the propertyName, propertyValue and
	 conditionalOperator for each conditions*/
	public String[] getConditions(String queryString) {
		//where with order,group,and,or
		if(queryString.contains("where"))
		{
		String[] conditions=(((queryString.split("where")[1].trim()).split("order by|group by")[0].trim().toLowerCase().trim()).split(" and | or "));
		return conditions;
		}
		else
		{
			return null;	
		}

	}
	
	// get the logical operators(applicable only if multiple conditions exist)
	public String[] getLogicalOperators(String queryString) {
		//only logical operators
		List<String> logicalOperator=new ArrayList<>();
		if(queryString.contains("where"))
		{
		String[] conditionsQuery=((queryString.split("where")[1].trim()).split("order by|group by")[0].trim().toLowerCase()).split(" ");
		for(String string:conditionsQuery)
		{
			if(string.equals("and")||string.equals("or"))
				logicalOperator.add(string);
		}
		String[] logicalOperators=logicalOperator.toArray(new String[logicalOperator.size()]);
		return logicalOperators;
		}
		else
		{
			return null;
		}

		
	}
	
	/*get the fields from the select clause*/
	public String[] getFields(String queryString) {
				//split according to select , from and storing separately
				
				//String[] fields = queryString.split("select")[1].trim().split("from")[0].split("[\\s,]+");
				String[] fields=(queryString.split("from")[0].trim()).split("select")[1].trim().split(",");
				return fields;

				//return fields;
		
	}
	// get order by fields if order by clause exists
	public String[] getOrderByFields(String queryString) {
		//code to split order by
		if(queryString.contains("order by"))
		{
		String[] orderByField=(queryString.split("order by")[1].trim()).split(" ")[0].trim().toLowerCase().split(" ");
		return orderByField;
		}
		
		return null;

	}
	
	// get group by fields if group by clause exists
	public String[] getGroupByFields(String queryString) {
		//code to split group by and to store separately
		if(queryString.contains("group by"))
		{
		String[] groupByFields=(queryString.split("group by")[1].trim()).split(" ")[0].trim().toLowerCase().split(" ");
		return groupByFields;
		}
		return null;

	}
	
	// parse and display aggregate functions(if applicable)
	public String[] getAggregateFunctions(String queryString) {
		//code to split aggregate functions alone
		List<String> aggregateFunction=new ArrayList<>();
		if(queryString.contains("("))
		{
		for(String string:getFields(queryString))
		{
			if(string.contains("min")||string.contains("max")||string.contains("avg")||string.contains("sum")||string.contains("count"))
			{
			aggregateFunction.add(string);
			}
		}
		String[] aggregateFunctions=aggregateFunction.toArray(new String[aggregateFunction.size()]);

		return aggregateFunctions;
		}
		else
		{
		return null;
		}

	}

	
	
	
	
}