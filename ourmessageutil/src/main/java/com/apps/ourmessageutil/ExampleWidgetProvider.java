package com.apps.ourmessageutil;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;

public class ExampleWidgetProvider extends AppWidgetProvider {

    static void onUpdateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.our_message_widget);
        appWidgetManager.updateAppWidget(appWidgetId, views);
        Log.d("EXAMPLE WIDGET", "onUpdateAppWidget "+appWidgetId);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for(int appWidgetId : appWidgetIds) {
            onUpdateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }
}
