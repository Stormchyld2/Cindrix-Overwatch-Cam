<p align="center"><img src="branding/overwatch-camera-logo.svg" width="220" alt="Cindrix Overwatch Cam"></p>

# Cindrix Overwatch Cam

Android H.264 RTSP camera for Cindrix Overwatch Watchtower. Based on ancamera by jestemkojak (MIT). Operates on a local hotspot or Wi-Fi without cloud, accounts, advertisements or telemetry.

## Build
GitHub Actions runs the Android debug build and tests on each push. Download the APK from the workflow's **Artifacts** section after a successful run. The workflow generates PNG launcher assets from the unchanged official Cindrix logo in the Cindrix-Overwatch branding repository. To build locally, install Python Pillow and run `python scripts/generate_icons.py` first; install JDK 21, Android SDK 37 and Gradle 9.7.1; run `gradle testDebugUnitTest assembleDebug`.

## Use
Connect the camera phone and Overwatch device to the same trusted local network. Start streaming in the app, then add the displayed `rtsp://PHONE_IP:8554/` URL as an RTSP camera in Watchtower. Optional username/password can be set on the phone. No audio is transmitted.

**Security:** RTSP and HTTP are unencrypted. Use only a private Wi-Fi network or personal hotspot. Do not expose ports to the internet.

## Android permissions
- CAMERA — captures video.
- INTERNET — opens local RTSP and HTTP sockets.
- ACCESS_WIFI_STATE — checks Wi-Fi.
- WAKE_LOCK — supports streaming with the screen off.
- FOREGROUND_SERVICE and FOREGROUND_SERVICE_CAMERA — keeps camera capture active with visible notification.
- POST_NOTIFICATIONS — displays stream status on supported Android versions.

## Build and device verification
This initial GitHub import has not yet been confirmed by a successful CI run or tested on a physical phone. QR pairing, boot start, web-server toggle and dedicated low-power preset remain TODO.

## Credits
Based on ancamera by jestemkojak (MIT). Original LICENSE preserved. Copyright (c) 2026 Cindrix for modifications.
