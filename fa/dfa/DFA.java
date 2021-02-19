package fa.dfa;

import java.util.Set;
import java.util.Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import fa.State;


public class DFA implements DFAInterface {

	// store start state
	private DFAState startState;
	// store final
	private Set<DFAState> finalState = new HashSet<DFAState>();
	// store alpha
	private Set<Character> alphabet = new HashSet<Character>();
	// store states
	private Set<DFAState> states = new HashSet<DFAState>();
	// store transitions
	private HashMap<DFAState, HashMap<Character, DFAState>> transitions = new HashMap<DFAState, HashMap<Character, DFAState>>();


	/**
	 * Construct the textual representation of the DFA, for example A simple two
	 * state DFA Q = { a b } Sigma = { 0 1 } delta = 0 1 a a b b a b q0 = a F = { b
	 * }
	 * 
	 * The order of the states and the alphabet is the order in which they were
	 * instantiated in the DFA.
	 * 
	 * @return String representation of the DFA
	 */
	public String toString() {

		String definition = "Q = { ";
		for(DFAState q: states) {
			definition += q.getName() + " ";
		}

		definition += "}\n";
		definition += "Sigma = { ";

		for(char sigma: alphabet) {
			definition += sigma + " ";
		}

		definition += "}\n";
		definition += "delta = \n\t";
		
		for(char sigma: alphabet) {
			definition += sigma + "  ";
		}

		/* Trying to test ouput for transitions I just need to play with it a little more */

		// for(DFAState q: states) {
		// 	HashMap<Character, DFAState> map = transitions.get(q.getName());
		// 	definition += q.getName() + " ";
		// }

		for (Map.Entry<DFAState, HashMap<Character, DFAState>> e : transitions.entrySet()) {
            System.out.println("Key: " + e.getKey() + " Value: " + e.getValue()); 
    
		}

		/*****************************************/

		return definition;

	}

	/**
	 * Simulates a DFA on input s to determine whether the DFA accepts s.
	 * 
	 * @param s - the input string
	 * @return true if s in the language of the DFA and false otherwise
	 */
	public boolean accepts(String s) {
		// If our final state set contains the string s return true, otherwise false
		if (finalState.contains(new DFAState(s))) {
			return true;
		}
		return false;
	}

	/**
	 * Uses transition function delta of FA
	 * 
	 * @param from   the source state
	 * @param onSymb the label of the transition
	 * @return the sink state.
	 */
	public State getToState(DFAState from, char onSymb) {
		// get the value of the innermap <Character, DFAState>
		HashMap<Character, DFAState> innerMap = transitions.get(from);
		// return DFAState from innermap and cast to type State
		return (State) innerMap.get(onSymb);

	}

	/**
	 * Adds the initial state to the DFA instance
	 * 
	 * @param name is the label of the start state
	 */
	public void addStartState(String name) {
		// startStates = new HashSet<DFAState>();
		// Create new start state
		startState = new DFAState(name);
		// add to states set
		states.add(startState);

	}

	/**
	 * Adds a non-final, not initial state to the DFA instance
	 * 
	 * @param name is the label of the state
	 */
	public void addState(String name) {

		states = new HashSet<DFAState>();
		// Adds the DFA state to state set
		states.add(new DFAState(name));

	}

	/**
	 * Adds a final state to the DFA
	 * 
	 * @param name is the label of the state
	 */
	public void addFinalState(String name) {

		finalState.add(new DFAState(name));
		states.add(new DFAState(name));
	}

	/**
	 * Adds the transition to the DFA's delta data structure
	 * 
	 * @param fromState is the label of the state where the transition starts
	 * @param onSymb    is the symbol from the DFA's alphabet.
	 * @param toState   is the label of the state where the transition ends
	 */
	public void addTransition(String fromState, char onSymb, String toState) {
		// Create new HashMap to store inside other map
		HashMap<Character, DFAState> innerMap = new HashMap<Character, DFAState>();
		// Put state and sybmol inside inner map
		innerMap.put(onSymb, new DFAState(fromState));
		// Add the onSymb to the alphabet if not already added
		alphabet.add(onSymb);
		// Put inner map and to state into the transition map
		transitions.put(new DFAState(toState), innerMap);

	}

	/**
	 * Getter for Q
	 * 
	 * @return a set of states that FA has
	 */
	public Set<? extends State> getStates() {

		return states;

	}

	/**
	 * Getter for F
	 * 
	 * @return a set of final states that FA has
	 */
	public Set<? extends State> getFinalStates() {
		return finalState;

	}

	/**
	 * Getter for q0
	 * 
	 * @return the start state of FA
	 */
	public State getStartState() {
		return startState;

	}

	/**
	 * Getter for Sigma
	 * 
	 * @return the alphabet of FA
	 */
	public Set<Character> getABC() {
		return alphabet;

	}

}
