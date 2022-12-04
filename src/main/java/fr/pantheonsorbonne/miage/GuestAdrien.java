package fr.pantheonsorbonne.miage;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import fr.pantheonsorbonne.miage.enums.CardValue;
import fr.pantheonsorbonne.miage.game.Card;

public class GuestAdrien implements Guest {

    public List<Card> checkLastNMoves(List<Card[]> lastNMoves) {
        List<Card> lastMove = new ArrayList<Card>();
        Card[] moves = lastNMoves.get(lastNMoves.size()-1);
            for (Card move : moves) {
                lastMove.add(move);
            }
        
        return lastMove;
    }

    public Set<Integer> findDoubleInHand(List<Card> hand) {
        Set<Integer> doubleInHand = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        for (Card c : hand) {
            if (!seen.add(c.getValue().getRank())) {
                doubleInHand.add(c.getValue().getRank());
            }
        }
        return doubleInHand;
    }

    public Card[] cardToPlayToArray(List<Card> cardsToPlay) {
        Card[] cardPlay = new Card[cardsToPlay.size()];
        for (int i = 0; i < cardsToPlay.size(); i++) {
            cardPlay[i] = cardsToPlay.get(i);
        }
        return cardPlay;
    }

    public Card[] playOneCard(List<Card> hand, List<Card[]> lastNMoves) {
        Set<Integer> doubleInHand = findDoubleInHand(hand);
        List<Card> lastMove = checkLastNMoves(lastNMoves);
        boolean thereIsDouble = false;
        Card[] oneCardToPlay = new Card[1];
        oneCardToPlay[0] = hand.get(0);

        for (Card card : hand) {
            for (Card card2 : hand) {
                for (Integer num : doubleInHand) {
                    if (card.getValue().getRank() == num) {
                        thereIsDouble = true;
                    }
                    if (card.getValue().getRank() >= card2.getValue().getRank() && thereIsDouble == false) {
                        if(lastMove.isEmpty() || card.getValue().getRank() <= lastMove.get(0).getValue().getRank()){
                        oneCardToPlay[0] = card;
                        }
                    }
                    thereIsDouble = false;
                }

            }
        }
        return oneCardToPlay;
    }

    public Card[] playOneCardLocal(List<Card> hand, List<Card[]> lastNMoves) {
        Set<Integer> doubleInHand = findDoubleInHand(hand);
        boolean thereIsDouble = false;
        Card[] oneCardToPlay = new Card[1];
        oneCardToPlay[0] = hand.get(0);

        for (Card card : hand) {
            for (Card card2 : hand) {
                for (Integer num : doubleInHand) {
                    if (card.getValue().getRank() == num) {
                        thereIsDouble = true;
                    }
                    if (card.getValue().getRank() >= card2.getValue().getRank() && thereIsDouble == false) {
                        
                        oneCardToPlay[0] = card;
                        
                    }
                    thereIsDouble = false;
                }

            }
        }
        return oneCardToPlay;
    }

    public Card[] playTriple(List<Card> hand, List<Card[]> lastNMoves) {

        Set<Integer> doubleInHand = findDoubleInHand(hand);
        List<Card> cardsToPlay = new ArrayList<>();
        List<Card> lastMove = checkLastNMoves(lastNMoves);
        boolean thereIsDouble = false;
        for (Card card : hand) {
            for (Card card2 : hand) {
                for (Integer num : doubleInHand) {
                    if (card.getValue().getRank() == num) {
                        thereIsDouble = true;
                    }
                }
                if (card.getValue().getRank() == card2.getValue().getRank() && thereIsDouble == true) {
                    if(lastMove.isEmpty() || card.getValue().getRank() <= lastMove.get(lastMove.size()-1).getValue().getRank()){
                    cardsToPlay.add(card2);
                    }
                }
                thereIsDouble = false;
            }
            if (cardsToPlay.size() == 3) {
                return cardToPlayToArray(cardsToPlay);
            }
        }
        return new Card[0];
    }

    public Card[] playTripleLocal(List<Card> hand, List<Card[]> lastNMoves) {

        Set<Integer> doubleInHand = findDoubleInHand(hand);
        List<Card> cardsToPlay = new ArrayList<>();
        boolean thereIsDouble = false;
        for (Card card : hand) {
            for (Card card2 : hand) {
                for (Integer num : doubleInHand) {
                    if (card.getValue().getRank() == num) {
                        thereIsDouble = true;
                    }
                }
                if (card.getValue().getRank() == card2.getValue().getRank() && thereIsDouble == true) {
                    cardsToPlay.add(card2);
                }
                thereIsDouble = false;
            }
            if (cardsToPlay.size() == 3) {
                return cardToPlayToArray(cardsToPlay);
            }
        }
        return new Card[0];
    }

    public Card[] playDouble(List<Card> hand, List<Card[]> lastNMoves) {
        Set<Integer> doubleInHand = findDoubleInHand(hand);
        List<Card> cardsToPlay = new ArrayList<>();
        List<Card> lastMove = checkLastNMoves(lastNMoves);
        boolean thereIsDouble = false;
        for (Card card : hand) {
            for (Card card2 : hand) {
                for (Integer num : doubleInHand) {
                    if (card.getValue().getRank() == num) {
                        thereIsDouble = true;
                    }
                }
                if (card.getValue().getRank() == card2.getValue().getRank() && thereIsDouble == true) {
                    if(lastMove.isEmpty() || card.getValue().getRank() <= lastMove.get(lastMove.size()-1).getValue().getRank()){
                    cardsToPlay.add(card2);
                    }
                }
                thereIsDouble = false;
            }
            if (cardsToPlay.size() == 2) {
                return cardToPlayToArray(cardsToPlay);
            }
        }
        return new Card[0];

    }

