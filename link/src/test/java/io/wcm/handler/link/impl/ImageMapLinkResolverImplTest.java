/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2019 wcm.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.wcm.handler.link.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.day.cq.wcm.api.Page;

import io.wcm.handler.link.testcontext.AppAemContext;
import io.wcm.handler.media.spi.ImageMapLinkResolver;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
class ImageMapLinkResolverImplTest {

  final AemContext context = AppAemContext.newAemContext();

  private ImageMapLinkResolver underTest;
  private Page page;

  @BeforeEach
  void setUp() {
    context.create().page("/content/site1/en");
    page = context.currentPage(context.create().page("/content/site1/en/page1"));

    underTest = context.registerInjectActivateService(new ImageMapLinkResolverImpl());
  }

  @Test
  void testResolve() {
    assertEquals("http://host", underTest.resolve("http://host", page.getContentResource()));
    assertEquals("/content/site1/en.html", underTest.resolve("/content/site1/en", page.getContentResource()));
    assertNull(underTest.resolve("/content/site1/en/invalid", page.getContentResource()));
  }

}
