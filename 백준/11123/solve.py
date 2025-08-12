from collections import deque
def bfs(graph, x, y, n, m):
    q = deque([[x, y]])
    dx = [-1, 1, 0, 0]
    dy = [0, 0, 1, -1]

    while q:
        cx, cy = q.popleft()
        graph[cx][cy] = '.'
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if graph[nx][ny] == '#':
                    q.appendleft([nx, ny])

def solve():
    n, m = map(int, input().split())
    graph = [list(input()) for _ in range(n)]
    cnt = 0

    for x in range(n):
        for y in range(m):
            if graph[x][y] == '#':
                bfs(graph, x, y, n, m)
                cnt += 1
    print(cnt)
for i in range(int(input())):
    solve()