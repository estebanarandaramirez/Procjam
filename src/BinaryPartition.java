import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;
import java.util.Random;

public class BinaryPartition {
    int numPartitions;
    char[][] map;

    private char DEFAULT = '-';
    private char WALL = '|';
    private char DOOR = 'O';

    Random seed;

    public BinaryPartition() {
        this.numPartitions = 5;
        this.map = new char[10][20];
        for(int i =0; i < this.map.length; i++) {
            Arrays.fill(this.map[i], DEFAULT);
        }
    }

    public void printMap() {
        for(int i = 0; i < this.map.length; i++) {
            System.out.println(Arrays.toString(this.map[i]));
        }
    }

    public void partition() {
        this.seed = new Random();
        int height = this.map.length;
        int width = this.map[0].length;
//        for(int i = 0; i < numPartitions; i++) {
            int rand =  (seed.nextInt(width-2)+2);

            for(int j = 0; j < height; j++) {
                for(int k = 0; k < width; k++) {
                    if(k < rand) {
                        this.map[j][k] = '1';
                    } else if (k == rand) {
                        this.map[j][k] = WALL;
                    } else {
                        this.map[j][k] = '2';
                    }
                }
                System.out.println(Arrays.toString(this.map[j]));
            }

    }

    public static void main(String[] args) {
        BinaryPartition map = new BinaryPartition();
        map.printMap();
        System.out.println();
        map.partition();
    }
}
