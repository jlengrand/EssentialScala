println("Welcome to the Scala worksheet".toUpperCase)

class Cat(val name : String, val color: String, val food: String){
}

val oswald = new Cat("Oswald", "Black", "Milk")
val henderson = new Cat("Henderson", "Ginger", "Chips")
val quentin = new Cat("Quentin", "Tabby and white", "Curry")

oswald.color

object ChipShop{
  def willServe(cat : Cat): Boolean ={
    return cat.food == "Chips"
  }
}

ChipShop.willServe(henderson)
ChipShop.willServe(oswald)
