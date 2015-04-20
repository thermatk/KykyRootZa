package com.thermatk.android.xf.kykyrootza;

import android.content.Context;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import de.robv.android.xposed.XC_MethodReplacement;

public class KykyRootZa implements IXposedHookLoadPackage {
	public void handleLoadPackage(final LoadPackageParam lpparam)
			throws Throwable {
		if (!lpparam.packageName.equals("ru.kykyryza"))
			return;

		XposedBridge.log("inside Kykyryza!");

		findAndHookMethod("ru.ftc.hce.mobilepaymentservice.util.SystemInformation",
				lpparam.classLoader, "checkDeviceInDeveloperMode",Context.class, new XC_MethodReplacement() {
					@Override
					protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
						return false;
					}
				});
		findAndHookMethod("ru.ftc.hce.mobilepaymentservice.util.SystemInformation",
				lpparam.classLoader, "checkDeviceIsRooted", new XC_MethodReplacement() {
					@Override
					protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
						return false;
					}
				});
	}
}
