package com.azure.mixedreality.remoterendering.models;

import com.azure.core.util.ExpandableStringEnum;

import java.util.Collection;

public final class SessionStatus extends ExpandableStringEnum<SessionStatus> {
    /** Static value Error for SessionStatus. */
    public static final SessionStatus ERROR = fromString("Error");

    /** Static value Expired for SessionStatus. */
    public static final SessionStatus EXPIRED = fromString("Expired");

    /** Static value Starting for SessionStatus. */
    public static final SessionStatus STARTING = fromString("Starting");

    /** Static value Ready for SessionStatus. */
    public static final SessionStatus READY = fromString("Ready");

    /** Static value Stopped for SessionStatus. */
    public static final SessionStatus STOPPED = fromString("Stopped");

    /**
     * Creates or finds a SessionStatus from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding SessionStatus.
     */
    public static SessionStatus fromString(String name) {
        return fromString(name, SessionStatus.class);
    }

    /** @return known SessionStatus values. */
    public static Collection<SessionStatus> values() {
        return values(SessionStatus.class);
    }
}

