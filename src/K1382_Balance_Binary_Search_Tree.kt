fun balanceBST(root: TreeNode?): TreeNode? {
    //inorder put value into intArray
    //recursive generate BST by intArray
    var list = mutableListOf<Int>()
    getSortedArray(root, list)
    var arr = list.toIntArray()
    return getBST(arr, 0, arr.lastIndex);
}

fun getSortedArray(root: TreeNode?, list: MutableList<Int>) {
    if (root == null) return
    getSortedArray(root.left, list)
    list.add(root.`val`)
    getSortedArray(root.right, list)
}

fun getBST(arr: IntArray, left: Int, right: Int): TreeNode? {
    if (left > right) return null
    var mid = (left + right) / 2

    var root = TreeNode(arr[mid])
    root.left = getBST(arr, left, mid - 1)
    root.right = getBST(arr, mid + 1, right)
    return root
}