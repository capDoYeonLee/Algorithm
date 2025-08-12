import sys

num = int(sys.stdin.readline())

for i in range(num):
    text = sys.stdin.readline()
    stack = []
    for j in text:
        if j == '(':
            stack.append(j)
        elif j == ')':
            if stack:
                stack.pop()    
            else:
                print("NO")
                break
    else:
        if not stack:
            print("YES")
        else:
            print("NO")
            
    