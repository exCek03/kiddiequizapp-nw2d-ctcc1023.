package dsa.major.pkgfinal.output;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DSAMajorFinalOutput {
JFrame app = new JFrame("Kiddie App");
JLabel questionLabel;
JButton optionA, optionB, optionC, optionD;
JTextArea feedback, resultFeedback, leaderboardTextArea;
int easyScore = 0;
int hardScore = 0;
JPanel container = new JPanel();
BackgroundPanel menuPanel = new BackgroundPanel("bg1.png");
JLabel menuLabel = new JLabel("Kiddie Quiz App");
BackgroundPanel getNamePanel = new BackgroundPanel("bg2.png");
JLabel getNameLabel = new JLabel("Hello, welcome to the Kiddie App, Please enter your name:");
BackgroundPanel levelPanel = new BackgroundPanel("bg3.png");
BackgroundPanel leaderboardPanel = new BackgroundPanel("bg3.png");
BackgroundPanel quizPanel = new BackgroundPanel("bg4.png");
BackgroundPanel feedbackPanel = new BackgroundPanel("bg5.png");
BackgroundPanel resultPanel = new BackgroundPanel("bg6.png");
JTextField nameField = new JTextField(10);
JLabel greetingLabel = new JLabel();
JButton easyButton = new JButton("Easy");
JButton hardButton = new JButton("Hard");
JButton nextButton = new JButton("Next");
JButton continueButton = new JButton("Continue");
JLabel resultLabel = new JLabel();
JButton retryButton = new JButton("Try Again");
JButton mainMenuButton = new JButton("Main Menu");
CardLayout cl = new CardLayout();
String username;
    String[] easyQuestions = {
    "What color is the sky?", "What sound does a dog make?", 
    "What is 2+2?", "What animal says 'meow'?", 
    "What is the color of grass?", "How many legs does a spider have?", 
    "What shape is a ball?", "Which one is a fruit: apple or rock?", 
    "What color is a banana?", "What do you wear on your feet?", 
    "What do bees make?", "What day comes after Monday?", 
    "What is 1+1?", "How many fingers do you have?", 
    "What do cows produce?", "Which one is a vegetable: carrot or stone?", 
    "What sound does a cat make?", "What is the opposite of night?", 
    "What do you use to write: pencil or shoe?", 
    "What color is an apple?", "How many wheels does a car have?", 
    "Which animal is big and gray: elephant or bird?", 
    "What number comes after 3?", 
    "What is 5-3?", "Which one is an insect: ant or tree?"
};


String[][] easyOptions = {
    {"Red", "Blue", "Green", "Yellow"},
    {"Bark", "Meow", "Chirp", "Roar"},
    {"1", "2", "3", "4"},
    {"Dog", "Cat", "Bird", "Fish"},
    {"Red", "Blue", "Green", "Yellow"},
    {"4", "6", "8", "10"},
    {"Square", "Triangle", "Circle", "Rectangle"},
    {"Apple", "Rock", "Stick", "Leaf"},
    {"Red", "Blue", "Green", "Yellow"},
    {"Hat", "Shirt", "Pants", "Shoes"},
    {"Honey", "Milk", "Bread", "Juice"},
    {"Monday", "Tuesday", "Wednesday", "Friday"},
    {"0", "1", "2", "3"},
    {"8", "10", "12", "5"},
    {"Milk", "Wool", "Cotton", "Silk"},
    {"Carrot", "Stone", "Leaf", "Water"},
    {"Meow", "Bark", "Chirp", "Roar"},
    {"Day", "Light", "Star", "Moon"},
    {"Pencil", "Shoe", "Bottle", "Book"},
    {"Red", "Blue", "Green", "Yellow"},
    {"4", "2", "3", "6"},
    {"Elephant", "Bird", "Mouse", "Frog"},
    {"2", "4", "5", "6"},
    {"1", "2", "3", "5"},
    {"Ant", "Tree", "Flower", "Leaf"}
};
String[] easyFeedback = {
    "The sky is blue, just like water!",
    "Dogs say 'Bark'. It’s a sound you often hear in parks!",
    "2+2 equals 4. It’s like adding two pairs of shoes!",
    "Cats say 'Meow'. They make this sound when they're happy or want attention.",
    "Grass is green, and it covers fields and parks!",
    "Spiders have 8 legs. Imagine them crawling on all those legs!",
    "A ball is round like a circle. It rolls easily on the ground.",
    "An apple is a fruit, while a rock is not something you can eat!",
    "Bananas are yellow. They’re a yummy snack!",
    "You wear shoes on your feet to protect them.",
    "Bees make honey, which is sweet and yummy!",
    "Tuesday comes after Monday. It’s the second day of the week.",
    "1+1 equals 2. Imagine two apples together!",
    "You have 10 fingers in total, five on each hand!",
    "Cows produce milk, which you drink or put in your cereal!",
    "A carrot is a vegetable, while a stone is not edible!",
    "Cats say 'Meow'. They make this sound when they are happy or want attention.",
    "The opposite of night is day, when the sun is out!",
    "You use a pencil to write, not a shoe!",
    "An apple is red. You can find them in trees and markets.",
    "A car has 4 wheels. They help it move smoothly on the road.",
    "An elephant is big and gray. It has a long trunk!",
    "The number after 3 is 4. It’s like adding one more to 3!",
    "5-3 equals 2. Imagine taking away three apples from five.",
    "An ant is an insect. It’s very small and lives in the ground!"
};
int[] easyAnswers = {1, 0, 3, 1, 2, 2, 2, 0, 3, 3, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0};

String[] hardQuestions = {
    "What planet do we live on?", "What is the largest ocean?", 
    "How many continents are there?", "What is the capital of France?", 
    "What is 10 - 4?", "Which planet is known as the Red Planet?", 
    "Who wrote 'Romeo and Juliet'?", "What is H2O?", 
    "Which animal is known as the King of the Jungle?", 
    "What is the largest mammal?", "How many colors are in a rainbow?", 
    "What gas do plants breathe?", "What is the capital of Japan?", 
    "What is 5*5?", "What shape has three sides?", 
    "What is the smallest prime number?", "What is the fastest land animal?", 
    "Which planet is the hottest?", "What is the boiling point of water?", 
    "Who was the first president of the USA?", 
    "What is the longest river in the world?", 
    "What is the freezing point of water?", 
    "Who invented the light bulb?", 
    "What is the square root of 64?", "What is the capital of Italy?"
};

String[][] hardOptions = {
    {"Mars", "Venus", "Earth", "Jupiter"},
    {"Atlantic", "Pacific", "Indian", "Arctic"},
    {"5", "6", "7", "8"},
    {"London", "Paris", "Berlin", "Madrid"},
    {"5", "6", "7", "8"},
    {"Earth", "Mars", "Jupiter", "Saturn"},
    {"Shakespeare", "Hemingway", "Tolstoy", "Dickens"},
    {"Oxygen", "Water", "Hydrogen", "Carbon"},
    {"Lion", "Tiger", "Elephant", "Giraffe"},
    {"Elephant", "Blue Whale", "Shark", "Giraffe"},
    {"5", "6", "7", "8"},
    {"Carbon Dioxide", "Oxygen", "Nitrogen", "Helium"},
    {"Beijing", "Tokyo", "Seoul", "Bangkok"},
    {"20", "25", "30", "35"},
    {"Square", "Triangle", "Circle", "Hexagon"},
    {"1", "2", "3", "4"},
    {"Cheetah", "Lion", "Tiger", "Elephant"},
    {"Mercury", "Venus", "Earth", "Mars"},
    {"100°C", "50°C", "25°C", "0°C"},
    {"Washington", "Lincoln", "Jefferson", "Roosevelt"},
    {"Amazon", "Nile", "Mississippi", "Yangtze"},
    {"0°C", "32°C", "100°C", "50°C"},
    {"Edison", "Tesla", "Newton", "Einstein"},
    {"8", "7", "6", "9"},
    {"Rome", "Paris", "London", "Madrid"}
};
String[] hardFeedback = {
    "We live on Earth, our home planet!",
    "The Pacific Ocean is the largest, covering more area than all the land combined.",
    "There are 7 continents on Earth.",
    "The capital of France is Paris, known for the Eiffel Tower.",
    "10 minus 4 equals 6. Imagine taking away four toys from ten!",
    "Mars is known as the Red Planet because of its reddish appearance.",
    "Shakespeare wrote 'Romeo and Juliet', a famous play.",
    "H2O is the chemical formula for water, which you drink.",
    "The lion is known as the King of the Jungle.",
    "The Blue Whale is the largest mammal. It lives in the ocean!",
    "A rainbow has 7 colors: red, orange, yellow, green, blue, indigo, and violet.",
    "Plants breathe Carbon Dioxide, which helps them grow.",
    "Tokyo is the capital of Japan, a bustling city full of culture.",
    "5 times 5 equals 25. Imagine having five groups of five apples!",
    "A triangle has three sides. It's the simplest polygon.",
    "The smallest prime number is 2, the only even prime number.",
    "The cheetah is the fastest land animal, able to run at incredible speeds.",
    "Venus is the hottest planet because of its thick, heat-trapping atmosphere.",
    "Water boils at 100°C. You can see it bubbling at this temperature!",
    "George Washington was the first president of the USA.",
    "The Nile is the longest river, flowing through northeastern Africa.",
    "Water freezes at 0°C. It turns into ice at this temperature!",
    "Thomas Edison invented the light bulb, bringing light to our homes.",
    "The square root of 64 is 8. Imagine finding a number that, when multiplied by itself, equals 64.",
    "The capital of Italy is Rome, a city rich in history and culture."
};
int[] hardAnswers = {2, 1, 2, 1, 1, 1, 0, 1, 0, 1, 2, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0};

int currentQuestionIndex = 0;
boolean isEasy = true;
Random rand = new Random();
List<Integer> questionIndices = new ArrayList<>();
ArrayList<Leaderboard> easyLeaderboard = new ArrayList<>();
ArrayList<Leaderboard> hardLeaderboard = new ArrayList<>();


public DSAMajorFinalOutput() {
    JButton start = new JButton("Start");
    JButton leaderboard = new JButton("Leaderboard");
    JButton exit = new JButton("Exit");
    app.add(container);
    app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    app.setVisible(true);
    app.setSize(1024, 768);
    app.setResizable(false);
    app.setLocationRelativeTo(null);
    menuLabel.setFont(new Font("Cooper Black",Font.PLAIN,30));
    menuLabel.setForeground(Color.RED);
    start.setFocusable(false);
    start.setBackground(Color.ORANGE);
    start.setFont(new Font("Cooper Black",Font.PLAIN,20));
    start.setBorder(BorderFactory.createEtchedBorder());
    leaderboard.setFocusable(false);
    leaderboard.setBackground(Color.ORANGE);
    leaderboard.setFont(new Font("Cooper Black",Font.PLAIN,20));
    leaderboard.setBorder(BorderFactory.createEtchedBorder());
    exit.setBackground(Color.ORANGE);
    exit.setFont(new Font("Cooper Black",Font.PLAIN,20));
    exit.setBorder(BorderFactory.createEtchedBorder());
    exit.setFocusable(false);
    getNameLabel.setFont(new Font("Cooper Black",Font.PLAIN,20));
    getNameLabel.setForeground(Color.black);
    nameField.setFont(new Font("Cooper Black",Font.PLAIN,20));
    nameField.setBackground(new Color(190,240,255));
    nextButton.setBackground(Color.ORANGE);
    nextButton.setFont(new Font("Cooper Black",Font.PLAIN,20));
    nextButton.setBorder(BorderFactory.createEtchedBorder());
    nextButton.setFocusable(false);
    greetingLabel.setFont(new Font("Cooper Black",Font.PLAIN,20));
    easyButton.setBackground(Color.ORANGE);
    easyButton.setFont(new Font("Cooper Black",Font.PLAIN,20));
    easyButton.setBorder(BorderFactory.createEtchedBorder());
    easyButton.setFocusable(false);
    hardButton.setBackground(Color.ORANGE);
    hardButton.setFont(new Font("Cooper Black",Font.PLAIN,20));
    hardButton.setBorder(BorderFactory.createEtchedBorder());
    hardButton.setFocusable(false);
    container.setLayout(cl);
    
    
    //Menu Panel
    menuPanel.setLayout(null);
    menuPanel.add(menuLabel);
    menuLabel.setBounds(380,160,280,100);
    menuPanel.add(start);
    start.setBounds(390,260,230,70);
    start.setForeground(Color.BLACK);
    menuPanel.add(leaderboard);
    leaderboard.setBounds(390,360,230,70);
    leaderboard.setForeground(Color.BLACK);
    menuPanel.add(exit);
    exit.setBounds(390,460,230,70);
    exit.setForeground(Color.BLACK);
    container.add(menuPanel,"1");

    // Get the user's name
    getNamePanel.setLayout(null);
    getNamePanel.add(getNameLabel);
    getNameLabel.setBounds(230, 240, 600, 100);
    getNamePanel.add(nameField);
    nameField.setBounds(380, 350 ,300, 50);
    getNamePanel.add(nextButton);
    nextButton.setBounds(430, 450, 200, 50);
    container.add(getNamePanel, "2");
    
    //Leaderboard panel
    easyLeaderboard.add(new Leaderboard("Alice", 8));
    easyLeaderboard.add(new Leaderboard("Bob", 7));
    easyLeaderboard.add(new Leaderboard("Charlie", 6));
    easyLeaderboard.add(new Leaderboard("Dave", 5));
    hardLeaderboard.add(new Leaderboard("Benjie", 6));
    hardLeaderboard.add(new Leaderboard("Carl", 4));
    hardLeaderboard.add(new Leaderboard("Camille", 8));
    hardLeaderboard.add(new Leaderboard("Sarah", 5));
    leaderboardPanel.setLayout(null);
    JLabel leaderboardLabel = new JLabel("Select Leaderboard: ");
    leaderboardLabel.setFont(new Font("Cooper Black", Font.PLAIN, 20));
    leaderboardLabel.setBounds(420, 150, 250, 50);
    leaderboardPanel.add(leaderboardLabel);
    JButton easyLeaderboardBtn = new JButton("Easy");
    easyLeaderboardBtn.setFont(new Font("Cooper Black", Font.PLAIN, 20));
    easyLeaderboardBtn.setBounds(360, 250, 300, 50);
    easyLeaderboardBtn.setBorder(BorderFactory.createEtchedBorder());
    easyLeaderboardBtn.setBackground(Color.ORANGE);
    leaderboardPanel.add(easyLeaderboardBtn);
    JButton hardLeaderboardBtn = new JButton("Hard");
    hardLeaderboardBtn.setFont(new Font("Cooper Black", Font.PLAIN, 20));
    hardLeaderboardBtn.setBounds(360, 350, 300, 50);
    hardLeaderboardBtn.setBorder(BorderFactory.createEtchedBorder());
    hardLeaderboardBtn.setBackground(Color.ORANGE);
    leaderboardPanel.add(hardLeaderboardBtn);
    
    JButton leaderboartToMainMenuBtn = new JButton("Main Menu");
    leaderboartToMainMenuBtn.setFont(new Font("Cooper Black", Font.PLAIN, 20));
    leaderboartToMainMenuBtn.setBounds(360, 650, 300, 50);
    leaderboartToMainMenuBtn.setBorder(BorderFactory.createEtchedBorder());
    leaderboartToMainMenuBtn.setBackground(Color.ORANGE);
    leaderboardPanel.add(leaderboartToMainMenuBtn);

    // TextArea to display leaderboard
    leaderboardTextArea = new JTextArea();
    leaderboardTextArea.setEditable(false);
    
    leaderboardTextArea.setFont(new Font("Cooper Black", Font.PLAIN, 20));
    leaderboardTextArea.setBackground(Color.ORANGE);
    leaderboardTextArea.setForeground(Color.BLACK);
    leaderboardTextArea.setLineWrap(true);
    leaderboardTextArea.setWrapStyleWord(true);
    leaderboardTextArea.setBounds(360, 450, 300, 150);  
    leaderboardPanel.add(leaderboardTextArea);
    container.add(leaderboardPanel, "3");

    // Greets the user, then opts to select a level
    levelPanel.setLayout(null);
    levelPanel.add(greetingLabel);
    greetingLabel.setBounds(330, 150, 1024, 50);
    levelPanel.add(easyButton);
    easyButton.setBounds(360, 250, 300, 50);
    levelPanel.add(hardButton);
    hardButton.setBounds(360,350,300,50);
    JButton levelToMainMenuBtn = new JButton ("Main Menu");
    levelToMainMenuBtn.setFont(new Font("Cooper Black", Font.PLAIN, 20));
    levelToMainMenuBtn.setBounds(360, 450, 300, 50);
    levelToMainMenuBtn.setBorder(BorderFactory.createEtchedBorder());
    levelToMainMenuBtn.setBackground(Color.ORANGE);
    levelPanel.add(levelToMainMenuBtn);
    container.add(levelPanel, "4");

    // Quiz Panel
    quizPanel.setLayout(new GridLayout(6, 1,50,20));
    questionLabel = new JLabel("", SwingConstants.CENTER);
    quizPanel.add(questionLabel);
    questionLabel.setFont(new Font("Cooper Black",Font.PLAIN,20));
    questionLabel.setForeground(Color.BLACK);
    optionA = new JButton();
    optionA.setBackground(Color.RED);
    optionA.setFont(new Font("Cooper Black",Font.PLAIN,20));
    optionA.setFocusable(false);
    optionA.setBorder(BorderFactory.createEtchedBorder());
    optionB = new JButton();
    optionB.setBackground(Color.CYAN);
    optionB.setFont(new Font("Cooper Black",Font.PLAIN,20));
    optionB.setFocusable(false);
    optionB.setBorder(BorderFactory.createEtchedBorder());
    optionC = new JButton();
    optionC.setBackground(Color.GREEN);
    optionC.setFont(new Font("Cooper Black",Font.PLAIN,20));
    optionC.setFocusable(false);
    optionC.setBorder(BorderFactory.createEtchedBorder());
    optionD = new JButton();
    optionD.setBackground(Color.YELLOW);
    optionD.setFont(new Font("Cooper Black",Font.PLAIN,20));
    optionD.setFocusable(false);
    optionD.setBorder(BorderFactory.createEtchedBorder());
    quizPanel.add(optionA);
    quizPanel.add(optionB);
    quizPanel.add(optionC);
    quizPanel.add(optionD);
    container.add(quizPanel, "5");

    // Sends a feedback depending on the answer
    feedbackPanel.setLayout(null); 
    feedback = new JTextArea();
    feedback.setEditable(false);
    feedback.setLineWrap(true);
    feedback.setWrapStyleWord(true);
    feedback.setBackground(Color.ORANGE);
    feedback.setBounds(350, 300, 360,100 ); 
    feedback.setFont(new Font("Cooper Black",Font.PLAIN,20));
    feedback.setForeground(Color.BLACK);
    feedbackPanel.add(feedback);
    continueButton.setBounds(430, 450, 200, 50); 
    continueButton.setBackground(Color.ORANGE);
    continueButton.setFont(new Font("Cooper Black",Font.PLAIN,20));
    continueButton.setForeground(Color.BLACK);
    
    feedbackPanel.add(continueButton);
    container.add(feedbackPanel, "6");
    

    resultPanel.setLayout(null);
    resultFeedback = new JTextArea();
    resultFeedback.setEditable(false);
    resultFeedback.setLineWrap(true);
    resultFeedback.setWrapStyleWord(true);
    resultFeedback.setBackground(Color.ORANGE);
    resultFeedback.setBounds(350, 200, 360,80 ); 
    resultFeedback.setFont(new Font("Cooper Black",Font.PLAIN,20));
    resultFeedback.setForeground(Color.BLACK);
    resultLabel.setFont(new Font("Cooper Black", Font.PLAIN, 20));
    resultPanel.add(resultFeedback);
    resultPanel.add(resultLabel);
    resultPanel.add(retryButton);
    retryButton.setBounds(430, 350, 200, 50); 
    retryButton.setBackground(Color.ORANGE);
    retryButton.setFont(new Font("Cooper Black",Font.PLAIN,20));
    retryButton.setForeground(Color.BLACK);
    resultPanel.add(mainMenuButton);
    mainMenuButton.setBounds(430, 450, 200, 50);
    mainMenuButton.setBackground(Color.ORANGE);
    mainMenuButton.setFont(new Font("Cooper Black",Font.PLAIN,20));
    mainMenuButton.setForeground(Color.BLACK);
    container.add(resultPanel, "7");


    
    // button functions
    start.addActionListener(new ActionListener(){
       @Override
       public void actionPerformed(ActionEvent e){
           cl.show(container,"2");
       }
    });
    
    leaderboard.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed (ActionEvent e){
        cl.show(container,"3");
       }
    });
    
    exit.addActionListener(new ActionListener(){
        @Override 
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    });
    nextButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            username = nameField.getText();
            greetingLabel.setText("Hello, " + username + "! Please select a level:");
            cl.show(container, "4");
        }
    });

    easyButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            isEasy = true;
            prepareQuestions();
            cl.show(container, "5");
            loadQuestion();
        }
    });

    hardButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            isEasy = false;
            prepareQuestions();
            cl.show(container, "5");
            loadQuestion();
        }
    });
    
    retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prepareQuestions();
                cl.show(container, "5");
                loadQuestion();
                easyScore = 0;
                hardScore = 0;
            }
        });

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(container, "1");
            }
        });

    // Option Buttons
    ActionListener optionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            checkAnswer(e);
        }
    };
    optionA.addActionListener(optionListener);
    optionB.addActionListener(optionListener);
    optionC.addActionListener(optionListener);
    optionD.addActionListener(optionListener);

    continueButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentQuestionIndex < 10) {
                cl.show(container, "5");
                loadQuestion();
            } else {
                showFinalScore();
            }
        }
    });
    
    easyLeaderboardBtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        addScoreToLeaderboard(easyLeaderboard,username,easyScore);
        showLeaderboard(easyLeaderboard);
    }
});

    hardLeaderboardBtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        addScoreToLeaderboard(hardLeaderboard,username,hardScore);
        showLeaderboard(hardLeaderboard);
    }
});

    
    leaderboartToMainMenuBtn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            cl.show(container, "1");
        }
    });
    
    levelToMainMenuBtn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            cl.show(container, "1");
        }
    });

}

