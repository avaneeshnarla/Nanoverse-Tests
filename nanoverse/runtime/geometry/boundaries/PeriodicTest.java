/*
 * Nanoverse: a declarative agent-based modeling language for natural and
 * social science.
 *
 * Copyright (c) 2015 David Bruce Borenstein and Nanoverse, LLC.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package nanoverse.runtime.geometry.boundaries;

import nanoverse.runtime.control.identifiers.*;
import nanoverse.runtime.geometry.boundaries.helpers.WrapHelper;
import nanoverse.runtime.geometry.boundary.MockWrapHelper;
import nanoverse.runtime.geometry.lattice.*;
import nanoverse.runtime.geometry.shape.*;
import org.junit.*;

import static org.junit.Assert.*;

public class PeriodicTest {

    private MockWrapHelper helper;
    private ExposedPeriodic query;

    @Before
    public void setUp() throws Exception {
        helper = new MockWrapHelper();
        Lattice lattice = new RectangularLattice();
        Shape shape = new Rectangle(lattice, 0, 0);
        query = new ExposedPeriodic(shape, lattice);
        query.setHelper(helper);
    }

    @Test
    public void testApply() throws Exception {
        Coordinate c = new Coordinate2D(0, 0, 0);
        query.apply(c);
        assertTrue(helper.isAllWrapped());
    }

    @Test
    public void testIsInfinite() throws Exception {
        assertFalse(query.isInfinite());
    }

    private class ExposedPeriodic extends Periodic {
        public ExposedPeriodic(Shape shape, Lattice lattice) {
            super(shape, lattice);
        }

        public void setHelper(WrapHelper helper) {
            this.helper = helper;
        }
    }
}