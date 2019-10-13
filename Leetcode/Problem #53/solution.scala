object Solution {
  def Array(nums: Array[Int]): Int = {
    var max = Int.MinValue
    var currentMax = 0

    for(i <- nums){
      if(currentMax < 0)
        currentMax = i
      else
        currentMax += i

      if(currentMax > max)
        max = currentMax
    }
    return max

  }
}

// Example -> Input: [-2,1,-3,4,-1,2,1,-5,4],
//