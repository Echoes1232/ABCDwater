# ABCDwater — 自动落地水（Minecraft 1.21.1）

[English](#english) | [中文](#中文)

---

<a id="中文"></a>

## 自动落地水

从高处坠落时自动在脚下放水，免除摔伤伤害。只需在快捷栏放一桶水，跳崖时自动触发。

> **移植说明**
>
> 本项目移植自 **lao2010** 的开源项目 [ABCDwater](https://github.com/lao2010/ABCDwater)（MIT 协议），原作者为 **lao2010**。原项目面向 Minecraft 26.1.2 / NeoForge 26.1.2.76。
>
> **1.21.1 版本适配、快捷键开关、配置持久化、自定义触发高度均由 DeepSeek 完成移植与开发。**

[![NeoForge](https://img.shields.io/badge/NeoForge-21.1.x-blue)](https://neoforged.net)
[![Minecraft](https://img.shields.io/badge/Minecraft-1.21.1-green)](https://minecraft.net)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

### 功能

- 智能预测 -- 模拟下一 tick 物理运动，仅在有摔伤风险时触发
- 双重放水 -- 先俯视右键，失败则直接交互方块
- 自动回收 -- 落地后自动用空桶收回水源，桶可重复使用
- 快捷键开关 -- 默认 `'`，状态写入配置文件，重启后保留
- 高度可调 -- 默认 6 格，可在 1-64 格之间自定义
- 维度适配 -- 下界自动禁用，水中不浪费桶
- 纯客户端 -- 任何服务器都能用

### 用法

1. 安装 NeoForge 21.1.x（Minecraft 1.21.1），将 JAR 放入 `.minecraft/mods/`
2. 快捷栏放一桶水
3. 从 **6 格及以上**高度跳下
4. 水自动放在落地点，落地后自动回收
5. 按 `'` 可随时开启/关闭，动作栏会提示当前状态

> 默认低于 6 格不触发，日常跳跃不干扰。按键可在「选项 → 控制 → 自动落地水」中修改。

### 修改触发高度

触发高度就是「坠落多少格开始自动放水」，默认 `6`，允许范围 `1-64`。有两种修改方式，任选其一。

#### 方式一：游戏内命令（推荐）

| 命令 | 作用 |
|------|------|
| `/abcdwater status` | 查看当前开关状态与触发高度 |
| `/abcdwater height <1-64>` | 设置触发高度，例如 `/abcdwater height 8` |
| `/abcdwater toggle` | 开启/关闭自动落地水 |

- 这是客户端命令，单人和多人服务器都能用，不需要管理员权限。
- 超出 1-64 的数值会被拒绝。
- 命令修改会立即写入配置文件，无需重启。

#### 方式二：配置文件

编辑 `.minecraft/config/abcdwater-client.toml`：

```toml
[general]
	#Whether auto water clutch is enabled.
	enabled = true
	#Minimum fall distance in blocks required to trigger auto clutch. Range: 1-64.
	triggerHeight = 6.0
```

- `triggerHeight`：触发高度（格），范围 `1.0 ~ 64.0`
- `enabled`：是否默认开启
- 手动改文件后需要**重启游戏**生效；用命令改则会立即保存。

### 工作原理

每 tick 检测坠落状态 -> 模拟下一 tick 物理 -> 预测落地位置 -> 计算坠落距离 -> 达到设定高度则放水 -> 落地后回收。

### 技术细节

| 项目 | 值 |
|--------|------|
| 模组加载器 | NeoForge 21.1.x（构建使用 21.1.267） |
| Minecraft | 1.21.1 |
| Java | 21 |
| 运行侧 | 仅客户端 |
| 依赖 | 无 |
| 配置文件 | `config/abcdwater-client.toml` |

### 构建

```bash
./gradlew build
# -> build/libs/abcdwater-<version>.jar
```

需要 JDK 21。

### 许可

MIT。原项目版权归 lao2010 所有，移植部分遵循同一协议。

---

<a id="english"></a>

## Auto MLG Water Clutch (Minecraft 1.21.1)

A client-side NeoForge mod that automatically places water when falling, saving you from fall damage. Just keep a water bucket in your hotbar.

> **Port notice**
>
> This project is ported from **lao2010**'s open-source project [ABCDwater](https://github.com/lao2010/ABCDwater) (MIT), originally targeting Minecraft 26.1.2 / NeoForge 26.1.2.76.
>
> **The 1.21.1 port, the toggle keybind, persistent config and configurable trigger height were implemented by DeepSeek.**

[![NeoForge](https://img.shields.io/badge/NeoForge-21.1.x-blue)](https://neoforged.net)
[![Minecraft](https://img.shields.io/badge/Minecraft-1.21.1-green)](https://minecraft.net)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

### Features

- Smart physics prediction -- simulates the next tick with gravity (0.08/tick^2) + drag
- Dual placement -- look-down right-click first, direct block interaction as fallback
- Auto recycle -- picks up the water source after landing with the empty bucket
- Toggle key -- defaults to `'`, state is saved to the config file
- Configurable height -- 6 blocks by default, adjustable from 1 to 64
- Dimension aware -- disabled in the Nether (water evaporates)
- Client-side only -- works on any server

### Usage

1. Install NeoForge 21.1.x for Minecraft 1.21.1 and put the JAR in `.minecraft/mods/`
2. Put a water bucket in your hotbar
3. Fall from **6 or more blocks**
4. Water is placed at the predicted landing position and recycled after landing
5. Press `'` to toggle it on/off (status is shown in the action bar)

> Falls below the configured height are ignored. The key can be changed in Options -> Controls -> ABCDwater.

### Changing the trigger height

The trigger height is the fall distance (in blocks) at which water is placed. Default `6`, allowed range `1-64`.

**Option 1: in-game commands**

| Command | Description |
|---------|-------------|
| `/abcdwater status` | Show current state and trigger height |
| `/abcdwater height <1-64>` | Set the trigger height, e.g. `/abcdwater height 8` |
| `/abcdwater toggle` | Toggle auto clutch on/off |

These are client-side commands: they work in singleplayer and on any server without operator permissions. Values outside 1-64 are rejected, and changes are saved immediately.

**Option 2: config file**

Edit `.minecraft/config/abcdwater-client.toml`:

```toml
[general]
	#Whether auto water clutch is enabled.
	enabled = true
	#Minimum fall distance in blocks required to trigger auto clutch. Range: 1-64.
	triggerHeight = 6.0
```

Manual edits take effect after restarting the game; command edits are written immediately.

### How It Works

```
ClientTickEvent.Post ->
  |- Skip: on ground / creative / flying / elytra / in water / Nether
  |- Skip: fallDistance < 1
  |- Physics prediction:
  |   nextMY = (motionY - 0.08) x 0.98
  |   nextY  = currentY + nextMY
  |   check if block below nextY is solid
  |- Landing predicted? -> calculate cumulative fallDistance
  |   >= configured triggerHeight? -> clutch!
  |- Method 1: useItem + look down
  |- Method 2: useItemOn on ground block
  '- Remember water position for recycling
```

### Technical Details

| Aspect | Value |
|--------|-------|
| Mod Loader | NeoForge 21.1.x (built with 21.1.267) |
| Minecraft | 1.21.1 |
| Java | 21 |
| Side | Client only |
| Dependencies | None |
| Config file | `config/abcdwater-client.toml` |

### Build

```bash
./gradlew build
# -> build/libs/abcdwater-<version>.jar
```

Requires JDK 21.

### License

MIT. Original project copyright belongs to lao2010; the port follows the same license.
