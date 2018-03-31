FROM ubuntu
# ubuntu setup
RUN apt-get update -y
RUN apt-get upgrade -y

# Install dependecies
RUN apt-get install -y software-properties-common vim
RUN add-apt-repository ppa:jonathonf/python-3.6
RUN apt-get update -y && \
      apt-get -y install sudo

RUN apt-get install -y build-essential python3.6 python3.6-dev python3-pip python3.6-venv
RUN apt-get install -y git

# update pip
RUN python3.6 -m pip install pip --upgrade
RUN python3.6 -m pip install wheel


# Install virtualenv
RUN pip3 install virtualenv

# Create new user
RUN useradd -m jnserver && echo "jnserver:jnserver" | chpasswd && adduser jnserver sudo
USER jnserver
WORKDIR /home/jnserver

# Add config files
ADD . /home/jnserver

# Create virtualenv
RUN virtualenv jn/env --python=python3.6

# Install jupyter notebook
RUN /bin/bash -c "source jn/env/bin/activate \
   && pip install jupyter notebook \
   && jupyter notebook --generate-config "

# Adding the config file for JN
RUN mkdir jn/notebooks
RUN cp jupyter_notebook_config.py /home/jnserver/.jupyter/jupyter_notebook_config.py


## Adding Jupyter Notebook as a service
# Steps to add the rest of th
#RUN cp jupyternotebook.service /etc/systemd/system/jupyternotebook.service
#RUN systemctl daemon-reload
#RUN systemctl enable jupyternotebook
#RUN systemctl start jupyternotebook
#EXPOSE 4567
