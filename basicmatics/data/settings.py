import os
import basicmatics.data.languages as languages
from configparser import ConfigParser
from typing import Any

path = os.path.expanduser('~')+'/.basicmatics'
file = path+'/settings.ini'
prefs = ConfigParser()

if not os.path.exists(path):
    os.makedirs(path)
if not os.path.exists(file):
    open(file, 'x')
    prefs['General'] = {'lang': 'en',
                        'aprox': 0}
    prefs.write(open(file, 'w'))

prefs.read(file)
lang = prefs['General']['lang']


def set_pref(section: str, key: str, value: Any):
    prefs.set(section, key, str(value))
    prefs.write(open(file, 'w'))


def get_pref(section: str, key: str) -> Any:
    return prefs[section][key]


def set_lang(lang: str):
    set_pref('General', 'lang', lang)
    prefs.write(open(file, 'w'))


def get_lang() -> dict:
    if prefs['General']['lang'] == 'es':
        return languages.ES
    elif prefs['General']['lang'] == 'en':
        return languages.EN


def set_aprox(apr: int):
    set_pref('General', 'aprox', apr)
    prefs.write(open(file, 'w'))


def get_aprox() -> int:
    return int(prefs['General']['aprox'])