    public Card[] playDoubleLocal(List<Card> hand, List<Card[]> lastNMoves) {
        Set<Integer> doubleInHand = findDoubleInHand(hand);
        List<Card> cardsToPlay = new ArrayList<>();
        boolean thereIsDouble = false;
        for (Card card : hand) {
            for (Card card2 : hand) {
                for (Integer num : doubleInHand) {
                    if (card.getValue().getRank() == num) {
                        thereIsDouble = true;
                    }
                }
                if (card.getValue().getRank() == card2.getValue().getRank() && thereIsDouble == true) {
                    cardsToPlay.add(card2);
                }
                thereIsDouble = false;
            }
            if (cardsToPlay.size() == 2) {
                return cardToPlayToArray(cardsToPlay);
            }
        }
        return new Card[0];

    }

    @Override
    public Card[] chooseCardsToPlay(List<Card> hand, List<Card[]> lastNMoves) {
        List<Card> lastMove = checkLastNMoves(lastNMoves);
        if (lastMove.size() == 1) {
            return playOneCard(hand, lastNMoves);
        } else if (lastMove.size() == 2) {
            return playDouble(hand, lastNMoves);
        } else if (lastMove.size() == 3) {
            return playTriple(hand, lastNMoves);
        } else if (lastMove.isEmpty()) {
            if (playTriple(hand, lastNMoves).length != 0) {
                return playTriple(hand, lastNMoves);
            } else if (playDouble(hand, lastNMoves).length != 0) {
                return playDouble(hand, lastNMoves);
            } else if (playOneCard(hand, lastNMoves).length != 0) {
                return playOneCard(hand, lastNMoves);
            } else {
                return new Card[0];
            }
        } else {
            return new Card[0];
        }
    }

    public Card[] chooseCardsToPlayLocal(List<Card> hand, List<Card[]> lastNMoves) {
        if (lastNMoves.size() == 1) {
            return playOneCardLocal(hand, lastNMoves);
        } else if (lastNMoves.size() == 2) {
            return playDoubleLocal(hand, lastNMoves);
        } else if (lastNMoves.size() == 3) {
            return playTripleLocal(hand, lastNMoves);
        } else if (lastNMoves.isEmpty()) {
            if (playTripleLocal(hand, lastNMoves).length != 0) {
                return playTripleLocal(hand, lastNMoves);
            } else if (playDoubleLocal(hand, lastNMoves).length != 0) {
                return playDoubleLocal(hand, lastNMoves);
            } else if (playOneCardLocal(hand, lastNMoves).length != 0) {
                return playOneCardLocal(hand, lastNMoves);
            } else {
                return new Card[0];
            }
        } else {
            return new Card[0];
        }
    }

    @Override
    public Card[] chooseBestCardsToGive(List<Card> hand, int nbCards) {

        if (nbCards == 1) {
            Card[] cardsToPlay = new Card[1];
            cardsToPlay[0] = hand.get(0);

            for (Card card : hand) {
                CardValue cardValue = card.getValue();
                if (cardValue.getRank() < cardsToPlay[0].getValue().getRank()) {
                    cardsToPlay[0] = card;
                }
            }

            return cardsToPlay;
        } else {
            Card[] cardsToPlay = new Card[2];
            cardsToPlay[0] = hand.get(0);
            cardsToPlay[1] = hand.get(0);
            for (Card card : hand) {
                CardValue cardValue = card.getValue();
                if (cardValue.getRank() < cardsToPlay[0].getValue().getRank()) {
                    cardsToPlay[0] = card;
                }
            }
            for (Card card2 : hand) {
                CardValue cardValue = card2.getValue();
                if (card2 == cardsToPlay[0]) {
                    continue;
                }
                if (cardValue.getRank() < cardsToPlay[0].getValue().getRank()) {
                    cardsToPlay[1] = card2;
                }
            }

            return cardsToPlay;
        }

    }

    @Override
    public Card[] chooseCardsOfYourChoiceToGive(List<Card> hand, int nbCards) {

        if (nbCards == 2) {
            Card[] cardsToGive = new Card[2];
            cardsToGive[0] = hand.get(0);
            cardsToGive[1] = hand.get(0);
            for (Card card : hand) {
                if (card.getValue().getRank() > cardsToGive[0].getValue().getRank()) {
                    cardsToGive[0] = card;
                }
            }
            for (Card card2 : hand) {
                if (card2.getValue().getRank() > cardsToGive[1].getValue().getRank() && card2 != cardsToGive[0]) {
                    cardsToGive[1] = card2;
                }
            }
            return cardsToGive;
        } else {
            Card[] cardsToGive = new Card[1];
            cardsToGive[0] = hand.get(0);
            for (Card card : hand) {
                CardValue cardValue = card.getValue();
                if (cardValue.getRank() > cardsToGive[0].getValue().getRank()) {
                    cardsToGive[0] = card;
                }
            }
            return cardsToGive;
        }
    }

}
