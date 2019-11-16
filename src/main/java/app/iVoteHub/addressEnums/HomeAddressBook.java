package app.iVoteHub.addressEnums;

public enum HomeAddressBook {
	
	ERROR("error","error-default");
	/*controller mapping address*/
	private String address;
	/*Address of the reosurce
	 * relative to WEB-INF/views/*/
	private String resource;
	HomeAddressBook(String address, String resource) {
		this.address = address;
		this.resource = resource;
	}
}
