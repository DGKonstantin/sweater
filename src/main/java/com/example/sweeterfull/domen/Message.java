package com.example.sweeterfull.domen;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Getter
    private Integer id;

    @Getter
    @Setter
    private String text;

    @Getter
    @Setter
    private String tag;

    @Getter
    @Setter
    private User author;

    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }
    public Message() {
    }
}