void showLeaderboard(List<Leaderboard> leaderboard) {
    leaderboardTextArea.setText(""); // Clear previous content
    StringBuilder leaderboardContent = new StringBuilder("Leaderboard:\n");
    for (int i = 0; i < leaderboard.size(); i++) {
        Leaderboard entry = leaderboard.get(i);
        leaderboardContent.append((i + 1))
                .append(". ")
                .append(entry.getName())
                .append(" - ")
                .append(entry.getScore())
                .append("\n");
    }
    leaderboardTextArea.setText(leaderboardContent.toString());
}

private void prepareQuestions() {
    questionIndices.clear();
    for (int i = 0; i < 15; i++) {
        questionIndices.add(i);
    }
    Collections.shuffle(questionIndices);
}

private void loadQuestion() {
    int questionIndex = questionIndices.get(currentQuestionIndex);
    if (isEasy) {
        questionLabel.setText(easyQuestions[questionIndex]);
        optionA.setText(easyOptions[questionIndex][0]);
        optionB.setText(easyOptions[questionIndex][1]);
        optionC.setText(easyOptions[questionIndex][2]);
        optionD.setText(easyOptions[questionIndex][3]);
    } else {
        questionLabel.setText(hardQuestions[questionIndex]);
        optionA.setText(hardOptions[questionIndex][0]);
        optionB.setText(hardOptions[questionIndex][1]);
        optionC.setText(hardOptions[questionIndex][2]);
        optionD.setText(hardOptions[questionIndex][3]);
    }
}

