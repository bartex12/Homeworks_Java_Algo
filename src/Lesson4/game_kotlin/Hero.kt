package Lesson4.game_kotlin

abstract class Hero(health: Int, var name: String, var damage: Int, var addHeal: Int) {

    var health: Int = 0
        protected set

    init {
        this.health = health
    }

    abstract fun hit(hero: Hero)

    abstract fun healing(hero: Hero)

    fun causeDamage(damage: Int) =
            if (health < 0)println("Герой уже мертвый!")else  health -= damage

//    fun causeDamage(damage: Int) {
//        if (health < 0) {
//            println("Герой уже мертвый!")
//        } else {
//            health -= damage
//        }
//    }

    fun addHealth(health: Int) {
        this.health += health
    }

    fun info() {
        println("Игрок " + name  + " -> " +
                (if (health < 0)" Герой погиб" else " Здоровье: " + health + " Сила: " + damage))
    }
}