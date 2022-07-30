/*
In NativeScript, the app.ts file is the entry point to your application.
You can use this file to perform app-level initialization, but the primary
purpose of the file is to pass control to the app’s first module.
*/

import { Application, Dialogs, Utils } from '@nativescript/core'
let receiverCallback = (context: android.content.Context, intent:android.content.Intent) => {
    const extras: android.os.Bundle = intent.getExtras();
    
    console.log(intent.getStringExtra("DATA"))
};

Application.android.registerBroadcastReceiver(
    "com.android.serial.BARCODEPORT_RECEIVEDDATA_ACTION",
    receiverCallback
);
Application.run({ moduleName: 'app-root' })

/*
Do not place any code after the application has been started as it will not
be executed on iOS.
*/
