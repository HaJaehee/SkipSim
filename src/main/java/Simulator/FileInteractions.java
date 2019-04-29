package Simulator;

import DataTypes.Constants;

public class FileInteractions
{
//    public static void readConfigFile()
//    {
//        try
//        {
//            BufferedReader in = new BufferedReader(new FileReader("config.txt"));
//            String command = in.readLine();
//            while (!command.equals("End of configuration"))
//            {
//                if (command.startsWith("//"))
//                {
//                    command = in.readLine();
//                    continue;
//                }
//                else if (command.contains("SkipGraph.Nodes.number"))
//                {
//                    SkipSimParameters.setSystemCapacity(extractValueFromString(command));
//                }
//                else if (command.contains("replication.dynamic"))
//                {
//                    SkipSimParameters.setDynamicReplication(extractBooleanParameterFromString(command));
//                }
//                else if (command.contains("SkipGraph.Nodes.nameIDSize"))
//                {
//                    SkipSimParameters.setNameIDLength(extractValueFromString(command));
//                }
////                else if (command.contains("Blockchain.LightChain.nameIDSize"))
////                {
////                    SkipSimParameters.setBlockNameIDsize(extractValueFromString(command));
////                }
//                else if (command.contains("SkipGraph.Nodes.generation"))
//                {
//                    SkipSimParameters.setNodeGenerationStrategy(extractStringParameterFromString(command));
//                }
//                else if (command.contains("landmarks.number"))
//                {
//                    SkipSimParameters.setLandmarksNum(extractValueFromString(command));
//                }
//                else if (command.contains("landmarks.prefix"))
//                {
//                    SkipSimParameters.setPrefix(extractValueFromString(command));
//                }
//                else if (command.contains("domain"))
//                {
//                    SkipSimParameters.setDomainSize(extractValueFromString(command));
//                }
//                else if (command.contains("iterations"))
//                {
//                    SkipSimParameters.setTopologyNumbers(extractValueFromString(command));
//                }
//                else if (command.contains("SkipGraph.Nodes.numericalIDAssignment"))
//                {
//                    SkipSimParameters.setNumericalIDAssignment(extractStringParameterFromString(command));
//                }
//                else if (command.contains("SkipGraph.NameIDAssignment"))
//                {
//                    SkipSimParameters.setNameIDAssignment(extractStringParameterFromString(command));
//                }
//                else if (command.contains("replication.type"))
//                {
//                    SkipSimParameters.setReplicationType(extractStringParameterFromString(command));
//                }
//                else if (command.contains("replication.algorithm"))
//                {
//                    SkipSimParameters.setReplicationAlg(extractStringParameterFromString(command));
//                }
//                else if (command.contains("replication.boost"))
//                {
//                    SkipSimParameters.setAvailabilityBoost(extractBooleanParameterFromString(command));
//                }
//                else if (command.contains("replication.MNR"))
//                {
//                    SkipSimParameters.setReplicationDegree(extractValueFromString(command));
//                }
//                else if (command.contains("replication.NOR"))
//                {
//                    SkipSimParameters.setDataRequesterNumber(extractValueFromString(command));
//                }
//                else if (command.contains("search.nameID"))
//                {
//                    SkipSimParameters.setSearchByNameID(extractValueFromString(command));
//                }
//                else if (command.contains("search.numericalID"))
//                {
//                    SkipSimParameters.setSearchByNumericalID(extractValueFromString(command));
//                }
//                else if (command.contains("evaluation.NameIDAssignment.NameIDEvaluation"))
//                {
//                    SkipSimParameters.setID_Evaluation(true);
//                }
//                else if (command.contains("evaluation.repEvaluation"))
//                {
//                    SkipSimParameters.setReplicationLocalityAwarenessEvaluation(true);
//                }
//                else if (command.contains("evaluation.loadEvaluation"))
//                {
//                    SkipSimParameters.setReplicationLoadEvaluation(true);
//                }
//                else if (command.contains("Simulator.system.simulationTime"))
//                {
//                    SkipSimParameters.setLifeTime(extractValueFromString(command));
//                }
//                else if (command.contains("aggregation.type"))
//                {
//                    SkipSimParameters.setAggregationAlg(extractStringParameterFromString(command));
//                }
//                else if (command.contains("simulation.type"))
//                {
//                    SkipSimParameters.setSimulationType(extractStringParameterFromString(command));
//                }
//                else if (command.contains("delayBasedReplication.initialReplicationDegree"))
//                {
//                    SkipSimParameters.setInitialReplicationDegree(extractValueFromString(command));
//                }
//                else if (command.contains("delayBasedReplication.delayBound"))
//                {
//                    SkipSimParameters.setDelayBound(extractValueFromString(command));
//                }
//                else if (command.contains("ilaras.virtualNameIDSize"))
//                {
//                    SkipSimParameters.setIlarasVirtualSize(extractValueFromString(command));
//                }
//                else if (command.toLowerCase().contains(Constants.Churn.TYPE))
//                {
//                    SkipSimParameters.setChurnType(extractStringParameterFromString(command));
//                }
//                else if(command.toLowerCase().contains(Constants.Churn.Parameters.CHURN_STABILIZATION))
//                {
//                    SkipSimParameters.setChurnStabilizationAlgorithm(extractStringParameterFromString(command));
//                }
//                else if (command.toLowerCase().toLowerCase().contains(Constants.Churn.Parameters.CHURN_STABILIZATION_PARAMETER))
//                {
//                    SkipSimParameters.setChurnStabilizationParameter(extractDoubleFromString(command));
//                }
//                else if (command.toLowerCase().contains(Constants.Churn.Parameters.BUCKET_SIZE))
//                {
//                    SkipSimParameters.setBackupTableSize(extractValueFromString(command));
//                }
//                //TODO ready to detach
////                else if (command.toLowerCase().contains(Constants.Churn.Parameters.BUCKET_DISTRIBUTION_SD))
////                {
////                    system.setBucketSD(extractValueFromString(command));
////                }
////                else if (command.toLowerCase().contains(Constants.Churn.Parameters.BRUIJN_SCORE))
////                {
////                    system.setBruijnGraphScore(extractValueFromString(command));
////                }
//                else if (command.toLowerCase().contains(Constants.Churn.Parameters.PREDICTION_PARAMETER))
//                {
//                    SkipSimParameters.setPredictionParameter(extractValueFromString(command));
//                }
//                else if (command.toLowerCase().contains(Constants.Churn.PREDICTOR))
//                {
//                    SkipSimParameters.setAvailabilityPredictor(extractStringParameterFromString(command));
//                }
//                else if(command.toLowerCase().contains(Constants.Replication.FPTI))
//                {
//                    SkipSimParameters.setFPTI(extractValueFromString(command));
//                }
//                else if(command.toLowerCase().contains(Constants.Replication.DATA_OWNER_NUMBER))
//                {
//                    SkipSimParameters.setDataOwnerNumber(extractValueFromString(command));
//                }
//                else if(command.toLowerCase().contains(Constants.Replication.REPLICATION_TIME))
//                {
//                    SkipSimParameters.setReplicationTime(extractValueFromString(command));
//                }
//                command = in.readLine();
//            }
//
//
//            in.close();
//        }
//        catch (FileNotFoundException e)
//        {
//            // TODO Auto-generated catch Block
//            e.printStackTrace();
//        }
//        catch (NumberFormatException e)
//        {
//            // TODO Auto-generated catch Block
//            e.printStackTrace();
//        }
//        catch (IOException e)
//        {
//            // TODO Auto-generated catch Block
//            e.printStackTrace();
//        }
//    }

