//Link : https://leetcode.com/problems/move-pieces-to-obtain-a-string/

public class MovePicesToObtainAString {
    public static void main(String[] args) {
        String start = "_L__R__R_";
        String target = "L_____RR";

        MovePicesToObtainAString obj = new MovePicesToObtainAString();
        System.out.println(obj.canChange(start, target));
    }

    public boolean canChange(String start, String target) {
        int stInd = 0, tInd = 0;

        while (stInd < start.length() && tInd < target.length()) {
            if ((start.charAt(stInd) == 'L' && target.charAt(tInd) == 'R') || (start.charAt(stInd) == 'R' && target.charAt(tInd) == 'L')) {
                return false;
            }

            if (start.charAt(stInd) == 'L' && target.charAt(tInd) == 'L') {
                if (stInd < tInd) {
                    return false;
                }
                stInd++;
                tInd++;
                continue;
            }

            if (start.charAt(stInd) == 'R' && target.charAt(tInd) == 'R') {
                if (stInd > tInd) {
                    return false;
                }
                stInd++;
                tInd++;
                continue;
            }

            if (start.charAt(stInd) == '_') {
                stInd++;
            }
            if (target.charAt(tInd) == '_') {
                tInd++;
            }
        }

        while(stInd < start.length()) {
            if(start.charAt(stInd) != '_') {
                return false;
            }
            stInd++;
        }
        while(tInd < target.length()) {
            if(target.charAt(tInd) != '_') {
                return false;
            }
            tInd++;
        }
        return true;
    }
}
