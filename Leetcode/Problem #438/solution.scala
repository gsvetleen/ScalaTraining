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

// Runtime: 1496 ms, faster than 80.00% of Scala online submissions for Find All Anagrams in a String.
// Memory Usage: 55.3 MB, less than 100.00% of Scala online submissions for Find All Anagrams in a String.
object Solution {
    def findAnagrams(s: String, p: String): List[Int] = {
        if(s.length<p.length) return List()
        var pc = Array.ofDim[Int](26)
        p.map(c=>pc(c.toInt-97)+=1)
        def f(a:Array[Int]):Int=a.zip(pc).map{x=>scala.math.abs(x._1-x._2)}.reduce((x,y)=>x+y)        
        var sc = Array.ofDim[Int](26)
        s.substring(0,p.length).map(c=>sc(c.toInt-97)+=1)        
        var res:List[Int] = Nil
        var j=0
        if(f(sc)==0) res = j :: res
        j+=1
        while(j<=s.length-p.length){
            sc(s(j-1).toInt-97)-=1
            sc(s(j+p.length-1).toInt-97)+=1
            if(f(sc)==0) res = j :: res
            j+=1
        }
        res
    }
}
