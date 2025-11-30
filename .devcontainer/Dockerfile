# .devcontainer/Dockerfile
FROM mcr.microsoft.com/devcontainers/java:21-bullseye

# Install useful CLI tools (as root)
USER root

# Install Docker CLI + docker-compose + extra tools
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
      docker.io \
      docker-compose \
      curl \
      postgresql-client \
      netcat-openbsd \
    && rm -rf /var/lib/apt/lists/*


USER vscode

# Default working directory inside the container
WORKDIR /workspace
