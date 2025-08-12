import math
import sys
from collections import deque
from itertools import chain, repeat

input = sys.stdin.readline

def tornado_move(N):
    order = deque([0, 1, 2, 3])
    lengths = list(chain.from_iterable(repeat(k, 2) for k in range(1, N)))
    lengths.append(N - 1)
    for length in lengths:
        d = order[0]
        for _ in range(length):
            yield d
        order.rotate(-1)

def rot(dr, dc):
    return -dc, dr

def rotate_mask(mask, times):
    times %= 4
    res = list(mask)
    for _ in range(times):
        res = [(*rot(dr, dc), p) for dr, dc, p in res]
    return res

def rotate_point(pt, times):
    dr, dc = pt
    for _ in range(times % 4):
        dr, dc = rot(dr, dc)
    return dr, dc

def inside(r, c, N):
    return 0 <= r < N and 0 <= c < N

def spread(r, c, d, graph, rotated_masks, rotated_alpha):
    global out_sand
    sand = graph[r][c]
    if sand == 0:
        return
    graph[r][c] = 0

    moved = 0
    for dr, dc, p in rotated_masks[d]:
        nr, nc = r + dr, c + dc
        w = (sand * p) // 100
        moved += w
        if inside(nr, nc, len(graph)):
            graph[nr][nc] += w
        else:
            out_sand += w

    adr, adc = rotated_alpha[d]
    nr, nc = r + adr, c + adc
    w = sand - moved
    if inside(nr, nc, len(graph)):
        graph[nr][nc] += w
    else:
        out_sand += w

if __name__ == "__main__":
    n = int(input())
    graph = [list(map(int, input().split())) for _ in range(n)]
    out_sand = 0
    sequence = [(0, -1), (1, 0), (0, 1), (-1, 0)]

    base = [
        (-2, 0, 2),
        (-1, 0, 7),
        (-1, 1, 1),
        (0, -2, 5),
        (1, 0, 7),
        (1, 1, 1),
        (2, 0, 2),
        (-1, -1, 10),
        (1, -1, 10),
    ]
    alpha = (0, -1)

    rotated_masks = [rotate_mask(base, k) for k in range(4)]
    rotated_alpha = [rotate_point(alpha, k) for k in range(4)]

    r = c = n // 2
    for d in tornado_move(n):
        dr, dc = sequence[d]
        r += dr
        c += dc
        spread(r, c, d, graph, rotated_masks, rotated_alpha)

    print(out_sand)
