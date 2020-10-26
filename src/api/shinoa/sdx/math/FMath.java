package api.shinoa.sdx.math;


public class FMath {

	private static final long HEX_40000000 = 0x40000000L;
	private static final long MASK_30BITS = -1L - (HEX_40000000 - 1);
	private static final long MASK_NON_SIGN_LONG = 0x7fffffffffffffffl;
	private static final int MASK_NON_SIGN_INT = 0x7fffffff;
	public static final double PI = 105414357.0 / 33554432.0 + 1.984187159361080883e-9;

	public static final double F_1_3 = 1d / 3d;

	public static final double F_1_5 = 1d / 5d;

	public static final double F_1_7 = 1d / 7d;

	public static final double F_1_9 = 1d / 9d;

	public static final double F_1_11 = 1d / 11d;

	public static final double F_1_13 = 1d / 13d;

	public static final double F_1_15 = 1d / 15d;

	public static final double F_1_17 = 1d / 17d;

	public static final double F_3_4 = 3d / 4d;

	public static final double F_15_16 = 15d / 16d;

	public static final double F_13_14 = 13d / 14d;

	public static final double F_11_12 = 11d / 12d;

	public static final double F_9_10 = 9d / 10d;

	public static final double F_7_8 = 7d / 8d;

	public static final double F_5_6 = 5d / 6d;

	private static final double F_1_2 = 1d / 2d;

	private static final double F_1_4 = 1d / 4d;
	private static final double TANGENT_TABLE_A[] = { +0.0d,
			+0.1256551444530487d, +0.25534194707870483d, +0.3936265707015991d,
			+0.5463024377822876d, +0.7214844226837158d, +0.9315965175628662d,
			+1.1974215507507324d, +1.5574076175689697d, +2.092571258544922d,
			+3.0095696449279785d, +5.041914939880371d, +14.101419448852539d,
			-18.430862426757812d, };

	private static final double TANGENT_TABLE_B[] = { +0.0d,
			-7.877917738262007E-9d, -2.5857668567479893E-8d,
			+5.2240336371356666E-9d, +5.206150291559893E-8d,
			+1.8307188599677033E-8d, -5.7618793749770706E-8d,
			+7.848361555046424E-8d, +1.0708593250394448E-7d,
			+1.7827257129423813E-8d, +2.893485277253286E-8d,
			+3.1660099222737955E-7d, +4.983191803254889E-7d,
			-3.356118100840571E-7d, };
	private static final double COSINE_TABLE_B[] = { +0.0d,
			+3.4439717236742845E-8d, +5.865827662008209E-8d,
			-3.7999795083850525E-8d, +1.184154459111628E-8d,
			-3.43338934259355E-8d, +1.1795268640216787E-8d,
			+4.438921624363781E-8d, +2.925681159240093E-8d,
			-2.6437112632041807E-8d, +2.2860509143963117E-8d,
			-4.813899778443457E-9d, +3.6725170580355583E-9d,
			+2.0217439756338078E-10d, };
	private static final double COSINE_TABLE_A[] = { +1.0d,
			+0.9921976327896118d, +0.9689123630523682d, +0.9305076599121094d,
			+0.8775825500488281d, +0.8109631538391113d, +0.7316888570785522d,
			+0.6409968137741089d, +0.5403022766113281d, +0.4311765432357788d,
			+0.3153223395347595d, +0.19454771280288696d, +0.07073719799518585d,
			-0.05417713522911072d, };
	private static final double SINE_TABLE_A[] = { +0.0d, +0.1246747374534607d,
			+0.24740394949913025d, +0.366272509098053d, +0.4794255495071411d,
			+0.5850973129272461d, +0.6816387176513672d, +0.7675435543060303d,
			+0.8414709568023682d, +0.902267575263977d, +0.9489846229553223d,
			+0.9808930158615112d, +0.9974949359893799d, +0.9985313415527344d, };
	private static final double SINE_TABLE_B[] = { +0.0d,
			-4.068233003401932E-9d, +9.755392680573412E-9d,
			+1.9987994582857286E-8d, -1.0902938113007961E-8d,
			-3.9986783938944604E-8d, +4.23719669792332E-8d,
			-5.207000323380292E-8d, +2.800552834259E-8d,
			+1.883511811213715E-8d, -3.5997360512765566E-9d,
			+4.116164446561962E-8d, +5.0614674548127384E-8d,
			-1.0129027912496858E-9d, };
	private static final double TWO_POWER_52 = 4503599627370496.0;
	private static final double EIGHTHS[] = { 0, 0.125, 0.25, 0.375, 0.5,
			0.625, 0.75, 0.875, 1.0, 1.125, 1.25, 1.375, 1.5, 1.625 };
	private static final long RECIP_2PI[] = new long[] {
			(0x28be60dbL << 32) | 0x9391054aL,
			(0x7f09d5f4L << 32) | 0x7d4d3770L,
			(0x36d8a566L << 32) | 0x4f10e410L,
			(0x7f9458eaL << 32) | 0xf7aef158L,
			(0x6dc91b8eL << 32) | 0x909374b8L,
			(0x01924bbaL << 32) | 0x82746487L,
			(0x3f877ac7L << 32) | 0x2c4a69cfL,
			(0xba208d7dL << 32) | 0x4baed121L,
			(0x3a671c09L << 32) | 0xad17df90L,
			(0x4e64758eL << 32) | 0x60d4ce7dL,
			(0x272117e2L << 32) | 0xef7e4a0eL,
			(0xc7fe25ffL << 32) | 0xf7816603L,
			(0xfbcbc462L << 32) | 0xd6829b47L,
			(0xdb4d9fb3L << 32) | 0xc9f2c26dL,
			(0xd3d18fd9L << 32) | 0xa797fa8bL,
			(0x5d49eeb1L << 32) | 0xfaf97c5eL,
			(0xcf41ce7dL << 32) | 0xe294a4baL, 0x9afed7ecL << 32 };

