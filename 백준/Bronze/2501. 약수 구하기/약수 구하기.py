N,k = map(int, input().split())
arr = []

for i in range(1, N+1):
    if N % i == 0:
        arr.append(i)

if len(arr) > k-1:
  print(arr[k-1])
else:
  print(0)
