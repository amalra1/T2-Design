#!/bin/bash

# Diretório onde os arquivos estão localizados
directory="models"

# Itera sobre todos os arquivos .java no diretório
for file in "$directory"/*.java; do
    # Verifica se o arquivo contém o package Models;
    if grep -q "package Models;" "$file"; then
        # Substitui 'package Models;' por 'package models;'
        sed -i 's/package Models;/package models;/g' "$file"
        echo "Substituído 'package Models;' por 'package models;' em $file"
    else
        echo "Package 'Models' não encontrado em $file"
    fi
done
