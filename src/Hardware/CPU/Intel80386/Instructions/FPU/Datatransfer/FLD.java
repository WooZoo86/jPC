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
package Hardware.CPU.Intel80386.Instructions.FPU.Datatransfer;

import Hardware.CPU.Intel80386.Instructions.Instruction;
import Hardware.CPU.Intel80386.Intel80386;
import Hardware.CPU.Intel80386.Operands.FPU.OperandFPU;



public final class FLD extends Instruction {

    private final OperandFPU m_source;
    
    public FLD(Intel80386 cpu,
               OperandFPU source) {
        
        super(cpu);
        
        m_source = source;
    }

    @Override
    public void run() {
        
        m_cpu.FPU.pushStack(m_source.getValue());
    }
    
    @Override
    public String toString() {
        
        return String.format("fld %s", m_source.toString());
    }
}
