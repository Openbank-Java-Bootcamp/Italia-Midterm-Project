package com.ironhack.bankingsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "transaction")
public class Transaction {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Long requesterAccountId;

        private Long targetAccountId;

        private String thirdPartyName;

        private Money amount;

        public Transaction(Long requesterAccountId, Long targetAccountId, Money amount) {
                this.requesterAccountId = requesterAccountId;
                this.targetAccountId = targetAccountId;
                this.amount = amount;
        }

        public Transaction(String thirdPartyName, Long targetAccountId, Money amount) {
                this.thirdPartyName = thirdPartyName;
                this.targetAccountId = targetAccountId;
                this.amount = amount;
        }

}
