package com.yuhan.test.web.demoweb.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yuhan.test.web.demoweb.db.QuestionRepository;
import com.yuhan.test.web.demoweb.pojo.Question;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void run(String... args) throws Exception {
    	// Science
    	addQuestionIfNotExists("What is the chemical symbol for Water?", "O2", "H2O", "CO2", "H2O");
    	addQuestionIfNotExists("What planet is known as the Red Planet?", "Earth", "Mars", "Venus", "Mars");
    	addQuestionIfNotExists("What gas do plants absorb from the atmosphere?", "Oxygen", "Carbon Dioxide", "Nitrogen", "Carbon Dioxide");
    	addQuestionIfNotExists("What part of the plant conducts photosynthesis?", "Root", "Stem", "Leaf", "Leaf");
    	addQuestionIfNotExists("Which organ helps in pumping blood?", "Heart", "Lungs", "Liver", "Heart");
    	addQuestionIfNotExists("Which metal is liquid at room temperature?", "Mercury", "Gold", "Iron", "Mercury");
    	addQuestionIfNotExists("Which vitamin is produced in human skin when exposed to sunlight?", "Vitamin A", "Vitamin D", "Vitamin C", "Vitamin D");
    	addQuestionIfNotExists("What is the hardest natural substance on Earth?", "Iron", "Diamond", "Gold", "Diamond");
    	addQuestionIfNotExists("Which planet is closest to the Sun?", "Earth", "Mercury", "Venus", "Mercury");
    	addQuestionIfNotExists("What is the chemical symbol for Iron?", "Ir", "In", "Fe", "Fe");

    	// Geography
    	addQuestionIfNotExists("What is the capital of France?", "Lyon", "Marseille", "Paris", "Paris");
    	addQuestionIfNotExists("Which is the largest continent?", "Africa", "Asia", "Europe", "Asia");
    	addQuestionIfNotExists("Which ocean is the largest?", "Atlantic", "Pacific", "Indian", "Pacific");
    	addQuestionIfNotExists("Mount Everest lies in which mountain range?", "Alps", "Himalayas", "Andes", "Himalayas");
    	addQuestionIfNotExists("Which country has the largest population?", "India", "China", "USA", "China");
    	addQuestionIfNotExists("Which desert is the largest in the world?", "Sahara", "Gobi", "Kalahari", "Sahara");
    	addQuestionIfNotExists("What is the longest river in the world?", "Amazon", "Nile", "Yangtze", "Nile");
    	addQuestionIfNotExists("Which is the smallest country in the world?", "Vatican City", "Monaco", "Malta", "Vatican City");
    	addQuestionIfNotExists("Which country is known as the Land of the Rising Sun?", "China", "Japan", "Korea", "Japan");
    	addQuestionIfNotExists("Which continent is known as the Dark Continent?", "Asia", "Africa", "Europe", "Africa");

    	// History
    	addQuestionIfNotExists("Who was the first President of the United States?", "Abraham Lincoln", "George Washington", "John Adams", "George Washington");
    	addQuestionIfNotExists("In which year did World War II end?", "1942", "1945", "1948", "1945");
    	addQuestionIfNotExists("Who discovered America?", "Christopher Columbus", "Marco Polo", "Vasco da Gama", "Christopher Columbus");
    	addQuestionIfNotExists("Who was the first man to step on the moon?", "Buzz Aldrin", "Neil Armstrong", "Yuri Gagarin", "Neil Armstrong");
    	addQuestionIfNotExists("Who was known as the Iron Lady?", "Margaret Thatcher", "Indira Gandhi", "Angela Merkel", "Margaret Thatcher");
    	addQuestionIfNotExists("Who discovered gravity?", "Albert Einstein", "Isaac Newton", "Galileo", "Isaac Newton");
    	addQuestionIfNotExists("Which war was fought between the North and South regions in the USA?", "Civil War", "World War I", "Cold War", "Civil War");
    	addQuestionIfNotExists("Who was the first Emperor of India?", "Ashoka", "Chandragupta Maurya", "Akbar", "Chandragupta Maurya");
    	addQuestionIfNotExists("Who discovered electricity?", "Thomas Edison", "Benjamin Franklin", "James Watt", "Benjamin Franklin");
    	addQuestionIfNotExists("In which country did the Industrial Revolution begin?", "France", "Britain", "Germany", "Britain");

    	// Math
    	addQuestionIfNotExists("What is 5 × 6?", "30", "25", "35", "30");
    	addQuestionIfNotExists("What is 12 ÷ 3?", "5", "4", "3", "4");
    	addQuestionIfNotExists("What is the square root of 81?", "9", "8", "7", "9");
    	addQuestionIfNotExists("What is 15% of 200?", "25", "30", "35", "30");
    	addQuestionIfNotExists("How many sides does a hexagon have?", "5", "6", "7", "6");
    	addQuestionIfNotExists("What is 10²?", "20", "100", "50", "100");
    	addQuestionIfNotExists("What is the next prime number after 7?", "8", "9", "11", "11");
    	addQuestionIfNotExists("How many degrees in a right angle?", "45", "90", "180", "90");
    	addQuestionIfNotExists("What is 9 × 9?", "81", "72", "91", "81");
    	addQuestionIfNotExists("What is 1000 divided by 10?", "100", "10", "50", "100");

    	// Technology
    	addQuestionIfNotExists("Who founded Microsoft?", "Steve Jobs", "Bill Gates", "Mark Zuckerberg", "Bill Gates");
    	addQuestionIfNotExists("What does CPU stand for?", "Central Processing Unit", "Computer Personal Unit", "Control Processing Unit", "Central Processing Unit");
    	addQuestionIfNotExists("Which company made the iPhone?", "Samsung", "Apple", "Google", "Apple");
    	addQuestionIfNotExists("What does AI stand for?", "Automatic Intelligence", "Artificial Intelligence", "Active Interface", "Artificial Intelligence");
    	addQuestionIfNotExists("What does URL stand for?", "Uniform Resource Locator", "Universal Record Locator", "User Resource Link", "Uniform Resource Locator");
    	addQuestionIfNotExists("Which programming language is used for Android apps?", "Swift", "Kotlin", "Ruby", "Kotlin");
    	addQuestionIfNotExists("What is the full form of HTML?", "Hyper Text Markup Language", "High Text Machine Language", "Hyper Tool Multi Language", "Hyper Text Markup Language");
    	addQuestionIfNotExists("Which company owns YouTube?", "Microsoft", "Google", "Meta", "Google");
    	addQuestionIfNotExists("What is the main page of a website called?", "Index Page", "Home Page", "Root Page", "Home Page");
    	addQuestionIfNotExists("What does HTTP stand for?", "Hyper Text Transfer Protocol", "Hyper Text Transmission Path", "High Transfer Type Protocol", "Hyper Text Transfer Protocol");

    	// Sports
    	addQuestionIfNotExists("How many players are there in a football team?", "9", "11", "7", "11");
    	addQuestionIfNotExists("Which sport uses a shuttlecock?", "Badminton", "Tennis", "Squash", "Badminton");
    	addQuestionIfNotExists("How many rings are there in the Olympic logo?", "4", "5", "6", "5");
    	addQuestionIfNotExists("Which sport is known as the ‘gentleman’s game’?", "Cricket", "Tennis", "Golf", "Cricket");
    	addQuestionIfNotExists("In which sport is the term 'love' used?", "Cricket", "Tennis", "Football", "Tennis");
    	addQuestionIfNotExists("Which country won the 2011 Cricket World Cup?", "Australia", "India", "Sri Lanka", "India");
    	addQuestionIfNotExists("Who is known as the fastest man in the world?", "Usain Bolt", "Carl Lewis", "Michael Phelps", "Usain Bolt");
    	addQuestionIfNotExists("In which sport is the term ‘goalkeeper’ used?", "Cricket", "Football", "Tennis", "Football");
    	addQuestionIfNotExists("What color flag means ‘stop’ in car racing?", "Yellow", "Red", "Green", "Red");
    	addQuestionIfNotExists("Which sport uses a bat and ball?", "Cricket", "Hockey", "Tennis", "Cricket");

    	// Space
    	addQuestionIfNotExists("What is the closest star to Earth?", "Sirius", "Sun", "Polaris", "Sun");
    	addQuestionIfNotExists("Which planet has rings?", "Venus", "Saturn", "Mars", "Saturn");
    	addQuestionIfNotExists("What galaxy is Earth located in?", "Milky Way", "Andromeda", "Whirlpool", "Milky Way");
    	addQuestionIfNotExists("What is the name of Earth’s natural satellite?", "Mars", "Moon", "Venus", "Moon");
    	addQuestionIfNotExists("Which planet is known as the Blue Planet?", "Mars", "Earth", "Neptune", "Earth");
    	addQuestionIfNotExists("Which planet is known for its red spot?", "Mars", "Jupiter", "Saturn", "Jupiter");
    	addQuestionIfNotExists("How long does Earth take to orbit the Sun?", "365 days", "30 days", "24 hours", "365 days");
    	addQuestionIfNotExists("Which planet is farthest from the Sun?", "Neptune", "Uranus", "Saturn", "Neptune");
    	addQuestionIfNotExists("Which planet is known as Earth’s twin?", "Venus", "Mars", "Mercury", "Venus");
    	addQuestionIfNotExists("What is the name of the first artificial satellite?", "Apollo 11", "Sputnik 1", "Voyager 1", "Sputnik 1");

    	// Miscellaneous
    	addQuestionIfNotExists("What is the national animal of India?", "Lion", "Tiger", "Elephant", "Tiger");
    	addQuestionIfNotExists("Which festival is known as the festival of lights?", "Holi", "Diwali", "Eid", "Diwali");
    	addQuestionIfNotExists("How many colors are there in a rainbow?", "6", "7", "8", "7");
    	addQuestionIfNotExists("Which is the largest mammal?", "Elephant", "Blue Whale", "Giraffe", "Blue Whale");
    	addQuestionIfNotExists("What instrument measures temperature?", "Barometer", "Thermometer", "Hygrometer", "Thermometer");
    	addQuestionIfNotExists("How many days are there in a leap year?", "365", "366", "364", "366");
    	addQuestionIfNotExists("Which month has 28 days?", "February", "January", "April", "February");
    	addQuestionIfNotExists("What is the national bird of India?", "Sparrow", "Peacock", "Crow", "Peacock");
    	addQuestionIfNotExists("Which organ helps us to breathe?", "Heart", "Lungs", "Liver", "Lungs");
    	addQuestionIfNotExists("Which planet do we live on?", "Mars", "Earth", "Venus", "Earth");

        // Add more questions here
    }

    private void addQuestionIfNotExists(String question, String opt1, String opt2, String opt3, String answer) {
        if (!questionRepository.existsByQuestion(question)) {
            Question q = new Question(question, opt1, opt2, opt3, answer);
            questionRepository.save(q);
        }
    }
}
