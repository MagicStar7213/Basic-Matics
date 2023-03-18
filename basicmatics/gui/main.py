import platform
import tkinter as tk
from tkinter import *
from tkinter import messagebox
from tkinter.ttk import *


from PIL import Image, ImageTk
from ttkthemes import ThemedStyle

os = platform.system()
window = tk.Tk()
window.title("Basic-Matics")
style = ThemedStyle(window)
if os == 'Linux':
    distro = platform.freedesktop_os_release()
    if distro['ID'] == 'ubuntu':
        style.theme_use('yaru') if float(distro['VERSION_ID']) >= 20.04 else style.theme_use('ubuntu')
    else:
        style.theme_use('arc')

top_frame = Frame(master=window)
top_frame.pack(side=TOP, fill=X, anchor=N, expand=True)

main_frame = Frame(master=window)
main_frame.pack(side=TOP, expand=True, anchor=CENTER)

label_frame = Frame(master=main_frame)
label_frame.pack(pady=20, expand=True)

button_frame = Frame(master=main_frame)
button_frame.pack(pady=10)

img = ImageTk.PhotoImage(Image.open("icons/bsm.png"))
icon = Label(master=label_frame, image=img, width=64)
icon.image = img
icon.pack(expand=True, anchor="center")

window.iconphoto(True, img)

title = Label(master=label_frame, text="Basic-Matics", font=("Segoe UI", 18))
title.pack(expand=True)

op_frame = Frame(master=main_frame)


def goback():
    title.config(text="Basic-Matics")
    button_frame.pack(side=LEFT, anchor=W)
    op_frame.pack_forget()


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


entry1 = Entry(master=op_frame)
entry2 = Entry(master=op_frame)
calculate = Button(master=op_frame, text='Calculate')
clean = Button(master=op_frame, text='Clean', command=lambda: clean_func())


def clean_func():
    entry1.delete(0, END)
    entry2.delete(0, END)


def show(a):
    messagebox.showinfo("Result", a)
    copy = messagebox.askquestion("Result", "Do you want to copy it to the clipboard", icon='info')
    if copy == 'yes':
        window.clipboard_append(a)
        window.update()
    else:
        pass


def base(s: str, op: str):
    button_frame.pack_forget()

    text = title['text']
    title.config(text=text + s)

    op_frame.pack(pady=10)
    entry1.pack(side=LEFT, padx=2.5)
    entry2.pack(side=LEFT, padx=2.5)
    calculate.pack(side=LEFT, padx=2.5)
    calculate.config(command=lambda: show(calc(float(entry1.get()), float(entry2.get()), op)))
    clean.pack(side=LEFT, padx=2.5)


back_img = ImageTk.PhotoImage(Image.open("icons/back.png"))
back = Button(master=top_frame, image=back_img, command=lambda: goback())
back.image = back_img
back.pack(side=LEFT, anchor=W)

set_img = ImageTk.PhotoImage(Image.open("icons/settings.png"))
set_button = Button(master=top_frame, image=set_img)
set_button.image = set_img
set_button.pack(expand=True, anchor=E)

divide = Button(master=button_frame, text="Divide", command=lambda: base("\n - Division -", 'dvd'))
divide.pack(side="left", padx=5, expand=True)

multiplicate = Button(master=button_frame, text="Multiplicate", command=lambda: base("\n - Multiplication -", 'mtp'))
multiplicate.pack(side="left", padx=5, expand=True)

add = Button(master=button_frame, text="Add Up", command=lambda: base("\n - Addition -", 'add'))
add.pack(side="left", padx=5, expand=True)

subtract = Button(master=button_frame, text="Subtract", command=lambda: base("\n - Subtraction -", 'sub'))
subtract.pack(side="left", padx=5, expand=True)

window.mainloop()
