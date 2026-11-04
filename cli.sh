export DB_HOST=16.170.148.65
export DB_PORT=5432
export DB_NAME=ki-step-2026
export DB_USER=admin
export DB_PASSWORD=admin4321

function run() {
 java -jar ./target/libs/user-management-api-0.0.1-SNAPSHOT.jar
}

"$@"

