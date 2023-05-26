import platform
from tkinter import *
from tkinter import messagebox
from tkinter.ttk import *
from subprocess import run

try:
    from PIL import Image, ImageTk
    from ttkthemes import ThemedStyle
    import distro
except ImportError or ModuleNotFoundError:
    print("Installing missing packages...")
    install_packages = run(['pip','install', 'Pillow>=9.4.0', 'ttkthemes>=3.2.2', 'distro>=1.8.0', '>/dev/null'])
    if install_packages.returncode != 0:
        print("Some packages are missing")
        print("Since Ubuntu 23.04 and Debian bullseye, you need to install python packages globally with APT")
        print("To continue, run: sudo apt install python3-pillow.imagetk python3-ttkthemes python3-distro")
        exit(1)
    else:
        print("Packages successfully installed")
        from PIL import Image, ImageTk
        from ttkthemes import ThemedStyle
        import distro

from basicmatics.gui.ops import *
from basicmatics.gui.settings import Settings


# Main GUI Class #
class GUI:
    def __init__(self):
        self.set = Settings()
        self.lang = self.set.language

        self.switch = Button(master=self.main_frame, text=self.lang['switch'], command=self.switch_div)
        self.entry1 = Entry(master=self.op_frame)
        self.entry2 = Entry(master=self.op_frame)
        self.calculate = Button(master=self.op_frame, text=self.lang['calc'])
        self.clean = Button(master=self.op_frame, text=self.lang['clean'], command=self.clean_func)
    os = platform.system()
    window = Tk()
    window.title("Basic-Matics")
    img = ImageTk.PhotoImage(Image.open("basicmatics/gui/icons/bsm.png"))
    style = ThemedStyle(window)
    if os == 'Linux':
        if distro.id() == 'ubuntu':
            style.theme_use('yaru') if float(distro.version(False)) >= 20.04 else style.theme_use('ubuntu')
        else:
            style.theme_use('arc')

    top_frame = Frame(master=window)
    main_frame = Frame(master=window)
    label_frame = Frame(master=main_frame)
    button_frame = Frame(master=main_frame)
    title = Label(master=label_frame, text="Basic-Matics", font=("Segoe UI", 18))
    op_frame = Frame(master=main_frame)

    def switch_div(self):
        if self.title['text'] == self.lang['divide_title']:
            self.title.config(text=self.lang['remainder_title'])
            self.calculate.config(
                command=lambda: self.show(calc(float(self.entry1.get()), float(self.entry2.get()), 'dvdr')))
        elif self.title['text'] == self.lang['remainder_title']:
            self.title.config(text=self.lang['divide_title'])
            self.calculate.config(command=lambda: self.show(calc(float(self.entry1.get()), float(self.entry2.get()), 'dvd')))

    def goback(self):
        self.title.config(text="Basic-Matics")
        self.button_frame.pack(side=LEFT, anchor=W)
        self.switch.pack_forget()
        self.op_frame.pack_forget()

    def clean_func(self):
        self.entry1.delete(0, END)
        self.entry2.delete(0, END)

    def show(self, a):
        messagebox.showinfo(self.lang['result'], a)
        copy = messagebox.askquestion(self.lang['result'], self.lang['copy'], icon='info')
        if copy == 'yes':
            self.window.clipboard_append(a)
            self.window.update()
        else:
            pass

    def base(self, s: str, op: str):
        self.button_frame.pack_forget()

        text = self.title['text']
        if s == self.lang['divide_title'] or self.lang['remainder_title']:
            self.title.config(text=s)
        else:
            self.title.config(text=text + s)

        if op == 'dvd':
            self.switch.pack(pady=5)

        self.op_frame.pack(pady=5)
        self.entry1.pack(side=LEFT, padx=2.5)
        self.entry2.pack(side=LEFT, padx=2.5)
        self.calculate.pack(side=LEFT, padx=2.5)
        self.calculate.config(command=lambda: self.show(calc(float(self.entry1.get()), float(self.entry2.get()), op)))
        self.clean.pack(side=LEFT, padx=2.5)

    def main(self):
        self.top_frame.pack(side=TOP, fill=X, anchor=N, expand=True)
        self.main_frame.pack(side=TOP, expand=True, anchor=CENTER)
        self.label_frame.pack(pady=20, expand=True)
        self.button_frame.pack(pady=10)

        icon = Label(master=self.label_frame, image=self.img, width=64)
        icon.image = self.img
        icon.pack(expand=True, anchor="center")

        self.window.iconphoto(True, self.img)
        self.title.pack(expand=True)

        back_img = ImageTk.PhotoImage(Image.open("basicmatics/gui/icons/back.png"))
        back = Button(master=self.top_frame, image=back_img, command=self.goback)
        back.image = back_img
        back.pack(side=LEFT, anchor=W)

        divide = Button(master=self.button_frame, text=self.lang['divide'],
                        command=lambda: self.base(self.lang['divide_title'], 'dvd'))
        divide.pack(side="left", padx=5, expand=True)

        multiplicate = Button(master=self.button_frame, text=self.lang['multiplicate'],
                              command=lambda: self.base(self.lang['multiplicate_title'], 'mtp'))
        multiplicate.pack(side="left", padx=5, expand=True)

        add = Button(master=self.button_frame, text=self.lang['add'],
                     command=lambda: self.base(self.lang['add_title'], 'add'))
        add.pack(side="left", padx=5, expand=True)

        subtract = Button(master=self.button_frame, text=self.lang['subtract'],
                          command=lambda: self.base(self.lang['subtract_title'], 'sub'))
        subtract.pack(side="left", padx=5, expand=True)

        set_img = ImageTk.PhotoImage(Image.open("basicmatics/gui/icons/settings.png"))
        set_button = Button(master=self.top_frame, image=set_img,
                            command=lambda: self.set.settings(self.window, self.img))
        set_button.image = set_img
        set_button.pack(expand=True, anchor=E)

        self.window.mainloop()


if __name__ == "__main__":
    GUI().main()
