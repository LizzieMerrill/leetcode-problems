import java.lang.Math;
import java.util.Map;
import java.util.HashMap;


class Solution {
    int numOfBooms;
    double tempDist;

    public double calculateDistance(int[] point1, int[] point2){
        int x1 = point1[0];
        int x2 = point2[0];
        int y1 = point1[1];
        int y2 = point2[1];
        return Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
    }
    
    public int numberOfBoomerangs(int[][] points) {
        for(int i = 0; i < points.length; i++){
            Map<Double, Integer> distMapFromI = new HashMap<>();
            for(int j = 0; j < points.length; j++){
                int numOfDistances = 0;
                tempDist = calculateDistance(points[i], points[j]);
                if(distMapFromI.containsKey(tempDist)){
                    distMapFromI.put(tempDist, distMapFromI.get(tempDist)+1);
                }
                else{
                    distMapFromI.put(tempDist, 1);
                }
            }
            for(int distCount : distMapFromI.values()){
                numOfBooms += (distCount)*(distCount-1);
            }
        }
        return numOfBooms;
    }
}
