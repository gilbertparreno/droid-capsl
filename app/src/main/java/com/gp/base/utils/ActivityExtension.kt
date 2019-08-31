package com.gp.base.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import com.gp.base.R
import com.gp.base.screen.base.FingerprintAuthListener

fun AppCompatActivity.showFingerprintPrompt(fingerprintAuthListener: FingerprintAuthListener) {
    BiometricPrompt(this, this.applicationContext.mainExecutor(),
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                fingerprintAuthListener.onError(Throwable(errString.toString()))
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                fingerprintAuthListener.onSuccess()
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                fingerprintAuthListener.onError(Throwable(getString(R.string.prompt_fingerprint_auth_error)))
            }
        }).apply {
        authenticate(
            BiometricPrompt.PromptInfo.Builder()
                .setTitle(getString(R.string.prompt_fingerprint_title))
                .setSubtitle(getString(R.string.prompt_fingerprint_subtitle))
                .setDescription(getString(R.string.prompt_fingerprint_description))
                .setNegativeButtonText(getString(R.string.prompt_fingerprint_button_label))
                .build()
        )
    }
}