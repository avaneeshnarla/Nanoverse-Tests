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

package nanoverse.runtime.processes.continuum;

import no.uib.cipr.matrix.DenseMatrix;
import org.junit.*;
import test.LinearMocks;

import static org.mockito.Mockito.*;

public class DiffusionOperatorTest extends LinearMocks {

    private DiffusionConstantHelper helper;
    private DiffusionOperator query;

    @Before
    public void init() throws Exception {
        helper = mock(DiffusionConstantHelper.class);
        when(helper.getDiagonalValue()).thenReturn(-0.2);
        when(helper.getNeighborValue()).thenReturn(0.1);
        query = new DiffusionOperator(helper, geom);
    }

    /**
     * The operator has the neighbor value in the neighbor
     * positions, the diagonal value in along the diagonal,
     * and it respects all properties of the nanoverse.runtime.geometry (size,
     * neighbors).
     */
    @Test
    public void contentsAsExpected() throws Exception {
        DenseMatrix expected = makeMatrix();
        assertMatricesEqual(expected, query, epsilon);
    }

    private DenseMatrix makeMatrix() {
        DenseMatrix ret = new DenseMatrix(3, 3);

        ret.add(0, 0, -0.2);
        ret.add(0, 1, 0.1);

        ret.add(1, 0, 0.1);
        ret.add(1, 1, -0.2);
        ret.add(1, 2, 0.1);

        ret.add(2, 1, 0.1);
        ret.add(2, 2, -0.2);

        return ret;
    }
}