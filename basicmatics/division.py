def divide(a, b):
    return a / b


def remainder(a, b):
    return a % b


def main():
    print('Basic-Matics')
    print('--Division--')
    print('')
    a = float(input('Input the two numbers yo want to operate (press enter between one and another): '))
    b = float(input())
    print('What do yo want to calculate?')
    ch = input('Quotient [q] or Remainder [r]: ')

    if ch == 'q':
        res = divide(a, b)
        if res.is_integer():
            res = int(res)
        print(f'The result is {res}')

    elif ch == 'r':
        res = remainder(a, b)
        if res.is_integer():
            res = int(res)
        print(f'The remainder is {res}')

    else:
        print('ERROR: incorrect input, exiting..')
        exit(1)
