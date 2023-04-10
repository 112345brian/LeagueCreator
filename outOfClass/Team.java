package outOfClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Team {
	private String name;
	private int membersAmount;
	private double teamRank;
	private ArrayList<TeamMember> teamMembers;
	private int teamID;
	
	private static int nextID = 1;
	
	public Team(String name, int membersAmount, ArrayList<Team> leagueList) {
		this.setName(name);
		this.setMembersAmount(membersAmount);
		this.teamMembers = new ArrayList<TeamMember>();
		this.teamID = nextID;
		nextID++;
		this.teamRank = -1;
		leagueList.add(this);
		
	}
	
	public void addTeamMember(TeamMember teamMember) {
		teamMembers.add(teamMember);
	}
	
	public int getTeamID() {
		return this.teamID;
	}

	/* public static void setNumOfTeams(int numOfTeams) {
		Team.numOfTeams = numOfTeams;
	} */
	
	public void setTeamRank() {
		int sum = 0;
	    for (TeamMember member : teamMembers) {
	        sum += member.getMemberRank();
	    }
	    this.teamRank = Math.round(sum / teamMembers.size());
	}
	
	public void setTeamRank(int rank) {
		this.teamRank = rank;
	}

	public double getTeamRank() {
		
		if (this.teamRank == -1) {
			setTeamRank();
		}
		
	    return this.teamRank;
	}

	public void sortTeamMembersByRank() {
		Collections.sort(this.teamMembers, new Comparator<TeamMember>() {
			public int compare(TeamMember tm1, TeamMember tm2) {
				return tm2.getMemberRank() - tm1.getMemberRank();
			}
		});
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMembersAmount() {
		return membersAmount;
	}

	public void setMembersAmount(int membersAmount) {
		this.membersAmount = membersAmount;
	}
	
	public ArrayList<TeamMember> getTeamMembers() {
		return this.teamMembers;
	}
}	


		
		
	

	
