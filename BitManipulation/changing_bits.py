def set(num, op):
    i = int(op[1])
    bit = int(op[2]) & 1
    if bit:
        # set ith bit to one
        num = num | (1 << i)
    else:
        # set ith bit to zero !!!!!
        num = num & (~(1 << i))
    return num

n, q = [int(i) for i in raw_input().split()]
a = int(raw_input(), base=2)
b = int(raw_input(), base=2)
c = a + b
changed = False
result = ''
for i in range(q):
    op = raw_input().split()
    if op[0] == 'set_a':
        a = set(a, op)
        changed = True
    elif op[0] == 'set_b':
        b = set(b, op)
        changed = True
    else:
        i = int(op[1])
        if changed:
            c = a + b
        changed = False
        result = result + str((c >> i) & 1)
print result