	private static final long PI_O_4_BITS[] = new long[] {
			(0xc90fdaa2L << 32) | 0x2168c234L,
			(0xc4c6628bL << 32) | 0x80dc1cd1L };

	public static float sqrt(final double a) {
		return (float) Math.sqrt(a);
	}

	public static double atan2(double y, double x) {
		if (x != x || y != y) {
			return Double.NaN;
		}

		if (y == 0) {
			final double result = x * y;
			final double invx = 1d / x;
			final double invy = 1d / y;

			if (invx == 0) {
				if (x > 0) {
					return y;
				} else {
					return copySign(Math.PI, y);
				}
			}

			if (x < 0 || invx < 0) {
				if (y < 0 || invy < 0) {
					return -Math.PI;
				} else {
					return Math.PI;
				}
			} else {
				return result;
			}
		}

		if (y == Double.POSITIVE_INFINITY) {
			if (x == Double.POSITIVE_INFINITY) {
				return Math.PI * F_1_4;
			}

			if (x == Double.NEGATIVE_INFINITY) {
				return Math.PI * F_3_4;
			}

			return Math.PI * F_1_2;
		}

		if (y == Double.NEGATIVE_INFINITY) {
			if (x == Double.POSITIVE_INFINITY) {
				return -Math.PI * F_1_4;
			}

			if (x == Double.NEGATIVE_INFINITY) {
				return -Math.PI * F_3_4;
			}

			return -Math.PI * F_1_2;
		}

		if (x == Double.POSITIVE_INFINITY) {
			if (y > 0 || 1 / y > 0) {
				return 0d;
			}

			if (y < 0 || 1 / y < 0) {
				return -0d;
			}
		}

		if (x == Double.NEGATIVE_INFINITY) {
			if (y > 0.0 || 1 / y > 0.0) {
				return Math.PI;
			}

			if (y < 0 || 1 / y < 0) {
				return -Math.PI;
			}
		}

		if (x == 0) {
			if (y > 0 || 1 / y > 0) {
				return Math.PI * F_1_2;
			}

			if (y < 0 || 1 / y < 0) {
				return -Math.PI * F_1_2;
			}
		}

		final double r = y / x;
		if (Double.isInfinite(r)) {
			return atan(r, 0, x < 0);
		}

		double ra = doubleHighPart(r);
		double rb = r - ra;

		final double xa = doubleHighPart(x);
		final double xb = x - xa;

		rb += (y - ra * xa - ra * xb - rb * xa - rb * xb) / x;

		final double temp = ra + rb;
		rb = -(temp - ra - rb);
		ra = temp;

		if (ra == 0) {
			ra = copySign(0d, y);
		}

		final double result = atan(ra, rb, x < 0);

		return result;
	}

