package main;

import java.util.logging.Logger;

class SanitizedTextLogger extends Logger {
    Logger delegate;

    public SanitizedTextLogger(Logger delegate) {
        super(delegate.getName(), delegate.getResourceBundleName());
        this.delegate = delegate;
    }

    public String sanitize(String msg) {
        String[] lines = msg.split("\n");
        StringBuilder sanitizedMsg = new StringBuilder(lines[0]);
        for (int i = 1; i < lines.length; i++) {
            sanitizedMsg.append("\n  ").append(lines[i]);
        }
        return sanitizedMsg.toString();
    }

    @Override
    public void severe(String msg) {
        delegate.severe(sanitize(msg));
    }

    @Override
    public void warning(String msg) {
        delegate.warning(sanitize(msg));
    }

    @Override
    public void info(String msg) {
        delegate.info(sanitize(msg));
    }

    @Override
    public void config(String msg) {
        delegate.config(sanitize(msg));
    }

    @Override
    public void fine(String msg) {
        delegate.fine(sanitize(msg));
    }

    @Override
    public void finer(String msg) {
        delegate.finer(sanitize(msg));
    }

    @Override
    public void finest(String msg) {
        delegate.finest(sanitize(msg));
    }
}

public class R00_IDS03_J {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("TestLogger");
        SanitizedTextLogger sanLogger = new SanitizedTextLogger(logger);

        boolean loginSuccessful = true;
        String username = "User";

        if (loginSuccessful) {
            sanLogger.severe("User login succeeded for: " + username);
        } else {
            sanLogger.severe("User login failed for: " + username);
        }
    }
}
