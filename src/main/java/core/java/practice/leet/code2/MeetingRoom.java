package core.java.practice.leet.code2;

import java.util.ArrayList;

public class MeetingRoom {

    public ArrayList<Point> checkMeetingOccupied(int[][] timings){// [1,3],[2,8],[3,7],[9,12],[13,19]
        Point[] slots =  createSlot(timings);
        ArrayList<Point> result = new ArrayList<>();
        int startTime = -1, endTime =-1;
        for(int i = 0 ; i < slots.length;i++) {
            if (i == slots.length-1) result.add(new Point(startTime, endTime == -1 ? slots[i].getY() : endTime));
            else {
                if (startTime == -1) startTime = slots[i].getX();
                while (i < slots.length && isOverlap(slots, i)) {
                    endTime = Math.max(endTime == -1 ? slots[i].getY() : endTime, slots[i + 1].getY());
                    i++;
                }
                result.add(new Point(startTime, endTime == -1 ? slots[i].getY() : endTime));
                startTime = -1;
                endTime = -1;

            }
        }
        return result;
    }

    private static boolean isOverlap(Point[] slots, int i) {
        return slots[i].getY() >= slots[i + 1].getX();
    }

    private static Point[] createSlot(int[][] timings) {
        Point[] points = new Point[timings.length];
        for(int i = 0; i< timings.length ; i++){
            points[i] = new Point(timings[i][0], timings[i][1]);
        }
        return points;
    }

}

class Point{
    private  int x;
    private int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
