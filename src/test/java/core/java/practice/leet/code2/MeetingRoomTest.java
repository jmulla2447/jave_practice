package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomTest {

    @Test
    void checkMeetingOccupied() {
        MeetingRoom occupieRoom = new MeetingRoom();
        System.out.println(occupieRoom.checkMeetingOccupied(new int[][]{{1,3}, {2,8}, {3,7}, {9,12}, {13,19}}));
    }
}
