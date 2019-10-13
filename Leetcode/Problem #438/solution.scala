import scala.collection.mutable.ListBuffer
object Solution {
  def find(s: String, p: String): List[Int] = {
    var count = p.length
    var compare = p.toArray.sorted

    var result = ListBuffer[Int]()

    for(i <- (0 to s.length - count)){
      var temper = s.slice(i, i + count)
      var temp = temper.toArray.sorted
      if(temp.sameElements(compare))
        result += i
    }
    return result.toList

  }
}
// Input: s: "cbaebabacd" p: "abc"
//
//
//