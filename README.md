# EMCTech - EMC科技

这是一个Slimefun4附属插件，将EMC2与等价交换(EquivalencyTech)整合起来的全新附属。

玩家可以使用解构机分解原版或粘液科技物品，来获得EMC值。  
通过重构机，玩家可以使用EMC值来重构已经分解过的物品。

另外，如果服务器中同时安装了网络(Networks)附属，玩家还可以使用网络EMC重构机，让重构出的物品直接接入网络中。

## 下载

点击这里下载 EMCTech: [下载 EMCTech](https://builds.guizhanss.net/SlimefunGuguProject/EMCTech/master)

<p align="center">
  <a href="https://github.com/SlimefunGuguProject/EMCTech/actions/workflows/maven.yml">
    <img src="https://github.com/SlimefunGuguProject/EMCTech/actions/workflows/maven.yml/badge.svg" alt="Java CI"/>
  </a>
  <a href="https://builds.guizhanss.net/SlimefunGuguProject/EMCTech/master">
    <img src="https://builds.guizhanss.net/f/SlimefunGuguProject/EMCTech/master/badge.svg" alt="Build status"/>
  </a>
</p>

## 指令与权限

本插件所有指令均以`/emctech`或`/emc`开头。  
下方列表将使用`/emc`进行说明。

`<>`为必填参数, `[]`为可选参数

| 指令 | 说明 | 所需权限 |
| --- | --- | ------- |
| `/emc emc` | 显示自己的EMC值 | 无 |
| `/emc viewemc <玩家名称>` | 查看指定玩家的EMC值 | `EMCTech.Admin` |
| `/emc addemc <玩家名称> <数量>` | 增加指定玩家的EMC值 | `EMCTech.Admin` |
| `/emc setemc <玩家名称> <数量>` | 设置指定玩家的EMC值 | `EMCTech.Admin` |

## PlaceholderAPI

- `%emctech_current_emc%` - 玩家当前EMC值
- `%emctech_amount_learned_vanilla%` - 玩家已解锁原版物品的数量
- `%emctech_amount_learned_slimefun%` - 玩家已解锁粘液科技物品的数量
