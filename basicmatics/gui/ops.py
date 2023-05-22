from basicmatics.data.settings import *

aprox = get_aprox()


def is_int(number: float):
    if number.is_integer():
        return int(number)
    else:
        return number


def is_aprox(number: float):
    if aprox == 1:
        return round(number, 3)
    else:
        return number


def calc(number1: float, number2: float, clc: str):
    if clc == 'dvd':
        return is_aprox(is_int(number1/number2))
    elif clc == 'dvdr':
        return is_aprox(is_int(number1%number2))
    elif clc == 'mtp':
        return is_aprox(is_int(number1*number2))
    elif clc == 'sub':
        return is_aprox(is_int(number1-number2))
    elif clc == 'add':
        return is_aprox(is_int(number1+number2))
