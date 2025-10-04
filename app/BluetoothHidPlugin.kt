class BluetoothHidPlugin : Plugin() {

    private lateinit var hidService: BluetoothHidService

    override fun onCreate() {
        super.onCreate()
        hidService = BluetoothHidService()
    }

    fun sendMouseMove(dx: Int, dy: Int) {
        val report = HidReportBuilder.buildMouseReport(dx, dy, 0)
        hidService.sendReport(report)
    }

    fun sendKeyPress(keyCode: Int) {
        val report = HidReportBuilder.buildKeyboardReport(keyCode)
        hidService.sendReport(report)
    }
}