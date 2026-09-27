# Friends — Android 重构练习

## 背景

这是一个基础的 Android 应用，用于从网络获取并展示好友列表信息。

**API 地址：** https://6ab64262c4c7bb67b918af50.mockapi.io/friends

该项目目前的实现存在改进空间，请分析并提出优化建议，并根据优先级选择最重要的部分进行重构。

---

## 项目结构

该项目主要使用 **Jetpack Compose** 进行开发。

主要实现代码位于：
* Compose: `compose/src/main/java/com/refactor/compose/MainActivity.kt`

---

## 任务要求

### 现状诊断与架构复盘

根据 Android 及软件工程最佳实践，分析并规划当前代码的改进方向。建议从以下维度思考：

* **架构设计** — 职责边界、逻辑分层（如引入 ViewModel、Repository 等）
* **Compose 最佳实践** — 状态流转 (UDF)、重组优化、副作用管理
* **性能表现** — 列表渲染效率、图片加载策略、内存占用
* **代码质量** — 可读性、健壮性、模块化程度
* **工程扩展性** — 面对需求变更或数据量增长时的灵活性
* **交互体验** — 异常捕获、加载反馈、空数据处理




