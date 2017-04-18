package etb.score;


public class Score {
	boolean win;
	int scores;
	
	public Score(boolean win, int scores){
		this.win = win;
		this.scores = scores;
	}
	
	public int addScore(){
		if (win==true){
			scores++;
		}
		return scores;
	}
	
	public int subtractScore(){
	if (win==false){
		scores--;
		}
	return scores;
	}
}

