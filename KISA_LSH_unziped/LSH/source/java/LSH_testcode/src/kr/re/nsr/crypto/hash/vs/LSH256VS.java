package kr.re.nsr.crypto.hash.vs;

import java.util.Arrays;

import kr.re.nsr.crypto.Hash;

public class LSH256VS {
	//@formatter:off
	static final byte EXP0000[] = { (byte) 0xf3, (byte) 0xcd, (byte) 0x41, (byte) 0x6a, (byte) 0x03, (byte) 0x81, (byte) 0x82, (byte) 0x17, (byte) 0x72, (byte) 0x6c, (byte) 0xb4, (byte) 0x7f, (byte) 0x4e, (byte) 0x4d, (byte) 0x28, (byte) 0x81, (byte) 0xc9, (byte) 0xc2, (byte) 0x9f, (byte) 0xd4, (byte) 0x45, (byte) 0xc1, (byte) 0x8b, (byte) 0x66, (byte) 0xfb, (byte) 0x19, (byte) 0xde, (byte) 0xa1, (byte) 0xa8, (byte) 0x10, (byte) 0x07, (byte) 0xc1 };
	
	static final byte EXP0001[] = { (byte) 0xfd, (byte) 0x5b, (byte) 0xe8, (byte) 0x99, (byte) 0xff, (byte) 0x15, (byte) 0x74, (byte) 0x3e, (byte) 0x75, (byte) 0xc1, (byte) 0xde, (byte) 0xfb, (byte) 0xdc, (byte) 0xd8, (byte) 0xbd, (byte) 0x8f, (byte) 0x10, (byte) 0x39, (byte) 0x75, (byte) 0xd8, (byte) 0x1d, (byte) 0x64, (byte) 0xd7, (byte) 0xe3, (byte) 0x5f, (byte) 0xe9, (byte) 0xe2, (byte) 0x3d, (byte) 0x98, (byte) 0x6e, (byte) 0x66, (byte) 0x62 };
	static final byte EXP0002[] = { (byte) 0x10, (byte) 0xae, (byte) 0x63, (byte) 0xfd, (byte) 0x3d, (byte) 0xc6, (byte) 0x3f, (byte) 0xa8, (byte) 0xe2, (byte) 0x1b, (byte) 0x51, (byte) 0xae, (byte) 0xa0, (byte) 0xd4, (byte) 0x6d, (byte) 0x40, (byte) 0x95, (byte) 0x7c, (byte) 0xc0, (byte) 0x8e, (byte) 0x0d, (byte) 0x8f, (byte) 0x6a, (byte) 0x74, (byte) 0xcb, (byte) 0xfd, (byte) 0xaf, (byte) 0xf1, (byte) 0x61, (byte) 0xe0, (byte) 0xc0, (byte) 0xc2 };
	static final byte EXP0007[] = { (byte) 0x34, (byte) 0x14, (byte) 0x0d, (byte) 0x1e, (byte) 0x77, (byte) 0x87, (byte) 0x2c, (byte) 0x87, (byte) 0x99, (byte) 0xc1, (byte) 0xeb, (byte) 0xb3, (byte) 0x55, (byte) 0xcb, (byte) 0xb3, (byte) 0xe6, (byte) 0x19, (byte) 0x31, (byte) 0xf4, (byte) 0x59, (byte) 0x4c, (byte) 0x34, (byte) 0x7a, (byte) 0x29, (byte) 0xa1, (byte) 0x2f, (byte) 0x29, (byte) 0x3a, (byte) 0x46, (byte) 0xdf, (byte) 0x0f, (byte) 0xe1 };

	static final byte EXP0008[] = { (byte) 0xcf, (byte) 0x25, (byte) 0xc4, (byte) 0x7e, (byte) 0xb1, (byte) 0xef, (byte) 0xa7, (byte) 0x7d, (byte) 0x2f, (byte) 0x7a, (byte) 0x1d, (byte) 0xfc, (byte) 0xc0, (byte) 0x9f, (byte) 0x4d, (byte) 0x3a, (byte) 0xcf, (byte) 0xe9, (byte) 0x7d, (byte) 0xc7, (byte) 0x7c, (byte) 0x31, (byte) 0x7b, (byte) 0x43, (byte) 0x97, (byte) 0x6e, (byte) 0x7b, (byte) 0x23, (byte) 0x8d, (byte) 0xa3, (byte) 0xdc, (byte) 0x71 };
	static final byte EXP0015[] = { (byte) 0x0a, (byte) 0xfe, (byte) 0xa6, (byte) 0xcd, (byte) 0xc8, (byte) 0xba, (byte) 0x4c, (byte) 0x2b, (byte) 0x2f, (byte) 0x5f, (byte) 0xb1, (byte) 0xf3, (byte) 0x2e, (byte) 0xd2, (byte) 0x7c, (byte) 0x22, (byte) 0xac, (byte) 0xc8, (byte) 0x81, (byte) 0x4e, (byte) 0x70, (byte) 0xd5, (byte) 0x4f, (byte) 0x64, (byte) 0xb6, (byte) 0x23, (byte) 0xb4, (byte) 0x10, (byte) 0x9b, (byte) 0x32, (byte) 0x21, (byte) 0x77 };
	static final byte EXP0016[] = { (byte) 0x70, (byte) 0x59, (byte) 0x9e, (byte) 0x67, (byte) 0x39, (byte) 0x9e, (byte) 0xa1, (byte) 0x45, (byte) 0x8c, (byte) 0x9d, (byte) 0xdc, (byte) 0xb8, (byte) 0x31, (byte) 0x4b, (byte) 0x7a, (byte) 0xbb, (byte) 0x4c, (byte) 0x6e, (byte) 0x97, (byte) 0xa5, (byte) 0x97, (byte) 0x98, (byte) 0x4d, (byte) 0x67, (byte) 0x76, (byte) 0xa3, (byte) 0x0f, (byte) 0xf5, (byte) 0xbc, (byte) 0x87, (byte) 0xfe, (byte) 0xd6 };

