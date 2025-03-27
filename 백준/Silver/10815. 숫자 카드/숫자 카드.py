N = map(int, input())
my_card = sorted(map(int, input().split()))
M = map(int, input())
num_card = list(map(int, input().split()))
answer = []

def binary_search(k, my_card, s, l):
    mid = (s+l) // 2
    if s > l:
        answer.append(str(0))
    elif k == my_card[mid]:
        answer.append(str(1))
    elif k > my_card[mid]:
        binary_search(k, my_card, mid+1, l)
    else:
        binary_search(k, my_card, s, mid-1)

for k in num_card:
    s = 0
    l = len(my_card)-1
    binary_search(k, my_card, s, l)

print(' '.join(answer))