




echo $PATH
DB_PATH=/tmp/applifire/db/TKOVURIKH8E1XS9CFW5AQQ/9DEA74AD-9EB8-4E33-9C20-E5B49271B471
MYSQL=/usr/bin
USER=test
PASSWORD=test
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'