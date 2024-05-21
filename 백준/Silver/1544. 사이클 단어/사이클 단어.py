from collections import deque

def rotate_word(arr1, arr2):
    if len(arr1)!=len(arr2): return arr2
    arr2 = deque(arr2)
    
    for _ in range(len(arr2)):
        arr2.rotate(1)
        t = ''.join(arr2)
        if arr1==t: return t
    
    return ''.join(arr2)


n = int(input())
arr = [input() for _ in range(n)]

for i in range(n):
    for j in range(i,n):
        if arr[i]!=arr[j]:
            arr[j] = rotate_word(arr[i], arr[j])

print(len(set(arr)))