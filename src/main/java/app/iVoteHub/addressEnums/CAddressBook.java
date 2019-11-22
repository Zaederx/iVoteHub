package app.iVoteHub.addressEnums;

public enum CAddressBook {

	C_HOME ("commission/home","commission/candidate-home"),
	C_VIEW_POLLS ("commission-polls","commission-polls-view"),
	
	;
	/*controller mapping address*/
	private String address;
	/*Address of the reosurce
	 * relative to WEB-INF/views/*/
	private String resource;

	CAddressBook(String address, String resource) {
		this.address = address;
		this.resource = resource;
	}

	/**
	 * Returns the address.
	 * These link to RequestMappings for their
	 * repsective resources.
	 * @return address
	 */
	public String url() {
		return address;
	}

	/**
	 * Returns relative url of jsp resources.
	 * Relative to /WEB-INF/views/
	 * @return resource url
	 */
	public String jsp() {
		return resource;
	}
}
