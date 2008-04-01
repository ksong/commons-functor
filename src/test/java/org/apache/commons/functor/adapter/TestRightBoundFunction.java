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
package org.apache.commons.functor.adapter;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.apache.commons.functor.BaseFunctorTest;
import org.apache.commons.functor.UnaryFunction;
import org.apache.commons.functor.core.Constant;
import org.apache.commons.functor.core.LeftIdentity;
import org.apache.commons.functor.core.RightIdentity;

/**
 * @version $Revision$ $Date$
 * @author Rodney Waldhoff
 */
public class TestRightBoundFunction extends BaseFunctorTest {

    // Conventional
    // ------------------------------------------------------------------------

    public TestRightBoundFunction(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(TestRightBoundFunction.class);
    }

    // Functor Testing Framework
    // ------------------------------------------------------------------------

    protected Object makeFunctor() {
        return new RightBoundFunction(new LeftIdentity(),"xyzzy");
    }

    // Lifecycle
    // ------------------------------------------------------------------------

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    // Tests
    // ------------------------------------------------------------------------    

    public void testEvaluate() throws Exception {
        UnaryFunction f = new RightBoundFunction(new LeftIdentity(),"foo");
        assertEquals("xyzzy",f.evaluate("xyzzy"));
    }
    
    public void testEquals() throws Exception {
        UnaryFunction f = new RightBoundFunction(new LeftIdentity(),"xyzzy");
        assertEquals(f,f);
        assertObjectsAreEqual(f,new RightBoundFunction(new LeftIdentity(),"xyzzy"));
        assertObjectsAreNotEqual(f,new Constant("xyzzy"));
        assertObjectsAreNotEqual(f,new RightBoundFunction(new RightIdentity(),"xyzzy"));
        assertObjectsAreNotEqual(f,new RightBoundFunction(new LeftIdentity(),"bar"));
        assertObjectsAreNotEqual(f,new RightBoundFunction(null,"xyzzy"));
        assertObjectsAreNotEqual(f,new RightBoundFunction(new LeftIdentity(),null));
        assertObjectsAreEqual(new RightBoundFunction(null,null),new RightBoundFunction(null,null));
    }

    public void testAdaptNull() throws Exception {
        assertNull(RightBoundFunction.bind(null,"xyzzy"));
    }

    public void testAdapt() throws Exception {
        assertNotNull(RightBoundFunction.bind(new LeftIdentity(),"xyzzy"));
        assertNotNull(RightBoundFunction.bind(new LeftIdentity(),null));
    }
}