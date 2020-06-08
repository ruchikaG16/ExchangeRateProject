package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;


public class Utils {
	
	public static RequestSpecification request;
	
public RequestSpecification requestSpecification() throws IOException {
		
	if(request==null) {
		PrintStream log = new PrintStream(new File("logging.txt"));
		
	   	 request = new RequestSpecBuilder().setBaseUri(getGlobalVariable("baseUrl")).
	   			 addFilter(RequestLoggingFilter.logRequestTo(log)).
	   			 addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
	   	 return request;
	}
	return request;
}	
		
	public String getGlobalVariable(String key) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\windows 10\\git\\ExchangeRateProject\\ExchangeRateProject\\src\\test\\java\\Resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
}
