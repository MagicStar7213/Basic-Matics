def is_int(a: float):
    if a.is_integer():
        return int(a)
    else:
        return a


def calc(a: float, b: float, clc: str):
    if clc == 'dvd':
        return is_int(a/b)
    elif clc == 'dvdr':
        return is_int(a%b)
    elif clc == 'mtp':
        return is_int(a*b)
    elif clc == 'sub':
        return is_int(a-b)
    elif clc == 'add':
        return is_int(a+b)
