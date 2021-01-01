import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Request {
    public Request(int arrival_time, int process_time) {
        this.arrival_time = arrival_time;
        this.process_time = process_time;
    }

    public int arrival_time;
    public int process_time;
}

class Response {
    public Response(boolean dropped, int start_time) {
        this.dropped = dropped;
        this.start_time = start_time;
    }

    public boolean dropped;
    public int start_time;
}

class Buffer {
    private final int size_;
    private ArrayList<Integer> finish_time_;

    public Buffer(int size) {
        this.size_ = size;
        this.finish_time_ = new ArrayList<>();
    }

    // Input 0 0 1 1
    // Input 1 2 0 1 0 1
    // Input 1 2 0 1 1 1
    // Input 1 1 1 1
    // Input 1 2 0 0 0 0 0 0
    // Input 1 2 0 0 0 1 0 0
    // Input 2 2 0 1 0 1
    // Input 3 3 0 1 0 1 0 1
    // Input 2 3 0 2 1 4 5 3
    // Input 3 6 0 2 1 2 2 2 3 2 4 2 5 2
    // Input
    public Response Process(Request request) {
        // System.out.println();
        // System.out.println("*** Processing new request *** ");
        // System.out.println();

        // System.out.println("request.arrival_time = " + request.arrival_time);
        // System.out.println("request.process_time = " + request.process_time);

        int last_finish_time = this.finish_time_.isEmpty() ? 0 :
                this.finish_time_.get(this.finish_time_.size()-1);

        int currently_processing_jobs = (int) this.finish_time_.stream().filter(
                time -> time > request.arrival_time
        ).count();
//      System.out.println("this.finish_time_ = " + this.finish_time_);

        if (last_finish_time <= request.arrival_time) {
            this.finish_time_.add(request.arrival_time + request.process_time);
            return new Response(false, request.arrival_time);
        } else if (currently_processing_jobs < this.size_) {
            this.finish_time_.add(last_finish_time + request.process_time);
            return new Response(false, last_finish_time);
        } else {
            // System.out.println("Dropping request");
            return new Response(true, -1);
        }

    }


}

class Requests {
    private static ArrayList<Request> ReadQueries(Scanner scanner) throws IOException {
        int requests_count = scanner.nextInt();
        ArrayList<Request> requests = new ArrayList<Request>();
        for (int i = 0; i < requests_count; ++i) {
            int arrival_time = scanner.nextInt();
            int process_time = scanner.nextInt();
            requests.add(new Request(arrival_time, process_time));
        }
        return requests;
    }

    private static ArrayList<Response> ProcessRequests(ArrayList<Request> requests, Buffer buffer) {
        ArrayList<Response> responses = new ArrayList<>();
        for (Request request : requests) {
            responses.add(buffer.Process(request));
        }
        return responses;
    }

    private static void PrintResponses(ArrayList<Response> responses) {
        for (Response response : responses) {
            if (response.dropped) {
                System.out.println(-1);
            } else {
                System.out.println(response.start_time);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int buffer_max_size = scanner.nextInt();
        Buffer buffer = new Buffer(buffer_max_size);

        ArrayList<Request> requests = ReadQueries(scanner);
        ArrayList<Response> responses = ProcessRequests(requests, buffer);
        // System.out.println("output");
        PrintResponses(responses);
    }
}
