package Lesson4.game_kotlin

import java.util.*

    fun main() {

        val randomStep = Random()    //чей ход
        val randomHealing = Random() //кого лечить
        val randomHiting = Random()  //кого мочить

        //команда team1
        val team1 = arrayOf(Warrior(250, "Тигрил", 50, 0),
                            Assasin(150, "Акали", 70, 0),
                            Doctor(120, "Жанна", 0, 60))

        //команда team2
        val team2 = arrayOf(Warrior(290, "Минотавр", 60, 0),
                            Assasin(160, "Джинкс", 90, 0),
                            Doctor(110, "Зои", 0, 80))


        var end:Boolean  //флаг конца игры
        var jj = 0  //номер раунда
        //запускаем цикл который остановится, когда в какой либо команде не останется игроков
        do {
            println("************************")
            println("Раунд ${jj + 1}")
            // перебираем игроков
            for (i in team1.indices) {
                //случайным образом выбираем атакующую команду (передаём ей ход)
                // если выпадает 0 - в атаке team1, если 1 = в атаке team2
                if (randomStep.nextInt(2) == 0) {
                    //алгоритм одного раунда игры - в атаке team1
                    raundOfGame(team1, i, randomHealing, randomHiting, team2, "team1")
                } else {
                    //алгоритм одного раунда игры - в атаке team2
                    raundOfGame(team2, i, randomHealing, randomHiting, team1,"team2" )
                }
            }

            println("---------------")
            println("Итоги раунда ${jj + 1}")

            val numberTeam1 = getNumberTeamIs(team1, "team1")
            val numberTeam2 = getNumberTeamIs(team2, "team2")

            if (numberTeam1 == 0 && numberTeam2 != 0) {
                //показать победителей из team2
                end = showWinner(team2, "team2")
            } else if (numberTeam2 == 0 && numberTeam1 != 0) {
                //показать победителей из team1
                end = showWinner(team1, "team1")
            } else {
                end = false
            }
            println()

            //увеличиваем переменнную номера раунда
            jj++

        } while (!end)

        println("---------------")

        for (t1 in team1) {
            t1.info()
        }
        println()
        for (t2 in team2) {
            t2.info()
        }

    }

//показать победителей
private fun showWinner(team2: Array<Hero>,  str:String): Boolean {

    println()
    println("Итоги игры")
    println("//////////////////////")
    println("Выиграла команда $str")
    println("//////////////////////")
    println()
    var s = ""
    for (t2 in team2) {
        s += "${t2.name}\t"
    }
    println("Имена победителей из команды $str:\n $s")
    return true
}

//в команде осталось игроков
private fun getNumberTeamIs(team1: Array<Hero>, str:String): Int {
    var numberTeam1 = 0
    for (t1 in team1) {
        if (t1.health >= 0) {
            numberTeam1++
        }
    }
    println("В команде $str осталось $numberTeam1 игроков")
    return numberTeam1
}

//алгоритм одного раунда игры
private fun raundOfGame(
        attack: Array<Hero>, i: Int, randomHealing: Random,
        randomHiting: Random, defender: Array<Hero>, teamName:String) {
    //Сейчас в атаке attack и мы  проверяем, текущий игрок - это доктор?
    if (attack[i] is Doctor) {
        println("В игре доктор по имени ${attack[i].name} из команды ${teamName}")
        //проверяем, а жив ли доктор
        if (attack[i].health < 0) {
            //если доктор не жив, выводим текст
            println("Доктор ${attack[i].name} уже погиб ")
        } else {
            //если доктор жив, то он может дать здоровья какому то игроку своей команды
            //сначала выбираем такого игрока
            val numToDoctor = randomHealing.nextInt(2)
            //затем проверяем, а жив ли этот игрок
            if (attack[numToDoctor].health < 0) {
                //если он уже погиб, выводим текст
                println("Игрок ${attack[numToDoctor].name} погиб и врач ему не нужен!")
                // а если игрок team1 жив
            } else {
                // то доктор лечит  этого игрока
                attack[i].healing(attack[numToDoctor])
                println("Игрок ${attack[numToDoctor].name}" +
                        " получил здоровья ${attack[i].addHeal}")
            }
        }
        //если игрок attack - это НЕ доктор, значит он игрок
    } else {
        println("В игре игрок ${(i + 1)} по имени ${attack[i].name} из команды ${teamName}")
        //и тогда проверяем: уровень его здоровья < 0 ?
        if (attack[i].health < 0) {
            //если здоровья < 0, то выводим текст, что он вне игры
            println("Игрок ${attack[i].name} погиб и бить не может!")
            //если же здоровья у игрока attack > 0
        } else {
            //тогда сначала выбираем игрока defender
            val numTeamDefender = randomHiting.nextInt(3)
            // а затем проверяем уровень его здоровья
            if (defender[numTeamDefender].health < 0) {
                //если здоровья < 0, тогда выводим текст, что он погиб
                println("Игрок ${defender[numTeamDefender].name} погиб и его нельзя бить!")
                //если же здоровья > 0, тогда игроки вступают в схватку
            } else {
                //а именно, игрок attack наносит урон игроку defender
                attack[i].hit(defender[numTeamDefender])
            }
        }
    }
}

