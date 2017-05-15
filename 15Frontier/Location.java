public class Location implements Comparable<Location>{
    private int row, col;
    private int distanceToStart, distanceToGoal;//Used in the priority queues (bestFirst and aStar)
    private boolean aStar;//if true use aStar as comparable, else use bestFirst
    private Location previous;

    //Accessors
    public int getRow(){
	return row;
    }
    public int getCol(){
	return col;
    }
    public int getDistToStart(){
	return distanceToStart;;
    }
    public int getDistToGoal(){
	return distanceToGoal;
    }
    public boolean getAStar(){
	return aStar();
    }
    public Location getPrevious(){
	return previous;
    }
    
}
