import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._
object Solution {
  def Order(matrix: Array[Array[Int]]): List[Int] = {
    var result = ListBuffer[Int]()
    if(matrix.length == 0)
      return result.toList
    var top = 0
    var bottom = matrix.length-1
    var left = 0
    var right = matrix(0).length-1

    while(true){
      for(i <- left to right)
        result += matrix(left)(i)
      top += 1
      if(left > right || top > bottom)
        return result.toList

      for(i <- top to bottom)
        result += matrix(i)(right)
      right -= 1
      if(left > right || top > bottom)
        return result.toList

      for(i <- (right to left by -1))
        result += matrix(bottom)(i)
      bottom -= 1
      if(left > right || top > bottom)
        return result.toList

      for(i <- (bottom to top by -1))
        result += matrix(i)(left)
      left += 1
      if(left > right || top > bottom)
        return result.toList

    }

    return result.toList
  }
}

//Input:[[ 1, 2, 3 ],[ 4, 5, 6 ],[ 7, 8, 9 ]]
//