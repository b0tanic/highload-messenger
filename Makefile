all:
	@echo "make build-app  - Build the app before run command"
	@echo "make run		   - Run all services"
	@echo "make stop	   - Stop all services"
	@echo "make delete	   - Delete all services"
	@exit 0

build-app:
	gradlew clean build -x test

run:
	docker compose up

stop:
	docker compose stop

delete:
	docker compose down
