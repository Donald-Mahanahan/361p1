package fa.dfa;

import java.util.Set;
import java.util.Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import fa.State;



public class DFA implements DFAInterface {
    
    	/**
	 * Construct the textual representation of the DFA, for example
	 * A simple two state DFA
	 * Q = { a b }
	 * Sigma = { 0 1 }
	 * delta =
	 *		0	1	
	 *	a	a	b	
	 *	b	a	b	
	 * q0 = a
	 * F = { b }
	 * 
	 * The order of the states and the alphabet is the order
	 * in which they were instantiated in the DFA.
	 * @return String representation of the DFA
	 */
	public abstract String toString() {

    }
	
	/**
	 * Simulates a DFA on input s to determine
	 * whether the DFA accepts s.
	 * @param s - the input string
	 * @return true if s in the language of the DFA and false otherwise
	 */
	public abstract boolean accepts(String s) {

    }
	
	/**
	 * Uses transition function delta of FA
	 * @param from the source state
	 * @param onSymb the label of the transition
	 * @return the sink state.
	 */
	public abstract State getToState(DFAState from, char onSymb) {

    }

    	/**
	 * Adds the initial state to the DFA instance
	 * @param name is the label of the start state
	 */
	public abstract void addStartState(String name);

	/**
	 * Adds a non-final, not initial state to the DFA instance
	 * @param name is the label of the state 
	 */
	public abstract void addState(String name);

	/**
	 * Adds a final state to the DFA
	 * @param name is the label of the state
	 */
	public abstract void addFinalState(String name);


	/**
	 * Adds the transition to the DFA's delta data structure
	 * @param fromState is the label of the state where the transition starts
	 * @param onSymb is the symbol from the DFA's alphabet.
	 * @param toState is the label of the state where the transition ends
	 */
	public abstract void addTransition(String fromState, char onSymb, String toState) {

    }
	
	/**
	 * Getter for Q
	 * @return a set of states that FA has
	 */
	public abstract Set<? extends State> getStates(){

    }
	
	/**
	 * Getter for F
	 * @return a set of final states that FA has
	 */
	public abstract Set<? extends State> getFinalStates(){

    }
	
	/**
	 * Getter for q0
	 * @return the start state of FA
	 */
	public abstract State getStartState(){

    }
	
	/**
	 * Getter for Sigma
	 * @return the alphabet of FA
	 */
	public abstract Set<Character> getABC(){

    }


}
