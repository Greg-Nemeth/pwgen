# **pwGen**

A simple random password generator built in java using picoCli.

## Contents

    - [Build](#build)
        - [Native-Image](#with-graalvm)
        - [Java Jar](#with-other-jdk)
    - [Install](#installation)
    - [Usage](#usage)
    - [Footer](#footer)

    

## Build
- ### With GraalVm
    - If you have a JDK containing the native-image tool in $JAVA_HOME simply clone the repo, check and update the version numbers in pom.xml if needed and run ```mvn package -f /path/to/pom.xml```. For convenience I recommend you copy the executable in a folder on $PATH to be able to run withouth specifying the location.
- ### With other JDK
    - If your JDK does not support native-image, clone the repo and remove the ```org.graalvm.sdk``` dependency and ```org.graalvm.nativeimage``` plugin. After that you can package into a jar and run as you would any other jars.

## Installation
In case you are not interested in building the application yourself, and you happen to run a linux distro, simply download the executable from the releases tab, copy in a folder that's present in your ```$PATH``` environmental variable and you are ready to go.

## Usage
Running the application without any options will produce a password of length 8 characters, with 2 numbers and 2 sepcial characters included.
You can specify all these attributes as options on the command line e.g.: ```pwGen [-l|--length] 12 [-d|--digits] 2 [-s|--specials] 4```.
Should you need any reminders in the future , there is no need to revisit this readme, simply run ```pwGen [-h|--help]``` ;)

## Footer
This is clearly not an overly serious project, and there's many things still missing. For example there is no minimum length defined or checked. In any cases, should you have any issues or recommendations don't hesitate to create an issue or get in touch.