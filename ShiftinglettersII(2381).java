import java.util.Arrays;

public class ShifingLetters {
    public static String shiftingLetters(String s, int[][] shifts) {
        char arr[]=s.toCharArray();
        int[] map=new int[arr.length+1];
        for(int[] num:shifts){
            if(num[2]==0){
                map[num[0]]-=1;
                map[num[1]+1]+=1;
            }else{
                map[num[0]]+=1;
                map[num[1]+1]-=1;
            }
        }
        System.out.println(Arrays.toString(map));
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=map[i];
            int n=((arr[i]-'a')+sum)%26;
            if(n<0) n+=26;
            arr[i]=(char)(n+'a');
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(shiftingLetters("abc", new int[][] { { 0, 1, 0 }, { 1, 2, 1 }, { 0, 2, 1 } }));
    }
}