/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License") +  you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.openmeetings.web.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.apache.wicket.request.Url;
import org.junit.jupiter.api.Test;

class TestApplicationMocked {
	@Test
	void testWsUrlIncomplete() {
		assertNull(Application.getWsUrl(Url.parse("./test")));
	}

	@Test
	void testWsUrlNoPort() {
		assertEquals("ws://www.com", Application.getWsUrl(Url.parse("http://www.com/test?param#hash")));
		assertEquals("wss://www.com", Application.getWsUrl(Url.parse("https://www.com/test?param#hash")));
		assertEquals("wss://www.com:8443", Application.getWsUrl(Url.parse("https://www.com:8443/test")));
	}
}
