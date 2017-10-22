class Person(first: String, last: String) {
  val firstName = first
  val lastName = last
  def name = firstName + " " + lastName
}
val dave = new Person("Dave", "Gurnell")
// dave: Person = Person@3ed12df7
dave.name
// res: String = Dave Gurnell

object Person{
  def apply(name: String): Person = {
    val parts = name.split(" ")
    return new Person(parts(0), parts(1))
  }
}

val john = Person("John Doe")
john.firstName