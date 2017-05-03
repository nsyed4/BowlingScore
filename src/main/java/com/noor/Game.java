package com.noor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Game {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ScoreCard scoreCard;
    private static final int TOTAL_PINS=10;
    
    public int firstRoll() {
	return (int) Math.floor(Math.random() * 11);
    }
    
    public int secondRoll(int pins) {
	return (int) Math.floor(Math.random() * (pins+1));
    }

    public void play() {

	
	scoreCard.setName("Noor");
	
	for(int i=0;i<10;i++) {
	    int pins = this.firstRoll();
	    scoreCard.score(pins);
	    if(pins!=10) {
		pins = TOTAL_PINS-pins;
		pins = this.secondRoll(pins);
		scoreCard.score(pins);
	    }
	    
	}
	
	 FrameScore[] frameScore = scoreCard.getFrameScore();
	 scoreCard.printScore(frameScore);
    }
}
