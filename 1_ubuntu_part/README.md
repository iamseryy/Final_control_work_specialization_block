## Задания - терминал Ubuntu
1. Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и ослы), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).
2. Создать директорию, переместить файл туда.
3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.
4. Установить и удалить deb-пакет с помощью dpkg.
5. Выложить историю команд в терминале ubuntu

----
## Решение
Файл **ubuntu_terminal_history.log**

````
   40  mkdir task2
   41  cd task2
   42  cat > Домашние_животные
   43  cat > Вьючные_животные
   44  cat Домашние_животные 
   45  cat Вьючные_животные 
   46  ls -ali
   47  cat Домашние_животные Вьючные_животные > животные
   48  cat животные 
   49  cp животные Друзья_человека
   50  ls -ali
   51  rm Друзья_человека 
   52  mv животные Друзья_человека
   53  ls -ali
   54  cat Друзья_человека 
   55  mkdir animals
   56  mv Друзья_человека animals/
   57  ls -ali animals/
   58  cat /etc/apt/sources.list
   59  sudo apt install dirmngr ca-certificates ca-certificates software-properties-common apt-transport-https curl lsb-release -y
   60  curl -fsSL http://repo.mysql.com/RPM-GPG-KEY-mysql-2022 | sudo gpg --dearmor | sudo tee /usr/share/keyrings/mysql.gpg > /dev/null
   61  echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/mysql.gpg] http://repo.mysql.com/apt/ubuntu $(lsb_release -cs) mysql-8.0" | sudo tee -a /etc/apt/sources.list.d/mysql.list
   62  grep mysql /etc/apt/sources.list.d/mysql.list
   63  sudo apt update
   64  cat /etc/apt/sources.list
   65  sudo apt install mysql-community-server
   66  apt policy mysql-community-server
   67  wget http://nginx.org/packages/ubuntu/pool/nginx/n/nginx/nginx_1.22.1-1~jammy_amd64.deb
   68  sudo dpkg -i nginx_1.22.1-1~jammy_amd64.deb
   69  dpkg-query -l
   70  sudo dpkg -P nginx
   71  history 1000 > history
````
