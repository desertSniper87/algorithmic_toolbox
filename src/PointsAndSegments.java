import java.util.*;

public class PointsAndSegments {
    static final int OPEN = -1;
    static final int CLOSE = 1;
    static final int POINT = 0;

    private static String getPointDescKey(int key) {
        switch (key) {
            case OPEN:
                return "OPEN";
            case CLOSE:
                return "CLOSE";
            case POINT:
                return "POINT";
        }

        return "UNKNOWN";
    }


    /*private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + " -> " + end;
        }
    }*/

    private static class Point {
        int coord, descKey;

        Point(int coord, int desc) {
            this.coord = coord;
            this.descKey = desc;
        }

        @Override
        public String toString() {
            return getPointDescKey(descKey) + " : " + coord;
        }
    }



    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        int numberOfSegments = starts.length;
        HashMap<Integer, Integer> initialIndex = new HashMap<>();
//        Segment[] segments = new Segment[numberOfSegments];


        List<Point> masterPointList = new ArrayList<>();


        for (int i = 0; i < numberOfSegments; i++) {
            masterPointList.add(new Point(starts[i], OPEN));
            masterPointList.add(new Point(ends[i], CLOSE));
        }

        for (int i = 0; i < points.length; i++) {
            masterPointList.add(new Point(points[i], POINT));
            initialIndex.put(points[i], i);
        }

        masterPointList.sort(Comparator.comparingInt((Point s) -> s.coord));

//        System.out.println("masterList = " + masterPointList);

        int masterCount = 0;

        for (Point p: masterPointList) {
            switch (getPointDescKey(p.descKey)) {
                case "OPEN":
//                    System.out.println("OPEN");
                    masterCount++;
                    break;
                case "CLOSE":
//                    System.out.println("CLOSE");
                    masterCount--;
                    break;
                case "POINT":
//                    System.out.println("p = " + p);
//                    System.out.println("POINT");
                    cnt[initialIndex.get(p.coord)] = masterCount;
                    break;
            }

        }


        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        // Input 2 3 0 5 7 10 1 6 11
        // Input 1 3 -10 10 -100 100 0
        // Input 3 2 0 5 -3 2 7 10 1 6
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

