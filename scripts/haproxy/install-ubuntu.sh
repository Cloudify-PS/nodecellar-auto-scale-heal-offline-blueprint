#!/bin/bash -e

ctx logger info "Installing HAProxy"
ctx logger debug "${COMMAND}"

#sudo apt-get update
#sudo apt-get -y install haproxy
ctx download-resource "resources/haproxy/haproxy_1.4.24-2ubuntu0.4_amd64.deb" "/tmp/haproxy_1.4.24-2ubuntu0.4_amd64.deb" 
sudo dpkg -i /tmp/haproxy_1.4.24-2ubuntu0.4_amd64.deb

sudo /bin/sed -i s/ENABLED=0/ENABLED=1/ /etc/default/haproxy

ctx logger info "Installed HAProxy"
