Write-Host "停止所有容器"
$array = (docker ps -a | ForEach-Object{ $_.split()[0] })[1..((docker ps -a).count - 1)]
for ($i = 0; $i -lt $array.Count; $i++) {
    docker stop $array[$i]
}