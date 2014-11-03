#!/bin/bash

echo "Installing the environment"

apt-get update

# Java development environment

apt-get -y install openjdk-7-jdk
apt-get -y install maven

# Distributed version control system

apt-get -y install git

# Utilities

apt-get -y install tree

# Our own scripts

SCRIPT="#!/bin/bash\n"
SCRIPT="${SCRIPT}TMPDIR=\$(mktemp -d)\n"
SCRIPT="${SCRIPT}cd \$TMPDIR\n"
SCRIPT="${SCRIPT}git init .\n"
SCRIPT="${SCRIPT}git remote add -f origin https://github.com/aamm/02j.git\n"
SCRIPT="${SCRIPT}git config core.sparsecheckout true\n"
SCRIPT="${SCRIPT}echo \"lesson-\$1\" >> .git/info/sparse-checkout\n"
SCRIPT="${SCRIPT}git pull origin master\n"
SCRIPT="${SCRIPT}mv \"lesson-\$1\" ~\n"
SCRIPT="${SCRIPT}rm -rf \$TMPDIR\n"

echo -e $SCRIPT > /usr/bin/02j-get-lesson
chmod o+x /usr/bin/02j-get-lesson

# First Maven executions using lesson-1
# So Maven will download the most commonly used dependencies
# before the user takes the "clean" snapshot.

sudo --set-home --user vagrant 02j-get-lesson 1
sudo --set-home --user vagrant mvn --file /home/vagrant/lesson-1/pom.xml
sudo --set-home --user vagrant mvn --file /home/vagrant/lesson-1/pom.xml compile exec:java -Dexec.mainClass=org.aamm.z2java.lesson1.App
sudo --set-home --user vagrant rm -rf lesson-1

echo "Done!!"

