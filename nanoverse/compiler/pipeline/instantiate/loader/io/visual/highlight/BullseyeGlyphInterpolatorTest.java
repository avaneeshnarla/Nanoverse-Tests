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

package nanoverse.compiler.pipeline.instantiate.loader.io.visual.highlight;

import nanoverse.runtime.control.GeneralParameters;
import org.junit.*;

import java.awt.*;
import java.util.function.Supplier;

import static org.mockito.Mockito.*;

public class BullseyeGlyphInterpolatorTest extends GlyphInterpolatorTest {

    private BullseyeGlyphInterpolator query;
    private BullseyeGlyphDefaults defaults;
    private GeneralParameters p;

    @Before
    @Override
    public void before() throws Exception {
        super.before();
        defaults = mock(BullseyeGlyphDefaults.class);
        p = mock(GeneralParameters.class);
        query = new BullseyeGlyphInterpolator(load, defaults, colorLoader);
    }

    @Test
    public void primary() throws Exception {
        Supplier<Color> trigger = () -> query.primary(node, p);
        verifyColor("primary", trigger);
    }

    @Test
    public void primaryDefault() throws Exception {
        String expected = "myPrimary";
        when(defaults.primary()).thenReturn(expected);
        verifyStringDefault("primary", expected, () -> query.primary(node, p));
    }

    @Test
    public void secondary() throws Exception {
        Supplier<Color> trigger = () -> query.secondary(node, p);
        verifyColor("secondary", trigger);
    }

    @Test
    public void secondaryDefault() throws Exception {
        String expected = "mySecondary";
        when(defaults.secondary()).thenReturn(expected);
        verifyStringDefault("secondary", expected, () -> query.secondary(node, p));

    }

    @Test
    public void size() throws Exception {
        Supplier<Double> trigger = () -> query.size(node, random);
        verifyDouble("size", trigger);
    }

    @Test
    public void sizeDefault() throws Exception {
        double expected = 3.0;
        Runnable trigger = () -> query.size(node, random);
        when(defaults.size()).thenReturn(expected);
        verifyDoubleDefault("size", expected, trigger);
    }
}