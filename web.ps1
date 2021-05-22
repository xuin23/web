
# ./dockerContainerStop.ps1
# ./baseService.ps1

chmod 777 ./mvnw

$path= Get-Location 

Set-Location init/shell/
Set-Location $path
./mvnw clean
./mvnw install

Set-Location $path
Set-Location web-service/service-gateway/
./build.ps1

Set-Location $path
Set-Location web-auth/auth-core/
./build.ps1