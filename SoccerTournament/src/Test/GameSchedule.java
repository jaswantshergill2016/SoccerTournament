package Test;

public class GameSchedule {
    public static void scheduleGames(int nmb) {
        int days = (nmb % 2 == 0) ? nmb -1 : nmb; 
        //for (int i=0; i<days; i++) {
            //System.out.println("\tDay " + (i+1) + ":");
            for (int j=0; j<nmb/2; j++) {
                int t1 = (j) % nmb + 1;
                int t2 = ((nmb - j -1) ) % nmb + 1;
                System.out.println("\t\tTeam " + t1 + " v.s Team " + t2);
            }
       // }
    }
    public static void main(String[] args) {
        //for (int i=1; i<12; i++) {
            //System.out.println("Schedule for " + i + " teams:");
            GameSchedule.scheduleGames(11);
        //}
    }
}