	static final byte EXP1023[] = { (byte) 0x69, (byte) 0xbd, (byte) 0x57, (byte) 0x58, (byte) 0x0e, (byte) 0xaf, (byte) 0x01, (byte) 0xf8, (byte) 0xce, (byte) 0x84, (byte) 0x5d, (byte) 0x02, (byte) 0x3f, (byte) 0x07, (byte) 0x0a, (byte) 0x36, (byte) 0x16, (byte) 0x34, (byte) 0x75, (byte) 0x09, (byte) 0x84, (byte) 0x7f, (byte) 0x99, (byte) 0x48, (byte) 0xbb, (byte) 0x1a, (byte) 0x04, (byte) 0xed, (byte) 0x6c, (byte) 0x70, (byte) 0x63, (byte) 0xc7 };
	static final byte EXP1024[] = { (byte) 0x2d, (byte) 0x44, (byte) 0xa9, (byte) 0x0b, (byte) 0x60, (byte) 0xf6, (byte) 0x96, (byte) 0xe8, (byte) 0xfa, (byte) 0x4b, (byte) 0xb2, (byte) 0x54, (byte) 0x32, (byte) 0xe2, (byte) 0x2d, (byte) 0xeb, (byte) 0xa1, (byte) 0xd9, (byte) 0x77, (byte) 0x5c, (byte) 0xff, (byte) 0x56, (byte) 0x06, (byte) 0xdb, (byte) 0xa2, (byte) 0x54, (byte) 0x5d, (byte) 0x17, (byte) 0xe2, (byte) 0xd4, (byte) 0xbf, (byte) 0x9a };
	static final byte EXP1025[] = { (byte) 0xe4, (byte) 0x73, (byte) 0x27, (byte) 0x8f, (byte) 0x03, (byte) 0x77, (byte) 0x60, (byte) 0xdf, (byte) 0x87, (byte) 0x20, (byte) 0xf9, (byte) 0xab, (byte) 0xca, (byte) 0x62, (byte) 0xbf, (byte) 0x38, (byte) 0x1c, (byte) 0xc3, (byte) 0x23, (byte) 0x2a, (byte) 0xc6, (byte) 0x8e, (byte) 0xce, (byte) 0x3e, (byte) 0xb3, (byte) 0xa8, (byte) 0x01, (byte) 0xa0, (byte) 0x7c, (byte) 0xe5, (byte) 0xaf, (byte) 0x64 };