	public static double copySign(double magnitude, double sign) {

		final long m = Double.doubleToRawLongBits(magnitude);
		final long s = Double.doubleToRawLongBits(sign);
		if ((m ^ s) >= 0) {
			return magnitude;
		}
		return -magnitude;
	}

	private static double doubleHighPart(double d) {
		if (d > -Precision.SAFE_MIN && d < Precision.SAFE_MIN) {
			return d;
		}
		long xl = Double.doubleToRawLongBits(d);
		xl &= MASK_30BITS;
		return Double.longBitsToDouble(xl);
	}

	private static double atan(double xa, double xb, boolean leftPlane) {
		if (xa == 0.0) {
			return leftPlane ? copySign(Math.PI, xa) : xa;
		}

		final boolean negate;
		if (xa < 0) {

			xa = -xa;
			xb = -xb;
			negate = true;
		} else {
			negate = false;
		}

		if (xa > 1.633123935319537E16) {
			return (negate ^ leftPlane) ? (-Math.PI * F_1_2)
					: (Math.PI * F_1_2);
		}

		final int idx;
		if (xa < 1) {
			idx = (int) (((-1.7168146928204136 * xa * xa + 8.0) * xa) + 0.5);
		} else {
			final double oneOverXa = 1 / xa;
			idx = (int) (-((-1.7168146928204136 * oneOverXa * oneOverXa + 8.0) * oneOverXa) + 13.07);
		}

		final double ttA = TANGENT_TABLE_A[idx];
		final double ttB = TANGENT_TABLE_B[idx];

		double epsA = xa - ttA;
		double epsB = -(epsA - xa + ttA);
		epsB += xb - ttB;

		double temp = epsA + epsB;
		epsB = -(temp - epsA - epsB);
		epsA = temp;

		temp = xa * HEX_40000000;
		double ya = xa + temp - temp;
		double yb = xb + xa - ya;
		xa = ya;
		xb += yb;

		if (idx == 0) {

			final double denom = 1d / (1d + (xa + xb) * (ttA + ttB));

			ya = epsA * denom;
			yb = epsB * denom;
		} else {
			double temp2 = xa * ttA;
			double za = 1d + temp2;
			double zb = -(za - 1d - temp2);
			temp2 = xb * ttA + xa * ttB;
			temp = za + temp2;
			zb += -(temp - za - temp2);
			za = temp;

			zb += xb * ttB;
			ya = epsA / za;

			temp = ya * HEX_40000000;
			final double yaa = (ya + temp) - temp;
			final double yab = ya - yaa;

			temp = za * HEX_40000000;
			final double zaa = (za + temp) - temp;
			final double zab = za - zaa;

			yb = (epsA - yaa * zaa - yaa * zab - yab * zaa - yab * zab) / za;

			yb += -epsA * zb / za / za;
			yb += epsB / za;
		}

		epsA = ya;
		epsB = yb;

		final double epsA2 = epsA * epsA;

		yb = 0.07490822288864472;
		yb = yb * epsA2 - 0.09088450866185192;
		yb = yb * epsA2 + 0.11111095942313305;
		yb = yb * epsA2 - 0.1428571423679182;
		yb = yb * epsA2 + 0.19999999999923582;
		yb = yb * epsA2 - 0.33333333333333287;
		yb = yb * epsA2 * epsA;

		ya = epsA;

		temp = ya + yb;
		yb = -(temp - ya - yb);
		ya = temp;

		yb += epsB / (1d + epsA * epsA);

		final double eighths = EIGHTHS[idx];

		double za = eighths + ya;
		double zb = -(za - eighths - ya);
		temp = za + yb;
		zb += -(temp - za - yb);
		za = temp;

		double result = za + zb;

		if (leftPlane) {

			final double resultb = -(result - za - zb);
			final double pia = 1.5707963267948966 * 2;
			final double pib = 6.123233995736766E-17 * 2;

			za = pia - result;
			zb = -(za - pia + result);
			zb += pib - resultb;

			result = za + zb;
		}

		if (negate ^ leftPlane) {
			result = -result;
		}

		return result;
	}

