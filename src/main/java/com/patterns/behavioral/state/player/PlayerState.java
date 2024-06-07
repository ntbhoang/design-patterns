package com.patterns.behavioral.state.player;



interface PlayerState {
    public static final String PLAYER_IS_LOCKED = "Player is locked";
    void clickPlay();
    void clickNext();
    void clickPrevious();
    void clickLock();
}

// Concrete State classes
class PlayingState implements PlayerState {
    public void clickPlay() {
        System.out.println("Player is already playing");
    }

    public void clickNext() {
        System.out.println("Next song is playing");
    }

    public void clickPrevious() {
        System.out.println("Previous song is playing");
    }

    public void clickLock() {
        System.out.println(PLAYER_IS_LOCKED);
    }
}


class LockedState implements PlayerState {


    public void clickPlay() {
        System.out.println(PLAYER_IS_LOCKED);
    }

    public void clickNext() {
        System.out.println(PLAYER_IS_LOCKED);
    }

    public void clickPrevious() {
        System.out.println(PLAYER_IS_LOCKED);
    }

    public void clickLock() {
        System.out.println("Player is unlocked");
    }
}

// Now we are ready to implement our Context object that will change its behavior based on its internal state.
class PlayerContext implements PlayerState {
    private PlayerState playerState;

    public void setState(PlayerState state) {
        this.playerState = state;
    }

    public void clickPlay() {
        this.playerState.clickPlay();
    }

    public void clickNext() {
        this.playerState.clickNext();
    }

    public void clickPrevious() {
        this.playerState.clickPrevious();
    }

    public void clickLock() {
        this.playerState.clickLock();
    }
}

class Player {
    public static void main(String[] args) {
        PlayerContext context = new PlayerContext();
        PlayerState playingState = new PlayingState();
        PlayerState lockedState = new LockedState();

        context.setState(playingState);
        context.clickPlay();
        context.clickNext();
        context.clickPrevious();
        context.clickLock();

        context.setState(lockedState);
        context.clickPlay();
        context.clickNext();
        context.clickPrevious();
        context.clickLock();
    }
}
