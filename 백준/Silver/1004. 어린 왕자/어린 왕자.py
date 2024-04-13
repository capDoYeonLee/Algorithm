T = int(input())
for _ in range(T):
    x1, y1, x2, y2 = map(int, input().split())
    n = int(input())
    count = 0
    
    for _ in range(n):
        c1, c2, r = map(int, input().split())
        d1 = (x1 - c1) ** 2 + (y1 - c2) ** 2
        d2 = (x2 - c1) ** 2 + (y2 - c2) ** 2
        cr = r ** 2
        
        if d1 > cr and d2 < cr:
            count += 1
        elif d1 < cr and d2 > cr:
            count += 1
        elif d1 < cr and d2 < cr:
            pass
        elif d2 > cr and d2 > cr:
            pass
    print(count)