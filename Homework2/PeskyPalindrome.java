    import java.util.*;

        public class Main {

            public static void main(String args[]) {

                int x;

                Scanner sc = new Scanner(System.in);

                while(sc.hasNext()) {

                    String currentString = sc.next();

                    List<String> allSubstrings = generateSubstrings(currentString);

                    int uniquePalindromes = findUniquePalindromes(allSubstrings);

                    System.out.println("The string " + "'" + currentString + "'" + " contains " + uniquePalindromes + " palindromes.");

                }

            }

            public static List<String> generateSubstrings(String s) {

                List<String> allSubstrings = new ArrayList<String>();

                for(int i = 0; i < s.length(); i++) {

                    for(int j = i + 1; j <= s.length(); j++) {

                        String currentSubstring = s.substring(i, j);

                        if(!allSubstrings.contains(currentSubstring)) {

                            allSubstrings.add(currentSubstring);

                        }

                    }

                }

                return allSubstrings;

            }

            public static int findUniquePalindromes(List<String> allSubstrings) {

                int totalUniquePalindromes = 0;

                for(String s : allSubstrings) {

                    int left = 0;
                    int right = s.length() - 1;

                    boolean isPalindrome = true;

                    while(left < right) {

                        if(s.charAt(left) != s.charAt(right)) {

                            isPalindrome = false;
                            break;

                        }

                        left++;
                        right--;

                    }

                    if(isPalindrome) {

                        totalUniquePalindromes++;

                    }

                }

                return totalUniquePalindromes;

            }





        }

