object HidReportBuilder {

    fun buildMouseReport(dx: Int, dy: Int, buttons: Int): ByteArray {
        return byteArrayOf(buttons.toByte(), dx.toByte(), dy.toByte())
    }

    fun buildKeyboardReport(keyCode: Int): ByteArray {
        return byteArrayOf(0x00, 0x00, keyCode.toByte(), 0x00, 0x00, 0x00, 0x00, 0x00)
    }

    object HidDescriptor {
        fun keyboardAndMouse(): ByteArray {
            return byteArrayOf(
                // HID descriptor bytes (à compléter selon usage)
            )
        }
    }
}