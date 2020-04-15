package Lesson4.game_kotlin


internal class Doctor(heal: Int, name: String, damage: Int, addHeal: Int) : Hero(heal, name, damage, addHeal) {

    override fun hit(hero: Hero) {
        println("Доктор не может бить!")
    }

    override fun healing(hero: Hero) {
        hero.addHealth(addHeal)
    }
}