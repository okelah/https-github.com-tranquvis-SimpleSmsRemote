package tranquvis.simplesmsremote;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import tranquvis.simplesmsremote.Services.Sms.MySmsCommandMessage;

/**
 * Created by Andreas Kaltenleitner on 02.09.2016.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MyNotificationManagerTest
{
    private Context appContext;
    private MyNotificationManager notificationManager;

    @Before
    public void setup() {
        appContext = InstrumentationRegistry.getTargetContext();
        notificationManager = MyNotificationManager.getInstance(appContext);
    }

    @Test
    public void testNotifySmsCommandsReceived() throws Exception
    {
        MySmsCommandMessage smsCommandMessage = new MySmsCommandMessage("000");
        smsCommandMessage.addControlCommand(ControlCommand.WIFI_HOTSPOT_DISABLE);
        smsCommandMessage.addControlCommand(ControlCommand.MOBILE_DATA_ENABLE);
        List<ControlCommand> failedCommands = new ArrayList<>();
        failedCommands.add(ControlCommand.MOBILE_DATA_ENABLE);
        notificationManager.notifySmsCommandsReceived(smsCommandMessage);
    }

    @Test
    public void testNotifyStartReceiverAfterBootFailed() throws Exception
    {
        notificationManager.notifyStartReceiverAfterBootFailed();
    }

    @After
    public void beforeEnd() throws InterruptedException
    {
        Thread.sleep(20000);
    }
}