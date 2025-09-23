package com.talkpay.wallet.controller;

import com.talkpay.wallet.model.Card;
import com.talkpay.wallet.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin(origins = "http://localhost:3000") // React frontend
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    // Get all cards for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Card>> getCardsByUser(@PathVariable Long userId) {
        List<Card> cards = cardService.getCardsByUser(userId);
        return ResponseEntity.ok(cards);
    }

    // Add a new card
    @PostMapping("/add")
    public ResponseEntity<Card> addCard(@RequestBody Card card) {
        Card savedCard = cardService.saveCard(card);
        return ResponseEntity.ok(savedCard);
    }

    // Delete a card
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        return ResponseEntity.ok().build();
    }

    // Set default card
    @PutMapping("/default/{id}")
    public ResponseEntity<Void> setDefaultCard(@PathVariable Long id, @RequestParam Long userId) {
        cardService.setDefaultCard(id, userId);
        return ResponseEntity.ok().build();
    }
}
