//Name: Yutao Ren	
//USC NetID: yutaoren
//CS 455 PA1
//Fall 2017

/**
 *class CoinTossSimulatorTester
 *
 *Test every method and the constructor of CoinTossSimulator class multiple times. 
 *Print out the result of each operation to the console.
 *
 */
public class CoinTossSimulatorTester {
	
	public static void main(String[] args) {
		
		//Test the default constructor correctly creates the simulator. 
		CoinTossSimulator tossCoin = new CoinTossSimulator();

		System.out.println("After constructor:");
		System.out.println("Number of trials [exp:0]: " + tossCoin.getNumTrials());
		System.out.println("Two-head tosses: " + tossCoin.getTwoHeads());
		System.out.println("Two-tail tosses: " + tossCoin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + tossCoin.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		System.out.println(tossCoin.getNumTrials() == tossCoin.getTwoHeads() 
						   + tossCoin.getTwoTails() + tossCoin.getHeadTails());
		System.out.println();
		
		//Test tossing one pair of coins.
		tossCoin.run(1);
		System.out.println("After run(1):");
		System.out.println("Number of trials [exp:1]: " + tossCoin.getNumTrials());
		System.out.println("Two-head tosses: " + tossCoin.getTwoHeads());
		System.out.println("Two-tail tosses: " + tossCoin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + tossCoin.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		System.out.println(tossCoin.getNumTrials() == tossCoin.getTwoHeads() 
				   + tossCoin.getTwoTails() + tossCoin.getHeadTails());
		System.out.println();
		
		//Test tossing 10 pairs of coins afterwards. 
		tossCoin.run(10);
		System.out.println("After run(10):");
		System.out.println("Number of trials [exp:11]: " + tossCoin.getNumTrials());
		System.out.println("Two-head tosses: " + tossCoin.getTwoHeads());
		System.out.println("Two-tail tosses: " + tossCoin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + tossCoin.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		System.out.println(tossCoin.getNumTrials() == tossCoin.getTwoHeads() 
				   + tossCoin.getTwoTails() + tossCoin.getHeadTails());
		System.out.println();
		
		//Test tossing 100 pairs of coins afterwards. 
		tossCoin.run(100);
		System.out.println("After run(100):");
		System.out.println("Number of trials [exp:111]: " + tossCoin.getNumTrials());
		System.out.println("Two-head tosses: " + tossCoin.getTwoHeads());
		System.out.println("Two-tail tosses: " + tossCoin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + tossCoin.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		System.out.println(tossCoin.getNumTrials() == tossCoin.getTwoHeads() 
				   + tossCoin.getTwoTails() + tossCoin.getHeadTails());
		System.out.println();
		
		//Test tossing 178 pairs of coins afterwards. 
		tossCoin.run(178);
		System.out.println("After run(178):");
		System.out.println("Number of trials [exp:289]: " + tossCoin.getNumTrials());
		System.out.println("Two-head tosses: " + tossCoin.getTwoHeads());
		System.out.println("Two-tail tosses: " + tossCoin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + tossCoin.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		System.out.println(tossCoin.getNumTrials() == tossCoin.getTwoHeads() 
				   + tossCoin.getTwoTails() + tossCoin.getHeadTails());
		System.out.println();
		
		//Test tossing 211 pairs of coins afterwards. 
		tossCoin.run(211);
		System.out.println("After run(211):");
		System.out.println("Number of trials [exp:500]: " + tossCoin.getNumTrials());
		System.out.println("Two-head tosses: " + tossCoin.getTwoHeads());
		System.out.println("Two-tail tosses: " + tossCoin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + tossCoin.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		System.out.println(tossCoin.getNumTrials() == tossCoin.getTwoHeads() 
				   + tossCoin.getTwoTails() + tossCoin.getHeadTails());
		System.out.println();
		
		//Test reseting the simulator to start a new simulation.
		tossCoin.reset();
		System.out.println("After reset:");
		System.out.println("Number of trials [exp:0]: " + tossCoin.getNumTrials());
		System.out.println("Two-head tosses: " + tossCoin.getTwoHeads());
		System.out.println("Two-tail tosses: " + tossCoin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + tossCoin.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		System.out.println(tossCoin.getNumTrials() == tossCoin.getTwoHeads() 
				   + tossCoin.getTwoTails() + tossCoin.getHeadTails());
		System.out.println();
		
		//Test tossing 1000 pairs of coins after reset.
		tossCoin.run(1000);
		System.out.println("After run(1000):");
		System.out.println("Number of trials [exp:1000]: " + tossCoin.getNumTrials());
		System.out.println("Two-head tosses: " + tossCoin.getTwoHeads());
		System.out.println("Two-tail tosses: " + tossCoin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + tossCoin.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		System.out.println(tossCoin.getNumTrials() == tossCoin.getTwoHeads() 
				   + tossCoin.getTwoTails() + tossCoin.getHeadTails());
		System.out.println();
		
		//Test tossing 538 pairs of coins afterwards.
		tossCoin.run(538);
		System.out.println("After run(538):");
		System.out.println("Number of trials [exp:1538]: " + tossCoin.getNumTrials());
		System.out.println("Two-head tosses: " + tossCoin.getTwoHeads());
		System.out.println("Two-tail tosses: " + tossCoin.getTwoTails());
		System.out.println("One-head one-tail tosses: " + tossCoin.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		System.out.println(tossCoin.getNumTrials() == tossCoin.getTwoHeads() 
				   + tossCoin.getTwoTails() + tossCoin.getHeadTails());
		System.out.println();
		
	}
}
