/**
 * @module SHA1
 */
var SHA1 =
	{
		rotate_left: function(n, s)
		{
			var t4 = (n << s) | (n >>> (32 - s));
			return t4;
		},

		lsb_hex: function(val)
		{
			var str = "";
			var i;
			var vh;
			var vl;

			for(i = 0; i <= 6; i += 2)
			{
				vh = (val >>> (i * 4 + 4)) & 0x0f;
				vl = (val >>> (i * 4)) & 0x0f;
				str += vh.toString(16) + vl.toString(16);
			}
			return str;
		},

		cvt_hex: function(val)
		{
			var str = "";
			var i;
			var v;

			for(i = 7; i >= 0; i--)
			{
				v = (val >>> (i * 4)) & 0x0f;
				str += v.toString(16);
			}
			return str;
		},

		encode: function(msg)
		{
			var blockstart;
			var i, j;
			var W = new Array(80);
			var H0 = 0x67452301;
			var H1 = 0xEFCDAB89;
			var H2 = 0x98BADCFE;
			var H3 = 0x10325476;
			var H4 = 0xC3D2E1F0;
			var A, B, C, D, E;
			var temp;

			var msg_len = msg.length;

			var word_array = new Array();
			for(i = 0; i < msg_len - 3; i += 4)
			{
				j = msg.charCodeAt(i) << 24 | msg.charCodeAt(i + 1) << 16 | msg.charCodeAt(i + 2) << 8 | msg.charCodeAt(i + 3);
				word_array.push( j );
			}

			switch(msg_len % 4)
			{
				case 0: i = 0x080000000; break;
				case 1: i = msg.charCodeAt(msg_len - 1) << 24 | 0x0800000; break;
				case 2: i = msg.charCodeAt(msg_len - 2) << 24 | msg.charCodeAt(msg_len-1) << 16 | 0x08000; break;
				case 3: i = msg.charCodeAt(msg_len - 3) << 24 | msg.charCodeAt(msg_len-2) << 16 | msg.charCodeAt(msg_len - 1) << 8 | 0x80; break;
			}

			word_array.push( i );
			while((word_array.length % 16) != 14) word_array.push( 0 );

			word_array.push(msg_len >>> 29);
			word_array.push((msg_len << 3) & 0x0ffffffff);

			for(blockstart = 0; blockstart < word_array.length; blockstart += 16 )
			{
				for( i=0; i<16; i++ ) W[i] = word_array[blockstart + i];
				for( i=16; i<=79; i++ ) W[i] = SHA1.rotate_left(W[i - 3] ^ W[i - 8] ^ W[i - 14] ^ W[i - 16], 1);

				A = H0; B = H1; C = H2; D = H3; E = H4;

				for(i= 0; i <= 19; i++)
				{
					temp = (SHA1.rotate_left(A, 5) + ((B & C) | (~B & D)) + E + W[i] + 0x5A827999) & 0x0ffffffff;
					E = D; D = C; C = SHA1.rotate_left(B,30); B = A; A = temp;
				}

				for(i=20; i<=39; i++)
				{
					temp = (SHA1.rotate_left(A, 5) + (B ^ C ^ D) + E + W[i] + 0x6ED9EBA1) & 0x0ffffffff;
					E = D; D = C; C = SHA1.rotate_left(B, 30); B = A; A = temp;
				}

				for(i = 40; i <= 59; i++)
				{
					temp = (SHA1.rotate_left(A, 5) + ((B & C) | (B & D) | (C & D)) + E + W[i] + 0x8F1BBCDC) & 0x0ffffffff;
					E = D; D = C; C = SHA1.rotate_left(B, 30); B = A; A = temp;
				}

				for(i = 60; i <= 79; i++)
				{
					temp = (SHA1.rotate_left(A,5) + (B ^ C ^ D) + E + W[i] + 0xCA62C1D6) & 0x0ffffffff;
					E = D; D = C; C = SHA1.rotate_left(B, 30); B = A; A = temp;
				}

				H0 = (H0 + A) & 0x0ffffffff;
				H1 = (H1 + B) & 0x0ffffffff;
				H2 = (H2 + C) & 0x0ffffffff;
				H3 = (H3 + D) & 0x0ffffffff;
				H4 = (H4 + E) & 0x0ffffffff;
			}
			var temp = SHA1.cvt_hex(H0) + SHA1.cvt_hex(H1) + SHA1.cvt_hex(H2) + SHA1.cvt_hex(H3) + SHA1.cvt_hex(H4);
			return temp.toLowerCase();
		}
	};


/**
 * @module HMAC
 */
var HMAC =
	{
		encode: function(key, data)
		{
			function hexToBin(hStr)
			{
				var bStr = "";
				for(i = 0; i < hStr.length; i += 2)
					bStr += String.fromCharCode((parseInt(hStr.charAt(i), 16) << 4) + parseInt(hStr.charAt(i + 1), 16));
				return bStr;
			}

			var hashLength = 64;
			if(key.length > hashLength) key = hexToBin(SHA1.encode(key));

			var a = (new Array(hashLength - key.length + 1)).join("\0");
			console.log(a);
			if(key.length < hashLength) key += a;

			var i = 0;
			var ipad = "";
			var opad = "";
			while(i < key.length)
			{
				opad += String.fromCharCode(key.charCodeAt(i) ^ 0x5C);
				ipad += String.fromCharCode(key.charCodeAt(i) ^ 0x36);
				i ++;
			}
			return SHA1.encode(opad + hexToBin(SHA1.encode(ipad + data)));
		}
	};


function hmac(key, data) {
	return HMAC.encode(SHA1.encode(key), data);
}


// console.log(SHA1.encode('testing'));
console.log(hmac('admin', 'test'));
// console.log(String.fromCharCode(12 ^ 0x5C));
