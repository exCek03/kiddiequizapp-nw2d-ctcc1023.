/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa.major.pkgfinal.output;

/**
 *
 * @author Aaron
 */
public class Leaderboard {
    String name;
    int score;

    public Leaderboard(String name, int score) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }
    
    public String getName(){
        return name;
    }
    
    public void setScore(int score) {
        this.score = score;
    }

    public String toString() {
        return name + " - " + score + "/10";
    }
}

