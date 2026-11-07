<p align="center"><img src="docs/overwatch-camera-logo.png" alt="Cindrix Overwatch Cam" width="320"></p>

# Cindrix Overwatch Cam

Turns an old Android phone (Android 4.4 or newer) into a camera on your own network. It is the camera side of **Cindrix Overwatch** (Watchtower). It needs **no internet**: only a network that the phone and the viewer are both on, such as a phone hotspot.

- **RTSP (H.264, video only):** `rtsp://<phone-ip>:8554/`. Add this as a camera in Overwatch (Settings > Watchtower).
- **Web page:** `http://<phone-ip>:8080/` with a live view and camera settings.
- **MJPEG:** `http://<phone-ip>:8080/mjpeg?fps=5`. **Snapshot:** `http://<phone-ip>:8080/snapshot.jpg`.
- Based on [ancamera](https://github.com/jestemkojak/ancamera) (MIT). See NOTICE.

## Use with Overwatch and a hotspot

1. Turn on the hotspot on the Overwatch phone (for example the Note10).
2. On the old phone, join that hotspot, install the APK and open **Overwatch Cam**.
3. Optional: set a username and password.
4. Push **Start**. The app shows the RTSP address. The stream keeps running with the screen off.
5. In Overwatch, Watchtower, add a camera and type that address.

Keep the camera phone on a power bank. A camera running all the time drains the battery quickly and runs warm.

## Safety

- No analytics, ads, accounts or outside calls. The code only listens for connections on your local network. The `INTERNET` permission is listed because Android requires it for any network server; nothing is sent to the internet.
- Streams are **not encrypted** and basic login is sent in the clear. Use only a private network or your own hotspot.
- Permissions: camera (the picture), foreground service and notifications (keep running), wake lock (stay awake while streaming), Wi-Fi state (show the phone's address), internet/network (the local server).

## Status

- The original ancamera was tested only on an LG G3. **Overwatch Cam has not yet been run on a real phone.** Treat the first test as a test.
- Not built yet: pairing QR code, low-power mode, start on boot, audio, ONVIF.

## Build

`./gradlew testDebugUnitTest assembleDebug` (JDK 21, Android SDK platform 37). GitHub Actions builds a debug APK on every push. A tag such as `v0.1.1` builds a signed release if the signing secrets (`OVERWATCHCAM_KEYSTORE_BASE64`, `OVERWATCHCAM_KEYSTORE_PASSWORD`, `OVERWATCHCAM_KEY_ALIAS`, `OVERWATCHCAM_KEY_PASSWORD`) are set.

Colors are in `Theme.kt` (app) and the top of `assets/index.html` (web page).

## Credits

ancamera by jestemkojak (MIT). RootEncoder and RTSP-Server by pedroSG94.
