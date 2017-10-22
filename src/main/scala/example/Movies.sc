class Director(val firstName : String, val lastName : String, val yearOfBirth: Int){
  def name() = firstName + " " + lastName
}

object Director{
  def apply(firstName: String, lastName: String, yearOfBirth: Int): Director = {
    new Director(firstName, lastName, yearOfBirth)
  }
  def older(director1 : Director, director2: Director) : Director = {
    return if (director1.yearOfBirth > director2.yearOfBirth) director2 else director1;
  }
}

val nolan = new Director("Christopher", "Nolan", 1970)

class Film(val name : String, val yearOfRelease : Int, val imdbRating : Double, val director : Director){
  def directorsAge() : Int =  yearOfRelease - director.yearOfBirth
  def isDirectedBy(anotherDirector : Director) : Boolean = anotherDirector == director

  def copy(name : String = "Memento", yearOfRelease : Int = 2000, imdbRating : Double = 8.5, director : Director = nolan): Film ={
    return new Film(name, yearOfRelease, imdbRating, director)
  }
}

object Film{
  def apply(name : String, yearOfRelease : Int, imdbRating : Double, director : Director): Film = {
    new Film(name, yearOfRelease, imdbRating, director)
  }
  def highestRating(film1: Film, film2: Film) : Film = {
    if(film1.imdbRating > film2.imdbRating) film1 else film2
  }
  def oldestDirectorAtTheTime(film1: Film, film2: Film) : Director = {
    Director.older(film1.director, film2.director)
  }
}

val eastwood = new Director("Clint", "Eastwood", 1930)

Director.older(eastwood, nolan).yearOfBirth

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