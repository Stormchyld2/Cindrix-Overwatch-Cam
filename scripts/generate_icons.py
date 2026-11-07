#!/usr/bin/env python3
"""Generate Android icon PNGs from the unchanged official Cindrix camera logo."""
from pathlib import Path
from urllib.request import urlopen
from io import BytesIO
from PIL import Image
root = Path(__file__).resolve().parents[1]
source = root / "branding" / "overwatch-camera-logo.png"
if not source.exists():
    source.parent.mkdir(parents=True, exist_ok=True)
    url = "https://raw.githubusercontent.com/Stormchyld2/Cindrix-Overwatch/main/branding/overwatch-camera-logo.png"
    source.write_bytes(urlopen(url, timeout=30).read())
image = Image.open(source).convert("RGBA")
res = root / "app/src/main/res"
for density, size in [("mdpi",48),("hdpi",72),("xhdpi",96),("xxhdpi",144),("xxxhdpi",192)]:
    dest = res / ("mipmap-"+density)
    dest.mkdir(parents=True, exist_ok=True)
    icon = image.copy()
    icon.thumbnail((size,size),Image.Resampling.LANCZOS)
    background = Image.new("RGBA",(size,size),(31,34,38,255))
    background.alpha_composite(icon,((size-icon.width)//2,(size-icon.height)//2))
    background.convert("RGB").save(dest/"ic_launcher.png")
    background.convert("RGB").save(dest/"ic_launcher_round.png")
dest = res / "drawable-nodpi"
dest.mkdir(parents=True, exist_ok=True)
image.save(dest/"overwatch_camera_logo.png")
print("Generated launcher assets from official logo")
