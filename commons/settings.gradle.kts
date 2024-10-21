
rootProject.name = "commons"

pluginManagement {
    includeBuild("../build-logic")
}
// todo_lh commons module下为什么不执行 include modules
// todo_lh  为什么中文在windows 上不行再linux 上可以测试
include("commons-annotation")
include("commons-annotation-processor")
include("commons-test")

