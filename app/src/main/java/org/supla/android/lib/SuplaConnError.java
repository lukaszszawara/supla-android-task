package org.supla.android.lib;

/*
 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.

 Author: Przemyslaw Zygmunt p.zygmunt@acsoftware.pl [AC SOFTWARE]
 */

import android.content.Context;

import org.supla.android.R;

public class SuplaConnError {

    public int Code;

    public String codeToString(Context context) {

     int resid = 0;

     switch(Code) {

      case SuplaConst.SUPLA_RESULTCODE_HOSTNOTFOUND:
       resid = R.string.err_hostnotfound;
       break;

      case SuplaConst.SUPLA_RESULTCODE_CANTCONNECTTOHOST:
       resid = R.string.err_cantconnecttohost;
       break;

     }

     return resid != 0 ? context.getResources().getString(resid) : new Integer(Code).toString();
    }

}