class MyMain{

	public native void cfxn();
	static
	{
		System.loadLibrary("cfxn");
	}

	public static void main(String[] args)
	{
		MyMain hello= new MyMain();
		hello.cfxn();
	}


}
