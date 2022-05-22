package jp.techacademy.madoka.inagaki.preference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //保存する際はPreferenceManagerクラスのgetDefaultSharedPreferencesメソッド
        // を使ってSharedPreferencesクラスのオブジェクトを取得します。
        // そしてeditメソッドを使って、SharedPreferences.Editorクラスを取得
        val preference = PreferenceManager.getDefaultSharedPreferences(this)

        putButton.setOnClickListener{
            val editor = preference.edit()
            //"TEXT"はkey
            editor.putString("TEXT", editText.text.toString())
            editor.commit()
        }

        getButton.setOnClickListener{
            editText.setText(preference.getString("TEXT","まだ保存されていません"))
        }
    }
}