import java.util.*;

public class CoveringSegments {

    private static List<Integer> optimalPoints(Segment[] segments) {
        List<Integer> points = new ArrayList<>();

        Arrays.sort(segments, Comparator.comparingInt((Segment s) -> s.end));
        int point = segments[0].end;
        points.add(point);

        for (Segment segment : segments) {
            if (point < segment.start || segment.end < point) {
                point = segment.end;
                points.add(point);
            }
        }

        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + " : " + end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());

        // Input 3 1 3 2 5 3 6
        // Output 1 3
        // Input 4 4 7 1 3 2 5 5 6
        // Output


        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
