package com;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @author Brad Peters on 5/9/16.
 */
public class ifdebugtest
{
	private static final Logger logger = LogManager.getLogger( ifdebugtest.class );
	private final int keyCnt = 100000000;

	@Test
	public void debugNoCheck()
	{
		long now = System.currentTimeMillis();

		for (int i = 0; i < keyCnt; i++) {

			logger.debug( "test1" );
		}

		long end = System.currentTimeMillis();

		long time = end - now;

		System.out.println("debugNoCheck: " + keyCnt + " in " + time + " ms");
		double seconds = (double) time / 1000;
		double eps = keyCnt / seconds;
		System.out.println("debugNoCheck/sec: " + eps);
	}

	@Test
	public void Ifdebug()
	{
		long now = System.currentTimeMillis();

		for (int i = 0; i < keyCnt; i++) {

			if(logger.isDebugEnabled())
			{
				logger.debug( "test1" );
			}
		}

		long end = System.currentTimeMillis();

		long time = end - now;

		System.out.println("ifdebug: " + keyCnt + " in " + time + " ms");
		double seconds = (double) time / 1000;
		double eps = keyCnt / seconds;
		System.out.println("ifdebug/sec: " + eps);
	}

	@Test
	public void debugLambdaExpensive()
	{
		long now = System.currentTimeMillis();

		for (int i = 0; i < keyCnt; i++) {

			logger.debug( "test1", this::expensiveFunction );
		}

		long end = System.currentTimeMillis();

		long time = end - now;

		System.out.println("debugLambdaExpensive: " + keyCnt + " in " + time + " ms");
		double seconds = (double) time / 1000;
		double eps = keyCnt / seconds;
		System.out.println("debugLambdaExpensive/sec: " + eps);
	}

	@Test
	public void debugExpensive()
	{
		long now = System.currentTimeMillis();

		for (int i = 0; i < keyCnt; i++) {

			logger.debug( "test1", expensiveFunction() );
		}

		long end = System.currentTimeMillis();

		long time = end - now;

		System.out.println("debugLambdaExpensive: " + keyCnt + " in " + time + " ms");
		double seconds = (double) time / 1000;
		double eps = keyCnt / seconds;
		System.out.println("debugLambdaExpensive/sec: " + eps);
	}

	@Test
	public void debugLambdaNotExpensive()
	{
		long now = System.currentTimeMillis();

		final String cheapValue = "cheapValue";

		for (int i = 0; i < keyCnt; i++) {

			logger.debug( "test1 {} ", () -> cheapValue);
		}

		long end = System.currentTimeMillis();

		long time = end - now;

		System.out.println("debugLambdaNotExpensive: " + keyCnt + " in " + time + " ms");
		double seconds = (double) time / 1000;
		double eps = keyCnt / seconds;
		System.out.println("debugLambdaNotExpensive/sec: " + eps);
	}

	@Test
	public void debugNotExpensive()
	{
		long now = System.currentTimeMillis();

		final String cheapValue = "cheapValue";

		for (int i = 0; i < keyCnt; i++) {

			logger.debug( "test1 {} ", cheapValue);
		}

		long end = System.currentTimeMillis();

		long time = end - now;

		System.out.println("debugNotExpensive: " + keyCnt + " in " + time + " ms");
		double seconds = (double) time / 1000;
		double eps = keyCnt / seconds;
		System.out.println("debugNotExpensive/sec: " + eps);
	}

	public String expensiveFunction()
	{
		return "expensiveFunction";
	}
}
