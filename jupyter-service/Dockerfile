FROM ubuntu
# ubuntu setup
RUN apt-get update -y
RUN apt-get upgrade -y

# Install Python
RUN apt-get install -y software-properties-common vim
RUN add-apt-repository ppa:jonathonf/python-3.6
RUN apt-get update

RUN apt-get install -y build-essential python3.6 python3.6-dev python3-pip python3.6-venv
RUN apt-get install -y git

# update pip
RUN python3.6 -m pip install pip --upgrade
RUN python3.6 -m pip install wheel


# Install virtualenv
RUN pip3 install virtualenv

# Create new user
RUN useradd -ms /bin/bash jnserver
RUn usermod -aG sudo jnserver

USER jnserver
WORKDIR /home/jnserver
RUN mkdir jn

# Add config files
ADD . /home/jnserver


RUN virtualenv jn/env --python=python3.6

RUN /bin/bash -c "source jn/env/bin/activate \
   && pip install jupyter notebook \
   && jupyter notebook --generate-config "

RUN ls -la
RUN mkdir jn/notebooks
RUN cp jupyter_notebook_config.py /home/jnserver/.jupyter/jupyter_notebook_config.py


RUN ls /usr/lib/systemd/
RUN cp jupyternotebook.service /etc/systemd/system/jupyternotebook.service
RUN systemctl daemon-reload
RUN systemctl enable jupyternotebook
RUN systemctl start jupyternotebook

EXPOSE 4567
