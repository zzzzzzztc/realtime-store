/*
 * Copyright 2012 Goodow.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.goodow.realtime;

import com.goodow.realtime.model.util.ModelFactory;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportPackage;

/**
 * Event fired when a map or custom object property changes.
 */
@ExportPackage(ModelFactory.PACKAGE_PREFIX_REALTIME)
@Export(all = true)
public class ValueChangedEvent extends BaseModelEvent {
  /**
   * The new property value.
   */
  public final Object newValue;
  /**
   * The old property value.
   */
  public final Object oldValue;
  /**
   * The property whose value changed.
   */
  public final String property;

  /**
   * @param target The target object that generated the event.
   * @param sessionId The id of the session that initiated the event.
   * @param userId The user id of the user that initiated the event.
   * @param property The property whose value changed.
   * @param newValue The new property value.
   * @param oldValue The old property value.
   */
  public ValueChangedEvent(CollaborativeMap target, String sessionId, String userId,
      String property, Object newValue, Object oldValue) {
    super(EventType.VALUE_CHANGED, target, sessionId, userId, false);
    this.property = property;
    this.newValue = newValue;
    this.oldValue = oldValue;
  }

  public Object getNewValue() {
    return newValue;
  }

  public Object getOldValue() {
    return oldValue;
  }

  public String getProperty() {
    return property;
  }
}
