package `in`.balakrishnan.keystoreexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val alias = "ThisIsFun"
    private val TAG = javaClass.name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val createKeys = KeyHolder.createKeys(this, alias)
        if (!createKeys.isDestroyed) {
            val enCryptor = EnCryptor(createKeys)
            val encryptText = enCryptor.encryptText("Hello This is test")

            Log.d(TAG, "iv :${enCryptor.iv} ")
            Log.d(TAG, "encryptText: $encryptText ")

            val decryptData =
                DeCryptor().decryptData(alias, encryptText, enCryptor.iv)
            Log.d(TAG, "decryptData: $decryptData ")
        }
    }
}
