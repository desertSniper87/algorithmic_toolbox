import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    // Input: []
    // Input: {}[]
    // Input: [()]
    // Input: (())
    // Input: {[]}()
    // Input: {
    // Input: foo(bar[i);
    // Input: [[]}]{}
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        return this.type == '(' && c == ')';
    }

    char type;
    int position;
}

class Brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                opening_brackets_stack.push(new Bracket(next, position));
            }

            if (next == ')' || next == ']' || next == '}') {
                if (opening_brackets_stack.empty()) {
                    System.out.println(position + 1);
                    return;
                }
                Bracket prev = opening_brackets_stack.peek();
                if (prev.Match(next)) {
                    opening_brackets_stack.pop();
                } else {
                    System.out.println(position + 1);
                    return;
                }
            }
        }

        if (opening_brackets_stack.empty()) {
            System.out.println("Success");
        } else {
            System.out.println(opening_brackets_stack.pop().position + 1);
        }
    }
}