"""
 Given a positive integer n and you can do operations as follow:

    If n is even, replace n with n/2.
    If n is odd, you can replace n with either n + 1 or n - 1.

What is the minimum number of replacements needed for n to become 1? 
"""

def int_repl(n):
    b = bin(n)[2:]
    i = len(b) - 1
    count = 0
    while len(b) > 1:
        if b == '11':
            return count + 2
        else:
            b, count = iter_count(b, count)
        i -= 1
    return count

def iter_count(b, c):
    if b[-1] == '1' and b[-2] == '1':
         return bin(int(b, 2) + 1)[2:], c + 1
    elif b[-1] == '1' and b[-2] == '0':
        return b[:-1] + '0', c + 1
    else:
        return b[:-1], c + 1
