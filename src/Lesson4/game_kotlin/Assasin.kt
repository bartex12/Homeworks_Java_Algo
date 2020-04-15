package Lesson4.game_kotlin

import java.util.*


class Assasin(heal: Int, name: String, damage: Int, addHeal: Int) : Hero(heal, name, damage, addHeal) {

    var cricitalHit: Int = 0
    var random = Random()

    init {
        this.cricitalHit = random.nextInt(20)
    }

    override fun hit(hero: Hero) {
        if (hero !== this) {
            if (health < 0) {
                println("Герой погиб и бить не может!")
            } else {
                hero.causeDamage(damage + cricitalHit)
            }
            println("${this.name} нанес урон ${hero.name}, оставив здоровья ${hero.health}")
        }
    }

        override fun healing(hero: Hero) {
            println("Убийцы не умеют лечить!")
        }
    }
