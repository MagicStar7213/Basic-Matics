import platform
import tkinter as tk
from tkinter import *
from tkinter.ttk import *

from PIL import Image, ImageTk
from ttkthemes import ThemedStyle


def base(s: str):
    text = title['text']
    title.config(text=text+s)

    op_frame = Frame(master=main_frame)
    op_frame.pack(pady=10)

    entry1 = Entry(master=op_frame)
    entry1.pack(side=LEFT, padx=2.5)

    entry2 = Entry(master=op_frame)
    entry2.pack(side=LEFT, padx=2.5)

    calculate = Button(master=op_frame, text='Calculate')
    calculate.pack(side=LEFT, padx=2.5)

    clean = Button(master=op_frame, text='Calculate')
    clean.text = 'Clean'
    clean.pack(side=LEFT, padx=2.5)


os = platform.system()
window = tk.Tk()

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

back_img = ImageTk.PhotoImage(Image.open("icons/back.png"))
back = Button(master=top_frame, image=back_img)
back.image = back_img
back.pack(side=LEFT, anchor=W)

set_img = ImageTk.PhotoImage(Image.open("icons/settings.png"))
set_button = Button(master=top_frame, image=set_img)
set_button.image = set_img
set_button.pack(expand=True, anchor=E)

title = Label(master=label_frame, text="Basic-Matics", font=("Segoe UI", 18))
title.pack(expand=True)

divide = Button(master=button_frame, text="Divide")
divide.pack(side="left", padx=5, expand=True)

multiplicate = Button(master=button_frame, text="Multiplicate", command=base("\n- Multiplication -"))
multiplicate.pack(side="left", padx=5, expand=True)

add = Button(master=button_frame, text="Add Up", command=base("\n- Addition -"))
add.pack(side="left", padx=5, expand=True)

subtract = Button(master=button_frame, text="Subtract", command=base("\n- Subtraction -"))
subtract.pack(side="left", padx=5, expand=True)

window.mainloop()
