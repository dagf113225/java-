package com.lixin.lesson9;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * java io流很多，应该使用的是读写性能比较高的流， 减少流的读写的次数
 * 
 * 
 * java io流要们只能读，要们只能写。 可以读也可以写.
 * 
 * @author lenovo
 * 
 */
public class Test
{

	static String srcpath = "./a3.wmv";
	static String topath = "./mp4/a1.wmv";

	public static void copy1()
	{
		FileInputStream in = null;
		FileOutputStream out = null;
		try
		{
			// 一般的字节流
			in = new FileInputStream(srcpath);

			File outf = new File(topath);

			if (!outf.getParentFile().exists())
			{
				outf.getParentFile().mkdirs();
			}
			out = new FileOutputStream(outf);

			byte[] buffer = new byte[1024];

			int len = 0;

			long startTime = System.currentTimeMillis();
			while ((len = in.read(buffer)) != -1)
			{
				out.write(buffer);
			}
			long endTime = System.currentTimeMillis();

			System.out.println("一般的字节流:" + (endTime - startTime));// 一般的字节流:312
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if (null != out)
			{
				try
				{
					out.close();
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (null != in)
			{
				try
				{
					in.close();
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void copy2()
	{
		FileInputStream in = null;
		FileOutputStream out = null;
		try
		{
			// 一般的字节流
			in = new FileInputStream(srcpath);

			File outf = new File(topath);

			if (!outf.getParentFile().exists())
			{
				outf.getParentFile().mkdirs();
			}
			out = new FileOutputStream(outf);

			// 考虑使用缓冲流来包装(转换成缓冲流)一般的字节流
			BufferedInputStream brin = new BufferedInputStream(in);
			BufferedOutputStream brout = new BufferedOutputStream(out);

			byte[] buffer = new byte[1024];
			int len = 0;

			long startTime = System.currentTimeMillis();
			while ((len = brin.read(buffer)) != -1)
			{
				brout.write(buffer);
			}
			long endTime = System.currentTimeMillis();

			System.out.println("缓冲的字节流:" + (endTime - startTime));// 缓冲的字节流:63
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if (null != out)
			{
				try
				{
					out.close();
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (null != in)
			{
				try
				{
					in.close();
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void copy3()
	{
		FileInputStream in = null;

		try
		{
			// 一般的字节流
			in = new FileInputStream(srcpath);

			File outf = new File(topath);

			if (!outf.getParentFile().exists())
			{
				outf.getParentFile().mkdirs();
			}

			// 可读可写
			RandomAccessFile raf = new RandomAccessFile(outf, "rw");

			byte[] buffer = new byte[1024];
			int len = 0;

			long startTime = System.currentTimeMillis();
			while ((len = in.read(buffer)) != -1)
			{
				raf.write(buffer);
			}
			long endTime = System.currentTimeMillis();

			System.out.println("RandomAccessFile的可读可写流:"
					+ (endTime - startTime));// RandomAccessFile的可读可写流:298
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{

			if (null != in)
			{
				try
				{
					in.close();
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	//隆重的NIO，非阻塞式IO,Netty,MIMA
	public static void copy4()
	{
		
		//nio是面向通道
		File outf = new File(topath);

		if (!outf.getParentFile().exists())
		{
			outf.getParentFile().mkdirs();
		}
	
		try
		{
			//得到文件输入流的通道  -->	面向缓冲
			FileChannel   fin = new FileInputStream(srcpath).getChannel();
			
			FileChannel   fout = new FileOutputStream(outf).getChannel();
			long startTime = System.currentTimeMillis();
			//复制文件
			fout.transferFrom(fin, 0, fin.size());
			
			long endTime = System.currentTimeMillis();

			System.out.println("FileChannel:"
					+ (endTime - startTime));//
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args)
	{
		// copy1();
		 copy2();//386

		//copy3();
		
		//copy4();//240
	}
}
