package MyDB

import android.provider.BaseColumns

object petDB {
    class petTable: BaseColumns {
        companion object {
            val TABLE_PET = "pet"
            val COLUMN_ID: String = "id"
            val COLUMN_NAME: String = "name"
            val COLUMN_PHONE: String = "phone"
            val COLUMN_WEIGHT: String = "weight"
        }
    }
}
