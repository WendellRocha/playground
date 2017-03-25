$backup = New-JobTrigger -Daily -At 1am
Register-ScheduledJob -Name Backup -ScriptBlock {C:\Users\wende\Documents\GitHub\playground\PowerShell\backup-command.ps1} -Trigger $backup