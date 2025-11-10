import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        String input = br.readLine();
        boolean inTag = false;

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if(c == '<') {
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                inTag = true;
                sb.append(c);
            }else if(c == '>') {
                inTag = false;
                sb.append(c);
            }else if(inTag) {
                sb.append(c);
            }else {
                if(c == ' ') {
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                }else {
                    stack.push(c);
                }
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());

        System.out.println(sb);
    }
}