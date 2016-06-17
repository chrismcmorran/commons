package utilities;


import java.io.PrintStream;

public class Logger {
	private boolean debug;
	private boolean verbose;
	private PrintStream out = System.out;

	public Logger(boolean debug, boolean verbose) {
		this.debug = debug;
		this.verbose = verbose;
	}

	public Logger(boolean debug) {
		this.debug = debug;
	}

	public Logger() {
		this.debug = false;
		this.verbose = true;
	}

	public void debug(Object o) {
		if (debug) out.println (o);
	}

	public void verbose(Object o) {
		if (verbose) out.println (o);
	}
}
