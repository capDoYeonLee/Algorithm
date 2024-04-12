num = int(input())
arr = list(map(int, input().split()))

a = sorted(arr)
b = sorted(arr, reverse=True)

find = []
for i in range(len(arr)):
    find.append(a[i] + b[i])

print(min(find))