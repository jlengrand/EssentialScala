class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

class Counter(val init: Int){
  def inc(): Counter = {
    return new Counter(init + 1);
  }
  def dec(): Counter = {
    return new Counter(init - 1);
  }

  def count(): Int = init;

  def inc(value : Int = 1) : Counter = {
    return new Counter(init + value);
  }

  def dec(value : Int = 1) : Counter = {
    return new Counter(init - value);
  }

  def adjust(adder : Adder) :  Counter = {
    return new Counter(adder.add(init))
  }

}

new Counter(10).inc.dec.inc.inc.count
new Counter(10).dec(5).count
