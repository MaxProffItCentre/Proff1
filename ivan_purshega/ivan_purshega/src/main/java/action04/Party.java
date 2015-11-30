package action04;

public class Party {
	private int number;
	private String contructor;
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contructor == null) ? 0 : contructor.hashCode());
		result = prime * result + number;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Party other = (Party) obj;
		if (contructor == null) {
			if (other.contructor != null)
				return false;
		} else if (!contructor.equals(other.contructor))
			return false;
		if (number != other.number)
			return false;
		return true;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getContructor() {
		return contructor;
	}
	public void setContructor(String contructor) {
		this.contructor = contructor;
	}
	public Party(int number, String contructor) {
		super();
		this.number = number;
		this.contructor = contructor;
	}
}

