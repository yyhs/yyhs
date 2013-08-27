package com.yilang.yyhs.utils;

import com.baidu.inf.iis.bcs.BaiduBCS;
import com.baidu.inf.iis.bcs.auth.BCSCredentials;

public class Bcs {
	private static final String accesskey = "mVgZqoDra3hD9xCOQhVhYNAi";
	private static final String secretkey = "b8eezLQ69ochjTSMtZL3GHz0EuP9VeFU";
	private static final String host = "bcs.duapp.com";
	private static BaiduBCS bcs = null;

	public BaiduBCS getBCS() {
		if (bcs == null) {
			BCSCredentials credentials = new BCSCredentials(accesskey,
					secretkey);
			bcs = new BaiduBCS(credentials, host);
		}
		return bcs;
	}

	public static void createBucket(String bucket) {

	}

	public static void deleteBucket(String bucket) {

	}

	public static void listBuckets() {

	}

	public static void putObject(String bucket, String object) {

	}

	public static void listBucketObjects(String bucket) {

	}

	public static void getObject(String bucket, String object) {

	}

	public static void deleteObject(String bucket, String object) {

	}
}
