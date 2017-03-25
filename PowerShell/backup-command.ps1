vmrun -T player stop C:\Users\admin\Desktop\vm\SGA\sga.vmx
Compress-Archive -Path C:\Users\wende\Documents\"Virtual Machines"\SGA\ -DestinationPath C:\Users\wende\Documents\"Virtual Machines"\backup.zip -Force
vmrun -T player start C:\Users\admin\Desktop\vm\SGA\sga.vmx