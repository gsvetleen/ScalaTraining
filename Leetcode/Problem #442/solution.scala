import scala.collection.mutable.ListBuffer
object Solution {
  def find(nums: Array[Int]): List[Int] = {
    var result = new ListBuffer[Int]()
    if(nums.size == 0)
      return result.toList
    val numbers = nums.sorted
    var prev = 0
    for(i <- 0 until numbers.size){
      var temp: Int = numbers(i)
      if(prev != 0 && temp == prev)
        result += temp;
      prev = temp;
    }
    return result.toList
  }
}
//Example: Input: [4,3,2,7,8,2,3,1]
//
//
