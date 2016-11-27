'''
Flavius Josephus was a roman historian of Jewish origin. During the Jewish-Roman wars of the first century AD,
he was in a cave with fellow soldiers, 40 men in all, surrounded by enemy Roman troops.
They decided to commit suicide by standing in a ring and counting off each third man.
Each man so designated was to commit suicide. Josephus, not wanting to die, managed to
place himself in the position of the last survivor.

In the general version of the problem, there are n soldiers numbered from 1 to n and each k-th
soldier will be eliminated. The count starts from the first soldier. What is the number of the last survivor?
'''

from collections import deque

def josephus(n, k):
    # soldiers n-1, n-2 ...... 2, 1, 0
    soldiers = deque(reversed(range(n)))
    while len(soldiers) > 1:
        # rotate soldiers k-1 steps
        soldiers.rotate(k-1)
        # kth soldier is popped (killed)
        soldiers.pop()
    return soldiers.pop() + 1

print josephus(1000, 3)