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

package nanoverse.compiler.pipeline.instantiate.loader.processes.discrete.filter;

import nanoverse.compiler.pipeline.instantiate.loader.InterpolatorTest;
import nanoverse.compiler.pipeline.translate.nodes.ListObjectNode;
import nanoverse.runtime.layers.cell.AgentLayer;
import nanoverse.runtime.processes.discrete.filter.Filter;
import org.junit.*;

import java.util.stream.Stream;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class CompositeFilterInterpolatorTest extends InterpolatorTest {

    private CompositeFilterDefaults defaults;
    private AgentLayer layer;
    private CompositeFilterInterpolator query;

    @Before
    public void before() throws Exception {
        super.before();
        defaults = mock(CompositeFilterDefaults.class);
        layer = mock(AgentLayer.class);
        query = new CompositeFilterInterpolator(load, defaults);
    }

    @Test
    public void including() throws Exception {
        ListObjectNode cNode = mock(ListObjectNode.class);
        when(node.getMember("including")).thenReturn(cNode);

        FilterStreamLoader loader = mock(FilterStreamLoader.class);
        when(load.getLoader(eq(node), eq("including"), anyBoolean())).thenReturn(loader);

        Stream<Filter> expected = mock(Stream.class);
        when(loader.instantiate(cNode, lm, p)).thenReturn(expected);

        Stream<Filter> actual = query.including(node, lm, p);
        assertSame(expected, actual);
    }

    @Test
    public void includingDefault() throws Exception {
        Stream<Filter> expected = mock(Stream.class);
        when(defaults.including()).thenReturn(expected);
        Stream<Filter> actual = query.including(node, lm, p);
        assertSame(expected, actual);
    }
}