FROM --platform=linux/amd64 ubuntu
COPY build/bin/native/releaseExecutable/innoday-km.kexe /innoday-km
ENTRYPOINT ["/innoday-km"]