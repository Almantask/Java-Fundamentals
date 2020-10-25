package edu.Part2;

public class Card {
    public static class Something{
        public static void main(String[] args) {
            Validations.Strings.notNullOrEmpty(null);
        }
    }

    public enum Rank{
        Two,
        Three,
        Four,
        Jack,
        Queen,
        King,
        Spade,
        Joker
    }

    public enum Suite{
        Spades,
        Hearts,
    }
}
