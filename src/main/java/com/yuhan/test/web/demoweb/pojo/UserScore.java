package com.yuhan.test.web.demoweb.pojo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_scores")
public class UserScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String standard;
    private int score;

    public UserScore() {}

    public UserScore(String username, String standard, int score) {
        this.username = username;
        this.standard = standard;
        this.score = score;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getStandard() { return standard; }
    public void setStandard(String standard) { this.standard = standard; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}
