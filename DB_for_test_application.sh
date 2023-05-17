docker stop polyclinic_api
docker rm polyclinic_api
docker run -d --name polyclinic_api -e POSTGRES_USERNAME=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=polyclinic -p 5432:5432 postgres