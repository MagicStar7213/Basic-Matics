# Basic-Matics #
![JDK](https://img.shields.io/badge/-Kotlin-b124ea?style=flat-square&logo=kotlin&labelColor=grey)
![IntelliJ IDEA](https://img.shields.io/badge/-IntelliJ-b5339a?style=flat-square&logo=intellij-idea&labelColor=grey)
![GitHub release](https://img.shields.io/github/v/release/MagicStar7213/Basic-Matics?include_prereleases&style=flat-square)
![GitHub license](https://img.shields.io/github/license/MagicStar7213/Basic-Matics?style=flat-square)
![Maven Release](https://img.shields.io/maven-central/v/io.github.magicstar7213/basic-matics?style=flat-square&logo=apachemaven&logoColor=red&color=red)

[![News](https://img.shields.io/badge/NOTICIAS-7-00d8ff?style=social&logo=googlenews&logoColor=black)](NEWS.md)

Basic Matics is a little graphic calculator. This is the kotlin (*deprecated*) edition of the project.

It is not very complex, but hou have plenty options. However, the main branch has been ported to Python.
Any pull request to fix some bugs are always welcome.

## Installation ##
### Prerequisites ###
 * x86_64/amd64 CPU
 * Any Linux, macOS or Windows
 * JDK 19
    #### Ubuntu ####
    You need Bionic Beaver (18.04) or higher
    ```shell
    apt install openjdk-17-jdk
    ```

    #### Fedora / RHEL ####
    $ARCH is your architecture
    ```shell
    dnf install java-17-openjdk-devel.$ARCH
    ```

    #### Arch ####
    ```shell
    pacman install jdk17-openjdk
    ```

Then, just run:
### UNIX / Linux ###
`./gradlew build`
### Windows ###
`.\gradlew build`

After, only go to `build` dir, mark it as executable if necessary and run it.