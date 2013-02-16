/*
 * Copyright (C) 2011 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.usb4java.support;

import javax.usb.event.UsbPipeDataEvent;
import javax.usb.event.UsbPipeErrorEvent;
import javax.usb.event.UsbPipeListener;

/**
 * USB pipe listener list.
 *
 * @author Klaus Reimer (k@ailis.de)
 */
public final class UsbPipeListenerList extends
        EventListenerList<UsbPipeListener> implements UsbPipeListener
{
    /**
     * @see EventListenerList#toArray()
     */
    @Override
    public UsbPipeListener[] toArray()
    {
        return this.listeners.toArray(new UsbPipeListener[this.listeners
                .size()]);
    }

    /**
     * @see UsbPipeListener#errorEventOccurred(UsbPipeErrorEvent)
     */
    @Override
    public void errorEventOccurred(final UsbPipeErrorEvent event)
    {
        for (final UsbPipeListener listener : toArray())
            listener.errorEventOccurred(event);
    }

    /**
     * @see UsbPipeListener#dataEventOccurred(UsbPipeDataEvent)
     */
    @Override
    public void dataEventOccurred(final UsbPipeDataEvent event)
    {
        for (final UsbPipeListener listener : toArray())
            listener.dataEventOccurred(event);
    }
}