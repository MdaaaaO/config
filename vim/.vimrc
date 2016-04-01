" Make the arrow keys work properly in Vim in tmux
nnoremap <Esc>A <up>
nnoremap <Esc>B <down>
nnoremap <Esc>C <right>
nnoremap <Esc>D <left>
inoremap <Esc>A <up>
inoremap <Esc>B <down>
inoremap <Esc>C <right>
inoremap <Esc>D <left>

" Show line numbers
set number

" Line Settings
set timeout ttimeoutlen=100 timeoutlen=5000
set cursorline
set colorcolumn=80
set nowrap

set nocompatible

" Tab settings
set tabstop=2
set shiftwidth=2
set expandtab

" Terminal
set term=screen-256color
set guifont=Menlo\ Regular:h18

" EOL
set list
set listchars=tab:▸\ ,eol:¬

" Colorscheme
filetype on
filetype indent on
syntax on
colorscheme Tomorrow-Night-Bright

" Shortcuts
map <leader>s :source ~/.vimrc<CR>

" Show matching Paranthesis
set showmatch

" Better Search
set hlsearch
nnoremap <silent> <Esc> :nohlsearch<Bar>:echo<CR>

" Autocmd
" remove whitespaces on save
autocmd BufWritePre * :%s/\s\+$//e
