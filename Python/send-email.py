import smtplib

'''
destinatario = 'exemple@exemple.com'
para = 'exemple@exemple.com'
header = 'De: '+ destinatario + '\n' + 'Para: ' + para + '\n' + 'Subject: subject \n'
mensagem = header + '\n mensagem do corpo do email'
'''

def enviar(destinatario, para, mensagem):
   header = 'De: ' + destinatario + '\n' + 'Para: ' + para + '\n' + 'Subject: teste \n'
   msg = header + mensagem
   usuario = 'usuario@exemple.com'
   senha = 'password'
   server = smtplib.SMTP('smtp.gmail.com', 587)
   server.ehlo()
   server.starttls()
   server.ehlo()
   server.login(usuario,senha)
   server.sendmail(destinatario, para, msg)
   server.quit()
   return True
   