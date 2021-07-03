from typing import Counter, List

def cut_off_rank(cut_off: int, scores: List[int]) -> int:

    counts = Counter(scores)

    lvlups = 0
    score = 100

    while score > 0 and lvlups < cut_off:
        lvlups += counts[score]
        score -= 1

    # now either lvlups >= cut_off (have enough players at least cut_off rank),

    # or score = 0 (every non-zero player levels up)
    return lvlups

if __name__ == '__main__':
    cut_off = int(input())
    scores = [int(x) for x in input().split()]
    res = cut_off_rank(cut_off, scores)
    print(res)