	static final byte EXP2047[] = { (byte) 0x7c, (byte) 0xe1, (byte) 0x25, (byte) 0xd1, (byte) 0x98, (byte) 0x4a, (byte) 0x19, (byte) 0xd6, (byte) 0x52, (byte) 0x2d, (byte) 0x4a, (byte) 0xfc, (byte) 0xa5, (byte) 0xeb, (byte) 0x6a, (byte) 0x48, (byte) 0xa8, (byte) 0x98, (byte) 0xfa, (byte) 0xd5, (byte) 0xb4, (byte) 0xfd, (byte) 0x94, (byte) 0x36, (byte) 0xa3, (byte) 0x2f, (byte) 0xbc, (byte) 0x9e, (byte) 0x16, (byte) 0x07, (byte) 0xe0, (byte) 0x8c };
	static final byte EXP2048[] = { (byte) 0x71, (byte) 0xbb, (byte) 0x40, (byte) 0x71, (byte) 0xbc, (byte) 0x78, (byte) 0x9e, (byte) 0x2c, (byte) 0x48, (byte) 0xb7, (byte) 0x26, (byte) 0xb5, (byte) 0x46, (byte) 0xa5, (byte) 0x29, (byte) 0xcb, (byte) 0x6a, (byte) 0x18, (byte) 0x51, (byte) 0xa7, (byte) 0x68, (byte) 0x6c, (byte) 0x36, (byte) 0x12, (byte) 0xad, (byte) 0xe3, (byte) 0xf7, (byte) 0xc0, (byte) 0x16, (byte) 0x0d, (byte) 0x68, (byte) 0x84 };
	static final byte EXP2049[] = { (byte) 0xca, (byte) 0x9e, (byte) 0x93, (byte) 0x28, (byte) 0xdb, (byte) 0x05, (byte) 0xbd, (byte) 0x14, (byte) 0xa7, (byte) 0x64, (byte) 0xdb, (byte) 0x5a, (byte) 0x78, (byte) 0x09, (byte) 0x09, (byte) 0xc2, (byte) 0x13, (byte) 0x0a, (byte) 0x1c, (byte) 0xae, (byte) 0x86, (byte) 0xc5, (byte) 0xdb, (byte) 0xfb, (byte) 0x36, (byte) 0xa9, (byte) 0xe4, (byte) 0x4a, (byte) 0x88, (byte) 0x93, (byte) 0x54, (byte) 0x3c };

	static final byte EXP3071[] = { (byte) 0x28, (byte) 0xf3, (byte) 0xe6, (byte) 0x95, (byte) 0x26, (byte) 0x76, (byte) 0x56, (byte) 0xad, (byte) 0x99, (byte) 0xe0, (byte) 0x90, (byte) 0x6c, (byte) 0x46, (byte) 0xd1, (byte) 0x7e, (byte) 0x98, (byte) 0xee, (byte) 0x3f, (byte) 0xb0, (byte) 0x02, (byte) 0xe1, (byte) 0x7a, (byte) 0xcd, (byte) 0x39, (byte) 0x43, (byte) 0xc7, (byte) 0x0d, (byte) 0x1d, (byte) 0xf9, (byte) 0x70, (byte) 0x52, (byte) 0xab };
	static final byte EXP3072[] = { (byte) 0x10, (byte) 0xc8, (byte) 0xe2, (byte) 0x52, (byte) 0x25, (byte) 0xfb, (byte) 0xea, (byte) 0xc3, (byte) 0x94, (byte) 0xd2, (byte) 0x86, (byte) 0xaf, (byte) 0xc7, (byte) 0x9e, (byte) 0xc1, (byte) 0x7f, (byte) 0x40, (byte) 0x06, (byte) 0x5f, (byte) 0x74, (byte) 0x85, (byte) 0xaa, (byte) 0x61, (byte) 0xf0, (byte) 0x7c, (byte) 0xed, (byte) 0x06, (byte) 0x3c, (byte) 0x7f, (byte) 0xe9, (byte) 0x17, (byte) 0x7d };
	static final byte EXP3073[] = { (byte) 0xa7, (byte) 0x6a, (byte) 0x9d, (byte) 0x0f, (byte) 0xd7, (byte) 0xc9, (byte) 0xd3, (byte) 0x55, (byte) 0xdb, (byte) 0x14, (byte) 0x72, (byte) 0xa3, (byte) 0xdb, (byte) 0xde, (byte) 0xc7, (byte) 0xb6, (byte) 0x67, (byte) 0x90, (byte) 0xef, (byte) 0x8c, (byte) 0x0b, (byte) 0x0e, (byte) 0x7b, (byte) 0x17, (byte) 0x2d, (byte) 0xf8, (byte) 0xf6, (byte) 0x08, (byte) 0x43, (byte) 0xc1, (byte) 0x3b, (byte) 0xf4 };
	//@formatter:on

	public static void test() {
		byte[] data = new byte[385];

		for (int i = 0; i < data.length; ++i) {
			data[i] = (byte) (i & 0xff);
		}

		test(data, EXP0000, 0);
		test(data, EXP0001, 1);
		test(data, EXP0002, 2);
		test(data, EXP0007, 7);
		test(data, EXP0008, 8);
		test(data, EXP0015, 15);
		test(data, EXP0016, 16);
		test(data, EXP1023, 1023);
		test(data, EXP1024, 1024);
		test(data, EXP1025, 1025);
		test(data, EXP2047, 2047);
		test(data, EXP2048, 2048);
		test(data, EXP2049, 2049);
		test(data, EXP3071, 3071);
		test(data, EXP3072, 3072);
		test(data, EXP3073, 3073);
		System.out.println();
	}

	public static void test(byte[] data, byte[] ref, int len) {
		Hash lsh = Hash.getInstance(Hash.Algorithm.LSH256_256);
		lsh.update(data, 0, len);
		byte[] hash = lsh.doFinal();
		System.out.printf("LSH256-TEST%03d: %s\n", len, Arrays.equals(hash, ref));
	}
}
