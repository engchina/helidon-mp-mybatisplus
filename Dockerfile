#
# Copyright (c) 2018, 2019 Oracle and/or its affiliates. All rights reserved.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# 1st stage, build the app
FROM openjdk:8 as build

WORKDIR /helidon

# Create a first layer to cache the "Gradle World" in the local repository.
# Incremental docker builds will always resume after that, unless you update
# the pom
ADD build.gradle gradlew settings.gradle ./
ADD gradle gradle
ADD libs libs
#RUN ./gradlew build -x :bootRepackage -x test --continue
RUN ./gradlew build -x test --continue --no-daemon

# Do the Gradle build!
# Incremental docker builds will resume here when you change sources
ADD src src
RUN ./gradlew build --no-daemon
RUN echo "done!"

# 2nd stage, build the runtime image
FROM openjdk:8-jre-slim
WORKDIR /helidon

# Copy the binary built in the 1st stage
COPY --from=build /helidon/build/libs/helidon-mp-mybatisplus.jar ./
COPY --from=build /helidon/build/libs/libs ./libs

CMD ["java", "-jar", "helidon-mp-mybatisplus.jar"]

EXPOSE 8080
