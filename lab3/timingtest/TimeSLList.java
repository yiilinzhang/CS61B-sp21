package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> testVariables=new AList();
        AList<Integer> opsCount = new AList();
        for (int var = 1000; var<=128000; var=var*2){
            testVariables.addLast(var);
            opsCount.addLast(10000);
        }
        AList<Double> timingsList=new AList();
        for (int index=0; index<testVariables.size(); index++){
            SLList<Integer> list = new SLList();
            for (int var=0; var< testVariables.get(index); var++){
                list.addLast(1);
            }
            int currOps=opsCount.get(index);
            Stopwatch sw = new Stopwatch();
            while(currOps>=0){
                list.getLast();
                currOps--;
            }
            double timing = sw.elapsedTime();
            timingsList.addLast(timing);
        }
        printTimingTable(testVariables, timingsList,opsCount);
    }

}
