"""
A python implementation of a binary search algorithm
"""

def binary_search(_list, target): 
    """
    :param list _list: A sorted list of ints to search
    :param int target:
    :return bool: 1(True) if `target` is in `_list`, otherwise 0(False)
    """
    if len(_list) > 1: 
        list1, list2 = _list[0:len(_list)/2], _list[len(_list)/2:] 
        if list1[-1] >= target: 
            if len(list1) > 0: 
                return binary_search(list1, target) 
            else: 
                return 0
        else: 
            if len(list2) > 0: 
                return binary_search(list2, target) 
            else: 
                return 0
    else: 
        if _list[0] == target: 
            return 1 
        else: return 0


if __name__ == '__main__':
    a_list = [x for x in range(21)]
    print("The list {0}".format(a_list))
    print("Is 3 in the list?\n")
    if binary_search(a_list, 3):
        print("Yes\n")
    else:
        print("No\n")

    print("Is 59 in the list?\n")
    if binary_search(a_list, 59):
        print("Yes\n")
    else:
        print("No\n")

    print("Is 21 in the list?\n")
    if binary_search(a_list, 21):
        print("Yes\n")
    else:
        print("No\n")

