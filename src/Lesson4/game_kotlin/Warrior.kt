package Lesson4.game_kotlin


class Warrior(health: Int, type: String, damage: Int, addHeal: Int) : Hero(health, type, damage, addHeal) {

    override fun hit(hero: Hero) {
        if (hero !== this) {
            if (this.health < 0) {
                println("Герой погиб и бить не может!")
            } else if (hero.health < 0) {
                println("Герой погиб и его нельзя бить!")
            } else {
                hero.causeDamage(damage)
                println(this.name + " нанес урон " + hero.name +
                        " оставив  здоровья " + hero.health)
            }

        }
    }

   override fun healing(hero: Hero) {
        println("Войны не умеют лечить!")
    }
}