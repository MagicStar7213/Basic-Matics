from tkinter import *
from tkinter.ttk import *
from tkinter import messagebox

from basicmatics.data.settings import *


# Settings GUI class #
class Settings:

    def __init__(self):
        self.aprox: int = get_aprox()
        self.lang = lang
        self.language = get_lang()

    def change_lang(self):
        if self.lang_choose.get() == self.language['es']:
            set_lang('es')
        else:
            set_lang('en')
        messagebox.showinfo('Restart required', 'Restart is required for changes to take effect')
        set_restart(1)

    def change_aprox(self):
        if self.aprox_var.get() == 1:
            set_aprox(1)
        else:
            set_aprox(0)


    def settings(self, window: Tk, img):
        self.set_window = Toplevel(master=window)
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

        self.lang_choose = Combobox(general_frame, state='readonly', values=LANGS)
        if self.lang == 'es':
            self.lang_choose.current(1)
        elif self.lang == 'en':
            self.lang_choose.current(0)
        self.lang_choose.bind('<<ComboboxSelected>>', lambda e: self.change_lang())
        self.lang_choose.pack()

        self.aprox_var = IntVar()
        self.aprox_var.set(self.aprox)
        aprox_button = Checkbutton(general_frame, variable=self.aprox_var, text=self.language['aprox'],
                                   command=self.change_aprox)
        aprox_button.config(variable=self.aprox_var)
        aprox_button.pack()
