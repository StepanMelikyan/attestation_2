#!/bin/bash

# Проверяем наличие аргумента - пути к директории
if [ $# -eq 0 ]; then
  echo "Ошибка: Не указан путь к директории."
  exit 1
fi

directory="$1"

# Проверяем, существует ли директория
if [ ! -d "$directory" ]; then
  echo "Ошибка: Директория не существует."
  exit 1
fi

# Удаляем файлы с расширениями .bak, .tmp, .backup
find "$directory" -type f \( -name "*.bak" -o -name "*.tmp" -o -name "*.backup" \) -delete

echo "Файлы с расширениями .bak, .tmp, .backup удалены из директории $directory."
