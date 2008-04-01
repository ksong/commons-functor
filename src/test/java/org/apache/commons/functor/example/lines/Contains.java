/*
 * Copyright 2003,2004 The Apache Software Foundation.
 * 
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
 */
package org.apache.commons.functor.example.lines;

import org.apache.commons.functor.UnaryPredicate;


/**
 * @version $Revision$ $Date$
 * @author Rodney Waldhoff
 */
public class Contains implements UnaryPredicate {
    public Contains(String str) {
        this.str = str;
    }
    
    public boolean test(Object obj) {
        return null != obj && obj.toString().indexOf(str) != -1;
    }

    private String str = null;
}