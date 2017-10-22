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

class Director(val firstName : String, val lastName : String, val yearOfBirth: Int){
  def name() = firstName + " " + lastName
}

val nolan = new Director("Christopher", "Nolan", 1970)

class Film(val name : String, val yearOfRelease : Int, val imdbRating : Double, val director : Director){
  def directorsAge() : Int =  yearOfRelease - director.yearOfBirth
  def isDirectedBy(anotherDirector : Director) : Boolean = anotherDirector == director

  def copy(name : String = "Memento", yearOfRelease : Int = 2000, imdbRating : Double = 8.5, director : Director = nolan): Film ={
    return new Film(name, yearOfRelease, imdbRating, director)
  }
}

val eastwood = new Director("Clint", "Eastwood", 1930)
eastwood.name()
val mcTiernan = new Director("John", "McTiernan", 1951)
val someBody = new Director("Just", "Some Body", 1990)
val memento = new Film("Memento", 2000, 8.5, nolan)
val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
val inception = new Film("Inception", 2010, 8.8, nolan)
val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
val invictus = new Film("Invictus", 2009, 7.4, eastwood)
val predator = new Film("Predator", 1987, 7.9, mcTiernan)
val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)
eastwood.yearOfBirth // should be 1930
dieHard.director.name // should be "John McTiernan"
invictus.isDirectedBy(nolan) // should be false
thomasCrownAffair.directorsAge()


highPlainsDrifter.copy(name = "L'homme des hautes plaines")
// returns Film("L'homme des hautes plaines", 1973, 7.7, /* etc */)
thomasCrownAffair.copy(yearOfRelease = 1968, director = new Director("Norman", "Jewison", 1926))
// returns Film("The Thomas Crown Affair", 1926, /* etc */)
inception.copy().copy().copy().director.yearOfBirth
// returns a new copy of `inception`

class Counter(val init: Int){

}