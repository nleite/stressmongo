package nleite.stressmongo;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;

public class StressIt {

	private final InputStreamReader in;
	private final PrintStream out;

	/**
	 * Collect the full in and out streams for further and better unit testing.
	 * 
	 * @param in
	 * @param out
	 */
	public StressIt(InputStreamReader in, PrintStream out) {
		super();
		this.in = in;
		this.out = out;
	}

	public void parseArguments(String[] args) {

		JSAP jsap = new JSAP();
		FlaggedOption numberOfIntances = new FlaggedOption("--instances")
				.setStringParser(JSAP.INETADDRESS_PARSER);
		
		try {
			jsap.registerParameter(numberOfIntances);
		} catch (JSAPException e) {
			out.printf("this is wrong {0}", args);
		}
		JSAPResult config = jsap.parse(args);
		
		out.println("ok");

	}

}
