package action04;

import java.util.LinkedList;

public class Party {
	private int number;
	private String contructor;
	
	public Party(int number, String contructor) {
		super();
		this.number = number;
		this.contructor = contructor;
	}

	@Override
	public int hashCode() {
		return number + contructor.hashCode();
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


	
}
