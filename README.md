# finance-api

Docker database image creation (First time):
sudo docker run -p 3307:3306 --name financedb -e MYSQL_ROOT_PASSWORD=123456 -d mysql:8.0

Docker database image start (On system restart):
sudo docker start financedb