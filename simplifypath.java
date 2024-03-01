//simplify path

import java.util.Stack;

public class StackB {
    public static void simpliftyPath(String input) {
        String array[]=input.split("/");

        //Divide the array based on '/'
        /* for(String s:array)
         *      System.out.println(s);
         */

        Stack stack=new Stack();

        for(int i=0;i<array.length;i++) {
            if(array[i].equals("..")) {
                stack.pop();
            }
            else if(array[i].equals(".") || array[i].equals("")) {
                continue;
            }
            else {
                stack.push(array[i]);
            }
        }

        Stack revStack=new Stack();
        while(stack.size()>0) {
            revStack.push(stack.pop());
        }
        if(revStack.isEmpty()) {
            System.out.println("/");
        }
        else {
            String output="/";
            while(revStack.size()>0) {
                if(revStack.size()!=1) {
                    output=output+revStack.pop()+"/";
                }
                else {
                    output=output+revStack.pop();
                }
            }
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        String ques1="/apnacollege/../";
        String ques2="/a/b/d/../q/./s/../";
        String ques3="/a/..";
        String ques4="/apnacollege/";
        simpliftyPath(ques1);
        simpliftyPath(ques2);
        simpliftyPath(ques3);
        simpliftyPath(ques4);
    }
}
