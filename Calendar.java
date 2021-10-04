package vovka.algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
public class Calendar {

    public static void mergeIntervals(Interval arr[])
    {
        if (arr.length <= 0)
            return;

        Stack<Interval> stack=new Stack<>();

        Arrays.sort(arr,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2)
            {
                return i1.start-i2.start;
            }
        });

        stack.push(arr[0]);

        for (int i = 1 ; i < arr.length; i++)
        {

            Interval top = stack.peek();

            if (top.end < arr[i].start)
                stack.push(arr[i]);

            else if (top.end < arr[i].end)
            {
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);
            }
        }

        int timeBlock = 30;
        int timeStart = 540;

        String startMinutes;
        String endMinutes;

        String text = "\nThe team will be busy:\n";
        System.out.print("The Merged Intervals are: ");

        while (!stack.isEmpty()) {

            Interval t = stack.pop();
            System.out.print("["+t.start+","+t.end+"] ");

            int start = timeStart + t.start * timeBlock;
            int end = timeStart + t.end * timeBlock;

            if (start % 60 == 0){
                startMinutes = "00";
            }else {
                startMinutes = "30";
            }

            if (end % 60 == 0){
                endMinutes = "00";
            }else {
                endMinutes = "30";
            }

            text += "\n" + start/60 + ":" + startMinutes + " - " + end/60 + ":" + endMinutes;

        }

        System.out.println(text);
    }

    public static void main(String args[]) {
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        mergeIntervals(arr);
    }
}

class Interval
{
    int start,end;
    Interval(int start, int end)
    {
        this.start=start;
        this.end=end;
    }
}



