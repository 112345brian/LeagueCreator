package outOfClass;

public class TeamMember {
	
	private String memberName;
	private int memberRank;
	private int memberID;
	
	/* private static int nextID = 1; */
	
	public TeamMember(String memberName, int memberRank, Team team, LeagueClass league) {
		this.setMemberName(memberName);
		this.setMemberRank(memberRank);
		this.setMemberID(league.getGlobalNextID());
		league.incGlobalNextID();
		team.addTeamMember(this);
	}

	public int getMemberRank() {
		return memberRank;
	}

	public void setMemberRank(int memberRank) {
		this.memberRank = memberRank;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	
	
	
	
	//memberRank between 1 and 10
	
}
