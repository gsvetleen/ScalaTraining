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

//Runtime: 5168 ms, faster than 91.67% of Scala online submissions for Find All Duplicates in an Array.
//Memory Usage: 68.6 MB, less than 100.00% of Scala online submissions for Find All Duplicates in an Array.
object Solution {
    def findDuplicates(nums: Array[Int]): List[Int] = {
        def f(a:Array[Int],j:Int,n:Int,r:List[Int]):List[Int]={
            if(j==n) r
            else if(a(j)>1) f(a,j+1,n,j+1::r)
            else f(a,j+1,n,r)
        }
        var r=Array.ofDim[Int](nums.length)
        nums.map(x=>r(x-1)+=1)
        f(r,0,nums.length,Nil)
    }
}
