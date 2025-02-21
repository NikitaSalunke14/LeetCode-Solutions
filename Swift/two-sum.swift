class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var solution = [Int]()
        (0..<nums.count).forEach { leftIndex in
            let subArray = nums.suffix(from: leftIndex + 1)
            let possibleValue = target - nums[leftIndex]
            if let rightIndex = subArray.firstIndex(where: { item in
                item == possibleValue
            })
            {
                solution = [leftIndex, rightIndex]
            }
        }

        return solution
    }
}