private void checkAnswer(ActionEvent e) {
    int questionIndex = questionIndices.get(currentQuestionIndex);
    int correctAnswer = isEasy ? easyAnswers[questionIndex] : hardAnswers[questionIndex];
    String feedbackMessage;

    JButton[] options = {optionA, optionB, optionC, optionD};
    for (int i = 0; i < options.length; i++) {
        if (e.getSource() == options[i]) {
            if (i == correctAnswer) {
                feedbackMessage = "Fantastic! That is correct.";
                 if (isEasy) {
                    easyScore++;
                } else {
                    hardScore++;
                }
            } else {
                feedbackMessage = "Oops! The correct answer is " + options[correctAnswer].getText() + ". ";
                feedbackMessage += isEasy ? easyFeedback[questionIndex] : hardFeedback[questionIndex];
        }
            feedback.setText(feedbackMessage);
            currentQuestionIndex++;
            cl.show(container, "6");
        break;
        }
    }
}

private void showFinalScore() {
    if (isEasy){
        resultFeedback.setText("Good Job! Your final score is: " + easyScore + "/10. Well done, " + username + "!");
    } else{
        resultFeedback.setText("Good Job! Your final score is: " + hardScore + "/10. Well done, " + username + "!");
    }
        currentQuestionIndex = 0;
        cl.show(container, "7"); 
}

private void addScoreToLeaderboard(List<Leaderboard> leaderboard, String username, int score) {
    boolean exists = false;
    for (Leaderboard entry : leaderboard) {
        if (entry.getName() != null && entry.getName().equals(username)) {
            exists = true;
            entry.setScore(score);
            break;
        }
    }
    if (!exists) {
        leaderboard.add(new Leaderboard(username, score));
    }
    leaderboard.sort((entry1, entry2) -> Integer.compare(entry2.getScore(), entry1.getScore())); // Sort by score (the higher first)
}

public static void main(String[] args) {
    new DSAMajorFinalOutput();
}

    
}