    private static int extractValueFromString(String str)
    {
        int startIndex = str.indexOf('$') + 1;
        String value = new String();
        for (int i = startIndex; i < str.length(); i++)
        {
            if (str.charAt(i) == '$')
            {
                break;
            }
            else
            {
                value = value + str.charAt(i);
            }

        }

        return Integer.parseInt(value);
    }

    private static Double extractDoubleFromString(String str)
    {
        int startIndex = str.indexOf('$') + 1;
        String value = new String();
        for (int i = startIndex; i < str.length(); i++)
        {
            if (str.charAt(i) == '$')
            {
                break;
            }
            else
            {
                value = value + str.charAt(i);
            }

        }

        return Double.parseDouble(value);
    }

    private static String extractStringParameterFromString(String str)
    {
        int startIndex = str.indexOf('$') + 1;
        String stringParameter = new String();
        for (int i = startIndex; i < str.length(); i++)
        {
            if (str.charAt(i) == '$')
            {
                break;
            }
            else
            {
                stringParameter = stringParameter + str.charAt(i);
            }

        }

        return stringParameter;
    }

    private static boolean extractBooleanParameterFromString(String str)
    {
        int startIndex = str.indexOf('$') + 1;
        String stringParameter = new String();
        for (int i = startIndex; i < str.length(); i++)
        {
            if (str.charAt(i) == '$')
            {
                break;
            }
            else
            {
                stringParameter = stringParameter + str.charAt(i);
            }

        }
        if (stringParameter.toLowerCase().contains("yes"))
        {
            return true;
        }
        return false;
    }

