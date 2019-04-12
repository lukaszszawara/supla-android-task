package org.supla.android.restapi;

/*
 Copyright (C) AC SOFTWARE SP. Z O.O.

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
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONException;
import org.json.JSONObject;
import org.supla.android.Trace;
import org.supla.android.db.ElectricityMeasurementItem;
import org.supla.android.db.ThermostatMeasurementItem;

public class DownloadThermostatMeasurements extends DownloadMeasurementLogs {

    public DownloadThermostatMeasurements(Context context) {
        super(context);
    }

    protected int itemsLimitPerRequest() {
        return 100;
    }

    protected long getMinTimestamp() {
        //return 0;
        return getMeasurementsDbH().getThermostatMeasurementTimestamp(getChannelId(), true);
    }

    protected long getMaxTimestamp() {
        return getMeasurementsDbH().getThermostatMeasurementTimestamp(getChannelId(), false);
    }

    protected void EraseMeasurements(SQLiteDatabase db) {
        getMeasurementsDbH().deleteThermostatMeasurements(db, getChannelId());
    }

    protected void SaveMeasurementItem(SQLiteDatabase db,
                                       long timestamp, JSONObject obj) throws JSONException {

        ThermostatMeasurementItem thi  = new ThermostatMeasurementItem();
        thi.AssignJSONObject(obj);
        thi.setChannelId(getChannelId());

        getMeasurementsDbH().addThermostatMeasurement(db, thi);

    }

}