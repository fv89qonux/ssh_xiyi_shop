## 本项目实现的最终作用是基于SSH洗衣店管理系统
## 分为3个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 公告管理
 - 商品库存管理
 - 洗衣产品管理
 - 洗衣产品类型管理
 - 留言管理
 - 管理员工
 - 管理员登录
 - 管理员账户管理
 - 订单管理
 - 财务统计
### 第2个角色为员工角色，实现了如下功能：
 - QQ截图20220718152138
 - 会员管理
 - 员工登录
 - 洗衣产品管理
 - 订单管理
### 第3个角色为用户角色，实现了如下功能：
 - 提交订单
 - 查看洗衣服务
 - 查看订单
 - 用户注册登录
 - 用户留言
 - 用户首页
## 数据库设计如下：
# 数据库设计文档

**数据库名：** ssh_xiyi_shop

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [dtproperties](#dtproperties) |  |
| [t_admin](#t_admin) | 管理员表 |
| [t_catelog](#t_catelog) |  |
| [t_director](#t_director) |  |
| [t_gonggao](#t_gonggao) |  |
| [t_goods](#t_goods) |  |
| [t_liuyan](#t_liuyan) |  |
| [t_order](#t_order) |  |
| [t_orderitem](#t_orderitem) |  |
| [t_user](#t_user) | 用户表 |

**表名：** <a id="dtproperties">dtproperties</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | objectid |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  3   | property |   varchar   | 64 |   0    |    N     |  Y   |       |   |
|  4   | value |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 值  |
|  5   | uvalue |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | lvalue |   longblob   | 2147483647 |   0    |    Y     |  N   |   NULL    |   |
|  7   | version |   int   | 10 |   0    |    N     |  N   |   0    |   |

**表名：** <a id="t_admin">t_admin</a>

**说明：** 管理员表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | UserId |   int   | 10 |   0    |    N     |  Y   |   0    | 用户ID  |
|  2   | username |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  3   | userPw |   varchar   | 54 |   0    |    Y     |  N   |   NULL    | 密码  |

**表名：** <a id="t_catelog">t_catelog</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | catelog_id |   int   | 10 |   0    |    N     |  Y   |   0    |   |
|  2   | catelog_name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | catelog_miaoshu |   text   | 65535 |   0    |    Y     |  N   |   NULL    |   |
|  4   | catelog_del |   varchar   | 56 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_director">t_director</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | dId |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | dName |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | dPw |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | dTel |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | dRealName |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_gonggao">t_gonggao</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | gonggao_id |   int   | 10 |   0    |    N     |  Y   |   0    |   |
|  2   | gonggao_title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 公告标题  |
|  3   | gonggao_content |   text   | 65535 |   0    |    Y     |  N   |   NULL    | 公告内容  |
|  4   | gonggao_data |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 公告日期  |
|  5   | gonggao_fabuzhe |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | gonggao_del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |
|  7   | gonggao_one1 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  8   | gonggao_one2 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  9   | gonggao_one3 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  10   | gonggao_one4 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  11   | gonggao_one5 |   datetime   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  12   | gonggao_one6 |   datetime   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  13   | gonggao_one7 |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  14   | gonggao_one8 |   int   | 10 |   0    |    Y     |  N   |   0    |   |

**表名：** <a id="t_goods">t_goods</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | goods_id |   int   | 10 |   0    |    N     |  Y   |   0    |   |
|  2   | goods_name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | goods_miaoshu |   text   | 65535 |   0    |    Y     |  N   |   NULL    |   |
|  4   | goods_pic |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 商品图片  |
|  5   | goods_yanse |   varchar   | 52 |   0    |    Y     |  N   |   NULL    |   |
|  6   | goods_shichangjia |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  7   | goods_tejia |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  8   | goods_isnottejia |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 正常价  |
|  9   | goods_isnottuijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  10   | goods_catelog_id |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  11   | goods_kucun |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  12   | goods_Del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**表名：** <a id="t_liuyan">t_liuyan</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | liuyan_id |   int   | 10 |   0    |    N     |  Y   |   0    |   |
|  2   | liuyan_title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | liuyan_content |   text   | 65535 |   0    |    Y     |  N   |   NULL    |   |
|  4   | liuyan_date |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | liuyan_user |   varchar   | 52 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_order">t_order</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | order_id |   int   | 10 |   0    |    N     |  Y   |   0    | 订单ID  |
|  2   | order_bianhao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | order_date |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | order_zhuangtai |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | order_songhuodizhi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | order_fukuangfangshi |   varchar   | 52 |   0    |    Y     |  N   |   NULL    |   |
|  7   | order_jine |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  8   | order_user_id |   int   | 10 |   0    |    Y     |  N   |   0    |   |

**表名：** <a id="t_orderitem">t_orderitem</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | orderItem_id |   int   | 10 |   0    |    N     |  Y   |   0    |   |
|  2   | order_id |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  3   | goods_id |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  4   | goods_quantity |   int   | 10 |   0    |    Y     |  N   |   0    |   |

**表名：** <a id="t_user">t_user</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | user_id |   int   | 10 |   0    |    N     |  Y   |   0    |   |
|  2   | user_name |   varchar   | 52 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  3   | user_pw |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户密码  |
|  4   | user_type |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  5   | user_realname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户真实名字  |
|  6   | user_address |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户地址  |
|  7   | user_sex |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户性别  |
|  8   | user_tel |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户电话  |
|  9   | user_email |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户邮箱  |
|  10   | user_qq |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户QQ  |
|  11   | user_man |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  12   | user_age |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户年龄  |
|  13   | user_birthday |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 生日  |
|  14   | user_xueli |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 学历  |
|  15   | user_del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |
|  16   | user_one1 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  17   | user_one2 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  18   | user_one3 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  19   | user_one4 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  20   | user_one5 |   varchar   | 54 |   0    |    Y     |  N   |   NULL    |   |
|  21   | user_one6 |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  22   | user_one7 |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  23   | user_one8 |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  24   | user_one9 |   datetime   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  25   | user_one10 |   datetime   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  26   | user_one11 |   decimal   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  27   | user_one12 |   decimal   | 20 |   0    |    Y     |  N   |   NULL    |   |