	public static double atan(double x) {
		return atan(x, 0.0, false);
	}

	public static long max(final long a, final long b) {
		return (a <= b) ? b : a;
	}

	public static double max(final double a, final double b) {
		if (a > b) {
			return a;
		}
		if (a < b) {
			return b;
		}

		if (a != b) {
			return Double.NaN;
		}

		long bits = Double.doubleToRawLongBits(a);
		if (bits == 0x8000000000000000L) {
			return b;
		}
		return a;
	}

	public static float max(final float a, final float b) {
		if (a > b) {
			return a;
		}
		if (a < b) {
			return b;
		}

		if (a != b) {
			return Float.NaN;
		}

		int bits = Float.floatToRawIntBits(a);
		if (bits == 0x80000000) {
			return b;
		}
		return a;
	}

	public static double abs(double x) {
		return Double.longBitsToDouble(MASK_NON_SIGN_LONG
				& Double.doubleToRawLongBits(x));
	}

	public static int max(final int a, final int b) {
		return (a <= b) ? b : a;
	}

	public static float abs(final float x) {
		return Float.intBitsToFloat(MASK_NON_SIGN_INT
				& Float.floatToRawIntBits(x));
	}

	public static double cos(double x) {
		int quadrant = 0;
		double xa = x;
		if (x < 0) {
			xa = -xa;
		}

		if (xa != xa || xa == Double.POSITIVE_INFINITY) {
			return Double.NaN;
		}

		double xb = 0;
		if (xa > 3294198.0) {

			double reduceResults[] = new double[3];
			reducePayneHanek(xa, reduceResults);
			quadrant = ((int) reduceResults[0]) & 3;
			xa = reduceResults[1];
			xb = reduceResults[2];
		} else if (xa > 1.5707963267948966) {
			final CodyWaite cw = new CodyWaite(xa);
			quadrant = cw.getK() & 3;
			xa = cw.getRemA();
			xb = cw.getRemB();
		}

		switch (quadrant) {
		case 0:
			return cosQ(xa, xb);
		case 1:
			return -sinQ(xa, xb);
		case 2:
			return -cosQ(xa, xb);
		case 3:
			return sinQ(xa, xb);
		default:
			return Double.NaN;
		}
	}

	private static double cosQ(double xa, double xb) {
		final double pi2a = 1.5707963267948966;
		final double pi2b = 6.123233995736766E-17;

		final double a = pi2a - xa;
		double b = -(a - pi2a + xa);
		b += pi2b - xb;

		return sinQ(a, b);
	}

