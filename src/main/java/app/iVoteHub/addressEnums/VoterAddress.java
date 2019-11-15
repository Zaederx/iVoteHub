package app.iVoteHub.addressEnums;

/**
 * Acts and an authority url address.
 * Created to address problem of keeping track
 * of Controller url mappings correct
 * across changes. <br>
 * 
 * Any changes to urls should be made here
 * before altering request mappings in 
 * order to maintain full functionality.
 * 
 * @author Zachary Ishmael
 *
 */
public enum VoterAddress {

	REGISTRATION ("voter-registration", "/voter/sign-up"),
	LOGIN("login",""),
	HOME("voter/voter-main", "voter/voter-home"),
	VOTE("voter/vote", "voter/voter-vote");
	
	/*controller mapping address*/
	private String address;
	/*Address of the reosurce
	 * relative to WEB-INF/views/*/
	private String resource;
	VoterAddress(String address, String resource) {
		this.address = address;
		this.resource = resource;
	}
	/**
	 * Returns last part of url for controllers.
	 * i.e. in voter/voter-page it would return 
	 * "voter-page"
	 * 
	 * @return
	 */
	public String url() {
		return address;
	}
	
	/**
	 * Return url with a forward slash before.
	 * Used to provide urls for security config.
	 * @return /url
	 */
	public String configUrl(){
		return "/"+address;
	}
	
	public String jsp() {
		return resource;
	}
//	/**
//	 * Returns the domain and url together.
//	 * i.e. /voter
//	 * @return
//	 */
//	public String path() {
//		return "/voter"+address;
//	}
}
