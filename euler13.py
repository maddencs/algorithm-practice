"""
Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.

Numbers are located in textfiles/euler13.txt
"""

import math


def do_math(file_name):
    with open(file_name) as f:
        numbers = f.readlines()
    sum_str = '0' * (len(numbers[0]) - 1)
    for number in numbers:
        sum_str = add(sum_str.rstrip(), number.rstrip())
    print("sum: " + sum_str[:10])
    return sum_str


def add(num1, num2):
    num1 = list(num1)
    num2 = list(num2)
    if len(num1) > len(num2):
        num2 = ['0' for i in range(len(num1) - len(num2))] + num2
    sum_list = list()
    i = len(num1) - 1
    carry = 0
    while i >= 0: 
        temp_sum = int(num1[i]) + int(num2[i]) + carry
        if temp_sum == 0:
            carry = 0
        else:
            carry = int(math.floor(math.log10(temp_sum)))
        sum_list.insert(0, str(temp_sum % 10))
        i -= 1
    if carry > 0:
        sum_list.insert(0, str(carry))
    return ''.join(sum_list)
        

if __name__ == '__main__':
    import sys
    file_name = sys.argv[1]
    do_math(file_name)
