package com.noor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringApplicationConfiguration(classes= {com.noor.ScoreCard.class})
@SpringBootTest
@ActiveProfiles("test")
public class BowlingScoreApplicationTests {

    @Autowired
    @Qualifier("scoreCard")
    ScoreCard scoreCard;
   
        @Test
	public void printScore() {

	    //ScoreCard scoreCard = new ScoreCard();
	    //scoreCard.init();
	    
	    FrameScore[] frameScores = scoreCard.getFrameScore();
	    frameScores[0].setPoints(9);
	    frameScores[1].setPoints(10);
	    frameScores[1].setScoreType(ScoreType.SPARE);
	    frameScores[2].setPoints(5);
	    frameScores[3].setPoints(7);
	    frameScores[4].setPoints(6);
	    frameScores[5].setPoints(10);
	    frameScores[5].setScoreType(ScoreType.STRIKE);
	    frameScores[6].setPoints(5);
	    frameScores[7].setPoints(3);
	    frameScores[8].setPoints(2);
	    frameScores[9].setPoints(9);
	    
	    scoreCard.printScore(frameScores);
	    
	    
	}

}
