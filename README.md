# UDL

Vicky Dineshchandra's final year project for UCL's Urban Design Lab.

The goal of this README is to inform the reader how to run some of the
functionality associated with the project. A full explanation of what
each component does and why it is required can be found in the final report.

## Jupyter Notebook Spark Interface

The service is already installed and up and running as required by
UDL on UDLTest1. This repository contains a Docker build test,
which includes the build instructions for the interface.

Build instructions for Jupyter Notebook Spark Interface are provided in
`/jupyter-service`. There are two configuration files provided:
- `jupyter_notebook_config.py` contains the settings for the JN installation
- `jupyternotebook.service` contains the conf file for the systemd service

Once you've installed the bare bones jupyternotebook service, tap in your virtualenv and type

```
jupyter toree install --spark_home=$your_spark_path
```

toree should be installed with the requirements file I have provided.

### Docker Build Test

The main goal of the Dockerfile found in `jupyter_notebook/Dockerfile` is
to act like the instructions to install the service.

You can also perform a build test using Docker, it requires the `ubuntu`
image. (This is the OS for UDLTest1)

```bash
docker pull ubuntu
cd jupyter-service
docker build -t jntest
```

## Pipeline 1: TFL Air Pollution API

This pipeline is written in Java and uses _ant_ as the build tool. The entire
project is unit tested and follows the javadoc documentation style.

### Prerequistes

Java 8 and ant must be installed

This can be checked with
```bash
java -version
ant --version
```

### Running the pipeline

Simple as
```bash
cd pipelines/fetching/AirAPI
ant
```

This will query relevant APIs and save the results into `output`

The folders are separated by "years", this can be configured in
`pipelines/fetching/AirAPI/src/main/java/AirPollutionGatherer.java`

### Unit Testing

This pipeline comes with unit tests for all classes that were written. To
run the tests:

```bash
cd pipelines/fetching/AirAPI
ant test
```

## Pipeline 2: London Development Data Store

This pipelines creates the postgres db server from the LDD database dump
that is provided

Make sure to download the dump and save it in `pipelines/dbserve/init`. The LDD
dump can be found at [here](https://data.london.gov.uk/dataset/london-development-database-sql-extract)


### Running the pipeline

First the database server needs to be mounted using Docker

Simply run
```bash
cd pipelines/dbserve
docker_up.sh
```

Once the server is up, remember to call `save_data.py` to make SQL
queries to the server, or make calls any other way. For dependencies, you can build a virtualenv from `jupyter-experiments/requirements.txt`

If there are port mapping issues, this can be simple set in the
`docker-compose.yml` file.

Finally, remember to close the db server using
```bash
docker_down.sh
```
