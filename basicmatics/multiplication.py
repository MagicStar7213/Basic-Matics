def multiplicate(a, b):
    return a * b


def main():
    print(' Basic-Matics')
    print('Multiplication')
    print('')
    a = float(input('Input the two numbers yo want to multiplicate (press enter between one and another): '))
    b = float(input())

    res = multiplicate(a, b)
    if res.is_integer():
        res = int(res)
    print(f'The result is {res}')
