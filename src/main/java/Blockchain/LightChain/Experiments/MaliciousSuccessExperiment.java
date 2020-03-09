package Blockchain.LightChain.Experiments;

import Blockchain.LightChain.Transaction;
import Simulator.SkipSimParameters;
import SkipGraph.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This static class is used to measure the chance of a malicious success in case of validator acquisition.
 * When a malicious transaction owner achieves to find SignatureThreshold (T) many malicious validators, we
 * define this as malicious success.
 */
public class MaliciousSuccessExperiment {

    // Time -> (Malicious node -> malicious success #)
    private static Map<Integer, Map<Integer, Integer>> successMap = new HashMap<>();
    // A list of malicious success chances for each time slot.
    private static List<Double> successChances = new LinkedList<>();
    // Number of times a malicious owner has generated a transaction/acquired
    // validators for this time slot.
    private static int acquisitions = 0;


    /**
     * Inform the experiment that a transaction has acquired validators.
     * This method should be called when a transaction acquires its validators.
     * @param owner the owner of the transaction.
     * @param tx the transaction itself.
     * @param time current time slot.
     */
    public static void informAcquisition(Node owner, Transaction tx, int time) {
        // We only care about transactions generated by a malicious owner.
        if(!owner.isMalicious()) return;
        acquisitions++;
        // Get the number of malicious validators the transaction has.
        int maliciousValidators = (int)tx.getValidators().stream()
                .filter(x -> x.isMalicious())
                .count();

        if(!successMap.containsKey(time)) {
            successMap.put(time, new HashMap<>());
        }

        if(!successMap.get(time).containsKey(owner.getIndex())) {
            successMap.get(time).put(owner.getIndex(), 0);
        }

        // If there are enough malicious validators, malicious owner has successfully performed an attack.
        if(maliciousValidators >= SkipSimParameters.getSignatureThreshold())
            successMap.get(time).put(owner.getIndex(), successMap.get(time).get(owner.getIndex()) + 1);
    }

    /**
     * Calculates and reports the result at the end of time slot. This method should be called at the
     * end of each time slot.
     * @param time current time slot.
     */
    public static void calculateResults(int time) {
        if(!successMap.containsKey(time)) {
            System.out.println("Malicious Success Experiment: For t=" + time + " there were no malicious nodes chosen to generate a transaction.");
        } else {
            // Malicious node -> malicious success amount
            Map<Integer, Integer> successMapForTime = successMap.get(time);
            double avgSuccessForTime = (double) successMapForTime.values().stream()
                    .mapToInt(x -> x)
                    .sum()
                    / acquisitions;
            System.out.println("Malicious Success Experiment: For t=" + time + " the avg malicious success chance (over the malicious nodes) was " + avgSuccessForTime);
            successChances.add(avgSuccessForTime);
        }
        double overallSuccessChance = successChances.stream().mapToDouble(x -> x).average().orElse(0);
        System.out.println("Malicious Success Experiment: Avg. malicious success chance over time is " + overallSuccessChance);
        acquisitions = 0;
    }

    public static void reset() {
        successMap.clear();
        successChances.clear();
        acquisitions = 0;
    }
}
