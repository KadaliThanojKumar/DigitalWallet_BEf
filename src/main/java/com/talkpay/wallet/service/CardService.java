package com.talkpay.wallet.service;

import com.talkpay.wallet.model.Card;
import com.talkpay.wallet.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getCardsByUser(Long userId) {
        return cardRepository.findByUserId(userId);
    }

    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

    public Optional<Card> getCardById(Long id) {
        return cardRepository.findById(id);
    }

    public void setDefaultCard(Long id, Long userId) {
        // unset previous default
        List<Card> userCards = cardRepository.findByUserId(userId);
        for (Card c : userCards) {
            if (c.getIsDefault()) {
                c.setIsDefault(false);
                cardRepository.save(c);
            }
        }
        // set new default
        Card card = cardRepository.findById(id).orElseThrow();
        card.setIsDefault(true);
        cardRepository.save(card);
    }
}
