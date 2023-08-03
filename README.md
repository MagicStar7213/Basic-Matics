# Basic-Matics #
<!-- Badges -->
![Python](https://img.shields.io/badge/-Python-yellow?labelColor=blue&logo=python&logoColor=white&style=flat-square)
![GitHub Workflow Status (with event)](https://img.shields.io/github/actions/workflow/status/magicstar7213/basic-matics/python-package.yml?logo=github&style=flat-square)
![Release](https://img.shields.io/github/v/release/magicstar7213/basic-matics?logo=github&sort=semver&style=flat-square)
![License](https://img.shields.io/github/license/magicstar7213/basic-matics?logo=github&style=flat-square)

This is a rewrite of my Basic-Matics app to Python

This is the start of a migration from my original app written in Kotlin to Python, as I found many bugs and
I want to rewrite it in a simpler way.

## Usage ##
To start the app, from the home directory, run:
```shell
python -m basicmatics
```
or python3 if you're in UNIX.

This is a very simple app, and it is everything clear when you run it.

It is pretty clear and intuitive, so you won't have problem.

## Installation ##
In case you want it installed on your system, you'll need Python 3.7 or higher and Tkinter for building this app.
### UNIX / Linux ###
#### Configuration ####
First, install the Python Tkinter module:

##### Debian / Ubuntu #####
You'll need Debian Buster / Ubuntu 18.04 (Bionic) or higher
```shell
sudo apt install python3-tk python3-pil.imagetk python3-ttkthemes python3-distro
```
##### Fedora #####
You'll need Fedora 29 or higher, or update your python3 package
```shell
sudo dnf install python3-tkinter
```
##### RHEL / CentOS / Oracle Linux #####
```shell
yum install tkinter
```
##### Arch / Manjaro #####
If you have python 3.6 installed, update it with
```shell
sudo pacman -S python
```
Then, install tkinter:
```shell
sudo pacman -S tk
```

#### Building ####
Then, install python package `build`:

```shell
pip3 install --upgrade build
```

Then, `cd` to the project directory and run

```shell
python3 -m build && pip3 install basicmatics-$VERSION-py3-none-any.whl
```

### Windows ###
You just need to install build module

```shell
pip install --upgrade build
```

Then, `cd` to the project directory and run

```shell
python -m build && pip install basicmatics-$VERSION-py3-none-any.whl
```

Now it's successfully installed!
