/*
 * Copyright (C) 2017 h0MER247
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package Hardware.CPU.Intel8086.Pointer;

import Hardware.CPU.Intel8086.Register.Reg16;



public final class PointerBaseIndex implements Pointer {

    private final Reg16 m_base;
    private final Reg16 m_index;

    public PointerBaseIndex(Reg16 base,
                            Reg16 index) {

        m_base = base;
        m_index = index;
    }

    @Override
    public int getAddress() {

        return (m_base.getValue() + m_index.getValue()) & 0xffff;
    }

    @Override
    public String toString() {

        return String.format("%s + %s", m_base.toString(), m_index.toString());
    }
}
