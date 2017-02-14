
/**
 * Created by kdn251 on 1/30/17.
 */

import java.util.*;

public class Main {

    public static void main(String args[]) {

        HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();

        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int caseCount = 1;

        for(int i = 0; i < testCases * 10; i++) {

            String website = sc.next();
            int relevance = sc.nextInt();

            if(i % 10 == 0 && i != 0) {

                List<String> allCandidates = map.get(max);
                System.out.println("Case #" + caseCount + ":");
                caseCount++;

                for(String s : allCandidates) {

                    System.out.println(s);

                }

                map = new HashMap<Integer, List<String>>();
                max = Integer.MIN_VALUE;

            }

            if(map.containsKey(relevance)) {

                map.get(relevance).add(website);

            }

            if(!map.containsKey(relevance)) {

                List<String> list = new ArrayList<String>();
                map.put(relevance, list);
                map.get(relevance).add(website);

            }

            if(relevance > max) {

                max = relevance;

            }

        }

        System.out.println("Case #" + caseCount + ":");

        for(String s : map.get(max)) {

            System.out.println(s);

        }

    }

}
