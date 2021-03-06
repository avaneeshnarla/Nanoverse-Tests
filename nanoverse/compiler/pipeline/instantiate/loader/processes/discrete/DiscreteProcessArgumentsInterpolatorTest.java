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

package nanoverse.compiler.pipeline.instantiate.loader.processes.discrete;

import nanoverse.compiler.pipeline.instantiate.loader.InterpolatorTest;
import nanoverse.compiler.pipeline.instantiate.loader.geometry.set.CoordinateSetLoader;
import nanoverse.compiler.pipeline.translate.nodes.MapObjectNode;
import nanoverse.runtime.control.arguments.IntegerArgument;
import nanoverse.runtime.geometry.set.CoordinateSet;
import org.junit.*;

import java.util.function.Supplier;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class DiscreteProcessArgumentsInterpolatorTest extends InterpolatorTest {

    private DiscreteProcessArgumentsDefaults defaults;
    private DiscreteProcessArgumentsInterpolator query;

    @Before
    public void before() throws Exception {
        super.before();
        defaults = mock(DiscreteProcessArgumentsDefaults.class);
        query = new DiscreteProcessArgumentsInterpolator(load, defaults);
    }

    @Test
    public void activeSites() throws Exception {
        MapObjectNode cNode = mock(MapObjectNode.class);
        when(node.getMember("activeSites")).thenReturn(cNode);

        CoordinateSetLoader loader = mock(CoordinateSetLoader.class);
        when(load.getLoader(eq(node), eq("activeSites"), anyBoolean())).thenReturn(loader);

        CoordinateSet expected = mock(CoordinateSet.class);
        when(loader.instantiate(cNode, lm, p)).thenReturn(expected);

        CoordinateSet actual = query.activeSites(node, lm, p);
        assertSame(expected, actual);
    }

    @Test
    public void activeSitesDefault() throws Exception {
        CoordinateSet expected = mock(CoordinateSet.class);
        when(defaults.activeSites(lm, p)).thenReturn(expected);

        CoordinateSet actual = query.activeSites(node, lm, p);
        assertSame(expected, actual);
    }

    @Test
    public void maxTargets() throws Exception {
        Supplier<IntegerArgument> trigger = () -> query.maxTargets(node, random);
        verifyIntegerArgument("maxTargets", trigger);
    }

    @Test
    public void maxTargetsDefault() throws Exception {
        IntegerArgument expected = mock(IntegerArgument.class);
        when(defaults.maxTargets()).thenReturn(expected);
        Runnable trigger = () -> query.maxTargets(node, random);
        verifyIntegerArgumentDefault("maxTargets", expected, trigger);
    }
}