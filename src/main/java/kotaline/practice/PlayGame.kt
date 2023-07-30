package kotaline.practice

class PlayGame {
        var hadrecord : Boolean =  false;
        fun getChoise(): Any {
            println(" Please enter 1- Paper, 2 - Rock and 3 -  Scissor")
            var gameId = readln();
            return Game.getGameValue(gameId.toInt())
        }

    companion object {
        fun getChoise(): Any {

        }
    }
}

fun main() {
    var p : PlayGame = PlayGame()
   var gameType =   p.getChoise()


}