	private static void reducePayneHanek(double x, double result[]) {

		long inbits = Double.doubleToRawLongBits(x);
		int exponent = (int) ((inbits >> 52) & 0x7ff) - 1023;

		inbits &= 0x000fffffffffffffL;
		inbits |= 0x0010000000000000L;

		exponent++;
		inbits <<= 11;

		long shpi0;
		long shpiA;
		long shpiB;
		int idx = exponent >> 6;
		int shift = exponent - (idx << 6);

		if (shift != 0) {
			shpi0 = (idx == 0) ? 0 : (RECIP_2PI[idx - 1] << shift);
			shpi0 |= RECIP_2PI[idx] >>> (64 - shift);
			shpiA = (RECIP_2PI[idx] << shift)
					| (RECIP_2PI[idx + 1] >>> (64 - shift));
			shpiB = (RECIP_2PI[idx + 1] << shift)
					| (RECIP_2PI[idx + 2] >>> (64 - shift));
		} else {
			shpi0 = (idx == 0) ? 0 : RECIP_2PI[idx - 1];
			shpiA = RECIP_2PI[idx];
			shpiB = RECIP_2PI[idx + 1];
		}

		long a = inbits >>> 32;
		long b = inbits & 0xffffffffL;

		long c = shpiA >>> 32;
		long d = shpiA & 0xffffffffL;

		long ac = a * c;
		long bd = b * d;
		long bc = b * c;
		long ad = a * d;

		long prodB = bd + (ad << 32);
		long prodA = ac + (ad >>> 32);

		boolean bita = (bd & 0x8000000000000000L) != 0;
		boolean bitb = (ad & 0x80000000L) != 0;
		boolean bitsum = (prodB & 0x8000000000000000L) != 0;

		if ((bita && bitb) || ((bita || bitb) && !bitsum)) {
			prodA++;
		}

		bita = (prodB & 0x8000000000000000L) != 0;
		bitb = (bc & 0x80000000L) != 0;

		prodB += bc << 32;
		prodA += bc >>> 32;

		bitsum = (prodB & 0x8000000000000000L) != 0;

		if ((bita && bitb) || ((bita || bitb) && !bitsum)) {
			prodA++;
		}

		c = shpiB >>> 32;
		d = shpiB & 0xffffffffL;
		ac = a * c;
		bc = b * c;
		ad = a * d;

		ac += (bc + ad) >>> 32;

		bita = (prodB & 0x8000000000000000L) != 0;
		bitb = (ac & 0x8000000000000000L) != 0;
		prodB += ac;
		bitsum = (prodB & 0x8000000000000000L) != 0;

		if ((bita && bitb) || ((bita || bitb) && !bitsum)) {
			prodA++;
		}

		c = shpi0 >>> 32;
		d = shpi0 & 0xffffffffL;

		bd = b * d;
		bc = b * c;
		ad = a * d;

		prodA += bd + ((bc + ad) << 32);

		int intPart = (int) (prodA >>> 62);

		prodA <<= 2;
		prodA |= prodB >>> 62;
		prodB <<= 2;

		a = prodA >>> 32;
		b = prodA & 0xffffffffL;

		c = PI_O_4_BITS[0] >>> 32;
		d = PI_O_4_BITS[0] & 0xffffffffL;

		ac = a * c;
		bd = b * d;
		bc = b * c;
		ad = a * d;

		long prod2B = bd + (ad << 32);
		long prod2A = ac + (ad >>> 32);

		bita = (bd & 0x8000000000000000L) != 0;
		bitb = (ad & 0x80000000L) != 0;
		bitsum = (prod2B & 0x8000000000000000L) != 0;

		if ((bita && bitb) || ((bita || bitb) && !bitsum)) {
			prod2A++;
		}

		bita = (prod2B & 0x8000000000000000L) != 0;
		bitb = (bc & 0x80000000L) != 0;

		prod2B += bc << 32;
		prod2A += bc >>> 32;

		bitsum = (prod2B & 0x8000000000000000L) != 0;

		if ((bita && bitb) || ((bita || bitb) && !bitsum)) {
			prod2A++;
		}

		c = PI_O_4_BITS[1] >>> 32;
		d = PI_O_4_BITS[1] & 0xffffffffL;
		ac = a * c;
		bc = b * c;
		ad = a * d;

		ac += (bc + ad) >>> 32;

		bita = (prod2B & 0x8000000000000000L) != 0;
		bitb = (ac & 0x8000000000000000L) != 0;
		prod2B += ac;
		bitsum = (prod2B & 0x8000000000000000L) != 0;

		if ((bita && bitb) || ((bita || bitb) && !bitsum)) {
			prod2A++;
		}

		a = prodB >>> 32;
		b = prodB & 0xffffffffL;
		c = PI_O_4_BITS[0] >>> 32;
		d = PI_O_4_BITS[0] & 0xffffffffL;
		ac = a * c;
		bc = b * c;
		ad = a * d;

		ac += (bc + ad) >>> 32;

		bita = (prod2B & 0x8000000000000000L) != 0;
		bitb = (ac & 0x8000000000000000L) != 0;
		prod2B += ac;
		bitsum = (prod2B & 0x8000000000000000L) != 0;

		if ((bita && bitb) || ((bita || bitb) && !bitsum)) {
			prod2A++;
		}

		double tmpA = (prod2A >>> 12) / TWO_POWER_52;
		double tmpB = (((prod2A & 0xfffL) << 40) + (prod2B >>> 24))
				/ TWO_POWER_52 / TWO_POWER_52;

		double sumA = tmpA + tmpB;
		double sumB = -(sumA - tmpA - tmpB);

		result[0] = intPart;
		result[1] = sumA * 2.0;
		result[2] = sumB * 2.0;
	}

