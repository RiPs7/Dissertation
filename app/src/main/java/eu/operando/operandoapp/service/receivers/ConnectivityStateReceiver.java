/*
 * Copyright (c) 2016 {UPRC}.
 *
 * OperandoApp is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * OperandoApp is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OperandoApp.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors:
 *       Nikos Lykousas {UPRC}, Constantinos Patsakis {UPRC}, Periklis Maravelias
 * Initially developed in the context of OPERANDO EU project www.operando.eu
 */

package eu.operando.operandoapp.service.receivers;

/**
 * Created by nikos on 5/6/16.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import eu.operando.operandoapp.MainContext;
import eu.operando.operandoapp.OperandoStatusEvent;

public class ConnectivityStateReceiver extends BroadcastReceiver {

    private String TAG = "OPERANDO";

    private MainContext mainContext = MainContext.INSTANCE;

    @Override
    public void onReceive(Context context, Intent intent) {
        mainContext.getBUS().post(new OperandoStatusEvent(OperandoStatusEvent.EventType.ConnectionState));

    }

}