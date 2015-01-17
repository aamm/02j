#!/bin/bash

# Updates apt-get
sudo apt-get update

# Installs VirtualBox
sudo apt-get -y install virtualbox

# Installs Vagrant
sudo apt-get -y install vagrant

# Creats the JavaClasses directory
mkdir JavaClasses

# Enters the JavaClasses directory
cd JavaClasses

# Downloads Vagrant configuration files
wget http://aamm.github.io/02j/vagrant/Vagrantfile
wget http://aamm.github.io/02j/vagrant/install.sh

# Installs a Vagrant plugin to manage virtual machine snapshots
vagrant plugin install vagrant-vbox-snapshot

# Starts Vagrant for the first time
vagrant up

# After it is running, turns it off
vagrant halt

# Takes a snapshot called "clean"
vagrant snapshot take clean
