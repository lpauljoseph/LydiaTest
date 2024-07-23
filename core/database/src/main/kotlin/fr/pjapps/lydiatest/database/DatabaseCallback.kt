package fr.pjapps.plantmedicine.database

import android.content.Context
import android.util.Log
import androidx.room.RoomDatabase.Callback
import androidx.sqlite.db.SupportSQLiteDatabase
import java.io.BufferedReader

/**
 * @author Loïc PAUL-JOSEPH.
 */
class DatabaseCallback(private var context: Context?) : Callback() {

	override fun onCreate(db: SupportSQLiteDatabase) {
		super.onCreate(db)
		Log.e("Tauron", "DatabaseCallback : onCreate")
		// Read database sql
		context?.assets?.open("PlantMedicine.sql")?.let {
			it.bufferedReader()
				.use { reader: BufferedReader ->
					reader.forEachTextToChar(';') { sql ->
						Log.e("Tauron", sql)
						db.execSQL(sql)
					}
				}
		}
		context = null
	}

	override fun onOpen(db: SupportSQLiteDatabase) {
		super.onOpen(db)
		Log.e("Tauron", "DatabaseCallback : onOpen")
	}
}

fun BufferedReader.forEachTextToChar(stopChar: Char, action: (String) -> Unit) {
	var line = readLine()
	val text = StringBuilder()
	while (line != null) {
		if (line.isNotBlank()) {
			line = line.trim()
			if (line.endsWith(stopChar)) {
				text.append(line)
				action(text.toString())
				text.clear()
			} else {
				text.appendln(line)
			}
		}
		line = readLine()
	}
}