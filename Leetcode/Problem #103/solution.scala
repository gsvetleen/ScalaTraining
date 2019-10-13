/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import scala.collection.mutable.Queue
import scala.collection.mutable.ListBuffer
object Solution {
  def Order(root: TreeNode): List[List[Int]] = {

    var depth = 0
    val holder: Queue[TreeNode] = Queue(root)
    val result = scala.collection.mutable.ListBuffer.empty[List[Int]]

    if(root == null)
      return result.toList
    while(!holder.isEmpty){
      var size = holder.size
      var temp = new ListBuffer[Int]()
      while(size > 0){
        var out = holder.dequeue()
        if(depth % 2 == 1)
          temp.insert(0, out.value);
        else
          temp += out.value;
        if(out.left != null)
          holder += out.left
        if(out.right != null)
          holder += out.right
        size -= 1
      }
      depth += 1
      println(temp.toList)
      result += temp.toList
    }
    return result.toList
  }
}
// Given binary tree [3,9,20,null,null,15,7]