    /**
     * Prints out the simulation parameters
     */
    public static void PrintSimulationParameters()
    {
        System.out.println("**************************Welcome to SkipSim Ver 2.1*****************");
        System.out.println("A simulation has been configured with ");
        System.out.println("System capacity:  " + SkipSimParameters.getSystemCapacity());
        System.out.println("Number of landmarks: " + SkipSimParameters.getLandmarksNum());
        System.out.println("Name ID size: " + SkipSimParameters.getNameIDLength());
        //System.out.println("Landmarks' prefix size: " + SkipSimParameters.);
        System.out.println("Number of topologies: " + SkipSimParameters.getTopologyNumbers());
        System.out.println("Size of domain: " + SkipSimParameters.getDomainSize());
        if (SkipSimParameters.getLifeTime() > 0)
        {
            System.out.println("System life time is set to: " + SkipSimParameters.getLifeTime());
        }
        if (SkipSimParameters.getNodeGenerationStrategy().equals("landmark"))
        {
            System.out.println("Nodes are distributed based on the SkipGraph.Nodes manifestation probability");
        }
        else
        {
            System.out.println("Nodes are distributed uniformely at random");
        }

        System.out.println("Name id assignment of SkipGraph.Nodes is " + SkipSimParameters.getNameIDAssignment());

        if (!SkipSimParameters.getReplicationAlgorithm().equalsIgnoreCase(Constants.Replication.Algorithms.NONE))
        {
            System.out.println("Replication algorithm is " + SkipSimParameters.getReplicationAlgorithm());
            System.out.println("Number of replicas " + SkipSimParameters.getReplicationDegree());
            if (SkipSimParameters.getReplicationType().equals("public"))
            {
                System.out.println("Replication type is public");
            }
            else
            {
                System.out.println("Replication type is private");
                System.out.println("A set of " + SkipSimParameters.getDataRequesterNumber() + " SkipGraph.Nodes are chosen uniformly at random as data requester SkipGraph.Nodes");
            }
            if (SkipSimParameters.isReplicationLocalityAwarenessEvaluation())
            {
                System.out.println("Replication algorithm is evaluated based on access delay");
            }
            if (SkipSimParameters.isReplicationLoadEvaluation())
            {
                System.out.println("Replication algorithm is evaluated based on load distribution among replicas");
            }
        }


        if (SkipSimParameters.isNameIDLocalityAwarenessEvaluatgion())
        {
            System.out.println("Name ids are evaluated based on their locality awareness");
        }
        if (SkipSimParameters.getSearchByNameID() != 0)
        {
            System.out.println(SkipSimParameters.getSearchByNameID() + " random search by name id will be initiated");
        }
        if (SkipSimParameters.getSearchByNumericalID() != 0)
        {
            System.out.println(SkipSimParameters.getSearchByNumericalID() + " random search by numerical id will be initiated");
        }

        System.out.println("**************************End of Configuration*****************");
    }


}