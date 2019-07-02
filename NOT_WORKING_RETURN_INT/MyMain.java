class MyMain{

	public native void cfxn();
	static
	{
		System.loadLibrary("cfxn");
	}

	public static void main(String[] args)
	{
		MyMain hello= new MyMain();
		int a=hello.cfxn(3);
		System.out.println("RESULT:");
		System.out.println(a);
	}


}
