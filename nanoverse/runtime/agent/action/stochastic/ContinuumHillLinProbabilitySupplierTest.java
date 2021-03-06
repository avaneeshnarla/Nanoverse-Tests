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

package nanoverse.runtime.agent.action.stochastic;

import nanoverse.runtime.agent.Agent;
import org.junit.*;
import test.TestBase;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ContinuumHillLinProbabilitySupplierTest extends TestBase {

    private Function<Agent, Double> valueLookup;
    private double coefficient;
    private double offset;
    private double halfpoint;
    private double maximum;
    private Function<Agent, Double> substrateLookup;
    private Agent cell, child;

    private ContinuumHillLinProbabilitySupplier query;

    @Before
    public void init() throws Exception {
        cell = mock(Agent.class);
        child = mock(Agent.class);

        valueLookup = (Function<Agent, Double>) mock(Function.class);
        substrateLookup = (Function<Agent, Double>) mock(Function.class);
        when(valueLookup.apply(cell)).thenReturn(1.0);
        when(valueLookup.apply(child)).thenReturn(2.0);

        coefficient = 3.0;
        offset = 0.5;
        halfpoint = 1.0;
        maximum = 0.3;

        query = new ContinuumHillLinProbabilitySupplier(valueLookup,
                substrateLookup,
                cell,
                coefficient, offset, halfpoint, maximum);
    }

    //@Test
    //public void getAppliesAllArguments() throws Exception {
    //     assertEquals(3.5, query.get(), epsilon);
    // }

    // @Test
    // public void cloneReturnsEquivalent() throws Exception {
    //     ContinuumProbabilitySupplier clone = query.clone(child);
    //     assertEquals(6.5, clone.get(), epsilon);
    // }

}