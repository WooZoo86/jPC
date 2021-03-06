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
package Hardware.CPU.Intel80386.Instructions.i386.String;

import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Register.General.Register;
import Hardware.CPU.Intel80386.Register.Segments.Segment;



public final class OUTSD extends Instruction {
    
    private final Register m_srcIndex;
    private final Segment m_srcSegment;
    
    public OUTSD(Intel80386 cpu,
                 Register srcIndex,
                 Segment srcSegment) {
        
        super(cpu);
        
        m_srcIndex = srcIndex;
        m_srcSegment = srcSegment;
    }
    
    @Override
    public void run() {
        
        int srcIndex = m_srcIndex.getValue();
        
        // Output DS:[(E)SI] to i/o port DX
        m_cpu.writeIO32(m_cpu.DX.getValue(), m_cpu.readMEM32(m_srcSegment, srcIndex));
        
        // Update index
        if(m_cpu.FLAGS.DF)
            m_srcIndex.setValue(srcIndex - 4);
        else
            m_srcIndex.setValue(srcIndex + 4);
    }
    
    @Override
    public String toString() {
        
        return "outsd";
    }
}
