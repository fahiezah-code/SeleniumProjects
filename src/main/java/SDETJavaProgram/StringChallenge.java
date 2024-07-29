package SDETJavaProgram;

import java.util.HashSet;

public class StringChallenge {

    public static void main(String[] args) {

        System.out.println(StringChallenge("Ar57se"));

    }

    public static String StringChallenge(String str){

        // check each chr is int >0 <9?
        // if int -> then check in set whether it contains
        // --> if yes_. return false
        // add into Set if not contains
        //if ch == ' ' check Set size > or < 3 return false
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            int ci = c - '0';
            System.out.print(ci+ " ");
            if(ci >=0 && ci<= 9){
                if(!hs.add(ci) ){
                    return "false";
                }
            }
        }
        System.out.println(hs.size());
        if(hs.size() != 3){
            return "false";
        }
        return "true";
    }
    //153
}
