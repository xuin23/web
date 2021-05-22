﻿Write-Host "删除所有当前存在的容器"
$array = (docker ps -a | ForEach-Object{ $_.split()[0] })[1..((docker ps -a).count - 1)]
for ($i = 0; $i -lt $array.Count; $i++) {
    docker stop $array[$i]
    docker rm $array[$i]
}

Write-Host "删除容器数据"
rm -rf /data