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
 * java io���ܶ࣬Ӧ��ʹ�õ��Ƕ�д���ܱȽϸߵ����� �������Ķ�д�Ĵ���
 * 
 * 
 * java io��Ҫ��ֻ�ܶ���Ҫ��ֻ��д�� ���Զ�Ҳ����д.
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
			// һ����ֽ���
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

			System.out.println("һ����ֽ���:" + (endTime - startTime));// һ����ֽ���:312
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
			// һ����ֽ���
			in = new FileInputStream(srcpath);

			File outf = new File(topath);

			if (!outf.getParentFile().exists())
			{
				outf.getParentFile().mkdirs();
			}
			out = new FileOutputStream(outf);

			// ����ʹ�û���������װ(ת���ɻ�����)һ����ֽ���
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

			System.out.println("������ֽ���:" + (endTime - startTime));// ������ֽ���:63
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
			// һ����ֽ���
			in = new FileInputStream(srcpath);

			File outf = new File(topath);

			if (!outf.getParentFile().exists())
			{
				outf.getParentFile().mkdirs();
			}

			// �ɶ���д
			RandomAccessFile raf = new RandomAccessFile(outf, "rw");

			byte[] buffer = new byte[1024];
			int len = 0;

			long startTime = System.currentTimeMillis();
			while ((len = in.read(buffer)) != -1)
			{
				raf.write(buffer);
			}
			long endTime = System.currentTimeMillis();

			System.out.println("RandomAccessFile�Ŀɶ���д��:"
					+ (endTime - startTime));// RandomAccessFile�Ŀɶ���д��:298
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
	//¡�ص�NIO��������ʽIO,Netty,MIMA
	public static void copy4()
	{
		
		//nio������ͨ��
		File outf = new File(topath);

		if (!outf.getParentFile().exists())
		{
			outf.getParentFile().mkdirs();
		}
	
		try
		{
			//�õ��ļ���������ͨ��  -->	���򻺳�
			FileChannel   fin = new FileInputStream(srcpath).getChannel();
			
			FileChannel   fout = new FileOutputStream(outf).getChannel();
			long startTime = System.currentTimeMillis();
			//�����ļ�
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
