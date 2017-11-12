package com.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

class Write {
	void _do(File _f, String _t, Object _i) throws IOException {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter out = null;
		try {
			fw = new FileWriter(_f, true);
			bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			out.println(_t + " : " + _i);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Logger {
	public void print(Object info) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String filename = new SimpleDateFormat("yyyy.MM.dd.HH").format(new Date());

		try {
			File file = new File(System.getProperty("user.dir") + "Logs//" + filename);
			Write _w = new Write();

			if (file.createNewFile()) {
				_w._do(file, timestamp, info);
			} else {
				_w._do(file, timestamp, info);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
