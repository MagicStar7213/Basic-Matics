def add_up(a, b):
    return a + b


def main():
    print('Basic-Matics')
    print('--Addition--')
    print('')
    a = float(input('Input the two numbers yo want to add up (press enter between one and another): '))
    b = float(input())

    res = add_up(a, b)
    if res.is_integer():
        res = int(res)
    print(f'The result is {res}')
