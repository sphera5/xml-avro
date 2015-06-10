/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ly.stealth.xmlavro;

import java.util.Objects;

/**
 *
 */
class Source {
    public static final String SOURCE = "source";
    public static final String DOCUMENT = "document";
    public static final String WILDCARD = "others";

    // name of element/attribute
    private String name;
    // element or attribute
    private boolean attribute;

    public Source(String name) { this(name, false); }

    public Source(String name, boolean attribute) {
        this.name = name;
        this.attribute = attribute;
    }

    public String getName() { return name; }

    public boolean isElement() { return !isAttribute(); }
    public boolean isAttribute() { return attribute; }

    public int hashCode() { return Objects.hash(name, attribute); }

    public boolean equals(Object obj) {
        if (!(obj instanceof Source)) return false;
        Source source = (Source) obj;
        return name.equals(source.name) && attribute == source.attribute;
    }

    public String toString() {
        return (attribute ? "attribute" : "element") + " " + name;
    }
}
