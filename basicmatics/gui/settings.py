from tkinter import *
from tkinter.ttk import *

from basicmatics.data.settings import *


class Settings:

    def __init__(self):
        self.aprox = None
        self.lang = prefs['General']['lang']
        self.language = get_lang()

    def change_lang(self):
        if self.lang == 'en':
            set_lang('es')
        elif self.lang == 'es':
            set_lang('en')

    def change_aprox(self):
        set_aprox(1) if self.aprox == 1 else set_aprox(0)

    def settings(self, window: Tk, img):
        self.set_window = Toplevel(master=window)
        lang = StringVar(window)
        self.set_window.title("Settings")

        LANGS = [self.language['en'], self.language['es']]

        title_frame = LabelFrame(master=self.set_window)
        general_frame = Frame(master=self.set_window)
        custom_frame = Frame(master=self.set_window)

        title_frame.pack(anchor=CENTER)
        general_frame.pack(side=LEFT, pady=5, padx=2.5)
        custom_frame.pack(side=LEFT, pady=5, padx=2.5)

        set_title = Label(master=title_frame, text=self.language['settings_title'], font=("Segoe UI", 18))
        gen_title = Label(master=general_frame, text=self.language['general'], font=("Segoe UI", 15))
        custom_title = Label(master=custom_frame, text=self.language['custom'], font=("Segoe UI", 15))
        img_title = Label(master=title_frame, image=img)
        img_title.config(image=img)

        gen_title.pack()
        custom_title.pack()
        img_title.pack()
        set_title.pack()

        lang_choose = Combobox(general_frame, state='readonly', textvariable=lang, values=LANGS)
        if self.lang == 'es':
            lang_choose.current(1)
        elif self.lang == 'en':
            lang_choose.current(0)
        lang_choose.bind('<<ComboboxSelected>>', self.change_lang())
        lang_choose.pack()

        self.aprox = IntVar()
        aprox_button = Checkbutton(custom_frame, variable=self.aprox, text=self.language['aprox'])
        aprox_button.pack()