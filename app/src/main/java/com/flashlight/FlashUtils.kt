package com.flashlight

import android.hardware.Camera


object FlashUtils {
    private var camera: Camera?= null
    private var isOpen = false

    private fun getMyCamera(): Camera? {
        try {
            if (camera == null) {
                camera = Camera.open()
            }
        } catch (e: Exception) {
            camera?.release()
            camera == null
        }
        return camera
    }

    fun switchFlash() {
        try {
            val parameters = getMyCamera()?.parameters ?: return
            if (isOpen) {
                if (parameters.flashMode.equals("torch")) {
                    return
                } else {
                    parameters.flashMode = "torch"
                }
            } else {
                if (parameters.flashMode.equals("off")) {
                    return
                } else {
                    parameters.flashMode = "off"
                }
            }
        } catch (e: Exception) {
            finishFlash()
        }
        isOpen = !isOpen
    }

    fun finishFlash() {
        camera?.stopPreview()
        camera?.release()
        camera = null
    }
}