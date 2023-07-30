package kotaline.practice
enum class Game {
    ROCK,
    PAPER,
    SCISSORS,
    NONE;


    companion object {
        fun getGameValue(index: Int) : Game{
            for (game in Game.values()){
                if(game.ordinal == index) return game;
            }
            return NONE;
        }
    }

}
