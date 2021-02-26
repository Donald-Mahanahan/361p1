package fa.dfa;

import java.util.Set;
import java.util.Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import fa.State;
import java.util.LinkedHashSet; 

public class DFA implements DFAInterface {

	// store start state
	private DFAState startState;
	// store final
	private Set<DFAState> finalState;
	// store alpha
	private Set<Character> alphabet;
	// store states
	private Set<DFAState> states;
	// store transitions
	private HashMap<DFAState, HashMap<Character, DFAState>> transitions;

	private DFAState currentState;

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

	public DFA() {
		// Instanitate all private variables at runtime
		transitions = new HashMap<DFAState, HashMap<Character, DFAState>>();
		finalState = new LinkedHashSet<DFAState>();
		alphabet = new LinkedHashSet<Character>();
		states = new LinkedHashSet<DFAState>();
		currentState = startState;

	}

	public String toString() {

		String definition = "Q = { ";
		for (DFAState q : states) {
			definition += q.getName() + " ";
		}

		definition += "}\n";
		definition += "Sigma = { ";

		for (char sigma : alphabet) {
			definition += sigma + " ";
		}

		definition += "}\n";
		definition += "delta = \n\t";

		for (char sigma : alphabet) {
			definition += "\t";
			definition += sigma ;
		}

		/*
		 * Trying to test ouput for transitions I just need to play with it a little
		 * more
		 */

		definition += "\n";

		for(DFAState q: states) {

			definition += "\t";

			HashMap<Character, DFAState> map = transitions.get(q);
			
			definition += q.getName() + "\t";

			Set set = map.entrySet();
			Iterator iterator = set.iterator();

			while(iterator.hasNext()) {
				Map.Entry mentry = (Map.Entry)iterator.next();
				definition += mentry.getValue() + "\t";
			}

			definition += "\n";
		
		}

		definition += "q0 = " + startState + "\n";

		definition += "F = { " + getFinalStateString(finalState) + "}";


		return definition;
	}

	public String getFinalStateString(Set<DFAState> finalStates) {
		
		String finalStatesString = "";
		
		for(DFAState s: finalStates) {
			finalStatesString += s.getName() + " ";
		}

		return finalStatesString;

	}

	/**
	 * Simulates a DFA on input s to determine whether the DFA accepts s.
	 * 
	 * @param s - the input string
	 * @return true if s in the language of the DFA and false otherwise
	 */
	public boolean accepts(String s) {
		currentState = startState;
		// Empty string
		if (s.equals("e")) {
			for (DFAState b : finalState) {
				if (currentState.equals(b)) {
					return true;
				}

			}
			return false;

		} else

		{
			DFAState transitionState;
			// Goes character by character through the given string
			for (int i = 0; i < s.length(); i++) {
				transitionState = (DFAState) getToState(currentState, s.charAt(i));
				currentState = transitionState;
			}

			// If our final state set contains the string s return true, otherwise false
			for (DFAState b : finalState) {
				if (currentState.equals(b)) {
					return true;
				}
			}
			return false;
		}

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
		HashMap<Character, DFAState> innerMap = new HashMap<Character, DFAState>();
		innerMap = transitions.get(from);
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

		currentState = startState;

	}

	/**
	 * Adds a non-final, not initial state to the DFA instance
	 * 
	 * @param name is the label of the state
	 */
	public void addState(String name) {

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
		alphabet.add(onSymb);
		// Put inner map and to state into the transition map
		HashMap<Character, DFAState> innerMap = new HashMap<Character, DFAState>();
		if (transitions.containsKey(new DFAState(fromState))) {
			innerMap = transitions.get(new DFAState(fromState));
			innerMap.put(onSymb, new DFAState(toState));

		} else {
			// Put state and sybmol inside inner map
			innerMap.put(onSymb, new DFAState(toState));
			// Add the onSymb to the alphabet if not already added

		}
		transitions.put(new DFAState(fromState), innerMap);

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
