# GradleLwjglHelper

The lwjgl helper gradle plugin that makes it easier to add lwjgl dependencies.

## Installation

Add the following entry to your build.gradle:
```
plugins {
    id 'io.github.dwarfley.lwjgl-helper' version '0.1.0'
}
```

## Usage

```
dependencies {
  lwjgl 'assimp'
  lwjgl 'glfw'
  lwjgl 'openal'
  lwjgl 'opengl'
  lwjgl 'stb'
}
```

The plugin will automatically detect the current platform and use it to select the correct natives for each dependency.
The lwjgl bom platform and core library are automatically included and no further configuration is necessary.

## Versions

The plugin automatically sets the lwjgl version.

The table below shows which plugin version coresponds to which lwjgl version.

| Plugin | LWJGL |
| --- | --- |
| 0.1.0 | 3.3.3 |