	private static double sinQ(double xa, double xb) {
		int idx = (int) ((xa * 8.0) + 0.5);
		final double epsilon = xa - EIGHTHS[idx];

		final double sintA = SINE_TABLE_A[idx];
		final double sintB = SINE_TABLE_B[idx];
		final double costA = COSINE_TABLE_A[idx];
		final double costB = COSINE_TABLE_B[idx];

		double sinEpsA = epsilon;
		double sinEpsB = polySine(epsilon);
		final double cosEpsA = 1.0;
		final double cosEpsB = polyCosine(epsilon);

		final double temp = sinEpsA * HEX_40000000;
		double temp2 = (sinEpsA + temp) - temp;
		sinEpsB += sinEpsA - temp2;
		sinEpsA = temp2;

		double result;

		double a = 0;
		double b = 0;

		double t = sintA;
		double c = a + t;
		double d = -(c - a - t);
		a = c;
		b += d;

		t = costA * sinEpsA;
		c = a + t;
		d = -(c - a - t);
		a = c;
		b += d;

		b = b + sintA * cosEpsB + costA * sinEpsB;

		b = b + sintB + costB * sinEpsA + sintB * cosEpsB + costB * sinEpsB;

		if (xb != 0.0) {
			t = ((costA + costB) * (cosEpsA + cosEpsB) - (sintA + sintB)
					* (sinEpsA + sinEpsB))
					* xb;
			c = a + t;
			d = -(c - a - t);
			a = c;
			b += d;
		}

		result = a + b;

		return result;
	}

	private static double polySine(final double x) {
		double x2 = x * x;

		double p = 2.7553817452272217E-6;
		p = p * x2 + -1.9841269659586505E-4;
		p = p * x2 + 0.008333333333329196;
		p = p * x2 + -0.16666666666666666;

		p = p * x2 * x;

		return p;
	}

	public static double sin(double x) {
		boolean negative = false;
		int quadrant = 0;
		double xa;
		double xb = 0.0;

		xa = x;
		if (x < 0) {
			negative = true;
			xa = -xa;
		}

		if (xa == 0.0) {
			long bits = Double.doubleToRawLongBits(x);
			if (bits < 0) {
				return -0.0;
			}
			return 0.0;
		}

		if (xa != xa || xa == Double.POSITIVE_INFINITY) {
			return Double.NaN;
		}

		if (xa > 3294198.0) {

			double reduceResults[] = new double[3];
			reducePayneHanek(xa, reduceResults);
			quadrant = ((int) reduceResults[0]) & 3;
			xa = reduceResults[1];
			xb = reduceResults[2];
		} else if (xa > 1.5707963267948966) {
			final CodyWaite cw = new CodyWaite(xa);
			quadrant = cw.getK() & 3;
			xa = cw.getRemA();
			xb = cw.getRemB();
		}

		if (negative) {
			quadrant ^= 2;
		}

		switch (quadrant) {
		case 0:
			return sinQ(xa, xb);
		case 1:
			return cosQ(xa, xb);
		case 2:
			return -sinQ(xa, xb);
		case 3:
			return -cosQ(xa, xb);
		default:
			return Double.NaN;
		}
	}

	private static class CodyWaite {

		private final int finalK;

		private final double finalRemA;

		private final double finalRemB;

		CodyWaite(double xa) {

			int k = (int) (xa * 0.6366197723675814);

			double remA;
			double remB;
			while (true) {
				double a = -k * 1.570796251296997;
				remA = xa + a;
				remB = -(remA - xa - a);

				a = -k * 7.549789948768648E-8;
				double b = remA;
				remA = a + b;
				remB += -(remA - b - a);

				a = -k * 6.123233995736766E-17;
				b = remA;
				remA = a + b;
				remB += -(remA - b - a);

				if (remA > 0) {
					break;
				}

				--k;
			}

			this.finalK = k;
			this.finalRemA = remA;
			this.finalRemB = remB;
		}

		int getK() {
			return finalK;
		}

		double getRemA() {
			return finalRemA;
		}

		double getRemB() {
			return finalRemB;
		}
	}

	private static double polyCosine(double x) {
		double x2 = x * x;

		double p = 2.479773539153719E-5;
		p = p * x2 + -0.0013888888689039883;
		p = p * x2 + 0.041666666666621166;
		p = p * x2 + -0.49999999999999994;
		p *= x2;

		return p;
	}
}
