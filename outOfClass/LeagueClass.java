package outOfClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class LeagueClass {
	private ArrayList<Team> leagueList = new ArrayList<>();
	private int globalNextID = 1;
	private Random random;
	
	final String[] POSSIBLE_NAMES = {"Alice", "Bob", "Charlie", "Dave", "Emma", "Frank", "Grace", "Henry", "Isabella", "Jack",
            "Kate", "Liam", "Mia", "Noah", "Olivia", "Penelope", "Quentin", "Riley", "Sophia", "Thomas",
            "Una", "Violet", "Wyatt", "Xander", "Yara", "Zane", "Ava", "Benjamin", "Chloe", "Daniel",
            "Ethan", "Faith", "Graham", "Hazel", "Isla", "James", "Katherine", "Leo", "Madison", "Nora",
            "Oscar", "Piper", "Quinn", "Rowan", "Scarlett", "Theo", "Ursula", "Vivienne", "Willow", "Xavier",
            "Yasmine", "Zoe"};

	final String[] POSSIBLE_TEAMS = {
		    "Warriors", "Knicks", "Lakers", "Spurs", "Raptors",
		    "Celtics", "Heat", "Bulls", "Clippers", "Suns",
		    "Mavericks", "Rockets", "Thunder", "Blazers", "Pelicans",
		    "Nets", "Jazz", "Hawks", "Pacers", "Grizzlies",
		    "Kings", "Timberwolves", "Hornets", "Magic", "76ers",
		    "Nuggets", "Pistons", "Cavaliers", "Wizards", "Bucks"
		};
	
	
	public LeagueClass() {
		this.random = new Random();
		teamGenerator();
		printSortTeamsByRank();
		
	}
	
	public void addTeamtoLeague(Team team) {
		leagueList.add(team);
	}
	
	
	public void printSortTeamsByRank() {
		System.out.print(sortTeamsByRank());
	}
	
	
	public void incGlobalNextID() {
		globalNextID++;
	}
	
	public int getGlobalNextID() {
		return globalNextID;
	}
	
	public String sortTeamsByRank() {
		
		Collections.sort(leagueList, new Comparator<Team>() {
			public int compare(Team tm1, Team tm2) {
				return (int)tm2.getTeamRank() - (int)tm1.getTeamRank();
			}
		});
		
		
		
		StringBuilder result = new StringBuilder();
	    for (Team team : leagueList) {
	    	team.sortTeamMembersByRank();
	    	
	        result.append(team.getName()).append(", ").append(team.getTeamRank()).append("\n");
	        
        	for (TeamMember teammember : team.getTeamMembers()) {
        		result.append("\t").append("Name: ").append(teammember.getMemberName()).append(", Rank: ").append(teammember.getMemberRank()).append(", ID: ").append(teammember.getMemberID()).append("\n");
        	}
	    
	    }
	    return result.toString();
	}
	
	public void teamGenerator() {
		
		Random nameSeed = new Random(random.nextInt());
		
		int numberOfTeams = random.nextInt(3) + 3;
		
		for (int i = 0; i < numberOfTeams; i++) {
			int membersAmount = random.nextInt(15) + 1;
			
			//generate a seed for the team names
			//generate a see
			
			String teamName = POSSIBLE_TEAMS[nameSeed.nextInt(10)];
			
			Team team = new Team(teamName, membersAmount, leagueList);
			
			for (int j = 0; j < membersAmount; j++) {
				
				String memberName = POSSIBLE_NAMES[nameSeed.nextInt(20)];
				
				int memberRank = random.nextInt(10) + 1;
				
				TeamMember member = new TeamMember(memberName, memberRank, team, this);
			}
		}
	}
	
}
