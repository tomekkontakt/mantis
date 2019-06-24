/*
 * Copyright 2019 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.mantisrx.publish.proto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class MantisEventEnvelope {

    private final String originServer;
    private final List<MantisEvent> eventList;
    private long ts;

    @JsonCreator
    public MantisEventEnvelope(@JsonProperty("ts") long ts, @JsonProperty("originServer") String originServer,
                               @JsonProperty("events") List<MantisEvent> eventList) {
        this.ts = ts;
        this.originServer = originServer;
        this.eventList = eventList;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public String getOriginServer() {
        return originServer;
    }

    public List<MantisEvent> getEventList() {
        return eventList;
    }

    public void addEvent(MantisEvent event) {
        eventList.add(event);
    }
}
