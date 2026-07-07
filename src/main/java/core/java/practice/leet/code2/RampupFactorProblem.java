package core.java.practice.leet.code2;

import java.sql.BatchUpdateException;

/*
* Problem 2: The "Ramp-Up Factory" Problem (Batch Processing)
The Scenario
A factory belt processes items.
'W' represents a Worker joining the assembly line.
'I' represents an Item that needs to be processed.
When a block of consecutive items ('I') arrives, every worker currently on the line must spend 1 minute inspecting each item in that block. Furthermore, setting up the batch takes a flat 2 minutes of setup time per worker, regardless of how many items are in that specific block.
Your Task
Given a string s of 'W' and 'I', calculate the total man-minutes spent by workers inspecting items.
The formula for hitting an item block is:
Minutes=(Worker Count×Item Block Size)+(Worker Count×2)
* */
public class RampupFactorProblem {
    private static final int BATCH_SPEND = 2;
    public int totalWorkingMinute(String beltProcessing){// WWIIIWIII
        int workerCount = 0;
        int totalMinute = 0;
        int itemCount =  0;
        int len = beltProcessing.length();
        for(int i = 0; i < len ; i++) {
            if (beltProcessing.charAt(i) == 'W') {
                workerCount++;
            } else{
                while (i < len && beltProcessing.charAt(i) == 'I') {
                    itemCount++;
                    i++;
                }
            int itemCountMinute = (workerCount * itemCount);
            int batchCountMinute = (workerCount * BATCH_SPEND);
            totalMinute += (itemCountMinute + batchCountMinute);
            itemCount = 0;
            i--;
        }
        }

        return totalMinute;
    }
}
