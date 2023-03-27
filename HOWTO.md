# Build
mvnw clean package

# Run
java -Dspring.data.mongodb.uri="<MongoDB connstr>" -jar target\ageera-0.0.1-SNAPSHOT.jar

# Test
### Add new site
POST http://localhost:8080/site/add
curl -v --json "@src\test\resources\site1.json" http://localhost:8080/site/add

### Configure site
PUT http://localhost:8080/site/config/{siteId}
curl -v -X PUT --json "@src\test\resources\configuration1.json" http://localhost:8080/site/config/1

### List of sites
GET http://localhost:8080/site/list

### Get site configuration
GET http://localhost:8080/site/details/{siteId}

### Send live data
POST http://localhost:8080/live-data/add
curl -v -X PUT --json "@src\test\resources\live_data1.json" http://localhost:8080/live-data/add

### Get latest live data
GET http://localhost:8080/live-data/latest
