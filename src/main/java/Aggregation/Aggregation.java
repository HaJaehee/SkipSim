package Aggregation;

import Simulator.SkipSimParameters;
import SkipGraph.Node;
import SkipGraph.SkipGraphOperations;

import java.util.ArrayList;

/**
 * Created by Yahya on 1/11/2017.
 */
public class Aggregation
    {
        protected SkipGraphOperations sgo;
        protected int initiator;
        protected final double E = 8;
        protected final double U = 1;
        private static double[] energyCosts = new double[SkipSimParameters.getTopologyNumbers()];
        private static double[] latency = new double[SkipSimParameters.getTopologyNumbers()];
        private static double[] childAvergae = new double[SkipSimParameters.getTopologyNumbers()];
        private static double[] parentNumber = new double[SkipSimParameters.getTopologyNumbers()];
        protected int findRoot()
            {
                int root = -1;
                for(int i = 0; i < SkipSimParameters.getSystemCapacity(); i++)
                    {
                        if(((Node) sgo.getTG().mNodeSet.getNode(i)).getParent() == i)
                            {
                                System.out.println("Error: Node " + i + " is its parent");
                                System.out.println(((Node) sgo.getTG().mNodeSet.getNode(i)).getChildren());
                                System.exit(0);
                            }
                        if(((Node) sgo.getTG().mNodeSet.getNode(i)).getParent() == -1)
                            {
                                if(((Node) sgo.getTG().mNodeSet.getNode(i)).getChildren().isEmpty())
                                    {
                                        System.out.println("Error: Node " + i + " has no parent and no child " + ((Node) sgo.getTG().mNodeSet.getNode(i)).getNameID());
                                        //System.exit(0);
                                    }
//
//
                                else if(root < 0)
                                    root = i;
                                else if(root > 0)
                                    {
                                        System.out.println("Error: Two roots in the Simulator.system");
                                        //System.exit(0);
                                    }
                            }
                    }

                System.out.println("Find root is done, root " + root);
                return root;
            }

//        protected int commonPrefixLength(int i, int j)
//            {
//                String s1 = Integer.toBinaryString(i);
//                String s2 = Integer.toBinaryString(j);
//                while(s1.length() < Simulator.system.getNameIDLength())
//                    s1 = "0" + s1;
//                while(s2.length() < Simulator.system.getNameIDLength())
//                    s2 = "0" + s2;
//                int k = 0;
//                while(s1.charAt(k) == s2.charAt(k))
//                    {
//                        k++;
//                        if(k >= s1.length() || k >= s2.length())
//                            break;
//                    }
//                return k;
//            }

        protected int commonBits(String s1, String s2)
            {
                int k = 0;
                while(s1.charAt(k) == s2.charAt(k))
                    {
                        k++;
                        if(k >= s1.length() || k >= s2.length())
                            break;
                    }
                return k;
            }

        protected void energyEvaluation(String algName)
            {
                double totalEnergy = 0;
                double childAve = 0;
                ArrayList<Integer> parents = new ArrayList<>();
                for(int i = 0; i < SkipSimParameters.getSystemCapacity(); i++)
                    {
                        if(!parents.contains(i)
                                && ((Node) sgo.getTG().mNodeSet.getNode(i)).getChildren().size() > 0)
                            parents.add(i);
                        childAve += ((Node) sgo.getTG().mNodeSet.getNode(i)).getChildren().size();
                        totalEnergy += (((Node) sgo.getTG().mNodeSet.getNode(i)).getChildren().size() * (2 * E + (U - 1)));
                    }
                energyCosts[SkipSimParameters.getCurrentTopologyIndex() - 1]     = totalEnergy/parents.size();
                parentNumber[SkipSimParameters.getCurrentTopologyIndex() - 1]    = parents.size();
                childAvergae[SkipSimParameters.getCurrentTopologyIndex() - 1]    = childAve / parents.size();
                if(SkipSimParameters.getCurrentTopologyIndex() == SkipSimParameters.getTopologyNumbers())
                    {
                        totalEnergy = 0;
                        childAve = 0;
                        double totalParent = 0;
                        for(int i = 0; i < SkipSimParameters.getTopologyNumbers(); i++)
                            {
                                totalEnergy  += energyCosts[i];
                                childAve     += childAvergae[i];
                                totalParent  += parentNumber[i];
                            }
                        System.out.println(algName + " average energy cost on a parent " + totalEnergy/ SkipSimParameters.getTopologyNumbers());
                        System.out.println(algName + " average number of child " + childAve/ SkipSimParameters.getTopologyNumbers());
                        System.out.println(algName + " average number of parents " +totalParent/ SkipSimParameters.getTopologyNumbers());
                    }
            }
        protected void latencyEvaluation(String algName)
            {
                int root = findRoot();
                double totalLatency = 0;
                for(int i = 0; i < SkipSimParameters.getSystemCapacity(); i++)
                    {
                        int parent = ((Node) sgo.getTG().mNodeSet.getNode(i)).getParent();
                        if(parent == -1 && i != root)
                            {
                                System.out.println("Error: SkipGraph.Node " + i + " exists with parent -1 and it is not root!");
                                System.exit(0);
                            }
                        else if(parent == -1)
                            {
                                continue;
                            }
                        double latency = 0;
                        //System.out.println("Finding maximum latency");
                        int child = i;
                        while(parent != -1)
                            {
                                 //System.out.println(parent);
                                 latency += ((Node) sgo.getTG().mNodeSet.getNode(child)).getCoordinate().distance(((Node) sgo.getTG().mNodeSet.getNode(parent)).getCoordinate());
                                 int ancestor = ((Node) sgo.getTG().mNodeSet.getNode(parent)).getParent();
                                 child = parent;
                                 parent = ancestor;
                            }
                        totalLatency = Math.max(latency, totalLatency);
                    }
                latency[SkipSimParameters.getCurrentTopologyIndex() - 1] = totalLatency/ SkipSimParameters.getSystemCapacity();
                if(SkipSimParameters.getCurrentTopologyIndex() == SkipSimParameters.getTopologyNumbers())
                    {
                        totalLatency = 0;
                        for(int i = 0; i < SkipSimParameters.getTopologyNumbers(); i++)
                            {
                                totalLatency += latency[i];
                            }
                        System.out.println(algName + "Average maximum latency " + totalLatency/ SkipSimParameters.getTopologyNumbers());
                    }

            }
    }
