class MyMain{

	public native int cfxn();
	static
	{
		System.loadLibrary("cfxn");
	}

	public static void main(String[] args)
	{
		MyMain hello= new MyMain();
		int a=hello.cfxn();
		System.out.println(a);
	}


}
