from basicmatics.division import main as division
from basicmatics.multiplication import main as multiplication
from basicmatics.subtraction import main as subtraction
from basicmatics.addition import main as addition


def restart():
    home = input('Do you want to return to main page? [y/n]')
    if home == 'y':
        main()
    elif home == 'n':
        print('Exiting...')
        exit(0)
    else:
        print('Wrong value entered, exiting...')
        exit(1)


def main():
    print('Basic-Matics')
    print('Choose operation: ')
    op = input('Division [d], Multiplication [m], Addition [a] or Subtraction [s] ')

    if op == 'd':
        division()
        restart()
    elif op == 'm':
        multiplication()
        restart()
    elif op == 'a':
        addition()
        restart()
    elif op == 's':
        subtraction()
        restart()


main()
