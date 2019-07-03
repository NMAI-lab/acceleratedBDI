class MyMain{

	public native int cfxn(int n1,int n2);
	static
	{
		System.loadLibrary("cfxn");
	}

	public static void main(String[] args)
	{
		MyMain hello= new MyMain();
		int a=hello.cfxn(3,9);
		System.out.println(a);
	}


}
