package Replication;

import Simulator.SkipSimParameters;
import SkipGraph.Node;
import SkipGraph.SkipGraphOperations;

public class Rep_Alg09_PrivateRepOnNeighbors extends Replication
{

    private void ReplicateOnNeighborsGenerator(int dataOwnerIndex)
    {


        int index = 0;
        while (index < SkipSimParameters.getSystemCapacity() && ((Node) sgo.getTG().mNodeSet.getNode(index)).neighborNumber() < SkipSimParameters.getReplicationDegree())
            index++;

        if (index >= SkipSimParameters.getSystemCapacity())
        {
            System.out.println("Error in Rep_Alg03_RepOnNeighbors.java: there is no SkipGraph.Node in the Simulator.system with " + SkipSimParameters.getReplicationDegree() + " neighbors" + "\n Change MNR please");
            System.exit(0);
        }

        for (int i = 0, rep = 0; i < SkipSimParameters.getLookupTableSize() && rep <= SkipSimParameters.getReplicationDegree(); i++)
            for (int j = 0; j < 2; j++)
            {
                if (sgo.getTG().mNodeSet.getNode(index).getLookup(i, j) != -1 && !((Node) sgo.getTG().mNodeSet.getNode(index)).isReplica(dataOwnerIndex))
                {
                    boolean replicationResult = ((Node) sgo.getTG().mNodeSet.getNode(sgo.getTG().mNodeSet.getNode(index).getLookup(i, j))).setAsReplica(dataOwnerIndex);
                    if (replicationResult)
                    {
                        rep++;
                    }
                }
            }


        sgo.getTG().getNodeSet().setCorrespondingReplica(dataOwnerIndex);

    }


    @Override
    public void Algorithm(SkipGraphOperations inputSgo, int dataOwnerIndex)
    {
        sgo = inputSgo;
        reset();
        resetRep();
        ReplicateOnNeighborsGenerator(dataOwnerIndex);
    }
}