"""
given a string find the longest valid parentheses pair

ex.
    input = "abc(de)(fgh)"
    output = 5  # (fgh)

    input = "abc(de(fg)hi)"
    output = 10  # (de(fg)hi)

    input = "ab("
    output = False
"""

def find_long(string):
    opens = list()
    i = 0
    longest = 0
    while i < len(string):
        c = string[i]
        if c == "(":
            opens.append(i)
        elif c == ")":
            if len(opens) > 0:
                open_index = opens.pop()
                length = i - open_index + 1
                if length > longest:
                    longest = length
            else:
                return False
        i += 1
    return longest or False



assert find_long("ab(cd)(efg)") == 5
assert find_long("ab((cd))") == 6
assert not find_long("ab(cd")
