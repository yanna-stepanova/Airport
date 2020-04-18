# Airport
## Установка
Для того чтобы начать работать с проектом нужно скачать этот репозиторий нажав на кнопку 
"Clone or download", после чего выбрать "Download ZIP"

После того как архив будет скачан, нужно распаковать его.

## Создание нового репозитория на GitHub
Зайти на GitHub под своим именем и паролем. Создать новый репозиторий с именем Airport.

После создания репозитория скопируйте его адрес (пример - git@github.com:OleksandrLarin/Airport.git)

## Настройка GIT
Нужно перейти в папку проекта, вызвать git bash и выполнить комманду:
        
        git init

После чего нужно проиндексировать все файлы коммандой:

        git add .gitignore //для добавления файла .gitignore
        git add pom.xml    //для добавления файла pom.xml
        git add src/*      //для добавления всех файлов из каталога src

Далее нужно сделать первый коммит:

        git commit -m "initial commit"
      
Добавим удаленный репозиторий, который мы создали на GitHub. Выполиним команды:

        git remote add origin git@github.com:OleksandrLarin/Airport.git // ваш адрес репозитория

И загрузим в удаленный репозиторий свои изменения:

        git push origin master


