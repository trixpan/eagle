package org.apache.eagle.alert.metric.sink;

import java.util.concurrent.TimeUnit;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.typesafe.config.Config;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class ConsoleSink implements MetricSink {
    private ConsoleReporter reporter;
    @Override
    public void prepare(Config config, MetricRegistry registry) {
        reporter = ConsoleReporter.forRegistry(registry).build();
    }

    @Override
    public void start(long period,TimeUnit unit) {
        reporter.start(period, unit);
    }

    @Override
    public void stop() {
        reporter.stop();
        reporter.close();
    }

    @Override
    public void report() {
        reporter.report();
    }
}