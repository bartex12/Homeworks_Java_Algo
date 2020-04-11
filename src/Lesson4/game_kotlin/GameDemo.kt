package Lesson4.game_kotlin

import java.util.*

    fun main() {

        val randomStep = Random()    //чей ход
        val randomHealing = Random() //кого лечить
        val randomHiting = Random()  //кого мочить

        val team1 = arrayOf(Warrior(250, "Тигрил", 50, 0),
                            Assasin(150, "Акали", 70, 0),
                            Doctor(120, "Жанна", 0, 60))

        val team2 = arrayOf(Warrior(290, "Минотавр", 60, 0),
                            Assasin(160, "Джинкс", 90, 0),
                            Doctor(110, "Зои", 0, 80))

        var end:Boolean
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
                    //Сейчас в атаке team1 и мы  проверяем, текущий игрок - это доктор?
                    if (team1[i] is Doctor) {
                        println("В игре доктор по имени ${team1[i].name} из команды team1")
                        //проверяем, а жив ли доктор
                        if (team1[i].health < 0) {
                            //если доктор не жив, выводим текст
                            println("Доктор ${team1[i].name} уже погиб ")
                        } else {
                            //если доктор жив, то он может дать здоровья какому то игроку своей команды
                            //сначала выбираем такого игрока
                            val numToDoctorTeam1 = randomHealing.nextInt(2)
                            //затем проверяем, а жив ли этот игрок
                            if (team1[numToDoctorTeam1].health < 0) {
                                //если он уже погиб, выводим текст
                                println("Игрок ${team1[numToDoctorTeam1].name } погиб и врач ему не нужен!")
                                // а если игрок team1 жив
                            } else {
                                // то доктор лечит  этого игрока
                                team1[i].healing(team1[numToDoctorTeam1])
                                println("Игрок ${team1[numToDoctorTeam1].name}" +
                                        " получил здоровья ${team1[i].addHeal}")
                            }
                        }
                        //если игрок team1 - это НЕ доктор, значит он игрок
                    } else {
                        println("В игре игрок ${(i + 1)} по имени ${team1[i].name} из команды team1")
                        //и тогда проверяем: уровень его здоровья < 0 ?
                        if (team1[i].health < 0) {
                            //если здоровья < 0, то выводим текст, что он вне игры
                            println("Игрок ${team1[i].name} погиб и бить не может!")
                            //если же здоровья у игрока team1 > 0
                        } else {
                            //тогда сначала выбираем игрока team2
                            val numTeam2 = randomHiting.nextInt(3)
                            // а затем проверяем уровень его здоровья
                            if (team2[numTeam2].health < 0) {
                                //если здоровья < 0, тогда выводим текст, что он погиб
                                println("Игрок ${team1[numTeam2].name} погиб и его нельзя бить!")
                                //если же здоровья > 0, тогда игроки вступают в схватку
                            } else {
                                //а именно, игрок team1 наносит урон игроку team2
                                team1[i].hit(team2[numTeam2])
                            }
                        }
                    }
                    //случайным образом выбрали атакующую команду -
                    // если выпадает 0 - в атаке team1, если 1 = в атаке team2 (передаём ей ход)
                } else {
                    //если игрок team2 - это доктор, то он может дать здоровья какому то игроку своей команды
                    if (team2[i] is Doctor) {
                        println("В игре доктор по имени ${team2[i].name} из команды team2")
                        //проверяем, а жив ли доктор
                        if (team2[i].health < 0) {
                            //если доктор не жив, выводим текст
                            println("Доктор ${team2[i].name} уже погиб")
                        } else {
                            //если доктор жив, то он может дать здоровья какому то игроку своей команды
                            //сначала выбираем такого игрока
                            val numToDoctorTeam2 = randomHealing.nextInt(2)
                            //затем проверяем, а жив ли этот игрок
                            if (team2[numToDoctorTeam2].health < 0) {
                                //если он уже погиб, выводим текст
                                println("Игрок ${team2[numToDoctorTeam2].name} погиб и врач ему не нужен!")
                                // а если игрок team2 жив
                            } else {
                                // то доктор лечит  этого игрока
                                team2[i].healing(team2[numToDoctorTeam2])
                                println("Игрок ${team2[numToDoctorTeam2].name}  получил здоровья ${team2[i].addHeal}")
                            }
                        }
                        //если игрок team2 - это НЕ доктор, значит он игрок
                    } else {
                        println("В игре игрок ${i + 1} по имени  ${team2[i].name} из команды team2")
                        //и тогда проверяем: уровень его здоровья < 0 ?
                        if (team2[i].health < 0) {
                            //если здоровья < 0, то выводим текст, что он вне игры
                            println("Игрок ${team2[i].name} погиб и бить не может!")
                            //если же здоровья у игрока team2 > 0
                        } else {
                            //тогда сначала выбираем игрока team1
                            val numTeam1 = randomHiting.nextInt(3)
                            // а затем проверяем уровень его здоровья
                            if (team1[numTeam1].health < 0) {
                                //если здоровья < 0, тогда выводим текст, что он погиб
                                println("Игрок ${team1[numTeam1].name} погиб и его нельзя бить!")
                                //если же здоровья > 0, тогда игроки вступают в схватку
                            } else {
                                //а именно, игрок team2 наносит урон игроку team1
                                team2[i].hit(team1[numTeam1])
                            }
                        }
                    }
                }
            }

            println("---------------")
            println("Итоги раунда ${jj + 1}")

            var numberTeam1 = 0
            for (t1 in team1) {
                if (t1.health >= 0) {
                    numberTeam1++
                }
            }
            println("В команде team1 осталось $numberTeam1 игроков")

            var numberTeam2 = 0
            for (t2 in team2) {
                if (t2.health >= 0) {
                    numberTeam2++
                }
            }
            println("В команде team2 осталось $numberTeam2 игроков")

            if (numberTeam1 == 0 && numberTeam2 != 0) {

                end = true

                println("")
                println("Итоги игры")
                println("//////////////////////")
                println("Выиграла команда team2")
                println("//////////////////////")
                println("")
                var s = ""
                for (t2 in team2) {
                    s += "" + t2.name + "\t"
                }
                println("Имена победителей из команды team2:\n $s")

            } else if (numberTeam2 == 0 && numberTeam1 != 0) {

                end = true

                println("")
                println("Итоги игры")
                println("//////////////////////")
                println("Выиграла команда team1")
                println("//////////////////////")
                println("")
                var s = ""
                for (t1 in team1) {
                    s += "" + t1.name + "\t"
                }
                println("Имена победителей из команды team1: \n $s")

            } else {
                end = false
            }
            println("")

            //увеличиваем переменнную номера раунда
            jj++

        } while (!end)

        println("---------------")

        for (t1 in team1) {
            t1.info()
        }

        for (t2 in team2) {
            t2.info()
        }

    }

