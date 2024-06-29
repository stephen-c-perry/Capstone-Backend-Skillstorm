# Employee Timekeeping App Backend Api

This repository holds the Spring Boot RESTful API code from the 20240311 Java CGI Apprenticeship cohort's final project.

## Contributing

To contribute to the application, follow the below instructions.

### Setup

To get started, clone the repository to your local computer using

```
git clone https://github.com/skillstorm-congo/cgi-java-proj4-api.git
```

Open a New Window in VS Code. In the new VS Code window select `Open Folder` and navigate to the root directory of the project. 

To make sure all of the maven dependencies are installed, run `mvn clean validate`

### Editing Code

Before starting to edit the code, create a new branch and checkout the new branch using:

```
git checkout -b <branch-name>
```

#### Branching Strategy

main - The main branch is for the production version of the code which has been approved and tested.

staging - The staging branch is for code waiting to be approved into main. All pull requests into main should come from staging. 

dev - The dev branch is where team members should resolve merge conflicts between their code before moving their code into staging.

All other branches should use the naming strategy:

```
feature-<something>-<your-initials>
```
or
```
bugfix-<something>-<your-initials>
```

For example: `feature-login-eh` or `bugfix-routeguard-eh`

### Merging Code

Instructions coming soon...

