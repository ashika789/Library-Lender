public class MediaItem {

	public String title;
	public String format;
	public boolean onLoan;
	public String loanedTo;
	public String dateLoaned;

	public MediaItem() {
		title = "";
		format = "";
		onLoan = false;
		loanedTo = "";
		dateLoaned = "";
	}

	public MediaItem(String name, String type) {
		title = name;
		format = type;
		onLoan = false;
		loanedTo = "";
		dateLoaned = "";
	}

	public String toString() {
		return title + " (" + format + ") " + loanedTo + dateLoaned;
	}

	public void markOnLoan(String name, String dat) {
		if (onLoan == true) {
			System.out.println(title + " is already on loan to " + loanedTo);
		} else {
			loanedTo = name;
			dateLoaned = " on " + dat;
			onLoan = true;
		}
	}

	public void setTitle(String n) {
		title = n;
	}

	public void markReturned() {
		if (loanedTo == "") {
			System.out.println(title + " is not currently on loan");
		} else {
			loanedTo = "";
			dateLoaned = "";
			onLoan = false;
		}
	}

	public String getTitle() {
		return title;
	}

	public String getLoanedTo() {
		return loanedTo;
	}

	public String getDateLoaned() {
		return dateLoaned;
	}

}