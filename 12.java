在WeakHashMap 中，当某个键不再正常使用时，会被从WeakHashMap 中自动移除。

直接使用HashMap有时候会带来内存溢出的风险，使用WaekHashMap实例化Map。当使用者不再有对象引用的时候，WeakHashMap将自动被移除对应Key值的对象。

androidx 是对 android.support.xxx 包的整理后产物。由于之前的support包过于混乱，所以，google推出了 androidX。
由于在后续版本中，会逐步放弃对support 的升级和维护，所以，我们必须迁移到 androidX.android.useAndroidX=true 表示当前项目启用 androidx

android.enableJetifier=true 表示将依赖包也迁移到androidx 。如果取值为false,表示不迁移依赖包到androidx，但在使用依赖包中的内容时可能会出现问题，当然了，如果你的项目中没有使用任何三方依赖，那么，此项可以设置为false
