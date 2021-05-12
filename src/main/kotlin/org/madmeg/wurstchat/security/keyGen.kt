package org.madmeg.wurstchat.security

import java.security.SecureRandom
import java.util.*
import javax.crypto.KeyGenerator

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */

class keyGen {
    fun newKey(): String {
        val keygen = KeyGenerator.getInstance("AES")
        val secureRandom = SecureRandom()
        val keyBitSize = 256
        keygen.init(keyBitSize, secureRandom)
        val key = keygen.generateKey()
        return Base64.getEncoder().encodeToString(key.encoded)
    }
}