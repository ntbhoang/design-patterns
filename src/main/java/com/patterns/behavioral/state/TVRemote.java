package com.patterns.behavioral.state;


interface State {
    void doAction();
}

// Concrete State classes
class TVStartState implements State {
    public void doAction() {
        System.out.println("TV is turned ON");
    }
}

class TVStopState implements State {
    public void doAction() {
        System.out.println("TV is turned OFF");
    }
}

// Now we are ready to implement our Context object that will change its behavior based on its internal state.
class TVContext implements State {
    private State tvState;

    public void setState(State state) {
        this.tvState = state;
    }

    public void doAction() {
        this.tvState.doAction();
    }
}

class TVRemote {
    public static void main(String[] args) {
        TVContext context = new TVContext();
        State tvStartState = new TVStartState();
        State tvStopState = new TVStopState();

        context.setState(tvStartState);
        context.doAction();

        context.setState(tvStopState);
        context.doAction();
    }
}

// The benefits of using State pattern to implement polymorphic behavior is clearly visible.
// The chances of error are less and it’s very easy to add more states for additional behavior.
// Thus making our code more robust, easily maintainable and flexible.
// Also State pattern helped in avoiding if-else or switch-case conditional logic in this scenario.