package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> testVariables=new AList();
        testVariables.addLast(1000);
        testVariables.addLast(2000);
        testVariables.addLast(4000);
        testVariables.addLast(8000);
        testVariables.addLast(16000);
        testVariables.addLast(32000);
        testVariables.addLast(64000);
        testVariables.addLast(128000);
        AList<Double> timingsList=new AList();
        for (int index=0; index<testVariables.size(); index++){
            Stopwatch sw = new Stopwatch();
            AList list = new AList();
            for (int var=0; var< testVariables.get(index); var++){
                list.addLast(1);
            }
            double timing = sw.elapsedTime();
            timingsList.addLast(timing);
        }
        printTimingTable(testVariables, timingsList,testVariables);


    }
}
