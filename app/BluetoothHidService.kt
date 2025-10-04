class BluetoothHidService : Service() {

    private lateinit var bluetoothAdapter: BluetoothAdapter
    private var hidDevice: BluetoothHidDevice? = null
    private var hostDevice: BluetoothDevice? = null

    override fun onCreate() {
        super.onCreate()
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        val manager = getSystemService(BLUETOOTH_HID_DEVICE) as BluetoothHidDevice
        hidDevice = manager
        registerApp()
    }

    private fun registerApp() {
        val sdp = BluetoothHidDeviceAppSdpSettings(
            "KDE HID",
            "Keyboard and Mouse via KDE Connect",
            "KDE Connect",
            BluetoothHidDevice.SUBCLASS1_COMBO,
            HidDescriptor.keyboardAndMouse()
        )
        hidDevice?.registerApp(sdp, null, executor, callback)
    }

    private val callback = object : BluetoothHidDevice.Callback() {
        override fun onAppStatusChanged(device: BluetoothDevice?, registered: Boolean) {
            hostDevice = device
        }
    }

    companion object {
        val executor = Executors.newSingleThreadExecutor()
    }
}