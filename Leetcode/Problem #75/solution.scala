object Solution {
  def Colors(nums: Array[Int]): Unit = {
    var numZero = 0
    var numTwo = nums.length -1
    var i = 0
    while(i <= numTwo){
      if(nums(i) == 1)
        i += 1
      else if(nums(i) == 2){
        swap(nums, i, numTwo)
        numTwo -= 1
      }
      else if(nums(i) == 0){
        swap(nums, i, numZero)
        numZero += 1
        i += 1
      }

    }
  }

  def swap(nums: Array[Int], i: Int, num: Int): Unit = {
    var temp = nums(i)
    nums(i) = nums(num)
    nums(num) = temp
  }
}

// Example: Input: [2,0,2,1,1,0]