/*
 * Copyright (C) 2015 Domoticz
 *
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */

package nl.hnogames.domoticz.Utils;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import nl.hnogames.domoticz.Widgets.WidgetProviderLarge;

import static android.appwidget.AppWidgetManager.EXTRA_APPWIDGET_ID;

public class WidgetUtils {
    public final static String WIDGET_UPDATE_ACTION = "nl.hnogames.domoticz.Utils.intent.action.UPDATE_WIDGET";

    public static void RefreshWidgets(Context context) {
        //refresh all widgets
        AppWidgetManager widgetManager = AppWidgetManager.getInstance(context);
        ComponentName widgetComponent = new ComponentName(context, WidgetProviderLarge.class);
        int[] appWidgetIds = widgetManager.getAppWidgetIds(widgetComponent);
        for (int i = 0; i < appWidgetIds.length; i++) {
            Intent updateIntent = new Intent(context, WidgetProviderLarge.UpdateWidgetService.class);
            updateIntent.putExtra(EXTRA_APPWIDGET_ID, appWidgetIds[i]);
            updateIntent.setAction("FROM WIDGET PROVIDER");
            context.startService(updateIntent);
        }
    }
}