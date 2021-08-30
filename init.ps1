# 保存当前路径
$path = Get-Location 

# 启动并初始化基本服务 例如redis postgres
Set-Location $path/init
./baseService.ps1

# 代码初始化
Set-Location $path

mvn clean
mvn install

# 创建并启动gateway容器
Set-Location $path/web-service/service-gateway/
./build.ps1

# 创建并启动auth-core容器
Set-Location $path/web-service/service-auth/
./build.ps1

# 创建并启动message容器
Set-Location $path/web-service/service-message/
./build.ps1
