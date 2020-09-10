package pageTests;

public class FlightDetails {
	private String flightName;
	private String startTime;
	private int filghtsTravalDuration;
	private String filghtsCost;
	private String filghtsCode;
	
	public FlightDetails(String flightName, String startTime,  int filghtsTravalDuration, String filghtsCost, String filghtsCode) {
		this.flightName = flightName;
		this.filghtsCost = filghtsCost;
		this.startTime = startTime;
		this.filghtsTravalDuration = filghtsTravalDuration;
		this.filghtsCode=filghtsCode;
	}

	public String getFlightName() {
		return flightName;
	}

	public String getPrice() {
		return filghtsCost;
	}

	public String getstartTime() {
		return startTime;
	}

	public int getfilghtsTravalDuration() {
		return filghtsTravalDuration;
	}

	public String getStartTime() {
		return startTime;
	}
	public String getfilghtsCode() {
		return filghtsCode;
	}
}
