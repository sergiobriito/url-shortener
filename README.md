# URL Shortener

This project is a URL shortening application that utilizes a snowflake ID generator to convert IDs into base62. It is built using Java Spring for the backend, PostgreSQL as the database, and HTML/JS for the frontend to enable user interaction.

## Features

- **URL Shortening:** Converts long URLs into shorter versions.
- **Snowflake ID Generation:** Uses a snowflake ID generator to create unique IDs.
- **Base62 Conversion:** Transforms snowflake IDs into base62 format for user-friendly representation.
- **Backend (Java Spring):** Handles URL shortening, snowflake ID generation, and database operations.
- **Database (PostgreSQL):** Stores mappings between original URLs and their shortened versions.
- **Frontend (HTML/JS):** Allows users to interact with the application by inputting URLs and retrieving shortened versions.

## Setup Instructions

### Prerequisites

- Java Development Kit (JDK)
- Apache Maven
- PostgreSQL
- Docker
- Web browser

### Steps

```bash
git clone https://github.com/sergiobriito/url-shortener.git
mvn clean install -DskipTests
docker-compose build
docker-compose up

