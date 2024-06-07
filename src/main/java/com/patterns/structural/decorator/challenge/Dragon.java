package com.patterns.structural.decorator.challenge;

class Bird
{
    public int age;

    public String fly()
    {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard
{
    public int age;

    public String crawl()
    {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon
{
    private int age;
    private Bird bird;
    private Lizard lizard;

    public void setAge(int age) {
        this.age = (age > 1 ) && (age < 10) ? age : 0;
    }

    public String fly() {
        bird.age = age;
        return bird.fly();
    }

    public String crawl() {
        lizard.age = age;
        return lizard.crawl();
    }
}
