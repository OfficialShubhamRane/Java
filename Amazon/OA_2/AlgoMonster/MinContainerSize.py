from math import inf
from typing import List

def min_container_size(item_sizes: List[int], days: int) -> int:

    end = len(item_sizes) + 1

    # boundary -> min total size
    dp = [inf for _ in range(end)]
    dp[0] = 0

    for day in range(1, days + 1):
        dp_ = [inf for _ in range(end)]
        for left in range(end - 1):
            mx = -inf
            for right in range(left + 1, end):
                mx = max(mx, item_sizes[right - 1])
                dp_[right] = min(dp_[right], dp[left] + mx)
        dp = dp_
    return dp[-1]

if __name__ == '__main__':
    item_sizes = [int(x) for x in input().split()]
    days = int(input())
    res = min_container_size(item_sizes, days)
    print(res)