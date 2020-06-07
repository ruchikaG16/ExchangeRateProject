package Resources;

public enum APIResource {
	
	latestForeignExchangeRate("latest"),
	incomplete(""),
	pastConversionRate("2010-01-12");
	
	private String resource;
	
	APIResource(String resource){
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}

}
