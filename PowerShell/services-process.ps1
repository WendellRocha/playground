$processos = Get-Process
$contagem = 0
foreach ($processo in $processos) {
$contagem++
$processo >> processo2.txt
Write-Progress -Activity "Listando processos" -Status "Andamento" -PercentComplete (($contagem / $processos.count)*100)
}

$serviços = Get-Service
$count = 0
foreach ($serviço in $serviços) {
$count++
$serviço >> serviços.txt
Write-Progress -Activity "Listando serviços" -Status "Pode demorar um pouco" -PercentComplete (($count / $serviços.count)*100)
}