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
package io.wcm.handler.media;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MediaFileExtensionTest {

  @Test
  void testIsImage() {
    assertTrue(MediaFileExtension.isImage("gif"));
    assertTrue(MediaFileExtension.isImage("jpg"));
    assertTrue(MediaFileExtension.isImage("jpeg"));
    assertTrue(MediaFileExtension.isImage("png"));
    assertTrue(MediaFileExtension.isImage("tif"));
    assertTrue(MediaFileExtension.isImage("tiff"));
    assertFalse(MediaFileExtension.isImage("pdf"));
    assertFalse(MediaFileExtension.isImage(null));
  }

  @Test
  void testIsFlash() {
    assertTrue(MediaFileExtension.isFlash("swf"));
    assertFalse(MediaFileExtension.isFlash("pdf"));
    assertFalse(MediaFileExtension.isFlash(null));
  }

}