package kr.re.nsr.crypto;

import kr.re.nsr.crypto.hash.LSH256;
import kr.re.nsr.crypto.hash.LSH512;

/**
 * LSH256, LSH512 의 상위 클래스, 해시 함수 구현을 위한 공통 인터페이스를 포함하는 클래스이다.
 */
public abstract class Hash {

	/**
	 * LSH 알고리즘 명세
	 */
	public enum Algorithm {
		/**
		 * LSH-256-224 알고리즘 명세
		 */
		LSH256_224,

		/**
		 * LSH-256-256 알고리즘 명세
		 */
		LSH256_256,

		/**
		 * LSH-512-224 알고리즘 명세
		 */
		LSH512_224,

		/**
		 * LSH-512-256 알고리즘 명세
		 */
		LSH512_256,

		/**
		 * LSH-512-384 알고리즘 명세
		 */
		LSH512_384,

		/**
		 * LSH-512-512 알고리즘 명세
		 */
		LSH512_512
	};

	/**
	 * 같은 출력길이를 가지는 객체를 만들어 리턴한다.
	 * 
	 * @return LSHDigest 객체
	 */
	public abstract Hash newInstance();

	/**
	 * 내부 계산에 사용되는 메시지 블록 비트 길이를 리턴한다.
	 * 
	 * @return 메시지 블록 비트 길이
	 */
	public abstract int getBlockSize();

	/**
	 * 해시 출력 길이를 리턴한다.
	 * 
	 * @return 해시 출력 길이 (비트 단위)
	 */
	public abstract int getOutlenbits();

	/**
	 * 내부 상태를 초기화하여 새로은 message digest를 계산할 준비를 한다.
	 */
	public abstract void reset();

	/**
	 * message digest를 계산할 데이터를 처리한다.
	 * 
	 * @param data
	 *            message digest를 계산할 데이터
	 * @param offset
	 *            데이터 배열의 시작 오프셋
	 * @param lenbits
	 *            데이터의 길이 (비트 단위)
	 */
	public abstract void update(byte[] data, int offset, int lenbits);

	/**
	 * message digest를 계산한다
	 * 
	 * @return 계산된 message digest 값
	 */
	public abstract byte[] doFinal();

	/**
	 * message digest를 계산할 데이터를 처리한다.
	 * 
	 * @param data
	 *            message digest를 계산할 데이터
	 */
	public void update(byte[] data) {
		if (data != null) {
			update(data, 0, data.length * 8);
		}
	}

	/**
	 * data를 추가하여 최종 message digest를 계산한다.
	 * 
	 * @param data
	 *            message digest를 계산할 데이터
	 * @param offset
	 *            데이터 배열의 시작 오프셋
	 * @param lenbits
	 *            데이터의 길이 (비트 단위)
	 */
	public byte[] doFinal(byte[] data, int offset, int lenbits) {
		if (data != null && lenbits > 0) {
			update(data, offset, lenbits);
		}

		return doFinal();
	}

	/**
	 * data를 추가하여 최종 message digest를 계산한다.
	 * 
	 * @param data
	 *            최종 data
	 * @return 계산된 message digest
	 */
	public byte[] doFinal(byte[] data) {
		if (data != null) {
			update(data);
		}

		return doFinal();
	}

	/**
	 * algorithm에 해당하는 해시함수 객체 리턴
	 * 
	 * @param algorithm
	 *            알고리즘
	 * @return 해시함수 객체
	 */
	public static Hash getInstance(Algorithm algorithm) {

		Hash lsh = null;

		switch (algorithm) {

		case LSH256_224:
			lsh = new LSH256(224);
			break;

		case LSH256_256:
			lsh = new LSH256(256);
			break;

		case LSH512_224:
			lsh = new LSH512(224);
			break;

		case LSH512_256:
			lsh = new LSH512(256);
			break;

		case LSH512_384:
			lsh = new LSH512(384);
			break;

		case LSH512_512:
			lsh = new LSH512(512);
			break;

		default:
			throw new RuntimeException("Unsupported algorithm");
		}

		return lsh;
	}

	/**
	 * algorithm을 이용하여 해시 계산
	 * 
	 * @param algorithm
	 *            알고리즘
	 * @param data
	 *            해시값을 계산할 데이터
	 * @return
	 */
	public static byte[] digest(Algorithm algorithm, byte[] data) {
		return digest(algorithm, data, 0, data == null ? 0 : data.length << 3);
	}

	/**
	 * algorithm을 이용하여 해시 계산
	 * 
	 * @param algorithm
	 *            알고리즘
	 * @param data
	 *            해시값을 계산할 데이터
	 * @param offset
	 *            데이터 시작 오프셋
	 * @param lenbits
	 *            데이터 길이, 비트 단위
	 * @return
	 */
	public static byte[] digest(Algorithm algorithm, byte[] data, int offset,
			int lenbits) {
		Hash lsh = Hash.getInstance(algorithm);
		lsh.update(data, offset, lenbits);
		return lsh.doFinal();
	}

	/**
	 * LSH-wordlenbits-hashlenbits 알고리즘을 이용하여 해시 계산
	 * 
	 * @param wordlenbits
	 *            워드 길이, 비트 단위, 256 or 512
	 * @param hashlenbits
	 *            출력 길이, 비트 단위, 1 ~ wordlenbits
	 * @param data
	 *            해시를 계산할 데이터
	 * @return 해시값
	 */
	public static byte[] digest(int wordlenbits, int hashlenbits, byte[] data) {
		return digest(wordlenbits, hashlenbits, data, 0, data == null ? 0
				: data.length * 8);
	}

	/**
	 * 
	 * @param wordlenbits
	 *            워드 길이, 비트 단위, 256 or 512
	 * @param hashlenbits
	 *            출력 길이, 비트 단위, 1 ~ wordlenbits
	 * @param data
	 *            해시를 계산할 데이터
	 * @param offset
	 *            데이터 시작 오프셋
	 * @param lenbits
	 *            데이터 길이, 비트 단위
	 * @return 해시값
	 */
	public static byte[] digest(int wordlenbits, int hashlenbits, byte[] data,
			int offset, int lenbits) {
		Hash lsh = null;
		if (wordlenbits == 256) {
			lsh = new LSH256(hashlenbits);
		} else if (wordlenbits == 512) {
			lsh = new LSH512(hashlenbits);
		} else {
			throw new RuntimeException("Unsupported wordlenbits");
		}

		lsh.update(data, offset, lenbits);
		return lsh.doFinal();
	}

}
