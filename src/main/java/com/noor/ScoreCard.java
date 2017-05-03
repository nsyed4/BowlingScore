package com.noor;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class ScoreCard  {

    private String name;
    private FrameScore[] frameScore = new FrameScore[10];
    private int[][] rollScore = new int[10][2];

    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
   
    public void setName(String name) {
	this.name=name;
    }
    
    @Autowired
    public ScoreCard() {
	for(int i=0;i<frameScore.length;i++) {
	    frameScore[i] = new FrameScore();
	}
     }
    
    
    public FrameScore[] getFrameScore() {
	return frameScore;
    }
    
    private int rollIdx;
    private int frameIdx;
    public void score(int pins) {
	
	logger.info("Pins dropped "+pins);
	
	if(rollIdx==0) {
	    rollScore[frameIdx][0] = pins;
	    frameScore[frameIdx].setScoreType(ScoreType.NO_BONUS);
	    rollIdx++;
	    if(pins==10) {
		frameScore[frameIdx].setPoints(10);
		frameScore[frameIdx].setScoreType(ScoreType.STRIKE);
		frameIdx++;
		rollIdx=0;
		
	    }
	    
	}else if(rollIdx==1) {
	    rollScore[frameIdx][1] = pins;
	    rollIdx++;
	    if(rollIdx==2) {
		
		if(pins==10)
		    frameScore[frameIdx].setScoreType(ScoreType.SPARE);
		else
		    frameScore[frameIdx].setScoreType(ScoreType.NO_BONUS);
		frameScore[frameIdx].setPoints(rollScore[frameIdx][0]+rollScore[frameIdx][1]);
		frameIdx++;
		rollIdx=0;
	    }
	}
	
	
    }
    
    
    public void printScore(FrameScore[] frameScore) {
	StringBuilder sb = new StringBuilder();
	int totalScore = 0;
	for(int i = 0;i<frameScore.length;i++) {
	    FrameScore fs = frameScore[i];
	 
	    if(fs.getPoints()==10) {
		if(fs.getScoreType().equals(ScoreType.STRIKE)) {
		  
		    if(i<8) {
			FrameScore fs1=frameScore[i+2];
			fs.setPoints(fs1.getPoints()+fs.getPoints());
		    }
		    if(i<9) {
			FrameScore fs1=frameScore[i+1];
			fs.setPoints(fs1.getPoints()+fs.getPoints());
		    }
		   
		   
		    
		}else if(fs.getScoreType().equals(ScoreType.SPARE)) {
		    if(i<9) {
			FrameScore fs1=frameScore[i+1];
			fs.setPoints(fs1.getPoints()+fs.getPoints());
		    }
		}
	    }
	    sb.append(fs.getPoints() + " "+ fs.getScoreType()+",");
	    totalScore=totalScore+fs.getPoints();
	    sb.append(" ");
	}
	logger.info(this.name+" scored "+sb.toString());
	logger.info("Total Score: "+totalScore);
    }
    
}
