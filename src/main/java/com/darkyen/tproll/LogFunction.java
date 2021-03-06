package com.darkyen.tproll;

import org.slf4j.Marker;

/**
 * Implements logging of the message to a medium, depending on the implementation.
 * For example console, file or other logging system.
 */
public abstract class LogFunction {
    /**
     * Called when logger needs to log a message. Called only when that log level is enabled in the logger.
     * Can be called by any thread, and thus MUST be thread safe.
     * @param name of the logger
     * @param time in ms since start of the app or since 1970
     * @param level of this message
     * @param marker provided or null
     * @param content of this message, formatted, without trailing newline. Do not keep around!
     */
    public abstract void log(String name, long time, byte level, Marker marker, CharSequence content);

    /**
     * Additional check whether this log function will log message of given level/marker.
     * This is only secondary check, primary level check is done through log level of TPLogger.
     * @return if such message would be logged
     */
    public boolean isEnabled(byte level, Marker marker){
        return true;
    }
}
