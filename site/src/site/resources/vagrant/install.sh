#!/bin/bash
#
# This script is run by Vagrant to prepare the virtual machine for use. The box we are using
# (Ubuntu/trusty) does not have all we need to work with Java. So this script install everything
# that is missing.
#

echo "Installing the environment"


####################################################################################################
#                                                                                                  #
# Install dependencies using apt-get                                                               #
#                                                                                                  #
####################################################################################################

# Updates apt, the package manager used by Ubuntu
apt-get update

# Installs the Java Developer Kit
apt-get -y install openjdk-7-jdk

# Installs Maven, the Java tool to make compilation and other recurrent tasks simple
apt-get -y install maven

# Installs the GIT distributed source code version control system
apt-get -y install git

# Installs console utilities
apt-get -y install tree


####################################################################################################
#                                                                                                  #
# Adds our own scripts to the virtual machine                                                      #
#                                                                                                  #
####################################################################################################
#                                                                                                  #
# We use the "here documents" to embed other scripts inside of this one in order to minimize the   #
# number of scripts needed. For more information on here documents, please check this:             #
# http://tldp.org/LDP/abs/html/here-docs.html                                                      #
#                                                                                                  #
####################################################################################################

# 02j-get-lesson

tee /usr/bin/02j-get-lesson > /dev/null <<EOF
#!/bin/bash
TMPDIR=\$(mktemp -d)
cd \$TMPDIR
git init .
git remote add -f origin https://github.com/aamm/02j.git
git config core.sparsecheckout true
echo "lesson-\$1" >> .git/info/sparse-checkout
git pull origin master
mv "lesson-\$1" ~
rm -rf \$TMPDIR
EOF

chmod o+x /usr/bin/02j-get-lesson

####################################################################################################
#                                                                                                  #
# Pre-fetching Maven dependencies                                                                  #
#                                                                                                  #
####################################################################################################
#                                                                                                  #
# We run Maven on lesson-1 to let Maven download the most commonly used dependencies before the    #
# user takes the "clean" snapshot. This way, the "clean" snapshot will already have those          #
# dependencies on the local Maven repository which saves a lot of time later.                      #
#                                                                                                  #
####################################################################################################

# Downloads lesson 1 using the script we just installed
sudo --set-home --user vagrant 02j-get-lesson 1
# Runs Maven build on this lesson
sudo --set-home --user vagrant mvn --file /home/vagrant/lesson-1/pom.xml
# Executes a class, forcing Maven to download all dependencies required to run Java programs
sudo --set-home --user vagrant mvn --file /home/vagrant/lesson-1/pom.xml compile exec:java -Dexec.mainClass=org.aamm.z2java.lesson1.App
# Erases lesson 1, in preparation for the clean snapshot
sudo --set-home --user vagrant rm -rf lesson-1

echo "Done!!"

