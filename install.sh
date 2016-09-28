#!/bin/bash
# use: sudo bash install.sh

# colors
RED='\033[33;31m'
GREEN='\033[33;32m'
YELLOW='\033[33;33m'
BLUE='\033[33;34m'
DEFAULT='\033[33;0m'

################################################################################
# helper methods
#
install_link_deb_bin() {
  if command -v "$3" >/dev/null 2>&1; then
    echo -e "| --- $3 ${YELLOW}already installed!${DEFAULT}"
  else
    echo -e "| --- Downloading and Installing $2"
    wget "$1"
    dpkg -i "$2"
    rm "$2"
  fi
}

install_apt_get() {
  echo -e -n "| --- $1 "
  apt-get install -y "$1" > /dev/null 2>&1
  if [ $? -eq 0 ]; then
    echo -e "installed ${GREEN}succesfuly.${DEFAULT}"
  else
    echo -e "${RED}failed.${DEFAULT}"
  fi
}

install_atom_apm() {
  echo -e -n "| --- [atom-plugin] $1 "
  apm install "$1" > /dev/null 2>&1
  if [ $? -eq 0 ]; then
    echo -e "installed ${GREEN}succesfuly.${DEFAULT}"
  else
    echo -e "${RED}failed.${DEFAULT}"
  fi
}

update() {
  echo -n -e "| --- ${BLUE}update"
  apt-get update >/dev/nul
  echo -e ", upgrade${DEFAULT}"
  apt-get -y upgrade >/dev/null
}

clean() {
  echo -e -n "| --- ${BLUE}autoclean"
  apt-get -y autoclean >/dev/null
  echo -e -n ", autoremove"
  apt-get -y autoremove >/dev/null
  echo -e ", -f install${DEFAULT}"
  apt-get -f install >/dev/null
}

################################################################################
# install
#
install_atom() {
  atom_link="https://atom.io/download/atom-amd64.deb"
  atom_app="atom-amd64.deb"
  atom_bin="atom"
  install_link_deb_bin $atom_link $atom_app $atom_bin
  install_atom_packages
}

install_chrome() {
  chrome_link="https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb"
  chrome_app="google-chrome-stable_current_amd64.deb"
  chrome_bin="google-chrome"
  install_link_deb_bin $chrome_link $chrome_app $chrome_bin
}

install_apps() {

  # shell
  install_apt_get "zsh" # shell
  install_apt_get "terminator" # terminal
  install_apt_get "tmux" # terminal application

  # texteditor
  install_apt_get "vim" # terminal editor
  install_apt_get "shellcheck" # linter shellscript
  install_apt_get "ack-grep" # grepping tool command line

  # ssh
  install_apt_get "openssh-client" # ssh
  install_apt_get "openssh-server" # ssh

  # nodejs
  install_apt_get "nodejs" # programming language
  install_apt_get "npm" # node packages

  # python
  install_apt_get "python-pip" # python packages

  # applications
  install_apt_get "git" # repository
  install_apt_get "gimp" # photo editor
  install_apt_get "gpodder" # podcast
  install_apt_get "shutter" # screen sniping tool
  install_apt_get "meld" # file / folder diff comparison
}

install_atom_packages() {
  install_atom_apm "linter"
  install_atom_apm "linter-shellcheck"
  install_atom_apm "linter-clang"
  install_atom_apm "autocomplete-clang"
  install_atom_apm "language-csharp"
  install_atom_apm "highlight-selected"
  install_atom_apm "jsonlint"
  install_atom_apm "atom-beautify"
  install_atom_apm "file-icons"
}

install_csharp() {
  # INSTRUCTIONS: http://www.mono-project.com/docs/getting-started/install/linux/#usage
  # TEST: http://www.mono-project.com/docs/getting-started/mono-basics/
  install_apt_get "mono-devel"
  install_apt_get "mono-complete"
  install_apt_get "ca-certificates-mono"
  install_apt_get "mono-xsp4"
  install_apt_get "gtk2.0"
  # formatter
  install_apt_get "uncrustify"
}

install_cpp() {
  # TODO: clang-format requires a cfg
  # formatter
  install_apt_get "clang" # required for linter and autocomplete
  install_apt_get "clang-format" # formatter
}

install_latex() {
  # TODO: install it :-)
  echo ""
}

################################################################################
# install.sh
# TODO: make zsh default shell
# NOTE: use pip for python packages
# NOTE: use apm for atom packages
main() {
  if [ "$(id -u)" != "0" ]; then
    echo -e "${DEFAULT}| --- sudo is ${RED}required.${DEFAULT}"
    exit 1
  fi
  clear
  update
  install_apps
  install_chrome
  install_atom
  install_csharp
  install_cpp
  clean
}

main
