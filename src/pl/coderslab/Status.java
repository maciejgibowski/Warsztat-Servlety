package pl.coderslab;

public class Status {
	private int id = 0;
	private boolean isAccepted;
	private double acceptedRepairCost = 0;
	private boolean isRepaired;
	private boolean isReady;
	private boolean resignation;

	public Status() {

	}

	public Status(int id, boolean isAccepted, double acceptedRepairCost, boolean isRepaired, boolean isReady,
			boolean resignation) {
		this.id = id;
		this.isAccepted = isAccepted;
		this.acceptedRepairCost = acceptedRepairCost;
		this.isRepaired = isRepaired;
		this.isReady = isReady;
		this.resignation = resignation;

	}

	public Status(boolean isAccepted, double acceptedRepairCost, boolean isRepaired, boolean isReady,
			boolean resignation) {
		this.isAccepted = isAccepted;
		this.acceptedRepairCost = acceptedRepairCost;
		this.isRepaired = isRepaired;
		this.isReady = isReady;
		this.resignation = resignation;

	}

	public boolean getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public double getAcceptedRepairCost() {
		return acceptedRepairCost;
	}

	public void setAcceptedRepairCost(double acceptedRepairCost) {
		this.acceptedRepairCost = acceptedRepairCost;
	}

	public boolean getIsRepaired() {
		return isRepaired;
	}

	public void setIsRepaired(boolean isRepaired) {
		this.isRepaired = isRepaired;
	}

	public boolean getIsReady() {
		return isReady;
	}

	public void setIsReady(boolean isReady) {
		this.isReady = isReady;
	}

	public boolean getResignation() {
		return resignation;
	}

	public void setResignation(boolean resignation) {
		this.resignation = resignation;
	}

	public int getId() {
		return id;
	}

}
