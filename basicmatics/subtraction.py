def subtract(a, b):
    return a - b


def main():
    print('Basic-Matics')
    print('Subtraction')
    print('')
    a = float(input('Input the two numbers yo want to subtract (press enter between one and another): '))
    b = float(input())

    res = subtract(a, b)
    if res.is_integer():
        res = int(res)
    print(f'The result is {res}')
