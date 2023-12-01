#!/bin/bash


if [ -x "$(command -v sass)" ]; then
  SASS_EXEC=sass
fi


if [ -z "$SASS_EXEC" ]; then
  echo "You need to have SASS installed"
  exit 1
fi

CHOKIDAR_USEPOLLING=true sass --watch demo/src/main/resources/static/style.scss demo/src/main/resources/static/assets/stylesheets/mainPage.css
# C:\Users\noset\Documents\ProjTech2\website-protech\demo\src\main\resources\static\style.scss