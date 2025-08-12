import sys
import queue


num = int(sys.stdin.readline())
q = queue.Queue()

for i in range(1, num+1):
    q.put(i)

while (q.qsize() != 1):
    q.get()
    x = q.get()          
    q.put(x) 

print(q.get())
    



