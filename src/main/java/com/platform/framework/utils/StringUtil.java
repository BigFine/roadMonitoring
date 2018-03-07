package com.platform.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.web.multipart.MultipartFile;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 *<p>类描述：常用工具类。</p>
 * @author 范相如[zggk-fanxr] 
 * Copyright 【中公高科养护科技股份有限公司】 2016
 * @version: v1.0.0.1。
 * @since JDK1.6。
 *<p>创建日期：2016-12-30 上午10:42:02。</p>
 */
public class StringUtil {

	/**
	 * <p>功能描述：判断字符串是否为空字符串。</p>	
	 * @param str
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2014-9-14 上午9:53:02。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static boolean isNullOrEmpty(String str){

		if(str == null){
			return true;
		}
		if(str.isEmpty()){
			return true;
		}
		return false;
	}
	/**
	 * <p>功能描述：字符串转int。</p>	
	 * @param str
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2014-9-14 上午9:53:02。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static int stringToInt(String str){

		return Integer.parseInt(str);
	}
	public static Float stringFloat(String str){

		return Float.parseFloat(str);
	}
	/**
	 * 
	 * <p>功能描述：获取文件名（不带扩展名）。</p>	
	 * @param filename
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2017-1-9 下午2:18:59。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static String getFileNameNoEx(String filename){
		if ((filename != null) && (filename.length() > 0)) {   
			int dot = filename.lastIndexOf('.');   
			if ((dot >-1) && (dot < (filename.length()))) {   
				return filename.substring(0, dot);   
			}   
		}   
		return filename;   
	}

	/**
	 * <p>功能描述：编码补位。</p>	
	 * @param source	
	 * @param specialChar
	 * @param len
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2014-9-14 下午4:18:34。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static String generateCode(String source,char specialChar,int len){

		String str ="";

		if(isNullOrEmpty(source)){
			str ="";
		}else{
			source = source.trim();
			if(source.length()>len){
				str = source.substring(0,len);
			}else{
				str = source;
			}

			len = len - str.length();
		}
		str = copyChar(specialChar,len)+ str;
		return str;

	}

	/**
	 * <p>功能描述：字符复制。</p>	
	 * @param specialChar
	 * @param len
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2014-9-14 下午4:18:12。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static String copyChar(char specialChar,int len){

		String str ="";
		for(int i=0;i<len;i++){
			str += specialChar;
		}
		return str;
	}

	/**
	 * 
	 * <p>功能描述：为字符串中每个字段添加引号。</p>	
	 * @param str 字符串  例 a,b,c → ‘a’,‘b’,‘c’
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2014-8-18 上午11:54:13。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static String addToString(String str){
		String s = "";
		String[] split = str.split(",");
		s += "'"+split[0]+"'";
		for (int i = 1; i < split.length; i++) {
			s += ",'"+split[i]+"'";
		}
		return s;
	}

	/**
	 * 
	 * <p>功能描述：将字符数组添加单引号并用逗号隔开拼接成字符串。</p>	
	 * @param str 字符数组 例 [a,b,c] → ‘a’,‘b’,‘c’
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2014-9-19 上午11:43:43。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static String arry2Str(String[] str){
		String s = "";
		if(str.length>0){
			s = "'"+str[0]+"'";
			for (int i = 1; i < str.length; i++) {
				s+=",'"+str[i]+"'";
			}
		}
		return s;
	}
	
	/**
	 * 
	 * <p>功能描述：将字符数组添加单引号并用逗号隔开拼接成字符串。</p>	
	 * @param str 字符数组 例 [a,b,c] → ‘a’,‘b’,‘c’
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2014-9-19 上午11:43:43。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static String arry2StrNoS(String[] str){
		String s = "";
		if(str.length>0){
			s = str[0];
			for (int i = 1; i < str.length; i++) {
				s+=","+str[i];
			}
		}
		return s;
	}

	/**
	 * 
	 * <p>功能描述：判断字符串是否为数字(空or null也返回true)。</p>	
	 * @param value
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2015-1-6 下午4:38:30。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static boolean isDouble(String value) {
		try {
			if(isNullOrEmpty(value)) return true;
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	/**
	 * 
	 * <p>功能描述：数字转换为桩号格式。</p>	
	 * @param stake 例 100.101 → 100+101
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2017-1-23 上午10:04:46。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static String getDisplayStake(Double stake){

		String str ="";

		if(stake != null){
			DecimalFormat df = new DecimalFormat("#.000");   

			String strValue =df.format(stake);
			int iPos =strValue.indexOf(".");
			String s = strValue.substring(0,iPos);
			if(StringUtil.isNullOrEmpty(s)){
				str = "0+"+ strValue.substring(iPos+1,strValue.length());
			}else{
				str = ""+ strValue.substring(0,iPos)+ "+"+ strValue.substring(iPos+1,strValue.length());
			}
		}
		return str;
	}
	/**
	 * 
	 * <p>功能描述：四舍五入保留两位小数。</p>	
	 * @param num
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2015-1-24 下午5:11:54。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static double toDoubleRound(Double num){
		BigDecimal bg = new BigDecimal(num);
		double n = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return n;
	}
	/**
	 * 
	 * <p>功能描述：四舍五入保留位小数。</p>	
	 * @param num
	 * @param o位数
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2015-1-24 下午5:11:54。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static double toDoubleRound(Double num,int o){
		BigDecimal bg = new BigDecimal(num);
		double n = bg.setScale(o, BigDecimal.ROUND_HALF_UP).doubleValue();
		return n;
	}

	/**
	 * 
	 * <p>功能描述：生成UUID。</p>	
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2015-7-20 下午3:57:45。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	/**
	 * 
	 * <p>功能描述：获取文件名后缀。</p>	
	 * @param str
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2016-12-30 下午1:20:06。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static String getFileExtension(String str){
		return str.substring(str.lastIndexOf(".")+1);
	}

	/**
	 * 
	 * <p>功能描述：判断字符串是否为Double数字。</p>	
	 * @param str
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2017-1-3 下午2:51:05。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static boolean isDigit(String str){
		try {
			double num=Double.valueOf(str);//把字符串强制转换为数字   
			return true;//如果是数字，返回True   
		} catch (Exception e) {
			return false;//如果抛出异常，返回False   
		}  

	}

	/**
	 * 
	 * <p>功能描述：返回Double的小数部分。</p>	
	 * @param stake	例 192.12 → 120
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2017-1-23 上午10:24:50。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static Integer splitDouble(Double stake){
		Integer res = (int) (stake * 1000);
		return res%1000;
	}

	/**
	 * 
	 * <p>功能描述：求数组中double的平均值（null 0除外）。</p>	
	 * @param ds
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2017-2-17 下午6:12:39。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static Double getAvgDouble(Double[] ds){
		int index=0;
		Double t=0.0;
		for(int i=0;i<ds.length;i++){
			if(ds[i]!=null && ds[i]>0){
				t+=ds[i];
				index++;
			}
		}
		if(t==0){
			return 0.0;
		}else{
			return toDoubleRound(t/index,1);
		}
	}

	/**
	 * 
	 * <p>功能描述：根据起终点桩号划分百米路段。</p>	
	 * @param sstake
	 * @param estake
	 * @return
	 * @since JDK1.6。
	 * <p>创建日期:2017-4-7 上午11:45:20。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public static List<Map<String, String>> getSplitUnit100(Double sstake,
			Double estake){
		sstake = sstake*10;
		estake = estake*10;
		Double minScale =  0.5;//最少不低于0.5km
		Double maxScale = 1.5;//最高不大于1.5km

		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		//总长度 (千米)
		Double totalLength = estake - sstake;

		DecimalFormat df = new DecimalFormat("0.000");

		if(totalLength < maxScale){
			Map<String,String> map = new HashMap<String, String>();
			map.put("SK", df.format(sstake/10));
			map.put("EK", df.format(estake/10));
			list.add(map);
		}else{
			//从起始桩号开始 + 1
			while(sstake < estake){
				Map<String,String> map1 = new HashMap<String, String>();
				Double currentVal  = sstake + 1;
				if((estake - currentVal) < minScale){
					map1.put("SK", df.format(sstake/10));
					map1.put("EK", df.format(estake/10));
					list.add(map1);
					break;
				}else if((estake - currentVal) >= minScale){
					map1.put("SK", df.format(sstake/10));
					currentVal = Math.rint(currentVal);
					map1.put("EK", df.format(currentVal/10));
				}
				list.add(map1);
				sstake = currentVal;
			}

		}

		/*	for(Map<String,Double> map : list){
			System.out.println(map.get("SK")+"-"+map.get("EK"));
		}*/
		return list;
	}

	/**
	 * 
	 *<p>方法描述：MD5加密。</p>
	 * @author 范相如[fanxiangru] 
	 * Copyright 【中公高科养护科技股份有限公司】 2017
	 * @version: v1.0.0.1。
	 * @param str
	 * @return
	 * @since JDK1.7。
	 *<p>创建日期：2017年4月20日 下午3:27:36。</p>
	 */
	public static String getMD5Str(String str){
		try{
			// 生成一个MD5加密计算摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(str.getBytes());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			return new BigInteger(1, md.digest()).toString(16).toUpperCase();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("密码解析失败.");
			return null;
		}
	}


	/**
	 * 
	 *<p>方法描述：图片转化成base64字符串。</p>
	 * @author 范相如[fanxiangru] 
	 * Copyright 【中公高科养护科技股份有限公司】 2017
	 * @version: v1.0.0.1。
	 * @param imgUrl
	 * @return
	 * @since JDK1.7。
	 *<p>创建日期：2017年5月22日 上午9:16:18。</p>
	 */
	public static String getImageStr(String imgUrl) {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		String imgFile = imgUrl;// 待处理的图片
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
		in = new FileInputStream(imgFile);
		data = new byte[in.available()];
		in.read(data);
		in.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	/**
	 * 
	 *<p>方法描述： base64字符串转化成文件（newUrl中需指出文件名称）。</p>
	 * @author 范相如[fanxiangru] 
	 * Copyright 【中公高科养护科技股份有限公司】 2017
	 * @version: v1.0.0.1。
	 * @param imgStr
	 * @param newUrl
	 * @return
	 * @since JDK1.7。
	 *<p>创建日期：2017年5月22日 上午9:18:15。</p>
	 */
	public static boolean getFileByBase64(String imgStr,String newUrl) { //对字节数组字符串进行Base64解码并生成文件
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			String imgFilePath = newUrl;//新生成的图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	  *<p>方法描述：合并多个数组。</p>
	  * @author 范相如[fanxiangru] 
	  * Copyright 【中公高科养护科技股份有限公司】 2017
	  * @version: v1.0.0.1。
	  * @param list
	  * @return
	  * @since JDK1.7。
	  *<p>创建日期：2017年6月2日 上午10:51:10。</p>
	 */
	public static String[] collectArrays(List<String[]> list){
		String[] ids = new String[]{};
		// tyy 每次都是两个数组合并 所以合并的次数为 collect.size() ，第一个是虚拟的数组  
		for (int k = 0; k < list.size(); k++) {
			String[] aa1 = list.get(k);  
			if(null!=aa1 && aa1.length>0){
				ids = (String[]) ArrayUtils.addAll(ids, aa1);  
			}
		} 
		return ids;
	}
	
	/**
	 * 
	  *<p>方法描述：MultipartFile转Base64。</p>
	  * @author 范相如[fanxiangru] 
	  * Copyright 【中公高科养护科技股份有限公司】 2017
	  * @version: v1.0.0.1。
	  * @param file
	  * @return
	  * @since JDK1.7。
	  *<p>创建日期：2017年6月2日 下午4:23:48。</p>
	 */
	public static String multipartFileToBase64(MultipartFile file) {
        try {
            byte[] buffer = file.getBytes();
            return new BASE64Encoder().encode(buffer);
        } catch (Exception e) {
            throw new RuntimeException("文件路径无效\n" + e.getMessage());
        }
    }
	
	/**
	 * 
	  *<p>方法描述：删除某个数组值。</p>
	  * @author 范相如[fanxiangru] 
	  * Copyright 【中公高科养护科技股份有限公司】 2017
	  * @version: v1.0.0.1。例 [1，2，3，4] → [1，3，4]
	  * @param array	原数组
	  * @param str 需要移除的字符串
	  * @return
	  * @since JDK1.7。
	  *<p>创建日期：2017年7月26日 上午11:47:06。</p>
	 */
	public static String[] removeArray(String[] array,String str) {
		List<String> list = new ArrayList<String>();
		for(int i=0;i<array.length;i++) {
			if(!array[i].equals(str)) {
				list.add(array[i]);
			}
		}
		String[] ids = new String[list.size()];
		for(int i=0;i<list.size();i++) {
			ids[i] = list.get(i);
		}
		return ids;
	}
	
	/**
	 * 
	  *<p>方法描述：base64字符串转化成图片。</p>
	  * @author 范相如[fanxiangru] 
	  * Copyright 【中公高科养护科技股份有限公司】 2017
	  * @version: v1.0.0.1。
	  * @param imgStr
	  * @param newPath
	  * @return
	  * @since JDK1.7。
	  *<p>创建日期：2017年9月22日 下午4:16:20。</p>
	 */
	public static boolean GenerateImage(String imgStr,String newPath) { // 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(newPath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
	String str = "123456789&&";
	System.out.println(str.substring(0, str.length()-1));
		   
	}
}
