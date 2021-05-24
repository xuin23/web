# 保存当前路径
$path = Get-Location 

Set-Location init/shell/
# 关闭并删除所有容器
# ./dockerContainerStop.ps1

# 启动并初始化基本服务 例如redis postgres
./baseService.ps1

# 代码初始化
Set-Location $path
mvn clean
mvn install

# 创建并启动gateway容器
Set-Location $path
Set-Location web-service/service-gateway/
./build.ps1

# 创建并启动auth-core容器
Set-Location $path
Set-Location web-auth/auth-core/
./build.ps1