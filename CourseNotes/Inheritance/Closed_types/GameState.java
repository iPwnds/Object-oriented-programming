package Closed_types;

import java.util.Objects;

public sealed interface GameState {
//	permits GameState.Regular, GameState.Advantage, GameState.Won {
    	public record Regular(Score serverScore, Score receiverScore) implements GameState {
    		public Regular {
    			Objects.requireNonNull(serverScore);
    			Objects.requireNonNull(receiverScore);
    		}
    	}
    	public record Advantage(boolean server) implements GameState {}
    	public record Won(boolean server) implements GameState {}
}
