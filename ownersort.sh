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

# Ищем файлы в директории и копируем их в директории, названные по имени владельца
find "$directory" -type f -exec bash -c '
  for file; do
    owner=$(stat -c "%U" "$file")
    dest_dir="$directory/$owner"
    mkdir -p "$dest_dir"
    cp "$file" "$dest_dir"
  done
' bash {} +

echo "Файлы из директории $directory скопированы в директории, названные по имени владельца."
